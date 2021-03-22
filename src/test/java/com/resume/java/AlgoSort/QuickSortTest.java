package com.resume.java.AlgoSort;

import java.util.Comparator;

import static com.resume.java.util.Assert.*;

public class QuickSortTest {
    public static void main(String[] args) {
        testQuickSort();
    }

    public static void testQuickSort() {
        int[] intArray = {3, 1, 2};
        QuickSort.quickSort(intArray);
        assertEquals("QuickSortTest.testQuickSort", 1, intArray[0]);

        long[] longArray = {3L, 1L, 2L};
        QuickSort.quickSort(longArray);
        assertEquals("QuickSortTest.testQuickSort", 2L, longArray[1]);

        short[] shortArray = {3, 1, 2};
        QuickSort.quickSort(shortArray);
        assertEquals("QuickSortTest.testQuickSort", 3, shortArray[2]);

        byte[] byteArray = {3, 1, 2};
        QuickSort.quickSort(byteArray);
        assertEquals("QuickSortTest.testQuickSort", 3, byteArray[2]);

        char[] charArray = {'c', 'a', 'b'};
        QuickSort.quickSort(charArray);
        assertEquals("QuickSortTest.testQuickSort", 'c', charArray[2]);

        float[] floatArray = {3F, 1F, 2F};
        QuickSort.quickSort(floatArray);
        assertEquals("QuickSortTest.testQuickSort", 1F, floatArray[0]);

        double[] doubleArray = {3D, 1D, 2D};
        QuickSort.quickSort(doubleArray);
        assertEquals("QuickSortTest.testQuickSort", 3D, doubleArray[2]);

        Character[] characters = {'c', 'a', 'b'};
        QuickSort.quickSort(characters);
        assertEquals("QuickSortTest.testQuickSort", Character.valueOf('a'), characters[0]);

        CatForTest[] catsForTest = {new CatForTest(10, "FirstCat"), new CatForTest(7, "SecondCat")};
        QuickSort.quickSort(catsForTest);
        assertEquals("QuickSortTest.testQuickSort", 7, catsForTest[0].getAge());

        DogForTest[] dogsForTest = {new DogForTest(2), new DogForTest(1)};
        Comparator<DogForTest> comparator = new Comparator<DogForTest>() {
            @Override
            public int compare(DogForTest o1, DogForTest o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
        QuickSort.quickSort(dogsForTest, comparator);
        assertEquals("QuickSortTest.testQuickSort", 1, dogsForTest[0].getAge());
        try {
            InsertionSort.insertionSort(dogsForTest);
            assertFail("QuickSortTest.testQuickSort");
        } catch (ClassCastException e) {
            assertPass("QuickSortTest.testQuickSort");
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