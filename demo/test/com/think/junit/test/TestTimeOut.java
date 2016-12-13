package com.think.junit.test;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 如果你希望一个测试运行时间过长的情况下自动变成测试失败,有以下两种方式来实现：
 @Test中的timeout参数(适用于测试方法)
 您可以指定以毫秒为单位超时时间。如果超过了时间限制,它会由异常触发一个失败：
 它通过单独起一条线程来实现的,如果测试运行超过了规定的超时时间,测试将会失败并且JUnit会中断线程运行测试.如果测试超时，执行的是一个可中断的操作，运行测试线程可以退出(如果该测试是一个无限死循环,运行这个测试的线程将永远运行,但是其他的测试也可以继续执行)
 *
 Timeout Rule(适用于测试类中的所有测试用例)

 Timout Rule适用于一个测试类中所有的测试方法(共用一个超时时间).并会运行除了由timeout参数在单个测试上指定的其他任何超时时间
 */
public class TestTimeOut {
    public static String log;
    private CountDownLatch latch = new CountDownLatch(1);

    private long before = 0l;

    @Before public void before() {
        before = System.currentTimeMillis();
        System.out.println("before----" + before);
    }

    @After public void after() {
        long after = System.currentTimeMillis();
        System.out.println("after----" + after + " diff----" + (after - before) / 1000);
    }

    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    @Test public void testSleepForTooLong() throws Exception {
        log += "ran1";
        TimeUnit.SECONDS.sleep(10);
    }

    @Test public void testBlockForever() throws Exception {
        log += "ran2";
        latch.await();
    }

    @Test(timeout = 2000) public void testTimeoutParameter() throws Exception {
        log += "ran3";
        TimeUnit.SECONDS.sleep(10);
    }

    @Test public void testNoBlockAndSleep() {
        log += "ran4";
        assertThat(log, Matchers.containsString("ran4"));
    }
}
