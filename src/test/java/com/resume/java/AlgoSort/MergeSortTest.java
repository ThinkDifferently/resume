package com.resume.java.AlgoSort;

import java.util.Comparator;

import static com.resume.java.util.Assert.assertEquals;

public class MergeSortTest {
    public static void main(String[] args) {
        testMergeSort();
    }

    public static void testMergeSort() {
        int[] intArray = {3, 1, 2};
        MergeSort.mergeSort(intArray);
        assertEquals("MergeSort.testMergeSort", 1, intArray[0]);

        long[] longArray = {3L, 1L, 2L};
        MergeSort.mergeSort(longArray);
        assertEquals("MergeSort.testMergeSort", 2L, longArray[1]);

        short[] shortArray = {3, 1, 2};
        MergeSort.mergeSort(shortArray);
        assertEquals("MergeSort.testMergeSort", 3, shortArray[2]);

        byte[] byteArray = {3, 1, 2};
        MergeSort.mergeSort(byteArray);
        assertEquals("MergeSort.testMergeSort", 1, byteArray[0]);

        char[] charArray = {'c', 'a', 'b'};
        MergeSort.mergeSort(charArray);
        assertEquals("MergeSort.testMergeSort", 'a', charArray[0]);

        float[] floatArray = {3F, 1F, 2F};
        MergeSort.mergeSort(floatArray);
        assertEquals("MergeSort.testMergeSort", 1F, floatArray[0]);

        double[] doubleArray = {3D, 1D, 2D};
        MergeSort.mergeSort(doubleArray);
        assertEquals("MergeSort.testMergeSort", 3D, doubleArray[2]);

        Character[] characters = {'c', 'a', 'b'};
        MergeSort.mergeSort(characters);
        assertEquals("MergeSort.testMergeSort", Character.valueOf('a'), characters[0]);

        CatForTest[] catsForTest = {new CatForTest(10, "FirstCat"), new CatForTest(7, "SecondCat")};
        MergeSort.mergeSort(catsForTest);
        assertEquals("MergeSort.testMergeSort", 7, catsForTest[0].getAge());

        DogForTest[] dogsForTest = {new DogForTest(2), new DogForTest(1)};
        Comparator<DogForTest> comparator = new Comparator<DogForTest>() {
            @Override
            public int compare(DogForTest o1, DogForTest o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
        MergeSort.mergeSort(dogsForTest, comparator);
        assertEquals("MergeSort.testMergeSort", 1, dogsForTest[0].getAge());
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