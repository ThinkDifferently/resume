package com.resume.java.DoublyLinkedList;

import java.util.*;

public class DoublyLinkedList<V> implements List<V> {

    private int size;
    private int modCount;
    private Element<V> first;
    private Element<V> last;

    public static void main(String[] args) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<V> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends V> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends V> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V set(int index, V element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<V> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<V> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V get(int i) {
        checkIndex(i);
        if (i < size / 2) {
            Element<V> x = first;
            for (int j = 0; j < i; j++) {
                x = x.next;
            }
            return x.val;
        } else {
            Element<V> x = last;
            for (int j = size - 1; j > i; j--) {
                x = x.prev;
            }
            return x.val;
        }
    }

    public boolean add(V val) {
        Element<V> l = last;
        Element<V> newElement = new Element<>(l, val, null);
        last = newElement;
        if (Objects.isNull(l)) {
            first = newElement;
        } else {
            l.next = newElement;
        }
        size++;
        modCount++;
        return true;
    }

    public void add(int i, V val) {
        checkIndex(i);
        if (i == size) {
            add(val);
        } else {
            Element<V> succ = getElementByIndex(i);
            Element<V> pred = getElementByIndex(i).prev;
            Element<V> newElement = new Element<>(pred, val, succ);
            succ.prev = newElement;
            if (Objects.isNull(pred)) {
                first = newElement;
            } else {
                pred.next = newElement;
            }
            size++;
            modCount++;
        }
    }

    public boolean remove(Object val) {
        if (Objects.isNull(val)) {
            for (Element<V> x = first; Objects.nonNull(x); x = x.next) {
                if (Objects.isNull(x.val)) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Element<V> x = first; Objects.nonNull(x); x = x.next) {
                if (val.equals(x.val)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    public V remove(int i) {
        checkIndex(i);
        return unlink(getElementByIndex(i));
    }

    public Element<V> getElementByIndex(int i) {
        checkIndex(i);
        if (i < size / 2) {
            Element<V> x = first;
            for (int j = 0; j < i; j++) {
                x = x.next;
            }
            return x;
        } else {
            Element<V> x = last;
            for (int j = size - 1; j > i; j--) {
                x = x.prev;
            }
            return x;
        }
    }

    public void checkIndex(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Wrong index - " + i);
        }
    }

    public ListIterator<V> listIterator(int i) {
        checkIndex(i);
        return new ListIteratorImpl(i);
    }

    V unlink(Element<V> x) {
        V element = x.val;
        Element<V> next = x.next;
        Element<V> prev = x.prev;
        if (Objects.isNull(prev)) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (Objects.isNull(next)) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.val = null;
        size--;
        modCount++;
        return element;
    }

    private static class Element<V> {
        Element<V> prev;
        Element<V> next;
        V val;

        public Element(Element<V> prev, V val, Element<V> next) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }

    private class ListIteratorImpl implements ListIterator<V> {

        int expectedModCount = modCount;
        int nextIndex;
        private Element<V> lastReturned;
        private Element<V> next;

        public ListIteratorImpl(int i) {
            checkIndex(i);
            next = (i == size) ? null : getElementByIndex(i);
            nextIndex = i;
        }

        public void checkForModification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public V next() {
            checkForModification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.val;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public V previous() {
            checkForModification();
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            lastReturned = next = (Objects.isNull(next)) ? last : next.prev;
            nextIndex--;
            return lastReturned.val;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            checkForModification();
            if (Objects.isNull(lastReturned)) {
                throw new IllegalStateException();
            }
            Element<V> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned) {
                next = lastNext;
            } else {
                nextIndex--;
            }
            lastReturned = null;
            expectedModCount++;
        }

        @Override
        public void set(V val) {
            if (Objects.isNull(lastReturned)) {
                throw new IllegalStateException();
            }
            checkForModification();
            lastReturned.val = val;
        }

        @Override
        public void add(V val) {
            checkForModification();
            lastReturned = null;
            DoublyLinkedList.this.add(val);
            nextIndex++;
            expectedModCount++;
        }

    }

}