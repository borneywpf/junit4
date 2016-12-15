package com.think.junit.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.fail;

/**
 * Created by borney on 12/14/16.
 */
public class A {
    @Ignore
    public void test() {
        System.out.println("Class A test " + System.currentTimeMillis());
    }

    @Test
    public void a() {
        fail();
    }

    @Category(SlowTests.class)
    @Test
    public void b() {
    }
}
