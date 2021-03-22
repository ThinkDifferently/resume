package java.com.resume.morozovm.lesson04;

import com.resume.java.DoublyLinkedList.DoublyLinkedList;
import com.resume.java.util.StopWatch;

import java.util.LinkedList;

public class DLLPerfomanceTest {
    public static void main(String[] args) {
        testPerfomanceAddInMiddleDLL();
    }

    public static void testPerfomanceAddInBeginDLL() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();
        StopWatch timer = new StopWatch();
        timer.start();
        for (int i = 0; i < 2_000_000; i++) {
            testDLL.add(0, i);
        }
        System.out.println("Result for DoublyLinkedList (Addition to the begin) = " + timer.getElapsedTime() + " ms");
    }

    public static void testPerfomanceAddInBeginLL() {
        LinkedList<Integer> testLL = new LinkedList<>();
        StopWatch timer = new StopWatch();
        timer.start();
        for (int i = 0; i < 2_000_000; i++) {
            testLL.add(0, i);
        }
        System.out.println("Result for LinkedList (Addition to the begin) = " + timer.getElapsedTime() + " ms");
    }

    public static void testPerfomanceAddInMiddleDLL() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();
        StopWatch timer = new StopWatch();
        timer.start();
        for (int i = 0; i < 30_000; i++) {
            testDLL.add(i / 2, i);
        }
        System.out.println("Result for DoublyLinkedList (Addition to the middle) = " + timer.getElapsedTime() + " ms");
    }

    public static void testPerfomanceAddInMiddleLL() {
        LinkedList<Integer> testLL = new LinkedList<>();
        StopWatch timer = new StopWatch();
        timer.start();
        for (int i = 0; i < 30_000; i++) {
            testLL.add(i / 2, i);
        }
        System.out.println("Result for LinkedList (Addition to the middle) = " + timer.getElapsedTime() + " ms");
    }

    public static void testPerfomanceAddInEndDLL() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();
        StopWatch timer = new StopWatch();
        timer.start();
        for (int i = 0; i < 2_000_000; i++) {
            testDLL.add(i);
        }
        System.out.println("Result for DoublyLinkedList (Addition to the end) = " + timer.getElapsedTime() + " ms");
    }

    public static void testPerfomanceAddInEndLL() {
        LinkedList<Integer> testLL = new LinkedList<>();
        StopWatch timer = new StopWatch();
        timer.start();
        for (int i = 0; i < 2_000_000; i++) {
            testLL.add(i);
        }
        System.out.println("Result for LinkedList (Addition to the end) = " + timer.getElapsedTime() + " ms");
    }

    public static void testPerfomanceRemoveFromBeginDLL() {
        DoublyLinkedList<Byte> testDLL = new DoublyLinkedList<>();
        StopWatch timer = new StopWatch();
        byte b = 1;
        for (int i = 0; i < 20_000_000; i++) {
            testDLL.add(b);
        }
        timer.start();
        for (int i = 0; i < 20_000_000; i++) {
            testDLL.remove(0);
        }
        System.out.println("Result for DoublyLinkedList (Remove from begin) = " + timer.getElapsedTime() + " ms");
    }

    public static void testPerfomanceRemoveFromBeginLL() {
        DoublyLinkedList<Byte> testLL = new DoublyLinkedList<>();
        StopWatch timer = new StopWatch();
        byte b = 1;
        for (int i = 0; i < 20_000_000; i++) {
            testLL.add(b);
        }
        timer.start();
        for (int i = 0; i < 20_000_000; i++) {
            testLL.remove(0);
        }
        System.out.println("Result for LinkedList (Remove from begin) = " + timer.getElapsedTime() + " ms");
    }

    public static void testPerfomanceRemoveFromMiddleDLL() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < 50_000; i++) {
            testDLL.add(i);
        }
        timer.start();
        for (int j = 0; j < 50_000; j++) {
            testDLL.remove(testDLL.size() / 2);
        }
        System.out.println("Result for DoublyLinkedList (Remove from middle) = " + timer.getElapsedTime() + " ms");
    }

    public static void testPerfomanceRemoveFromMiddleLL() {
        LinkedList<Integer> testLL = new LinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < 50_000; i++) {
            testLL.add(i);
        }
        timer.start();
        for (int j = 0; j < 50_000; j++) {
            testLL.remove(testLL.size() / 2);
        }
        System.out.println("Result for LinkedList (Remove from middle) = " + timer.getElapsedTime() + " ms");
    }

    public static void testPerfomanceRemoveFromEndDLL() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < 10_000_000; i++) {
            testDLL.add(i);
        }
        timer.start();
        for (int j = 0; j < 10_000_000; j++) {
            testDLL.remove(testDLL.size());
        }
        System.out.println("Result for DoublyLinkedList (Remove from end) = " + timer.getElapsedTime() + " ms");
    }

    public static void testPerfomanceRemoveFromEndLL() {
        LinkedList<Integer> testLL = new LinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < 10_000_001; i++) {
            testLL.add(i);
        }
        timer.start();
        for (int j = 0; j < 10_000_000; j++) {
            testLL.remove(testLL.size() - 1);
        }
        System.out.println("Result for LinkedList (Remove from end) = " + timer.getElapsedTime() + " ms");
    }
}