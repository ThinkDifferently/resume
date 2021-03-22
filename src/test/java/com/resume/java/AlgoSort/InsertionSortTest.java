package com.resume.java.AlgoSort;

import java.util.Comparator;

import static com.resume.java.util.Assert.*;

public class InsertionSortTest {
    public static void main(String[] args) {
        testInsertionSort();
    }

    public static void testInsertionSort() {
        int[] intArray = {3, 1, 2};
        InsertionSort.insertionSort(intArray);
        assertEquals("InsertionSortTest.testInsertionSort", 1, intArray[0]);

        long[] longArray = {3L, 1L, 2L};
        InsertionSort.insertionSort(longArray);
        assertEquals("InsertionSortTest.testInsertionSort", 2L, longArray[1]);

        short[] shortArray = {3, 1, 2};
        InsertionSort.insertionSort(shortArray);
        assertEquals("InsertionSortTest.testInsertionSort", 3, shortArray[2]);

        byte[] byteArray = {3, 1, 2};
        InsertionSort.insertionSort(byteArray);
        assertEquals("InsertionSortTest.testInsertionSort", 1, byteArray[0]);

        char[] charArray = {'c', 'a', 'b'};
        InsertionSort.insertionSort(charArray);
        assertEquals("InsertionSortTest.testInsertionSort", 'a', charArray[0]);

        float[] floatArray = {3F, 1F, 2F};
        InsertionSort.insertionSort(floatArray);
        assertEquals("InsertionSortTest.testInsertionSort", 1F, floatArray[0]);

        double[] doubleArray = {3D, 1D, 2D};
        InsertionSort.insertionSort(doubleArray);
        assertEquals("InsertionSortTest.testInsertionSort", 1D, doubleArray[0]);

        Character[] characters = {'c', 'a', 'b'};
        InsertionSort.insertionSort(characters);
        assertEquals("InsertionSortTest.testInsertionSort", Character.valueOf('a'), characters[0]);

        CatForTest[] catsForTest = {new CatForTest(10, "FirstCat"), new CatForTest(7, "SecondCat")};
        InsertionSort.insertionSort(catsForTest);
        assertEquals("InsertionSortTest.testInsertionSort", 7, catsForTest[0].getAge());

        DogForTest[] dogsForTest = {new DogForTest(2), new DogForTest(1)};
        Comparator<DogForTest> comparator = new Comparator<DogForTest>() {
            @Override
            public int compare(DogForTest o1, DogForTest o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
        InsertionSort.insertionSort(dogsForTest, comparator);
        assertEquals("InsertionSortTest.testInsertionSort", 1, dogsForTest[0].getAge());
        try {
            InsertionSort.insertionSort(dogsForTest);
            assertFail("InsertionSortTest.testInsertionSort");
        } catch (ClassCastException e) {
            assertPass("InsertionSortTest.testInsertionSort");
        }
    }

    static class CatForTest implements Comparable<CatForTest> {
        int age;
        String name;

        public CatForTest(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(CatForTest o) {
            return Integer.compare(age, o.getAge());
        }
    }

    static class DogForTest {
        int age;

        public DogForTest(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

}