package com.think.junit.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by borney on 11/26/16.
 */
public class TestFeatureLogin {
    @Test public void testAssertEquals_Login() {
        System.out.println("TestFeatureLogin->testAssertEquals_Login");
        assertEquals("login", "login");
    }

    @Test public void testAssertEquals_vim() {
        assertEquals("vim", "vim");
    }
}
