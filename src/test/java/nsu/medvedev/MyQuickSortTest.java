package nsu.medvedev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQuickSortTest {

    @Test
    public void testQuickSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(9);
        MyQuickSort<Integer> quickSort = new MyQuickSort<>();
        quickSort.quickSort(list);

        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(4, list.get(2));
        assertEquals(5, list.get(3));
        assertEquals(5, list.get(4));
        assertEquals(9, list.get(5));
    }

    @Test
    public void testQuickSortEmptyList() {
        MyArrayList<Integer> list = new MyArrayList<>();

        MyQuickSort<Integer> quickSort = new MyQuickSort<>();
        quickSort.quickSort(list);

        assertEquals(0, list.size());
    }

    @Test
    public void testQuickSortSingleElement() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);

        MyQuickSort<Integer> quickSort = new MyQuickSort<>();
        quickSort.quickSort(list);

        assertEquals(1, list.get(0));
    }
}