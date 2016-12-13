package com.think.junit.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.junit.Assert.assertTrue;

/**
 * ErrorCollector允许发现第一个问题之后继续执行测试代码.(比如：搜索表中所有有问题的行,并报告这些行)：
 */
public class RuleErrorCollector {

    @Rule public ErrorCollector collector = new ErrorCollector();

    @Test public void testExample() {
        collector.addError(new Throwable("first thing went wrong"));
        collector.addError(new Throwable("second thing went wrong"));
        System.out.println("testExample");
        assertTrue(true);
    }
}
