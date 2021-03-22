package com.resume.java.AlgoSort;

import java.util.Comparator;
import java.util.Objects;

public class MergeSort {
    public static void main(String[] args) {

    }

    public static void mergeSort(int[] array) {
        int[] aux = new int[array.length];
        mSort(array, 0, array.length - 1, aux);
    }

    public static void mergeSort(long[] array) {
        long[] aux = new long[array.length];
        mSort(array, 0, array.length - 1, aux);
    }

    public static void mergeSort(short[] array) {
        short[] aux = new short[array.length];
        mSort(array, 0, array.length - 1, aux);
    }

    public static void mergeSort(byte[] array) {
        byte[] aux = new byte[array.length];
        mSort(array, 0, array.length - 1, aux);
    }

    public static void mergeSort(char[] array) {
        char[] aux = new char[array.length];
        mSort(array, 0, array.length - 1, aux);
    }

    public static void mergeSort(float[] array) {
        float[] aux = new float[array.length];
        mSort(array, 0, array.length - 1, aux);
    }

    public static void mergeSort(double[] array) {
        double[] aux = new double[array.length];
        mSort(array, 0, array.length - 1, aux);
    }

    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        Object[] aux = new Object[array.length];
        mSort(array, 0, array.length - 1, aux);
    }

    public static <T> void mergeSort(T[] array, Comparator<? super T> c) {
        if (Objects.isNull(c)) {
            throw new NullPointerException("Comparator is null");
        } else {
            T[] aux = (T[]) new Object[array.length];
            mSort(array, 0, array.length - 1, aux, c);
        }
    }

    public static int compare(Object first, Object second) {
        return ((Comparable<Object>) first).compareTo(second);
    }

    private static void merge(int[] array, int l, int m, int r, int[] aux) {
        for (int i = l; i <= r; i++) {
            aux[i] = array[i];
        }
        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                array[k] = aux[j++];
            } else if (j > r) {
                array[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

    private static void mSort(int[] array, int l, int r, int[] aux) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mSort(array, l, mid, aux);
        mSort(array, mid + 1, r, aux);
        merge(array, l, mid, r, aux);
    }

    private static void merge(long[] array, int l, int m, int r, long[] aux) {
        for (int i = l; i <= r; i++) {
            aux[i] = array[i];
        }
        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                array[k] = aux[j++];
            } else if (j > r) {
                array[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

    private static void mSort(long[] array, int l, int r, long[] aux) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mSort(array, l, m, aux);
            mSort(array, m + 1, r, aux);
            merge(array, l, m, r, aux);
        }
    }

    private static void merge(short[] array, int l, int m, int r, short[] aux) {
        for (int i = l; i <= r; i++) {
            aux[i] = array[i];
        }
        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                array[k] = aux[j++];
            } else if (j > r) {
                array[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

    private static void mSort(short[] array, int l, int r, short[] aux) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mSort(array, l, m, aux);
            mSort(array, m + 1, r, aux);
            merge(array, l, m, r, aux);
        }
    }

    private static void merge(byte[] array, int l, int m, int r, byte[] aux) {
        for (int i = l; i <= r; i++) {
            aux[i] = array[i];
        }
        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                array[k] = aux[j++];
            } else if (j > r) {
                array[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

    private static void mSort(byte[] array, int l, int r, byte[] aux) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mSort(array, l, m, aux);
            mSort(array, m + 1, r, aux);
            merge(array, l, m, r, aux);
        }
    }

    private static void merge(char[] array, int l, int m, int r, char[] aux) {
        for (int i = l; i <= r; i++) {
            aux[i] = array[i];
        }
        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                array[k] = aux[j++];
            } else if (j > r) {
                array[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

    private static void mSort(char[] array, int l, int r, char[] aux) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mSort(array, l, m, aux);
            mSort(array, m + 1, r, aux);
            merge(array, l, m, r, aux);
        }
    }

    private static void merge(float[] array, int l, int m, int r, float[] aux) {
        for (int i = l; i <= r; i++) {
            aux[i] = array[i];
        }
        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                array[k] = aux[j++];
            } else if (j > r) {
                array[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

    private static void mSort(float[] array, int l, int r, float[] aux) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mSort(array, l, m, aux);
            mSort(array, m + 1, r, aux);
            merge(array, l, m, r, aux);
        }
    }

    private static void merge(double[] array, int l, int m, int r, double[] aux) {
        for (int i = l; i <= r; i++) {
            aux[i] = array[i];
        }
        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                array[k] = aux[j++];
            } else if (j > r) {
                array[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

    private static void mSort(double[] array, int l, int r, double[] aux) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mSort(array, l, m, aux);
            mSort(array, m + 1, r, aux);
            merge(array, l, m, r, aux);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] array, int l, int m, int r, Object[] aux) {
        for (int i = l; i <= r; i++) {
            aux[i] = array[i];
        }
        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                array[k] = (T) aux[j++];
            } else if (j > r) {
                array[k] = (T) aux[i++];
            } else if (((T) aux[i]).compareTo((T) aux[j]) <= 0) {
                array[k] = (T) aux[i++];
            } else {
                array[k] = (T) aux[j++];
            }
        }
    }

    private static <T extends Comparable<T>> void mSort(T[] array, int l, int r, Object[] aux) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mSort(array, l, m, aux);
            mSort(array, m + 1, r, aux);
            merge(array, l, m, r, aux);
        }
    }

    private static <T> void merge(T[] array, int l, int m, int r, Object[] aux, Comparator<? super T> c) {
        for (int i = l; i <= r; i++) {
            aux[i] = array[i];
        }
        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                array[k] = (T) aux[j++];
            } else if (j > r) {
                array[k] = (T) aux[i++];
            } else if (c.compare((T) aux[i], (T) aux[j]) <= 0) {
                array[k] = (T) aux[i++];
            } else {
                array[k] = (T) aux[j++];
            }
        }
    }

    private static <T> void mSort(T[] array, int l, int r, Object[] aux, Comparator<? super T> c) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mSort(array, l, m, aux, c);
            mSort(array, m + 1, r, aux, c);
            merge(array, l, m, r, aux, c);
        }
    }

}