package com.resume.java.AlgoSort;

import java.util.*;

import static com.resume.java.util.Assert.*;

public class CollectionsTest {
    public static void main(String[] args) {
        testSort();
        testBinarySearch();
        testReverse();
        testShuffle();
        testSwap();
        testFill();
        testCopy();
        testMin();
        testMax();
        testRotate();
        testReplaceAll();
        testIndexOfSublist();
        testLastIndexOfSublist();
        testUnmodifiableCollection();
        testUnmodifiableSet();
        testUnmodifiableSortedSet();
        testUnmodifiableNavigableSet();
        testUnmodifiableList();
        testUnmodifiableMap();
        testUnmodifiableSortedMap();
        testUnmodifiableNavigableMap();
        testSynchronizedCollection();
        testSynchronizedSet();
        testSynchronizedSortedSet();
        testSynchronizedNavigableSet();
        testSynchronizedList();
        testSynchronizedMap();
        testSynchronizedSortedMap();
        testSynchronizedNavigableMap();
        testCheckedCollection();
        testCheckedQueue();
        testCheckedSet();
        testCheckedSortedSet();
        testCheckedNavigableSet();
        testCheckedList();
        testCheckedMap();
        testCheckedSortedMap();
        testCheckedNavigableMap();
        testEmptyIterator();
        testEmptyListIterator();
        testEmptyEnumeration();
        testEmptySet();
        testEmptySortedSet();
        testEmptyNavigableSet();
        testEmptyList();
        testEmptyMap();
        testEmptySortedMap();
        testEmptyNavigableMap();
        testSingletonSet();
        testSingletonList();
        testSingletonMap();
        testNCopies();
        testReverseOrder();
        testEnumeration();
        testList();
        testFrequency();
        testDisjoint();
        testAddAll();
        testNewSetFromMap();
        testAsLifoQueue();
    }

    public static void testSort() {
        List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(4);
        list.add(1);
        assertEquals("CollectionsTest.testSort", Integer.valueOf(5), list.get(0));
        Collections.sort(list);
        assertEquals("CollectionsTest.testSort", Integer.valueOf(1), list.get(0));
    }

    public static void testBinarySearch() {
        List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(4);
        list.add(1);
        Collections.sort(list);
        assertEquals("CollectionsTest.testBinarySearch", 0, Collections.binarySearch(list, 1));
        assertEquals("CollectionsTest.testBinarySearch", true, Collections.binarySearch(list, 100) < 0);
        assertEquals("CollectionsTest.testBinarySearch", true, Collections.binarySearch(list, 4) == 1);
    }

    public static void testReverse() {
        List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(4);
        list.add(1);
        Collections.sort(list);
        assertEquals("CollectionsTest.testReverse", Integer.valueOf(1), list.get(0));
        Collections.reverse(list);
        assertEquals("CollectionsTest.testReverse", Integer.valueOf(5), list.get(0));
    }

    public static void testShuffle() {
        List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(4);
        list.add(1);
        Collections.sort(list);
        assertEquals("CollectionsTest.testShuffle", Integer.valueOf(1), list.get(0));
        int j = 0;
        for (int i = 0; i < 10; i++) {
            Collections.shuffle(list);
            if (list.get(0) != 1) {
                j++;
            }
        }
        assertEquals("CollectionsTest.testShuffle", true, j > 0);
    }

    public static void testSwap() {
        List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(4);
        list.add(1);
        Collections.sort(list);
        Collections.swap(list, 0, 2);
        assertEquals("CollectionsTest.testSwap", Integer.valueOf(5), list.get(0));
        try {
            Collections.swap(list, 1, 99);
            assertFail("CollectionsTest.testSwap");
        } catch (IndexOutOfBoundsException e) {
            assertPass("CollectionsTest.testSwap");
        }
    }

    public static void testFill() {
        List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(4);
        list.add(1);
        Collections.fill(list, 99);
        assertEquals("CollectionsTest.testFill", Integer.valueOf(99), list.get(0));
        assertEquals("CollectionsTest.testFill", Integer.valueOf(99), list.get(1));
    }

    public static void testCopy() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(1);
        List<Integer> dest = new ArrayList<>();
        dest.add(-1);
        dest.add(-1);
        try {
            Collections.copy(dest, list);
            assertFail("CollectionsTest.testCopy");
        } catch (IndexOutOfBoundsException e) {
            assertPass("CollectionsTest.testCopy");
        }
        dest.add(-1);
        Collections.copy(dest, list);
        assertEquals("CollectionsTest.testCopy", Integer.valueOf(5), dest.get(0));
    }

    public static void testMin() {
        List<Integer> list = new ArrayList<>();
        try {
            Collections.min(list);
            assertFail("CollectionsTest.testMin");
        } catch (NoSuchElementException e) {
            assertPass("CollectionsTest.testMin");
        }
        list.add(5);
        list.add(4);
        list.add(1);
        assertEquals("CollectionsTest.testMin", Integer.valueOf(1), Collections.min(list));
        list.add(-1);
        assertEquals("CollectionsTest.testMin", Integer.valueOf(-1), Collections.min(list));
    }

    public static void testMax() {
        List<Integer> list = new ArrayList<>();
        try {
            Collections.max(list);
            assertFail("CollectionsTest.testMax");
        } catch (NoSuchElementException e) {
            assertPass("CollectionsTest.testMax");
        }
        list.add(5);
        list.add(4);
        list.add(1);
        assertEquals("CollectionsTest.testMax", Integer.valueOf(5), Collections.max(list));
        list.add(11);
        assertEquals("CollectionsTest.testMax", Integer.valueOf(11), Collections.max(list));
    }

    public static void testRotate() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Collections.rotate(list, 1);
        assertEquals("CollectionsTest.testRotate", Integer.valueOf(3), list.get(0));
    }

    public static void testReplaceAll() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        assertEquals("CollectionsTest.testReplaceAll", false, Collections.replaceAll(list, -1, 99));
        assertEquals("CollectionsTest.testReplaceAll", true, Collections.replaceAll(list, 1, 99));
        assertEquals("CollectionsTest.testReplaceAll", Integer.valueOf(99), list.get(0));
        assertEquals("CollectionsTest.testReplaceAll", Integer.valueOf(99), list.get(3));
    }

    public static void testIndexOfSublist() {
        List<Integer> source = new ArrayList<>();
        source.add(1);
        source.add(2);
        source.add(3);
        source.add(4);
        source.add(5);
        source.add(2);
        source.add(3);
        List<Integer> target1 = new ArrayList<>();
        target1.add(3);
        target1.add(5);
        assertEquals("CollectionsTest.testIndexOfSublist", -1, Collections.indexOfSubList(source, target1));
        target1.clear();
        target1.add(2);
        target1.add(3);
        assertEquals("CollectionsTest.testIndexOfSublist", 1, Collections.indexOfSubList(source, target1));
        assertEquals("CollectionsTest.testIndexOfSublist", -1, Collections.indexOfSubList(target1, source));
    }

    public static void testLastIndexOfSublist() {
        List<Integer> source = new ArrayList<>();
        source.add(1);
        source.add(2);
        source.add(3);
        source.add(4);
        source.add(5);
        source.add(2);
        source.add(3);
        List<Integer> target1 = new ArrayList<>();
        target1.add(3);
        target1.add(5);
        assertEquals("CollectionsTest.testLastIndexOfSublist", -1, Collections.lastIndexOfSubList(source, target1));
        target1.clear();
        target1.add(2);
        target1.add(3);
        assertEquals("CollectionsTest.testLastIndexOfSublist", 5, Collections.lastIndexOfSubList(source, target1));
        assertEquals("CollectionsTest.testLastIndexOfSublist", -1, Collections.lastIndexOfSubList(target1, source));
    }

    public static void testUnmodifiableCollection() {
        Collection<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Collection<Integer> unmodCol = Collections.unmodifiableCollection(list);
        try {
            unmodCol.add(1);
            assertFail("CollectionsTest.testUnmodifiableCollection");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableCollection");
        }
        try {
            unmodCol.remove(1);
            assertFail("CollectionsTest.testUnmodifiableCollection");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableCollection");
        }
        try {
            unmodCol.clear();
            assertFail("CollectionsTest.testUnmodifiableCollection");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableCollection");
        }
        try {
            Collection unmodCollection = Collections.unmodifiableCollection(null);
            assertFail("CollectionsTest.testUnmodifiableCollection");
        } catch (NullPointerException n) {
            assertPass("CollectionsTest.testUnmodifiableCollection");
        }
    }

    public static void testUnmodifiableSet() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Set<Integer> unmodSet = Collections.unmodifiableSet(set);
        try {
            unmodSet.add(5);
            assertFail("CollectionsTest.testUnmodifiableSet");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableSet");
        }
        try {
            unmodSet.remove(5);
            assertFail("CollectionsTest.testUnmodifiableSet");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableSet");
        }
        try {
            Set<Integer> set1 = new HashSet<>();
            set1.add(1);
            unmodSet.retainAll(set1);
            assertFail("CollectionsTest.testUnmodifiableSet");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableSet");
        }
        try {
            Collections.unmodifiableSet(null);
            assertFail("CollectionsTest.testUnmodifiableSet");
        } catch (NullPointerException n) {
            assertPass("CollectionsTest.testUnmodifiableSet");
        }
    }

    public static void testUnmodifiableSortedSet() {
        SortedSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Set<Integer> unmodSet = Collections.unmodifiableSortedSet(set);
        try {
            unmodSet.add(5);
            assertFail("CollectionsTest.testUnmodifiableSortedSet");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableSortedSet");
        }
        try {
            unmodSet.remove(5);
            assertFail("CollectionsTest.testUnmodifiableSortedSet");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableSortedSet");
        }
        try {
            SortedSet<Integer> set1 = new TreeSet<>();
            set1.add(1);
            unmodSet.removeAll(set1);
            assertFail("CollectionsTest.testUnmodifiableSortedSet");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableSortedSet");
        }
        try {
            Collections.unmodifiableSortedSet(null);
            assertFail("CollectionsTest.testUnmodifiableSortedSet");
        } catch (NullPointerException n) {
            assertPass("CollectionsTest.testUnmodifiableSortedSet");
        }
    }

    public static void testUnmodifiableNavigableSet() {
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Set<Integer> unmodSet = Collections.unmodifiableNavigableSet(set);
        try {
            unmodSet.add(5);
            assertFail("CollectionsTest.testUnmodifiableNavigableSet");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableNavigableSet");
        }
        try {
            unmodSet.remove(5);
            assertFail("CollectionsTest.testUnmodifiableNavigableSet");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableNavigableSet");
        }
        try {
            SortedSet<Integer> set1 = new TreeSet<>();
            set1.add(1);
            unmodSet.addAll(set1);
            assertFail("CollectionsTest.testUnmodifiableNavigableSet");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableNavigableSet");
        }
        try {
            Collections.unmodifiableNavigableSet(null);
            assertFail("CollectionsTest.testUnmodifiableNavigableSet");
        } catch (NullPointerException n) {
            assertPass("CollectionsTest.testUnmodifiableNavigableSet");
        }
    }

    public static void testUnmodifiableList() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        List<Integer> unmodList = Collections.unmodifiableList(list);
        try {
            unmodList.add(5);
            assertFail("CollectionsTest.testUnmodifiableList");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableList");
        }
        try {
            unmodList.remove(1);
            assertFail("CollectionsTest.testUnmodifiableList");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableList");
        }
        try {
            List<Integer> list1 = new LinkedList<>();
            list1.add(1);
            unmodList.addAll(list1);
            assertFail("CollectionsTest.testUnmodifiableList");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableList");
        }
        try {
            Collections.unmodifiableList(null);
            assertFail("CollectionsTest.testUnmodifiableList");
        } catch (NullPointerException n) {
            assertPass("CollectionsTest.testUnmodifiableList");
        }
    }

    public static void testUnmodifiableMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        Map<Integer, String> unmodMap = Collections.unmodifiableMap(map);
        try {
            unmodMap.put(5, "Five");
            assertFail("CollectionsTest.testUnmodifiableMap");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableMap");
        }
        try {
            unmodMap.remove(1);
            assertFail("CollectionsTest.testUnmodifiableMap");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableMap");
        }
        try {
            Map<Integer, String> map1 = new HashMap<>();
            map1.put(1, "sda");
            unmodMap.putAll(map1);
            assertFail("CollectionsTest.testUnmodifiableMap");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableMap");
        }
        try {
            Collections.unmodifiableMap(null);
            assertFail("CollectionsTest.testUnmodifiableMap");
        } catch (NullPointerException n) {
            assertPass("CollectionsTest.testUnmodifiableMap");
        }
    }

    public static void testUnmodifiableSortedMap() {
        SortedMap<Integer, String> map = new TreeMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        Map<Integer, String> unmodMap = Collections.unmodifiableSortedMap(map);
        try {
            unmodMap.put(5, "Five");
            assertFail("CollectionsTest.testUnmodifiableSortedMap");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableSortedMap");
        }
        try {
            unmodMap.remove(1);
            assertFail("CollectionsTest.testUnmodifiableSortedMap");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableSortedMap");
        }
        try {
            SortedMap<Integer, String> map1 = new TreeMap<>();
            map1.put(1, "sda");
            unmodMap.putAll(map1);
            assertFail("CollectionsTest.testUnmodifiableSortedMap");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableSortedMap");
        }
        try {
            Collections.unmodifiableSortedMap(null);
            assertFail("CollectionsTest.testUnmodifiableSortedMap");
        } catch (NullPointerException n) {
            assertPass("CollectionsTest.testUnmodifiableSortedMap");
        }
    }

    public static void testUnmodifiableNavigableMap() {
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        Map<Integer, String> unmodMap = Collections.unmodifiableNavigableMap(map);
        try {
            unmodMap.put(5, "Five");
            assertFail("CollectionsTest.testUnmodifiableNavigableMap");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableNavigableMap");
        }
        try {
            unmodMap.remove(1);
            assertFail("CollectionsTest.testUnmodifiableNavigableMap");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableNavigableMap");
        }
        try {
            NavigableMap<Integer, String> map1 = new TreeMap<>();
            map1.put(1, "sda");
            unmodMap.putAll(map1);
            assertFail("CollectionsTest.testUnmodifiableNavigableMap");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testUnmodifiableNavigableMap");
        }
        try {
            Collections.unmodifiableNavigableMap(null);
            assertFail("CollectionsTest.testUnmodifiableNavigableMap");
        } catch (NullPointerException n) {
            assertPass("CollectionsTest.testUnmodifiableNavigableMap");
        }
    }

    public static void testSynchronizedCollection() {
        Collection<Integer> collection = new HashSet<>();
        collection.add(1);
        collection.add(3);
        Collection<Integer> syncCol = Collections.synchronizedCollection(collection);
        assertEquals("CollectionsTest.testSynchronizedCollection", 2, syncCol.size());
        Iterator<Integer> iterator = syncCol.iterator();
        assertEquals("CollectionsTest.testSynchronizedCollection", Integer.valueOf(1), iterator.next());
    }

    public static void testSynchronizedSet() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        Set<Integer> syncSet = Collections.synchronizedSet(set);
        assertEquals("CollectionsTest.testSynchronizedSet", 2, syncSet.size());
        Iterator<Integer> iterator = syncSet.iterator();
        assertEquals("CollectionsTest.testSynchronizedSet", Integer.valueOf(1), iterator.next());
    }

    public static void testSynchronizedSortedSet() {
        SortedSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        Set<Integer> syncSet = Collections.synchronizedSortedSet(set);
        assertEquals("CollectionsTest.testSynchronizedSortedSet", 2, syncSet.size());
        Iterator<Integer> iterator = syncSet.iterator();
        assertEquals("CollectionsTest.testSynchronizedSortedSet", Integer.valueOf(1), iterator.next());
    }

    public static void testSynchronizedNavigableSet() {
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        Set<Integer> syncSet = Collections.synchronizedNavigableSet(set);
        assertEquals("CollectionsTest.testSynchronizedNavigableSet", 2, syncSet.size());
        Iterator<Integer> iterator = syncSet.iterator();
        assertEquals("CollectionsTest.testSynchronizedNavigableSet", Integer.valueOf(1), iterator.next());
    }

    public static void testSynchronizedList() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        List<Integer> syncList = Collections.synchronizedList(list);
        assertEquals("CollectionsTest.testSynchronizedList", 2, syncList.size());
        Iterator<Integer> iterator = syncList.iterator();
        assertEquals("CollectionsTest.testSynchronizedList", Integer.valueOf(1), iterator.next());
    }

    public static void testSynchronizedMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        Map<Integer, String> syncMap = Collections.synchronizedMap(map);
        assertEquals("CollectionsTest.testSynchronizedMap", 2, map.size());
        Map.Entry<Integer, String> entry = map.entrySet().iterator().next();
        assertEquals("CollectionsTest.testSynchronizedMap", Integer.valueOf(1), entry.getKey());
        assertEquals("CollectionsTest.testSynchronizedMap", "One", entry.getValue());
    }

    public static void testSynchronizedSortedMap() {
        SortedMap<Integer, String> map = new TreeMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        Map<Integer, String> syncMap = Collections.synchronizedSortedMap(map);
        assertEquals("CollectionsTest.testSynchronizedSortedMap", 2, map.size());
        Map.Entry<Integer, String> entry = map.entrySet().iterator().next();
        assertEquals("CollectionsTest.testSynchronizedSortedMap", Integer.valueOf(1), entry.getKey());
        assertEquals("CollectionsTest.testSynchronizedSortedMap", "One", entry.getValue());
    }

    public static void testSynchronizedNavigableMap() {
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        Map<Integer, String> syncMap = Collections.synchronizedNavigableMap(map);
        assertEquals("CollectionsTest.testSynchronizedNavigableMap", 2, map.size());
        Map.Entry<Integer, String> entry = map.entrySet().iterator().next();
        assertEquals("CollectionsTest.testSynchronizedNavigableMap", Integer.valueOf(1), entry.getKey());
        assertEquals("CollectionsTest.testSynchronizedNavigableMap", "One", entry.getValue());
    }

    public static void testCheckedCollection() {
        Collection<Integer> checkedCol = Collections.checkedCollection(new ArrayList<>(), Integer.class);
        Collection collection = checkedCol;
        collection.add(1);
        try {
            collection.add("One");
            assertFail("CollectionsTest.testCheckedCollection");
        } catch (ClassCastException e) {
            assertPass("CollectionsTest.testCheckedCollection");
        }
    }

    public static void testCheckedQueue() {
        Queue<Integer> checkedQueue = Collections.checkedQueue(new ArrayDeque<>(), Integer.class);
        Queue queue = checkedQueue;
        queue.add(1);
        try {
            queue.add("One");
            assertFail("CollectionsTest.testCheckedQueue");
        } catch (ClassCastException e) {
            assertPass("CollectionsTest.testCheckedQueue");
        }
    }

    public static void testCheckedSet() {
        Set<Integer> checkedSet = Collections.checkedSet(new HashSet<>(), Integer.class);
        Set set = checkedSet;
        set.add(1);
        try {
            set.add("One");
            assertFail("CollectionsTest.testCheckedSet");
        } catch (ClassCastException e) {
            assertPass("CollectionsTest.testCheckedSet");
        }
    }

    public static void testCheckedSortedSet() {
        SortedSet<Integer> checkedSet = Collections.checkedSortedSet(new TreeSet<>(), Integer.class);
        Set set = checkedSet;
        set.add(1);
        try {
            set.add("One");
            assertFail("CollectionsTest.testCheckedSortedSet");
        } catch (ClassCastException e) {
            assertPass("CollectionsTest.testCheckedSortedSet");
        }
    }

    public static void testCheckedNavigableSet() {
        NavigableSet<Integer> checkedSet = Collections.checkedNavigableSet(new TreeSet<>(), Integer.class);
        Set set = checkedSet;
        set.add(1);
        try {
            set.add("One");
            assertFail("CollectionsTest.testCheckedNavigableSet");
        } catch (ClassCastException e) {
            assertPass("CollectionsTest.testCheckedNavigableSet");
        }
    }

    public static void testCheckedList() {
        List<Integer> checkedList = Collections.checkedList(new LinkedList<>(), Integer.class);
        checkedList.add(1);
        List list = checkedList;
        list.add(2);
        try {
            list.add("Three");
            assertFail("CollectionsTest.testCheckedList");
        } catch (ClassCastException e) {
            assertPass("CollectionsTest.testCheckedList");
        }
    }

    public static void testCheckedMap() {
        Map<Integer, String> checkedMap = Collections.checkedMap(new HashMap<>(), Integer.class, String.class);
        checkedMap.put(1, "One");
        Map map = checkedMap;
        map.put(2, "Two");
        try {
            map.put("WrongData", 999D);
            assertFail("CollectionsTest.testCheckedMap");
        } catch (ClassCastException e) {
            assertPass("CollectionsTest.testCheckedMap");
        }
    }

    public static void testCheckedSortedMap() {
        SortedMap<Integer, String> checkedMap = Collections.checkedSortedMap(new TreeMap<>(), Integer.class, String.class);
        checkedMap.put(1, "One");
        Map map = checkedMap;
        map.put(2, "Two");
        try {
            map.put("WrongData", 999D);
            assertFail("CollectionsTest.testCheckedSortedMap");
        } catch (ClassCastException e) {
            assertPass("CollectionsTest.testCheckedSortedMap");
        }
    }

    public static void testCheckedNavigableMap() {
        NavigableMap<Integer, String> checkedMap = Collections.checkedNavigableMap(new TreeMap<>(), Integer.class, String.class);
        checkedMap.put(1, "One");
        Map map = checkedMap;
        map.put(2, "Two");
        try {
            map.put("WrongData", 999D);
            assertFail("CollectionsTest.testCheckedNavigableMap");
        } catch (ClassCastException e) {
            assertPass("CollectionsTest.testCheckedNavigableMap");
        }
    }

    public static void testEmptyIterator() {
        Iterator iterator = Collections.emptyIterator();
        assertEquals("CollectionsTest.testEmptyIterator", false, iterator.hasNext());
        try {
            iterator.next();
            assertFail("CollectionsTest.testEmptyIterator");
        } catch (NoSuchElementException e) {
            assertPass("CollectionsTest.testEmptyIterator");
        }
        try {
            iterator.remove();
            assertFail("CollectionsTest.testEmptyIterator");
        } catch (IllegalStateException e) {
            assertPass("CollectionsTest.testEmptyIterator");
        }
    }

    public static void testEmptyListIterator() {
        ListIterator iterator = Collections.emptyListIterator();
        assertEquals("CollectionsTest.testEmptyListIterator", false, iterator.hasPrevious());
        assertEquals("CollectionsTest.testEmptyListIterator", 0, iterator.nextIndex());
        assertEquals("CollectionsTest.testEmptyListIterator", -1, iterator.previousIndex());
        try {
            iterator.previous();
            assertFail("CollectionsTest.testEmptyListIterator");
        } catch (NoSuchElementException e) {
            assertPass("CollectionsTest.testEmptyListIterator");
        }
        try {
            iterator.set(1);
            assertFail("CollectionsTest.testEmptyListIterator");
        } catch (IllegalStateException e) {
            assertPass("CollectionsTest.testEmptyListIterator");
        }
        try {
            iterator.add(1);
            assertFail("CollectionsTest.testEmptyListIterator");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testEmptyListIterator");
        }
    }

    public static void testEmptyEnumeration() {
        Enumeration enumeration = Collections.emptyEnumeration();
        assertEquals("CollectionsTest.testEmptyEnumeration", false, enumeration.hasMoreElements());
        try {
            enumeration.nextElement();
            assertFail("CollectionsTest.testEmptyEnumeration");
        } catch (NoSuchElementException e) {
            assertPass("CollectionsTest.testEmptyEnumeration");
        }
    }

    public static void testEmptySet() {
        Set set = Collections.emptySet();
        assertEquals("CollectionsTest.testEmptySet", 0, set.size());
        assertEquals("CollectionsTest.testEmptySet", true, set.isEmpty());
    }

    public static void testEmptySortedSet() {
        Set set = Collections.emptySortedSet();
        assertEquals("CollectionsTest.testEmptySortedSet", 0, set.size());
        assertEquals("CollectionsTest.testEmptySortedSet", true, set.isEmpty());
    }

    public static void testEmptyNavigableSet() {
        Set set = Collections.emptyNavigableSet();
        assertEquals("CollectionsTest.testEmptyNavigableSet", 0, set.size());
        assertEquals("CollectionsTest.testEmptyNavigableSet", true, set.isEmpty());
    }

    public static void testEmptyList() {
        List list = Collections.emptyList();
        assertEquals("CollectionsTest.testEmptyList", 0, list.size());
        assertEquals("CollectionsTest.testEmptyList", true, list.isEmpty());
        try {
            list.get(0);
            assertFail("CollectionsTest.testEmptyList");
        } catch (IndexOutOfBoundsException e) {
            assertPass("CollectionsTest.testEmptyList");
        }
    }

    public static void testEmptyMap() {
        Map map = Collections.emptyMap();
        assertEquals("CollectionsTest.testEmptyMap", 0, map.size());
        assertEquals("CollectionsTest.testEmptyMap", true, map.isEmpty());
        assertEquals("CollectionsTest.testEmptyMap", null, map.get(0));
        try {
            map.remove(1, "One");
            assertFail("CollectionsTest.testEmptyMap");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testEmptyMap");
        }
    }

    public static void testEmptySortedMap() {
        SortedMap map = Collections.emptySortedMap();
        assertEquals("CollectionsTest.testEmptySortedMap", 0, map.size());
        assertEquals("CollectionsTest.testEmptySortedMap", true, map.isEmpty());
        assertEquals("CollectionsTest.testEmptySortedMap", null, map.get(10));
        try {
            map.replace(1, "One");
            assertFail("CollectionsTest.testEmptySortedMap");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testEmptySortedMap");
        }
    }

    public static void testEmptyNavigableMap() {
        NavigableMap map = Collections.emptyNavigableMap();
        assertEquals("CollectionsTest.testEmptyNavigableMap", 0, map.size());
        assertEquals("CollectionsTest.testEmptyNavigableMap", true, map.isEmpty());
        assertEquals("CollectionsTest.testEmptyNavigableMap", null, map.get(99));
        try {
            map.putIfAbsent(2, "Two");
            assertFail("CollectionsTest.testEmptyNavigableMap");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testEmptyNavigableMap");
        }
    }

    public static void testSingletonSet() {
        Set set = Collections.singleton("Singleton");
        assertEquals("CollectionsTest.testSingletonSet", 1, set.size());
        try {
            set.add("another one");
            assertFail("CollectionsTest.testSingletonSet");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testSingletonSet");
        }
    }

    public static void testSingletonList() {
        List list = Collections.singletonList("Singleton");
        assertEquals("CollectionsTest.testSingletonList", "Singleton", list.get(0));
        assertEquals("CollectionsTest.testSingletonList", 1, list.size());
        try {
            list.get(1);
            assertFail("CollectionsTest.testSingletonList");
        } catch (IndexOutOfBoundsException e) {
            assertPass("CollectionsTest.testSingletonList");
        }
    }

    public static void testSingletonMap() {
        Map map = Collections.singletonMap(1, "Singleton");
        assertEquals("CollectionsTest.testSingletonMap", "Singleton", map.get(1));
        assertEquals("CollectionsTest.testSingletonMap", 1, map.size());
        assertEquals("CollectionsTest.testSingletonMap", true, map.containsKey(1));
        try {
            map.remove(1);
            assertFail("CollectionsTest.testSingletonMap");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testSingletonMap");
        }
    }

    public static void testNCopies() {
        List<String> zeroCopies = Collections.nCopies(0, "Empty");
        assertEquals("CollectionsTest.testNCopies", 0, zeroCopies.size());
        List<Float> copies = Collections.nCopies(10, 1F);
        assertEquals("CollectionsTest.testNCopies", 10, copies.size());
        assertEquals("CollectionsTest.testNCopies", 1F, copies.get(3));
        try {
            Collections.nCopies(-1, 1F);
            assertFail("CollectionsTest.testNCopies");
        } catch (IllegalArgumentException e) {
            assertPass("CollectionsTest.testNCopies");
        }
    }

    public static void testReverseOrder() {
        Comparator<Integer> comparator = Collections.reverseOrder();
        assertEquals("CollectionsTest.testReverseOrder", 1, comparator.compare(10, 1020));
        assertEquals("CollectionsTest.testReverseOrder", -1, comparator.reversed().compare(10, 1020));
        assertEquals("CollectionsTest.testReverseOrder", 0, comparator.compare(10, 10));
        Comparator<Integer> comparator1 = Collections.reverseOrder(comparator);
        assertEquals("CollectionsTest.testReverseOrder", -1, comparator1.compare(10, 1020));
    }

    public static void testEnumeration() {
        Collection<Integer> col = new ArrayList<>();
        col.add(1);
        col.add(2);
        Enumeration<Integer> enumeration = Collections.enumeration(col);
        assertEquals("CollectionsTest.testEnumeration", true, enumeration.hasMoreElements());
        assertEquals("CollectionsTest.testEnumeration", Integer.valueOf(1), enumeration.nextElement());
    }

    public static void testList() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        Enumeration<Integer> enumeration = vector.elements();
        ArrayList<Integer> list = Collections.list(enumeration);
        assertEquals("CollectionsTest.testList", 2, list.size());
        assertEquals("CollectionsTest.testList", Integer.valueOf(1), list.get(0));
    }

    public static void testFrequency() {
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Two");
        list.add("Three");
        list.add("Three");
        list.add("Three");
        assertEquals("CollectionsTest.testFrequency", 2, Collections.frequency(list, "Two"));
        assertEquals("CollectionsTest.testFrequency", 0, Collections.frequency(list, "Zero"));
        try {
            Collections.frequency(null, "Null");
            assertFail("CollectionsTest.testFrequency");
        } catch (NullPointerException e) {
            assertPass("CollectionsTest.testFrequency");
        }
    }

    public static void testDisjoint() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        assertEquals("CollectionsTest.testDisjoint", true, Collections.disjoint(list1, list2));
        list1.add(2);
        assertEquals("CollectionsTest.testDisjoint", false, Collections.disjoint(list1, list2));
        try {
            Collections.disjoint(null, null);
            assertFail("CollectionsTest.testDisjoint");
        } catch (NullPointerException e) {
            assertPass("CollectionsTest.testDisjoint");
        }
        try {
            ArrayList<Object> nulls = new ArrayList<>();
            nulls.add(null);
            nulls.add("null");
            Set set = new TreeSet();
            Collections.disjoint(nulls, set);
            assertFail("CollectionsTest.testDisjoint");
        } catch (NullPointerException e) {
            assertPass("CollectionsTest.testDisjoint");
        }
        try {
            SortedSet<String> set = new TreeSet<>();
            set.add("One");
            set.add("Two");
            Collections.disjoint(set, list1);
            assertFail("CollectionsTest.testDisjoint");
        } catch (ClassCastException e) {
            assertPass("CollectionsTest.testDisjoint");
        }
    }

    public static void testAddAll() {
        Collection<Integer> col = new ArrayList<>();
        col.add(1);
        assertEquals("CollectionsTest.testAddAll", true, Collections.addAll(col, 2, 3));
        assertEquals("CollectionsTest.testAddAll", 3, col.size());
        col = Collections.unmodifiableCollection(col);
        try {
            col.add(11);
            assertFail("CollectionsTest.testAddAll");
        } catch (UnsupportedOperationException e) {
            assertPass("CollectionsTest.testAddAll");
        }
        try {
            Collections.addAll(new TreeSet<>(), null, null);
            assertFail("CollectionsTest.testAddAll");
        } catch (NullPointerException n) {
            assertPass("CollectionsTest.testAddAll");
        }
        try {
            Collection collection = new ArrayList();
            Collections.addAll(collection, Collections.nCopies(-1, col));
            assertFail("CollectionsTest.testAddAll");
        } catch (IllegalArgumentException e) {
            assertPass("CollectionsTest.testAddAll");
        }
    }

    public static void testNewSetFromMap() {
        try {
            Map<Integer, Boolean> map = new HashMap<>();
            map.put(1, true);
            Collections.newSetFromMap(map);
            assertFail("CollectionsTest.testNewSetFromMap");
        } catch (IllegalArgumentException e) {
            assertPass("CollectionsTest.testNewSetFromMap");
        }
        Set<Integer> set = Collections.newSetFromMap(new HashMap<>());
        set.add(1);
        assertEquals("CollectionsTest.testNewSetFromMap", 1, set.size());
    }

    public static void testAsLifoQueue() {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("First");
        deque.add("Second");
        deque.add("Third");
        Queue<String> queue = Collections.asLifoQueue(deque);
        assertEquals("CollectionsTest.testAsLifoQueue", "First", queue.poll());
    }

}