package com.think.junit.test;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 在外部内加了@RunWith(Enclosed.class)之后,只会执行内部类中的方法
 */
@RunWith(Enclosed.class)
public class TestEnclosed {

    public static class insideClassTest{
        @Test
        public void testInsideClass(){
            System.out.println("inside");
            OutsideClass.insideClass insideClass = new OutsideClass.insideClass("str");
            assertThat(insideClass.getStr(), Matchers.equalTo("str"));
        }
    }

    @Test
    public void testInsideClass(){
        System.out.println("outside");
        OutsideClass.insideClass insideClass = new OutsideClass.insideClass("str");
        assertThat(insideClass.getStr(), Matchers.equalTo("str"));
    }
}
