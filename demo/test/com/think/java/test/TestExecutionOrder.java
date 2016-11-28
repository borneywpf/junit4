package com.think.java.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by borney on 11/28/16.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestExecutionOrder {

    @Test public void testA() {
        System.out.println("testA");
    }

    @Test public void testC() {
        System.out.println("testC");
    }

    @Test public void testB() {
        System.out.println("testB");
    }
}
