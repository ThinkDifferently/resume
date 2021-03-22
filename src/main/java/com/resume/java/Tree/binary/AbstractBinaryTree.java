package com.resume.java.Tree.binary;

import com.resume.java.Tree.AbstractTree;
import com.resume.java.Tree.Node;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    @Override
    public Node<E> sibling(Node<E> n) throws IllegalArgumentException {
        if (left(parent(n)) == n) {
            return right(parent(n));
        } else {
            return left(parent(n));
        }
    }

    @Override
    public Collection<Node<E>> children(Node<E> n) throws IllegalArgumentException {
        LinkedList<Node<E>> result = new LinkedList<>();
        if (Objects.nonNull(left(n))) {
            result.add(left(n));
        }
        if (Objects.nonNull(right(n))) {
            result.add(right(n));
        }
        return result;
    }

    @Override
    public int childrenNumber(Node<E> n) throws IllegalArgumentException {
        int i = 0;
        if (Objects.nonNull(right(n))) {
            i++;
        }
        if (Objects.nonNull(left(n))) {
            i++;
        }
        return i;
    }

    /**
     * @return an iterable collection of nodes of the tree in inorder
     */
    public Collection<Node<E>> inOrder() {
        LinkedList<Node<E>> result = new LinkedList<>();
        return inOrderRecursion(root(), result);
    }

    private Collection<Node<E>> inOrderRecursion(Node<E> node, Collection<Node<E>> result) {
        if (node == null) {
            return result;
        }
        inOrderRecursion(left(node), result);
        result.add(node);
        System.out.println(node);
        inOrderRecursion(right(node), result);
        return result;
    }

}