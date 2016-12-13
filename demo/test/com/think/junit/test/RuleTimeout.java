package com.think.junit.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

/**
 * 该规则适用于测试类中的所有测试方法
 */
public class RuleTimeout {

    public static String log;

    @Rule public TestRule globalTimeout = new Timeout(20);

    @Test public void testInfiniteLoop1() {
        log += "ran1";
        for(;;) {}
    }

    @Test public void testInfiniteLoop2() {
        log += "ran2";
        for (;;) {}
    }
}
