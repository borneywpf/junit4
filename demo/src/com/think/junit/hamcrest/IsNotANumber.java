package com.think.junit.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by borney on 11/28/16.
 */
public class IsNotANumber extends TypeSafeMatcher<Double> {

    @Override
    public boolean matchesSafely(Double number) {
        return number.isNaN();
    }

    public void describeTo(Description description) {
        description.appendText("not a number");
    }

    @Factory
    public static Matcher notANumber()
    {
        return new IsNotANumber();
    }

}
