package com.think.junit.test.hamcrest;

import com.think.java.test.Biscuit;

import junit.framework.TestCase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by borney on 11/28/16.
 */
public class BiscuitTest extends TestCase {

    public void testEquals() {
        Biscuit theBiscuit = new Biscuit("Ginger");
        Biscuit myBiscuit = new Biscuit("Ginger");
        assertThat(theBiscuit, equalTo(myBiscuit));
    }

    public void testIdentifier() {
        Biscuit theBiscuit = new Biscuit("Ginger");
        assertThat("chocolate chips", theBiscuit.getChocolateChipCount(), equalTo(10));
        assertThat("hazelnuts", theBiscuit.getHazelnutCount(), equalTo(3));
    }

    public void testSugar() {
        Biscuit theBiscuit = new Biscuit("Ginger");
        Biscuit myBiscuit = new Biscuit("Ginger");
        assertThat(theBiscuit, equalTo(myBiscuit));
        assertThat(theBiscuit, is(equalTo(myBiscuit)));
        assertThat(theBiscuit, is(myBiscuit));
    }
}
