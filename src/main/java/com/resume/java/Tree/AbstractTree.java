package com.resume.java.Tree;

import java.util.*;

/**
 * An abstract base class providing some functionality of the Tree interface
 *
 * @param <E> element
 */
public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean isInternal(Node<E> n) throws IllegalArgumentException {
        return childrenNumber(n) > 0;
    }

    @Override
    public boolean isExternal(Node<E> n) throws IllegalArgumentException {
        return childrenNumber(n) == 0;
    }

    @Override
    public boolean isRoot(Node<E> n) throws IllegalArgumentException {
        return n == root();
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(root());
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    /**
     * @return an iterable collection of nodes of the tree in preorder
     */
    public Collection<Node<E>> preOrder() {
        LinkedList<Node<E>> res = new LinkedList<>();
        return preOrderRecursion(root(), res);
    }

    /**
     * @return an iterable collection of nodes of the tree in postorder
     */
    public Collection<Node<E>> postOrder() {
        LinkedList<Node<E>> res = new LinkedList<>();
        return postOrderRecursion(root(), res);
    }

    /**
     * @return an iterable collection of nodes of the tree in breadth-first order
     */
    public Collection<Node<E>> breadthFirst() {
        LinkedList<Node<E>> result = new LinkedList<>();
        Queue<Node<E>> tempQueue = new LinkedList<>();
        tempQueue.add(root());
        Node<E> node;
        while (!tempQueue.isEmpty()) {
            node = tempQueue.poll();
            result.add(node);
            LinkedList<Node<E>> childrenOfNode = new LinkedList<>();
            childrenOfNode.addAll(children(node));
            for (Node<E> eNode : childrenOfNode) {
                tempQueue.add(eNode);
            }
        }
        return result;
    }

    private Collection<Node<E>> preOrderRecursion(Node<E> node, Collection<Node<E>> result) {
        if (Objects.isNull(node)) {
            return result;
        }
        System.out.println(node);
        result.add(node);
        LinkedList<Node<E>> childrenOfNode = new LinkedList<>();
        childrenOfNode.addAll(children(node));
        for (Node<E> eNode : childrenOfNode) {
            preOrderRecursion(eNode, result);
        }
        return result;
    }

    private Collection<Node<E>> postOrderRecursion(Node<E> node, Collection<Node<E>> result) {
        if (Objects.isNull(node)) {
            return result;
        }
        LinkedList<Node<E>> childrenOfNode = new LinkedList<>();
        childrenOfNode.addAll(children(node));
        for (Node<E> eNode : childrenOfNode) {
            postOrderRecursion(eNode, result);
        }
        System.out.println(node);
        result.add(node);
        return result;
    }

    /**
     * Adapts the iteration produced by {@link Tree#nodes()}
     */
    private class ElementIterator implements Iterator<E> {
        private Iterator<Node<E>> it = nodes().iterator();

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public E next() {
            return it.next().getElement();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}