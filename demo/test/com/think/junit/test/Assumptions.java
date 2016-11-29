package com.think.junit.test;

import com.think.junit.User;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assume.assumeThat;

/**
 * Created by borney on 11/29/16.
 */
public class Assumptions {
    @Test public void filenameIncludesUsername() {
        System.out.println("separatorChar = " + File.separatorChar);
        assumeThat(String.valueOf(File.separatorChar), is("\\"));
        assertThat(new User("optimus").configFileName(), is("configfiles\\optimus.cfg"));
    }
}
