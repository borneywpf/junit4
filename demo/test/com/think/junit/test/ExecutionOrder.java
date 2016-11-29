package com.think.junit.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * 设置单元测试顺序
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExecutionOrder {

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
