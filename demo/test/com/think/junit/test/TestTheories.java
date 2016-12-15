package com.think.junit.test;

/**
 可以参考https://www.ibm.com/developerworks/cn/java/j-lo-junit44/
 *
 如何使用理论机制
 在 JUnit 4.4 的理论机制中，每个测试方法不再是由注释 @Test 指定的无参测试函数，
 而是由注释 @Theory 指定的带参数的测试函数，这些参数来自一个数据集（data sets），
 数据集通过注释 @DataPoint 指定。
 JUnit 4.4 会自动将数据集中定义的数据类型和理论测试方法定义的参数类型进行比较，如果类型相同，
 会将数据集中的数据通过参数一一传入到测试方法中。数据集中的每一个数据都会被传入到每个相同类型的参数中。
 这时有人会问了，如果参数有多个，而且类型都和数据集中定义的数据相同，怎么办？
 答案是，JUnit 4.4 会将这些数据集中的数据进行一一配对组合（所有的组合情况都会被考虑到），
 然后将这些数据组合统统通过参数，一一传入到理论的测试方法中，但是用户可以通过假设机制（assumption）
 在断言函数（assertion）执行这些参数之前，对这些通过参数传进来的数据集中的数据进行限制和过滤，
 达到有目的地部分地将自己想要的参数传给断言函数（assertion）来测试。
 只有满足所有假设的数据才会执行接下来的测试用例，任何一个假设不满足的数据，
 都会自动跳过该理论测试函数（假设 assumption 不满足的数据会被忽略，不再执行接下来的断言测试），
 如果所有的假设都满足，测试用例断言函数不通过才代表着该理论测试不通过。
 *
 翻译理论 你读过数学理论吗？ 它看起来通常像这样：
 对于所有的a，b>0，都可以得出：a+b>a，a+b>b。 只是我们看到的定义通常难以理解。
 譬如可以这样描述：它囊括了一个相当大的范围内(在此是无穷大)的所有元素(或者是元素的组合) 目前看来它是Parameterized改良版
 */

import org.hamcrest.Matchers;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

/**
 它分为两部分：一个是提供数据点集(比如待测试的数据)的方法，另一个是理论本身。
 这个理论看起来几乎就像一个测试，但是它有一个不同的注解(@Theory)，并且它需要参数。
 类通过使用数据点集的任意一种可能的组合来执行所有理论。
 */
@RunWith(Theories.class)
public class TestTheories {

    @DataPoints public static int[] positiveIntegers() {
        return new int[]{1, 10, 1234567};
    }

    @Theory public void a_plus_b_is_greater_than_a_and_greater_than_b(Integer a, Integer b) {
        System.out.println("a = " + a + " b = " + b + " (a + b) = " + (a + b));
        assertThat(a + b > a, Matchers.is(true));
        assertThat(a + b > b, Matchers.is(true));
    }

    /*
    Theories支持在参数中内嵌一套整数:
     */
    @Theory public void multiplyIsInverseOfDivideWithInlineDataPoints(@TestedOn(ints = {0, 5, 10}) int amount, @TestedOn(ints = {0, 1, 2}) int m) {
        assumeThat(m, Matchers.not(0));
        System.out.println("amount = " + amount + " m = " + m);
    }


    /*
    也可以自定义来拓展参数的提供方案
     */

    @Theory public void multiplyIsInverseOfDivideWithInlineDataPoints2(@Between(first = -3, last = 3) int amount, @Between(first = -3, last = 3) int m) {
        assumeThat(m , Matchers.not(0));
        System.out.println("amount = " + amount + " m = " + m);
    }



    @Retention(RetentionPolicy.RUNTIME)
    @ParametersSuppliedBy(BetweenSupplier.class)
    public @interface Between {
        int first();

        int last();
    }

    public static class BetweenSupplier extends ParameterSupplier {

        @Override
        public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
            Between annotation = (Between)sig.getAnnotation(Between.class);
            ArrayList<PotentialAssignment> list = new ArrayList<PotentialAssignment>();
            for (int i = annotation.first(); i <= annotation.last(); i++) {
                list.add(PotentialAssignment.forValue("ints", i));
            }
            return list;
        }
    }
}
