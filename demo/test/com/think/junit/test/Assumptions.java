package com.think.junit.test;

import com.think.junit.User;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

/**
 * Created by borney on 11/29/16.
 * 参考(http://www.ibm.com/developerworks/cn/java/j-lo-junit44/)
 */
public class Assumptions {
    @Test public void filenameIncludesUsername() {
        System.out.println("separatorChar = " + File.separatorChar);
        assumeThat(String.valueOf(File.separatorChar), is("\\"));
        assertThat(new User("optimus").configFileName(), is("configfiles\\optimus.cfg"));
    }

    @Test public void testAssumeTrue_true() {
        assumeTrue(true);
        System.out.println("--------testAssumeTrue_true-------");
    }

    @Test public void testAssumeTrue_false() {
        assumeTrue(false);
        System.out.println("--------testAssumeTrue_false-------");
    }
}
