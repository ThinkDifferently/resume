package com.resume.java.AlgoSort;

import java.util.Comparator;
import java.util.Objects;

public class QuickSort {
    public static void main(String[] args) {

    }

    public static void quickSort(int[] array) {
        qSort(array, 0, array.length - 1);
    }

    public static void quickSort(long[] array) {
        qSort(array, 0, array.length - 1);
    }

    public static void quickSort(short[] array) {
        qSort(array, 0, array.length - 1);
    }

    public static void quickSort(byte[] array) {
        qSort(array, 0, array.length - 1);
    }

    public static void quickSort(char[] array) {
        qSort(array, 0, array.length - 1);
    }

    public static void quickSort(float[] array) {
        qSort(array, 0, array.length - 1);
    }

    public static void quickSort(double[] array) {
        qSort(array, 0, array.length - 1);
    }

    public static <T> void quickSort(T[] array) {
        qSort(array, 0, array.length - 1);
    }

    public static <T> void quickSort(T[] array, Comparator<? super T> c) {
        if (Objects.isNull(c)) {
            qSort(array, 0, array.length - 1);
        } else {
            qSort(array, 0, array.length - 1, c);
        }
    }

    public static int compare(Object first, Object second) {
        return ((Comparable<Object>) first).compareTo(second);
    }

    private static void qSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = i - (i - j) / 2;
        while (i < j) {
            while (i < pivot && array[i] <= array[pivot]) {
                i++;
            }
            while (j > pivot && array[pivot] <= array[j]) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
                if (i == pivot) {
                    pivot = j;
                } else if (j == pivot) {
                    pivot = i;
                }
            }
        }
        qSort(array, start, pivot);
        qSort(array, pivot + 1, end);
    }

    private static void qSort(long[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = i - (i - j) / 2;
        while (i < j) {
            while (i < pivot && array[i] <= array[pivot]) {
                i++;
            }
            while (j > pivot && array[pivot] <= array[j]) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
                if (i == pivot) {
                    pivot = j;
                } else if (j == pivot) {
                    pivot = i;
                }
            }
        }
        qSort(array, start, pivot);
        qSort(array, pivot + 1, end);
    }

    private static void qSort(short[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = i - (i - j) / 2;
        while (i < j) {
            while (i < pivot && array[i] <= array[pivot]) {
                i++;
            }
            while (j > pivot && array[pivot] <= array[j]) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
                if (i == pivot) {
                    pivot = j;
                } else if (j == pivot) {
                    pivot = i;
                }
            }
        }
        qSort(array, start, pivot);
        qSort(array, pivot + 1, end);
    }

    private static void qSort(byte[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = i - (i - j) / 2;
        while (i < j) {
            while (i < pivot && array[i] <= array[pivot]) {
                i++;
            }
            while (j > pivot && array[pivot] <= array[j]) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
                if (i == pivot) {
                    pivot = j;
                } else if (j == pivot) {
                    pivot = i;
                }
            }
        }
        qSort(array, start, pivot);
        qSort(array, pivot + 1, end);
    }

    private static void qSort(char[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = i - (i - j) / 2;
        while (i < j) {
            while (i < pivot && array[i] <= array[pivot]) {
                i++;
            }
            while (j > pivot && array[pivot] <= array[j]) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
                if (i == pivot) {
                    pivot = j;
                } else if (j == pivot) {
                    pivot = i;
                }
            }
        }
        qSort(array, start, pivot);
        qSort(array, pivot + 1, end);
    }

    private static void qSort(float[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = i - (i - j) / 2;
        while (i < j) {
            while (i < pivot && array[i] <= array[pivot]) {
                i++;
            }
            while (j > pivot && array[pivot] <= array[j]) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
                if (i == pivot) {
                    pivot = j;
                } else if (j == pivot) {
                    pivot = i;
                }
            }
        }
        qSort(array, start, pivot);
        qSort(array, pivot + 1, end);
    }

    private static void qSort(double[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = i - (i - j) / 2;
        while (i < j) {
            while (i < pivot && array[i] <= array[pivot]) {
                i++;
            }
            while (j > pivot && array[pivot] <= array[j]) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
                if (i == pivot) {
                    pivot = j;
                } else if (j == pivot) {
                    pivot = i;
                }
            }
        }
        qSort(array, start, pivot);
        qSort(array, pivot + 1, end);
    }

    private static <T> void qSort(T[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = i - (i - j) / 2;
        while (i < j) {
            while (i < pivot && compare(array[i], array[pivot]) <= 0) {
                i++;
            }
            while (j > pivot && compare(array[pivot], array[j]) <= 0) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
                if (i == pivot) {
                    pivot = j;
                } else if (j == pivot) {
                    pivot = i;
                }
            }
        }
        qSort(array, start, pivot);
        qSort(array, pivot + 1, end);
    }

    private static <T> void qSort(T[] array, int start, int end, Comparator<? super T> c) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = i - (i - j) / 2;
        while (i < j) {
            while (i < pivot && c.compare(array[i], array[pivot]) <= 0) {
                i++;
            }
            while (j > pivot && c.compare(array[pivot], array[j]) <= 0) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
                if (i == pivot) {
                    pivot = j;
                } else if (j == pivot) {
                    pivot = i;
                }
            }
        }
        qSort(array, start, pivot, c);
        qSort(array, pivot + 1, end, c);
    }

    private static void swap(int[] x, int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    private static void swap(long[] x, int a, int b) {
        long t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    private static void swap(short[] x, int a, int b) {
        short t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    private static void swap(byte[] x, int a, int b) {
        byte t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    private static void swap(double[] x, int a, int b) {
        double t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    private static void swap(float[] x, int a, int b) {
        float t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    private static void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    private static <T> void swap(T[] x, int a, int b) {
        T t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

}