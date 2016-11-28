package com.think.junit.test;

import com.think.junit.Calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by borney on 11/25/16.
 */
public class CalculatorTest {

    @Test
    public void evaluatesExpression() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.evaluate("1+2+3"));
    }

//    @Test
//    public void evaluatesNotEqueasExpression() {
//        Calculator calculator = new Calculator();
//        assertNotEquals(5, calculator.evaluate("1+2+3"));
//    }
}
