package com.think.junit.test;

/**
 * Created by borney on 12/15/16.
 */
public class OutsideClass {
    public static class insideClass {

        private final String str;

        public insideClass(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }
    }
}
