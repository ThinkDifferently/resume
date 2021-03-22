package com.resume.java.Tree;

import com.resume.java.Tree.binary.LinkedBinaryTree;

import static com.resume.java.util.Assert.*;

public class LinkedBinaryTreeTest {
    public static void main(String[] args) {
        testValidate();
        testAddRoot();
        testAdd();
        testAddLeft();
        testAddRight();
        testSet();
        testRemove();
        testLeft();
        testRight();
        testRoot();
        testParent();
        testSize();
    }

    public static void testValidate() {
        LinkedBinaryTree testTree = new LinkedBinaryTree<>();
        Node<Integer> rootNode = testTree.addRoot(1);
        assertEquals("LinkedBinaryTreeTest.testValidate", testTree.validate(rootNode), rootNode);
        try {
            testTree.validate(testTree.left(testTree.root()));
            assertFail("LinkedBinaryTreeTest.testValidate");
        } catch (IllegalArgumentException e) {
            assertPass("LinkedBinaryTreeTest.testValidate");
        }
    }

    public static void testAddRoot() {
        LinkedBinaryTree testTree = new LinkedBinaryTree();
        Node<Integer> nodeRoot = testTree.addRoot(1);
        assertEquals("LinkedBinaryTreeTest.testAddRoot", testTree.root(), nodeRoot);
        assertEquals("LinkedBinaryTreeTest.testAddRoot", 1, testTree.size());
    }

    public static void testAdd() {
        LinkedBinaryTree testTree = new LinkedBinaryTree();
        Node<Integer> nodeRoot = testTree.addRoot(1);
        Node<Integer> nodeLeft = testTree.add(testTree.root(), 5);
        assertEquals("LinkedBinaryTreeTest.testAdd", nodeLeft, testTree.validate(nodeRoot).getLeft());
        assertEquals("LinkedBinaryTreeTest.testAdd", 2, testTree.size());
        Node<Integer> nodeRight = testTree.add(testTree.root(), 6);
        assertEquals("LinkedBinaryTreeTest.testAdd", nodeRight, testTree.validate(nodeRoot).getRight());
        assertEquals("LinkedBinaryTreeTest.testAdd", 3, testTree.size());
        try {
            testTree.add(testTree.root(), 11);
            assertFail("LinkedBinaryTreeTest.testAdd");
        } catch (IllegalArgumentException e) {
            assertPass("LinkedBinaryTreeTest.testAdd");
        }
        assertEquals("LinkedBinaryTreeTest.testAdd", 3, testTree.size());
    }

    public static void testAddLeft() {
        LinkedBinaryTree testTree = new LinkedBinaryTree();
        Node<Integer> nodeRoot = testTree.addRoot(1);
        Node<Integer> nodeLeft = testTree.addLeft(testTree.root(), 5);
        assertEquals("LinkedBinaryTreeTest.testAddLeft", nodeLeft, testTree.validate(nodeRoot).getLeft());
        assertEquals("LinkedBinaryTreeTest.testAddLeft", 2, testTree.size());
    }

    public static void testAddRight() {
        LinkedBinaryTree testTree = new LinkedBinaryTree();
        Node<Integer> nodeRoot = testTree.addRoot(1);
        Node<Integer> nodeRight = testTree.addRight(testTree.root(), 5);
        assertEquals("LinkedBinaryTreeTest.testAddRight", nodeRight, testTree.validate(nodeRoot).getRight());
        assertEquals("LinkedBinaryTreeTest.testAddRight", 2, testTree.size());
    }

    public static void testSet() {
        LinkedBinaryTree testTree = new LinkedBinaryTree();
        Node nodeRoot = testTree.addRoot(1);
        assertEquals("LinkedBinaryTreeTest.testSet", 1, testTree.root().getElement());
        testTree.set(nodeRoot, 3);
        assertEquals("LinkedBinaryTreeTest.testSet", 3, testTree.root().getElement());
        try {
            testTree.set(null, 3);
            assertFail("LinkedBinaryTreeTest.testSet");
        } catch (IllegalArgumentException e) {
            assertPass("LinkedBinaryTreeTest.testSet");
        }
    }

    public static void testRemove() {
        LinkedBinaryTree testTree = new LinkedBinaryTree();
        Node nodeRoot = testTree.addRoot(1);
        Node nodeRight1 = testTree.addRight(nodeRoot, 3);
        Node nodeLeft1 = testTree.addLeft(nodeRoot, 2);
        Node nodeRight2 = testTree.addRight(nodeRight1, 4);
        Node nodeLeft2 = testTree.addLeft(nodeRight1, 5);
        try {
            testTree.remove(nodeRight1);
            assertFail("LinkedBinaryTreeTest.testRemove");
        } catch (IllegalArgumentException e) {
            assertPass("LinkedBinaryTreeTest.testRemove");
        }
        assertEquals("LinkedBinaryTreeTest.testRemove", 4, testTree.remove(nodeRight2));
        assertEquals("LinkedBinaryTreeTest.testRemove", 5, testTree.remove(nodeLeft2));
    }

    public static void testLeft() {
        LinkedBinaryTree testTree = new LinkedBinaryTree();
        Node nodeRoot = testTree.addRoot(1);
        Node nodeLeft1 = testTree.addLeft(nodeRoot, 2);
        assertEquals("LinkedBinaryTreeTest.testLeft", nodeLeft1, testTree.left(nodeRoot));
    }

    public static void testRight() {
        LinkedBinaryTree testTree = new LinkedBinaryTree();
        Node nodeRoot = testTree.addRoot(1);
        Node nodeRight1 = testTree.addRight(nodeRoot, 3);
        assertEquals("LinkedBinaryTreeTest.testRight", nodeRight1, testTree.right(nodeRoot));
    }

    public static void testRoot() {
        LinkedBinaryTree testTree = new LinkedBinaryTree();
        Node nodeRoot = testTree.addRoot(1);
        assertEquals("LinkedBinaryTreeTest.testRoot", nodeRoot, testTree.root());
    }

    public static void testParent() {
        LinkedBinaryTree testTree = new LinkedBinaryTree();
        Node nodeRoot = testTree.addRoot(1);
        Node nodeRight1 = testTree.addRight(nodeRoot, 3);
        assertEquals("LinkedBinaryTreeTest.testParent", null, testTree.parent(nodeRoot));
        assertEquals("LinkedBinaryTreeTest.testParent", testTree.root(), testTree.parent(nodeRight1));
    }

    public static void testSize() {
        LinkedBinaryTree testTree = new LinkedBinaryTree();
        Node nodeRoot = testTree.addRoot(1);
        Node nodeRight1 = testTree.addRight(nodeRoot, 3);
        assertEquals("LinkedBinaryTreeTest.testSize", 2, testTree.size());
        Node nodeLeft1 = testTree.addLeft(nodeRoot, 2);
        assertEquals("LinkedBinaryTreeTest.testSize", 3, testTree.size());
        testTree.remove(nodeRight1);
        assertEquals("LinkedBinaryTreeTest.testSize", 2, testTree.size());
    }

}