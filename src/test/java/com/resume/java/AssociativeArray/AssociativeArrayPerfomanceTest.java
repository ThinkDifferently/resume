package java.com.resume.morozovm.lesson06;

import com.resume.java.AssociativeArray.AssociativeArray;
import com.resume.java.util.StopWatch;

import java.util.HashMap;

public class AssociativeArrayPerfomanceTest {
    public static void main(String[] args) {
        testGetAR();
    }

    public static void testAddHM() {
        HashMap<Integer, String> testHM = new HashMap<>();
        StopWatch timer = new StopWatch();
        timer.start();
        for (int i = 0; i < 1_000_000; i++) {
            testHM.put(i, "as" + i);
        }
        System.out.println("Result for HashMap (Add) = " + timer.getElapsedTime() + " ms");
    }

    public static void testAddAR() {
        AssociativeArray<Integer, String> testAR = new AssociativeArray<>();
        StopWatch timer = new StopWatch();
        timer.start();
        for (int i = 0; i < 1_000_000; i++) {
            testAR.add(i, "as" + i);
        }
        System.out.println("Result for AssociativeArray (Add) = " + timer.getElapsedTime() + " ms");
    }

    public static void testRemoveAR() {
        AssociativeArray<Integer, String> testAR = new AssociativeArray<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < 3_000_000; i++) {
            testAR.add(i, "as" + i);
        }
        timer.start();
        for (int i = 0; i < 3_000_000; i++) {
            testAR.remove(i);
        }
        System.out.println("Result for AssociativeArray (Remove) = " + timer.getElapsedTime() + " ms");
    }

    public static void testRemoveHM() {
        HashMap<Integer, String> testHM = new HashMap<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < 3_000_000; i++) {
            testHM.put(i, "as" + i);
        }
        timer.start();
        for (int i = 0; i < 3_000_000; i++) {
            testHM.remove(i);
        }
        System.out.println("Result for HashMap (Remove) = " + timer.getElapsedTime() + " ms");
    }

    public static void testGetAR() {
        AssociativeArray<Integer, String> testAR = new AssociativeArray<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < 3_000_000; i++) {
            testAR.add(i, "as" + i);
        }
        timer.start();
        for (int i = 0; i < 3_000_000; i++) {
            testAR.get(i);
        }
        System.out.println("Result for AssociativeArray (Get) = " + timer.getElapsedTime() + " ms");
    }

    public static void testGetHM() {
        HashMap<Integer, String> testHM = new HashMap<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < 3_000_000; i++) {
            testHM.put(i, "as" + i);
        }
        timer.start();
        for (int i = 0; i < 3_000_000; i++) {
            testHM.get(i);
        }
        System.out.println("Result for HashMap (Get) = " + timer.getElapsedTime() + " ms");
    }
}