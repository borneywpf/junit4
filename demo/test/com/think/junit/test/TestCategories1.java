package com.think.junit.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 Categories runner只运行那些有@Category注解或者@IncludeCategory注解的类,或者它的子类的方法。
 任何类或者接口都可以被作为categories.@IncludeCategory(SuperClass.class)和@Category({SubClass.class})标记的类将会被运行.
 你可以可以用@ExcludeCategory注解排除一些类.

 categories的典型应用

 categories用于在测试中添加元数据。 categories的用途一般如下:
     1、这些类型的测试都可能用到:单元测试,集成测试,冒烟测试,回归测试,性能测试
     2、怎样快速的执行测试: SlowTests, QuickTests
     3、自动化测试:每日部署测试
     4、测试状态: 不稳定测试,进行中测试
 根据上面文字,可以理解为categories的主要用途是用给不同测试范围准备不同的元数据的
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(SlowTests.class)
@Suite.SuiteClasses( { A.class, B.class }) // Note that Categories is a kind of Suite
public class TestCategories1 {
    // Will run A.b and B.c, but not A.a
}
