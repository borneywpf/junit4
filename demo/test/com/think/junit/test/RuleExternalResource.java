package com.think.junit.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertTrue;

/**
 ExternalResource为子类提供了两个接口，分别是进入测试之前和退出测试之后，
 一般它是作为对一些资源在测试前后的控制，如Socket的开启与关闭、Connection的开始与断开、临时文件的创建与删除等。
 如果ExternalResource用在@ClassRule注解字段中，before()方法会在所有@BeforeClass注解方法之前调用；
 after()方法会在所有@AfterClass注解方法之后调用，不管在执行@AfterClass注解方法时是否抛出异常。
 如果ExternalResource用在@Rule注解字段中，before()方法会在所有@Before注解方法之前调用；
 after()方法会在所有@After注解方法之后调用。
 */
public class RuleExternalResource {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Rule
    public ExternalResource resource = new ExternalResource() {

        @Override
        protected void before() throws Throwable {
            System.out.println("ExternalResource---before()");
            folder.create();
        }

        @Override
        protected void after() {
            System.out.println("ExternalResource---after()");
            folder.delete();
        }
    };

    @Test public void testFoo() {
        assertTrue(folder.getRoot().isDirectory());
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("-----beforeClass----");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("-----afterClass----");
    }

    @Before
    public void before() {
        System.out.println("-----before----");
    }

    @After
    public void after() {
        System.out.println("-----after----");
    }
}
