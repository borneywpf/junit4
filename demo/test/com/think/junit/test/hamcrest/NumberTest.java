package com.think.junit.test.hamcrest;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import static com.think.junit.hamcrest.IsNotANumber.notANumber;

/**
 * Created by borney on 11/28/16.
 */
public class NumberTest {
    @Test public void testSquareRootOfMinusOneIsNotANumber() {
        MatcherAssert.assertThat(Math.sqrt(-1), Matchers.is(notANumber()));
    }
}
