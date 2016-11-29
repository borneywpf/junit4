package com.think.junit.test.hamcrest;

import org.junit.Test;

import static com.think.junit.hamcrest.Matchers.notANumber;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by borney on 11/29/16.
 */
public class CustomSugarNumberTest {

    @Test
    public void testSquareRootOfMinusOneIsNotANumber() {
        assertThat(Math.sqrt(-1), is(notANumber()));
    }
}
