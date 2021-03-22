package com.resume.java.DoublyLinkedList;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static com.resume.java.util.Assert.*;

public class DoublyLinkedListTest {

    public static void main(String[] args) {
        testSize();
        testGet();
        testBooleanAdd();
        testAdd();
        testBooleanRemove();
        testRemove();
        testCheckIndex();
        testListIterator();
    }

    public static void testSize() {
        DoublyLinkedList<Integer> test = new DoublyLinkedList<>();
        test.add(1);
        assertEquals("DoublyLinkedListTest.testSize", 1, test.size());
    }

    public static void testGet() {
        DoublyLinkedList<String> test = new DoublyLinkedList<>();
        test.add("test");
        assertEquals("DoublyLinkedListTest.testGet", "test", test.get(0));
    }

    public static void testBooleanAdd() {
        DoublyLinkedList<String> test = new DoublyLinkedList<>();
        assertEquals("DoublyLinkedListTest.testBooleanAdd", true, test.add("test"));
    }

    public static void testAdd() {
        DoublyLinkedList<String> test = new DoublyLinkedList<>();
        test.add("one");
        test.add("two");
        test.add("three");
        assertEquals("DoublyLinkedListTest.testAdd", "two", test.get(1));
    }

    public static void testBooleanRemove() {
        DoublyLinkedList<String> test = new DoublyLinkedList<>();
        test.add("one");
        test.add("two");
        test.add("three");
        assertEquals("DoublyLinkedListTest.testBooleanRemove", true, test.remove("two"));
        assertEquals("DoublyLinkedListTest.testBooleanRemove", false, test.remove("Dtwo"));
    }

    public static void testRemove() {
        DoublyLinkedList<String> test = new DoublyLinkedList<>();
        test.add("one");
        test.add("two");
        test.add("three");
        assertEquals("DoublyLinkedListTest.testRemove", "two", test.remove(1));
    }

    public static void testCheckIndex() {
        DoublyLinkedList<String> test = new DoublyLinkedList<>();
        test.add("one");
        try {
            test.checkIndex(111);
            assertFail("DoublyLinkedListTest.testCheckIndex");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("DoublyLinkedListTest.testCheckIndex passed");
        }
    }

    public static void testListIterator() {
        DoublyLinkedList<String> test = new DoublyLinkedList<>();
        test.add("one");
        test.add("two");
        test.add("three");
        ListIterator<String> listIterator = test.listIterator(0);
        assertEquals("DoublyLinkedList.testListIterator", true, listIterator.hasNext());
        assertEquals("DoublyLinkedList.testListIterator", false, listIterator.hasPrevious());
        try {
            listIterator.previous();
            assertFail("DoublyLinkedList.testListIterator");
        } catch (NoSuchElementException e) {
            assertPass("DoublyLinkedList.testListIterator");
        }
        assertEquals("DoublyLinkedList.testListIterator", "one", listIterator.next());
        assertEquals("DoublyLinkedList.testListIterator", 1, listIterator.nextIndex());
        assertEquals("DoublyLinkedList.testListIterator", 0, listIterator.previousIndex());
        listIterator.remove();
        assertEquals("DoublyLinkedList.testListIterator", 2, test.size());
        listIterator.next();
        listIterator.set("second, edited");
        assertEquals("DoublyLinkedList.testListIterator", "second, edited", listIterator.previous());
        listIterator.add("first");
        assertEquals("DoublyLinkedList.testListIterator", 3, test.size());
        try {
            test.add("oops");
            listIterator.next();
            assertFail("DoublyLinkedList.testListIterator");
        } catch (ConcurrentModificationException e) {
            assertPass("DoublyLinkedList.testListIterator");
        }
    }

}