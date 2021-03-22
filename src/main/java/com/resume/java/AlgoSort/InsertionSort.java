package com.resume.java.AlgoSort;

import java.util.Comparator;
import java.util.Objects;

public class InsertionSort {
    public static void main(String[] args) {

    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void insertionSort(long[] array) {
        for (int i = 1; i < array.length; ++i) {
            long key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void insertionSort(short[] array) {
        for (int i = 1; i < array.length; ++i) {
            short key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void insertionSort(byte[] array) {
        for (int i = 1; i < array.length; ++i) {
            byte key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void insertionSort(char[] array) {
        for (int i = 1; i < array.length; ++i) {
            char key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void insertionSort(float[] array) {
        for (int i = 1; i < array.length; ++i) {
            float key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void insertionSort(double[] array) {
        for (int i = 1; i < array.length; ++i) {
            double key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static <T> void insertionSort(T[] array) {
        for (int i = 1; i < array.length; ++i) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static <T> void insertionSort(T[] array, Comparator<? super T> c) {
        if (Objects.isNull(c)) {
            insertionSort(array);
        } else {
            for (int i = 1; i < array.length; ++i) {
                T key = array[i];
                int j = i - 1;
                while (j >= 0 && c.compare(array[j], key) > 0) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = key;
            }
        }
    }

    public static int compare(Object first, Object second) {
        return ((Comparable<Object>) first).compareTo(second);
    }

}