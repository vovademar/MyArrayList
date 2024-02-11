package nsu.medvedev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    public void testAddAndGet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testSet() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");

        list.set(1, "grape");

        assertEquals("grape", list.get(1));
        assertEquals(3, list.size());
    }

    @Test
    public void testIndexAdd() {
        MyArrayList<Character> list = new MyArrayList<>();
        list.add('a');
        list.add('c');
        list.add('d');

        list.add(1, 'b');

        assertEquals(4, list.size());
        assertEquals('b', list.get(1));
        assertEquals('c', list.get(2));
    }

    @Test
    public void testRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(1);

        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    public void testSort() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("banana");
        list.add("apple");
        list.add("orange");

        list.sort();

        assertEquals("apple", list.get(0));
        assertEquals("banana", list.get(1));
        assertEquals("orange", list.get(2));
    }

    @Test
    public void testClear() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();

        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2);
        });
    }

    @Test
    public void testIncreaseCapacityInAdd() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3, 1);

        assertEquals(11, list.size());
    }

    @Test
    public void testIncreaseCapacityInIndexAdd() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(1,2);
        list.add(2,3);
        list.add(3,2);
        list.add(1,3);
        list.add(1,2);
        list.add(3, 1);

        assertEquals(11, list.size());
    }

}