package com.think.junit.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Parameters 如果你的测试只需要一个参数，你不必用数组包装它。
 * 相反，您可以提供一个Iterable或一个对象数组。
 *
 */
@RunWith(Parameterized.class)
public class TestParameterized2 {
    @Parameterized.Parameters public static Iterable<? extends Object> data() {
        return Arrays.asList("first test", "second test");
    }

    /*
    @Parameterized.Parameters public Object[] data() {
        return new Object[] { "first test", "second test" };
    }
    */

    @Parameterized.Parameter
    public String input;


    @Test public void test() {
        assertThat(input, org.hamcrest.Matchers.containsString("test"));
    }
}
