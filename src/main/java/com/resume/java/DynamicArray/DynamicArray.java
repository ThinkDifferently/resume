package com.resume.java.DynamicArray;

import java.util.*;

public class DynamicArray<V> implements List<V> {

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private Object[] arrayData;
    private int size;
    private int modCount;

    public DynamicArray(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Wrong size of dynamic array");
        }
        this.arrayData = new Object[initialSize];
    }

    public DynamicArray() {
        this(10);
    }

    public static void main(String[] args) {

    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<V> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <V> V[] toArray(V[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<V> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<V> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public boolean add(Object e) {
        ensureCapacity(size + 1);
        arrayData[size] = e;
        size++;
        return true;
    }

    public void add(int i, Object e) {
        checkIndex(i);
        ensureCapacity(size + 1);
        System.arraycopy(arrayData, i, arrayData, i + 1, size - i);
        arrayData[i] = e;
        size++;
    }

    public V set(int i, V e) {
        checkIndex(i);
        V prev = (V) arrayData[i];
        arrayData[i] = e;
        return prev;
    }

    public V get(int i) {
        checkIndex(i);
        return (V) arrayData[i];
    }

    public V remove(int i) {
        checkIndex(i);
        modCount++;
        V old = (V) arrayData[i];
        if (i == size - 1) {
            arrayData[i] = null;
        } else {
            System.arraycopy(arrayData, i + 1, arrayData, i, size - i);
            arrayData[size - 1] = null;
        }
        size--;
        return old;
    }

    public boolean remove(Object e) {
        modCount++;
        if (Objects.isNull(e)) {
            for (int i = 0; i < size; i++) {
                if (Objects.isNull(arrayData[i])) {
                    System.arraycopy(arrayData, i + 1, arrayData, i, size - i);
                    size--;
                    arrayData[size] = null;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (arrayData[i].equals(e)) {
                    System.arraycopy(arrayData, i + 1, arrayData, i, size - i);
                    size--;
                    arrayData[size] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public int indexOf(Object e) {
        if (Objects.isNull(e)) {
            for (int i = 0; i < size; i++) {
                if (Objects.isNull(arrayData[i])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (arrayData[i].equals(e)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object e) {
        if (Objects.isNull(e)) {
            for (int i = 0; i < size; i++) {
                if (Objects.isNull(arrayData[i])) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(arrayData[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object[] toArray() {
        return Arrays.copyOf(arrayData, size);
    }

    public ListIterator<V> listIterator() {
        return new ListIteratorImpl<>();
    }

    void ensureCapacity(int capacity) {
        modCount++;
        if (arrayData.length - capacity < 0) {
            increaseCapacity(capacity);
        }
    }

    void increaseCapacity(int capacity) {
        int newCapacity = (int) (arrayData.length * 1.5);
        if (newCapacity - arrayData.length < 0) {
            newCapacity = MAX_ARRAY_SIZE;
        }
        arrayData = Arrays.copyOf(arrayData, newCapacity);
    }

    void checkIndex(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Wrong index - " + i);
        }
    }

    class ListIteratorImpl<E> implements ListIterator<E> {
        int pointer;
        int lastPointer = -1;
        int expectedModCount = modCount;

        public ListIteratorImpl() {
        }

        public E next() {
            checkModCount();
            int currentIndex = pointer;
            if (currentIndex >= size) {
                throw new NoSuchElementException();
            }
            pointer = currentIndex + 1;
            lastPointer = currentIndex;
            return (E) arrayData[lastPointer];
        }

        public boolean hasNext() {
            return pointer != size;
        }

        public boolean hasPrevious() {
            return pointer != 0;
        }

        public E previous() {
            checkModCount();
            int currentIndex = pointer - 1;
            if (currentIndex < 0) {
                throw new NoSuchElementException();
            }
            pointer = currentIndex;
            lastPointer = currentIndex;
            return (E) arrayData[lastPointer];
        }

        public int nextIndex() {
            return pointer;
        }

        public int previousIndex() {
            return pointer - 1;
        }

        public void remove() {
            if (lastPointer < 0) {
                throw new NoSuchElementException();
            }
            checkModCount();
            try {
                DynamicArray.this.remove(lastPointer);
                pointer = lastPointer;
                lastPointer = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        public void set(E e) {
            if (lastPointer < 0) {
                throw new NoSuchElementException();
            }
            checkModCount();
            try {
                DynamicArray.this.set(lastPointer, (V) e);
            } catch (IndexOutOfBoundsException exc) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(Object e) {
            checkModCount();
            try {
                DynamicArray.this.add(pointer, e);
                pointer++;
                lastPointer = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException exc) {
                throw new ConcurrentModificationException();
            }
        }

        void checkModCount() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }

    }

}