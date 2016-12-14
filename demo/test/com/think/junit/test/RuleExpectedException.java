package com.think.junit.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by borney on 12/14/16.
 */
public class RuleExpectedException {

    @Rule public ExpectedException thrown = ExpectedException.none();

    @Test public void throwNothing() {

    }

    @Test public void throwNullPointerException() {
        thrown.expect(NullPointerException.class);
        throw new NullPointerException();
    }

    @Test public void throwNullPointerExceptionWithMessage() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("happened?");
        thrown.expectMessage(org.hamcrest.Matchers.startsWith("What"));

        throw new NullPointerException("What happened?");
    }
}
