package com.think.junit.test;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 ClassRule扩展了方法级别的规则,添加了可以影响类的运行的的静态属性。
 任何ParentRunner的子类,包括标准BlockJUnit4ClassRunner和Suite类,都支持ClassRule。

 例子会在A，B开始之前创建一个文件,并在其结束之后删除文件
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({A.class, B.class})
public class RuleClassRule {
    @Rule public static TemporaryFolder folder = new TemporaryFolder();

    @ClassRule public static ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            System.out.println("RuleClassRule resource ---- before " + System.currentTimeMillis());
            folder.create();
        }

        @Override
        protected void after() {
            System.out.println("RuleClassRule resource ---- after " + System.currentTimeMillis());
            folder.delete();
        }
    };

    @Test public void test() {
        System.out.println("Class RulClassRule test" + System.currentTimeMillis());
    }
}
