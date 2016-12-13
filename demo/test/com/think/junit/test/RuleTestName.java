package com.think.junit.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * TestName是用来测试方法名的

 */
public class RuleTestName {

    @Rule public TestName testName = new TestName();


    @Test public void testA() {
        Assert.assertEquals("testA", testName.getMethodName());
    }

    @Test public void testB() {
        Assert.assertEquals("testB", testName.getMethodName());
    }
}
