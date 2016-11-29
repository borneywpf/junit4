package com.think.junit.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * 设置Runner
 */
@RunWith(MockitoJUnitRunner.class)
public class Runners extends TestCase {

    @Test public void testAssertEquals() {
        assertEquals(1, 1);
    }
}
