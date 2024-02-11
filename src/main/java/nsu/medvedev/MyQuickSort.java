package nsu.medvedev;

/**
 * Класс для сортировки списка алгоритом quickSort
 *
 * @param <T> тип элемента списка
 */
public class MyQuickSort<T extends Comparable<T>> {
    /**
     * Входная точка для сортировки списка.
     *
     * @param list список
     */
    public void quickSort(MyArrayList<T> list) {
        quickSort(0, list.size() - 1, list);
    }

    /**
     * Рекурсивная точка входа сортировки.
     *
     * @param low  нижняя граница
     * @param high верхняя граница
     * @param list сортируемый список
     */
    private void quickSort(int low, int high, MyArrayList<T> list) {
        if (low < high) {
            int pi = partition(low, high, list);
            quickSort(low, pi - 1, list);
            quickSort(pi + 1, high, list);
        }
    }

    /**
     * Разделение списка на две части.
     *
     * @param low  нижняя граница списка для сортировки
     * @param high верхняя граница списка для сортировки
     * @param list сортируемый список
     * @return новый индекс разделителя
     */
    private int partition(int low, int high, MyArrayList<T> list) {
        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                i++;
                swap(i, j, list);
            }
        }
        swap(i + 1, high, list);
        return i + 1;
    }

    /**
     * Меняет местами два элемента в списке.
     *
     * @param i    индекс первого элемента
     * @param j    индекс второго элемента
     * @param list список, в котором необходимо поменять элементы местами
     */
    private void swap(int i, int j, MyArrayList<T> list) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
