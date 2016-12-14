package com.think.junit.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static org.junit.Assert.assertTrue;

/**
 * RuleChain支持TestRule的排序
 */
public class RuleRuleChain {

    @Rule public TestRule chain = RuleChain
            .outerRule(new LoggingRule("outer rule"))
            .around(new LoggingRule("middle rule"))
            .around(new LoggingRule("inner rule"));

    @Test public void example() {
        System.out.println("test example");
        assertTrue(true);
    }

    private class LoggingRule extends ExternalResource {
        private String s;
        public LoggingRule(String s) {
            this.s = s;
        }

        @Override
        protected void before() throws Throwable {
            System.out.println(s + " --before");
        }

        @Override
        protected void after() {
            System.out.println(s + " --after");
        }

        @Override
        public Statement apply(Statement base, Description description) {
            System.out.println(s);
            return base;
        }

    }
}
