package com.resume.java.AlgoSort;

import java.util.Comparator;

import static com.resume.java.util.Assert.*;

public class BubbleSortTest {
    public static void main(String[] args) {
        testBubbleSort();
    }

    public static void testBubbleSort() {
        int[] intArray = {3, 1, 2};
        BubbleSort.bubbleSort(intArray);
        assertEquals("BubbleSortTest.testBubbleSort", 1, intArray[0]);

        long[] longArray = {3L, 1L, 2L};
        BubbleSort.bubbleSort(longArray);
        assertEquals("BubbleSortTest.testBubbleSort", 2L, longArray[1]);

        short[] shortArray = {3, 1, 2};
        BubbleSort.bubbleSort(shortArray);
        assertEquals("BubbleSortTest.testBubbleSort", 3, shortArray[2]);

        byte[] byteArray = {3, 1, 2};
        BubbleSort.bubbleSort(byteArray);
        assertEquals("BubbleSortTest.testBubbleSort", 3, byteArray[2]);

        char[] charArray = {'b', 'a', 'c'};
        BubbleSort.bubbleSort(charArray);
        assertEquals("BubbleSortTest.testBubbleSort", 'a', charArray[0]);

        float[] floatArray = {3F, 1F, 2F};
        BubbleSort.bubbleSort(floatArray);
        assertEquals("BubbleSortTest.testBubbleSort", 3F, floatArray[2]);

        double[] doubleArray = {3D, 1D, 2D};
        BubbleSort.bubbleSort(doubleArray);
        assertEquals("BubbleSortTest.testBubbleSort", 2D, doubleArray[1]);

        Character[] charactersArray = {'b', 'a', 'c'};
        BubbleSort.bubbleSort(charactersArray);
        assertEquals("BubbleSortTest.testBubbleSort", Character.valueOf('b'), charactersArray[1]);

        CatForTest[] catsForTest = {new CatForTest(10, "FirstCat"), new CatForTest(7, "SecondCat")};
        BubbleSort.bubbleSort(catsForTest);
        assertEquals("BubbleSortTest.testBubbleSort", 7, catsForTest[0].getAge());

        DogForTest[] dogsForTest = {new DogForTest(2), new DogForTest(1)};
        Comparator<DogForTest> comparator = new Comparator<DogForTest>() {
            @Override
            public int compare(DogForTest o1, DogForTest o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
        BubbleSort.bubbleSort(dogsForTest, comparator);
        assertEquals("BubbleSortTest.testBubbleSort", 1, dogsForTest[0].getAge());
        try {
            BubbleSort.bubbleSort(dogsForTest);
            assertFail("BubbleSortTest.testBubbleSort");
        } catch (ClassCastException e) {
            assertPass("BubbleSortTest.testBubbleSort");
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