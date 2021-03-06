package com.resume.java.Tree;

/**
 * An abstraction for a node of a tree
 *
 * @param <E> element
 */
public interface Node<E> {

    /**
     * @return the element stored at this node
     */
    E getElement();

}