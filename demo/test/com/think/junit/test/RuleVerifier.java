package com.think.junit.test;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 Verifier是在每个测试方法已经结束的时候，再加入一些额外的逻辑，只有额外的逻辑也通过，才表示测试成功，
 否则，测试依旧失败，即使在之前的运行中都是成功的
 */
public class RuleVerifier {

    private static String sequence = "";

    @Rule public Verifier verifier = new Verifier() {

        @Override
        protected void verify() throws Throwable {
            System.out.println("verify sequence = " + sequence);
            assertThat(sequence, Matchers.equalTo("test verify "));
        }
    };

    @Test public void example() {
        sequence += "test ";
        System.out.println("verify example = " + sequence);
        assertThat(sequence, Matchers.equalTo("test "));//????????,??Verifier?????,??????????
    }

    @Test public void verifierRunsAfterTest() {
        sequence = "test verify ";
        System.out.println("verify verifierRunsAfterTest = " + sequence);
//        assertThat(testResult(RuleVerifier.class), isSuccessful());
//        assertEquals("test verify ", sequence);
    }
}
