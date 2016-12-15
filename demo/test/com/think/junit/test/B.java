package com.think.junit.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by borney on 12/14/16.
 */
@Category({SlowTests.class, FastTests.class})
public class B {
    @Ignore
    public void test() {
        System.out.println("Class B test " + System.currentTimeMillis());
    }

    @Test
    public void c() {

    }
}
