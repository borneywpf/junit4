package com.think.junit.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.fail;


/**
 * Created by borney on 11/28/16.
 */
public class TestExceptions {

    /**
     * normal use
     */
    @Test(expected = IndexOutOfBoundsException.class) public void testArrayList_empty() {
        new ArrayList<Object>().get(0);
    }

    /**
     * deeper testing of the exception
     * try/catch idiom
     */
    @Test public void testExceptionMessage() {
        try {
            new ArrayList<Object>().get(0);
            fail("Exception an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), is("Index: 0, Size: 0"));
        }
    }

    /**
     *
     * ExpectedException Rule
     * this rule lets we indicate only what exception we are expecting, but also the exception message
     * we are expecting
     */

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
        List<Object> list = new ArrayList<Object>();

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        list.get(0);
    }

    /**
     *
     * the expectMessage also lets we use Mathchers, which get we a bit flexibility in we tests
     */
    @Test public void showTestExceptionMessageMatchers() {
        List<Object> list = new ArrayList<Object>();

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage(containsString("Size: 0"));

        list.get(0);
    }

    /**
     *
     * moreover, you can use Matchers to inspect the Exception, useful if it has embeded state
     * we wish to verify
     */

    @Rule
    public ExpectedException thr = ExpectedException.none();

    @Test public void shouldThrow() {
        Testing testing = new Testing();
        thr.expect(NotFoundException.class);
        thr.expectMessage(startsWith("some Message"));
        thr.expect(hasProperty("response", hasProperty("status", is(404))));

        testing.chuck();
    }

    private class Testing {
        public void chuck() {
            Response response = Response.status(Status.NOT_FOUND).entity("Resource not found").build();
            throw new NotFoundException("some Message", response);
        }
    }
}
