package com.think.junit.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by borney on 12/15/16.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(SlowTests.class)
@Categories.ExcludeCategory(FastTests.class)
@Suite.SuiteClasses( { A.class, B.class }) // Note that Categories is a kind of Suite
public class TestCategories2 {
    // Will run A.b and B.c, but not A.a
}
