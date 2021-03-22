package com.resume.java.AssociativeArray;

import static com.resume.java.util.Assert.assertEquals;

public class AssociativeArrayTest {
    public static void main(String[] args) {
        testAdd();
        testGet();
        testRemove();
        testResize();
        testGetSize();
        testGetArrayCapacity();
    }

    public static void testAdd() {
        AssociativeArray<String, String> test = new AssociativeArray<>();
        assertEquals("AssociativeArrayTest.testAdd", "test", test.add("1", "test"));
        assertEquals("AssociativeArrayTest.testAdd", "test", test.get("1"));
        assertEquals("AssociativeArrayTest.testAdd", "polygenelubricants", test.add("polygenelubricants", "polygenelubricants"));
        assertEquals("AssociativeArrayTest.testAdd", "polygenelubricants", test.get("polygenelubricants"));
    }

    public static void testGet() {
        AssociativeArray<String, String> test = new AssociativeArray<>();
        test.add("1", "test");
        assertEquals("AssociativeArrayTest.testGet", "test", test.get("1"));
    }

    public static void testRemove() {
        AssociativeArray<String, String> test = new AssociativeArray<>();
        test.add("1", "test");
        test.add("2", "removed");
        assertEquals("AssociativeArrayTest.testRemove", "removed", test.remove("2"));
        assertEquals("AssociativeArrayTest.testRemove", 1, test.getSize());
    }

    public static void testGetArrayCapacity() {
        AssociativeArray<String, String> test = new AssociativeArray<>(5);
        assertEquals("AssociativeArrayTest.testGetArrayCapacity", 5, test.getArrayCapacity());
    }

    public static void testGetSize() {
        AssociativeArray<String, String> test = new AssociativeArray<>(5);
        assertEquals("AssociativeArrayTest.testGetSize", 0, test.getSize());
        test.add("1", "test");
        assertEquals("AssociativeArrayTest.testGetSize", 1, test.getSize());
    }

    public static void testResize() {
        AssociativeArray<String, String> test = new AssociativeArray<>(5);
        assertEquals("AssociativeArrayTest.testResize", 5, test.getArrayCapacity());
        test.resize();
        assertEquals("AssociativeArrayTest.testResize", 10, test.getArrayCapacity());
    }

}