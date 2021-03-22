package com.resume.java.AssociativeArray;

import java.util.Objects;

public class AssociativeArray<K, V> {
    static final int MAX_CAPACITY = 1073741824;

    private int size;
    private int limitSize;
    private int modCount;
    private Node<K, V>[] elementData;

    public AssociativeArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Wrong capacity");
        }
        if (initialCapacity > MAX_CAPACITY) {
            initialCapacity = MAX_CAPACITY;
        }
        limitSize = (int) (initialCapacity * 0.75);
        elementData = new Node[initialCapacity];
    }

    public AssociativeArray() {
        this(16);
    }

    public static void main(String[] args) {

    }

    public int getArrayCapacity() {
        return elementData.length;
    }

    public int getSize() {
        return size;
    }

    public V add(K key, V value) {
        if (size > limitSize) {
            resize();
        }
        int hash = calcHash(key);
        V oldValue;
        if (Objects.isNull(elementData[hash])) {
            elementData[hash] = new Node<>(key, value, hash, null);
            oldValue = value;
        } else {
            if (elementData[hash].key == key && elementData[hash].key.equals(key)) {
                oldValue = elementData[hash].getValue();
                elementData[hash].setValue(value);
            } else {
                oldValue = value;
                elementData[hash].next = new Node<>(key, value, hash, null);
            }
        }
        size++;
        return oldValue;
    }

    public V get(K key) {
        int hash = calcHash(key);
        if (Objects.isNull(elementData[hash].next)) {
            return elementData[hash].getValue();
        } else {
            Node<K, V> e = elementData[hash];
            do {
                if (e.getKey() == key && e.getKey().equals(key)) {
                    return e.getValue();
                } else {
                    e = e.next;
                }
            } while (Objects.nonNull(e));
        }
        return null;
    }

    public Node<K, V>[] resize() {
        int newCap = elementData.length * 2;
        if (elementData.length == MAX_CAPACITY) {
            System.out.println("Reached max array capacity. Capacity can not be increased");
            return elementData;
        }
        if (newCap > MAX_CAPACITY) {
            newCap = MAX_CAPACITY;
        }
        int newLimitSize = (int) (newCap * 0.75);
        Node<K, V>[] newElementData = new Node[newCap];
        for (Node<K, V> oldNode : elementData) {
            if (Objects.nonNull(oldNode)) {
                do {
                    int hash = calcHash(oldNode.getKey());
                    if (Objects.isNull(newElementData[hash])) {
                        newElementData[hash] = new Node<>(oldNode.getKey(), oldNode.getValue(), hash, null);
                    } else {
                        newElementData[hash].next = new Node<>(oldNode.getKey(), oldNode.getValue(), hash, null);
                    }
                    oldNode = oldNode.next;
                } while (Objects.nonNull(oldNode));
            }
        }
        limitSize = newLimitSize;
        elementData = newElementData;
        return newElementData;
    }

    public V remove(K key) {
        V oldValue = null;
        int hash = calcHash(key);
        if (Objects.isNull(elementData[hash].next)) {
            oldValue = elementData[hash].getValue();
            elementData[hash] = null;
            size--;
            return oldValue;
        } else {
            Node<K, V> e = elementData[hash];
            Node<K, V> eNext = e.next;
            if (e.getKey() == key && e.getKey().equals(key)) {
                oldValue = e.getValue();
                elementData[hash] = eNext;
            } else {
                do {
                    if (eNext.getKey() == key && eNext.equals(key)) {
                        oldValue = e.getValue();
                        e.next = eNext.next;
                        break;
                    }
                    e = e.next;
                    eNext = e.next;
                } while (Objects.nonNull(eNext));
            }
        }
        return oldValue;
    }

    int calcHash(K key) {
        int result = Objects.isNull(key) ? 0 : key.hashCode() % elementData.length;
        return result < 0 ? Math.negateExact(result) : result;
    }

    static class Node<K, V> {
        final K key;
        V value;
        int hash;
        Node<K, V> next;

        public Node(K key, V value, int hash, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

}