package com.think.junit.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Parameters ???????????
 *
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
