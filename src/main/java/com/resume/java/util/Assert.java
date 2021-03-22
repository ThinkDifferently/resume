package com.resume.java.util;

import java.util.Arrays;
import java.util.Objects;

public class Assert {
    public static void assertEquals(String testName, int expected, int actual) {
        if (expected == actual) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected " + expected + ", actual " + actual);
        }
    }

    public static void assertEquals(String testName, long expected, long actual) {
        if (expected == actual) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected " + expected + ", actual " + actual);
        }
    }

    public static void assertEquals(String testName, Object expected, Object actual) {
        try {
            if (expected.equals(actual)) {
                System.out.println(testName + " passed");
            } else {
                System.out.println(testName + " failed: expected " + expected + ", actual " + actual);
            }
        } catch (NullPointerException e) {
            if (Objects.isNull(expected) && Objects.isNull(actual)) {
                System.out.println(testName + " passed");
            } else {
                System.out.println(testName + " failed: expected " + expected + ", actual " + actual);
            }
        }
    }

    public static void assertEquals(String testName, boolean expected, boolean actual) {
        if (expected == actual) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected " + expected + ", actual " + actual);
        }
    }

    public static void assertEquals(String testName, Object[] expected, Object[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected " + expected + ", actual " + actual);
        }
    }

    public static void assertFail(String testName) {
        System.out.println(testName + " failed");
    }

    public static void assertPass(String testName) {
        System.out.println(testName + " passed");
    }

}