package com.think.junit.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 组合测试
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestFeatureLogin.class,
        TestFeatureLogout.class,
})

public class Suites {

}
