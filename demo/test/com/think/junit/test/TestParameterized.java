package com.think.junit.test;

import com.think.junit.Fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * ????????????????,??runner Parameterized?@Parameters???????????static?
 */

@RunWith(Parameterized.class)
public class TestParameterized {
    @Parameterized.Parameters public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}
        });
    }

    private int fInput;

    private int fExpected;

    public TestParameterized(int fInput, int fExpected) {
        this.fInput = fInput;
        this.fExpected = fExpected;
    }

    @Test public void test() {
        assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}
