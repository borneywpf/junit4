package com.think.junit.test;

import com.think.junit.Fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * 您可以使用@Parameters注释提供名称
 * {index} 当前参数索引
 * {0},{1}...第一，第二，等等，参数值；注意：单引号'应转义为两个单引号
 */
@RunWith(Parameterized.class)
public class TestParameterized1 {
    @Parameterized.Parameters(name = "{index} : fib({0})={1}") public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}
        });
    }

    @Parameterized.Parameter
    public int fInput;

    @Parameterized.Parameter(1)
    public int fExpected;

    @Test public void test() {
        assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}
