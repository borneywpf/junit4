package com.think.junit.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.logging.Logger;

/**
 大多数自定义规则都是ExternalResource规则的延伸,一般情况下你需要实现TestRule接口:
 实现TestRule需要自定义一个构造方法,添加的方法用于测试,并且提供一个新的Statement。比如说有一下需求:为每个测试记录日志
 */
public class RuleCustom {

    @Rule public TestLogger logger = new TestLogger();

    @Test public void checOutMyLogger() {
        final Logger log = logger.getLogger();
        log.info("Your test is showing!");
    }

    private class TestLogger implements TestRule {

        private Logger logger;

        public Logger getLogger() {
            return logger;
        }

        @Override
        public Statement apply(final Statement base, final Description description) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    logger = Logger.getLogger(description.getTestClass().getName() + "." + description.getDisplayName());
                    base.evaluate();
                }
            };
        }
    }
}
