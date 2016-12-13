package com.think.junit.test;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 忽略
 */
public class Ignoring {
    @Ignore("Test is ignored as a demonstration")
    @Test public void testSame() {
        assertThat(1, is(1));
    }
}
