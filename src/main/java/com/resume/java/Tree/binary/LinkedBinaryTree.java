package com.resume.java.Tree.binary;

import com.resume.java.Tree.Node;

import java.util.*;

/**
 * Concrete implementation of a binary tree using a node-based, linked structure
 *
 * @param <E> element
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    private Node<E> root;
    private int size;

    public static void main(String[] args) {

    }

    @Override
    public String toString() {
        Queue<Node<E>> currentLevel = new LinkedList<>();
        Queue<Node<E>> nextLevel = new LinkedList<>();
        currentLevel.add(root);
        StringBuilder result = new StringBuilder();
        while (!currentLevel.isEmpty()) {
            while (!currentLevel.isEmpty()) {
                Node<E> curNode = currentLevel.poll();
                if (Objects.isNull(curNode)) {
                    result.append("- ");
                } else {
                    result.append(curNode + " ");
                }
                if (Objects.nonNull(curNode)) {
                    if (Objects.isNull(validate(curNode).getLeft())) {
                        nextLevel.add(null);
                    } else {
                        nextLevel.add(left(curNode));
                    }
                    if (Objects.isNull(validate(curNode).getRight())) {
                        nextLevel.add(null);
                    } else {
                        nextLevel.add(right(curNode));
                    }
                }
            }
            currentLevel.addAll(nextLevel);
            nextLevel.clear();
            result.append(System.lineSeparator());
        }
        return new String(result);
    }

    @Override
    public Node<E> addRoot(E e) throws IllegalStateException {
        if (Objects.nonNull(root)) {
            throw new IllegalStateException("Root is already exists");
        }
        root = new NodeImpl<>(e);
        size++;
        return root;
    }

    @Override
    public Node<E> add(Node<E> n, E e) throws IllegalArgumentException {
        if (Objects.isNull(validate(n).getLeft())) {
            return addLeft(n, e);
        } else if (Objects.isNull(validate(n).getRight())) {
            return addRight(n, e);
        } else {
            throw new IllegalArgumentException("Node n already have right and left child");
        }
    }

    @Override
    public Node<E> addLeft(Node<E> n, E e) throws IllegalArgumentException {
        Node<E> leftNode = new NodeImpl<>(null, null, n, e);
        validate(n).setLeft(leftNode);
        size++;
        return leftNode;
    }

    @Override
    public Node<E> addRight(Node<E> n, E e) throws IllegalArgumentException {
        Node<E> rightNode = new NodeImpl<>(null, null, n, e);
        validate(n).setRight(rightNode);
        size++;
        return rightNode;
    }

    /**
     * Replaces the element at {@link Node} <i>n</i> with <i>e</i>
     *
     * @param n node
     * @param e element
     * @return replace element
     * @throws IllegalArgumentException
     */
    @Override
    public E set(Node<E> n, E e) throws IllegalArgumentException {
        E value = validate(n).getElement();
        validate(n).setElement(e);
        return value;
    }

    /**
     * Replaces the element at {@link Node} <i>n</i> with <i>e</i>
     *
     * @param n node
     * @return replace element
     * @throws IllegalArgumentException
     */
    @Override
    public E remove(Node<E> n) throws IllegalArgumentException {
        E result = validate(n).getElement();
        if (Objects.isNull(validate(n).getLeft())) {
            if (Objects.isNull(validate(n).getRight())) {
                if (left(parent(n)) == n) {
                    validate(parent(n)).setLeft(null);
                } else {
                    validate(parent(n)).setRight(null);
                }
            } else {
                if (left(parent(n)) == n) {
                    validate(parent(n)).setLeft(validate(n).getRight());
                } else {
                    validate(parent(n)).setRight(validate(n).getRight());
                }
            }
        } else if (Objects.isNull(validate(n).getRight())) {
            if (left(parent(n)) == n) {
                validate(parent(n)).setLeft(validate(n).getLeft());
            } else {
                validate(parent(n)).setRight(validate(n).getLeft());
            }
        } else {
            throw new IllegalArgumentException("Node n have left and right child");
        }
        size--;
        return result;
    }

    // {@link Tree} and {@link BinaryTree} implementations

    @Override
    public Node<E> left(Node<E> p) throws IllegalArgumentException {
        return validate(p).getLeft();
    }

    @Override
    public Node<E> right(Node<E> p) throws IllegalArgumentException {
        return validate(p).getRight();
    }

    @Override
    public Node<E> root() {
        return root;
    }

    @Override
    public Node<E> parent(Node<E> n) throws IllegalArgumentException {
        return validate(n).getParent();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        Collection<Node<E>> nodes = nodes();
        LinkedList<E> result = new LinkedList<>();
        for (Node<E> x : nodes) {
            result.add(x.getElement());
        }
        return result.iterator();
    }

    @Override
    public Collection<Node<E>> nodes() {
        return breadthFirst();
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    /**
     * Validates the node is an instance of supported {@link NodeImpl} type and casts to it
     *
     * @param n node
     * @return casted {@link NodeImpl} node
     * @throws IllegalArgumentException
     */
    public NodeImpl<E> validate(Node<E> n) throws IllegalArgumentException {
        if (n instanceof NodeImpl) {
            return (NodeImpl<E>) n;
        } else {
            throw new IllegalArgumentException("Unsupported type of n");
        }
    }

    public static class NodeImpl<E> implements Node<E> {

        Node<E> right;
        Node<E> left;
        Node<E> parent;
        E element;

        public NodeImpl(E element) {
            this.element = element;
        }

        public NodeImpl(Node<E> right, Node<E> left, Node<E> parent, E element) {
            this.right = right;
            this.left = left;
            this.parent = parent;
            this.element = element;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        @Override
        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

}