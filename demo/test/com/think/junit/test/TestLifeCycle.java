package com.think.junit.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by borney on 11/29/16.
 */
public class TestLifeCycle {

    @Before public void before() {
        System.out.println("before");
    }

    @After public void after() {
        System.out.println("after");
    }

    @Test public void testA() {
        System.out.println("testA");
    }

    @Test public void testB() {
        System.out.println("testB");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }
}
