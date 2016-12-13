package com.think.junit.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static org.junit.Assert.fail;

/**
 * 从4.9版本开始TestWatcher替代TestWatchman,它实现的是TestRule接口而不是MethodRule --http://junit.org/javadoc/latest/org/junit/rules/TestWatcher.html
 * JUnit从4.7开始采用TestWatchman,它使用的是MethodRule接口，现在已经不建议使用
 * TestWatcher(还有已经不建议使用的TestWatchman)是为记下测试行动规则的基类，并不需修改它。例如，这个类将保留每个通过和未通过测试的日志
 */

/*
TestWatcher为子类提供了四个事件方法以监控测试方法在运行过程中的状态，一般它可以作为信息记录使用。
如果TestWatcher作为@ClassRule注解字段，则该测试类在运行之前（调用所有的@BeforeClass注解方法之前）
会调用starting()方法；当所有@AfterClass注解方法调用结束后，succeeded()方法会被调用；
若@AfterClass注解方法中出现异常，则failed()方法会被调用；最后，finished()方法会被调用；
所有这些方法的Description是Runner对应的Description。如果TestWatcher作为@Rule注解字段，
则在每个测试方法运行前（所有的@Before注解方法运行前）会调用starting()方法；
当所有@After注解方法调用结束后，succeeded()方法会被调用；
若@After注解方法中跑出异常，则failed()方法会被调用；最后，finished()方法会被调用；
所有Description的实例是测试方法的Description实例。+

 */
public class RuleTestWatcher {
    private static String watchedLog = "";

    @Rule public TestRule watchman = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            watchedLog += description.getDisplayName() + " " + "success!\n";
            System.out.println(watchedLog);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
            System.out.println(watchedLog);
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
            System.out.println(watchedLog);
        }

        @Override
        protected void starting(Description description) {
            super.starting(description);
            System.out.println("starting " + description.getDisplayName());
        }

        @Override
        protected void finished(Description description) {
            System.out.println("finished " + description.getDisplayName());
            super.finished(description);
        }
    };

    @Test public void fails() {
        System.out.println("fails");
        fail();
    }

    @Test public void successed() {
        System.out.println("successed");
    }

    @BeforeClass public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass public static void afterClass() {
        System.out.println("afterClass");
    }

    @Before public void before() {
        System.out.println("before");
    }

    @After public void after() {
        System.out.println("after");
    }
}
