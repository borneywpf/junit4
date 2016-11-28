package com.think.java.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by borney on 11/26/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestRunners extends TestCase {

    @Test public void testAssertEquals() {
        assertEquals(1, 1);
    }
}
