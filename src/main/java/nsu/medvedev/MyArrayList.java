package nsu.medvedev;

/**
 * Реализация аналога класса ArrayList.
 * Поддерживает добавление, удаление, получение, замену и очистку элементов.
 *
 * @param <T> тип элементов, которые хранит список
 */
public class MyArrayList<T extends Comparable<T>> {
    private Object[] array;
    private int size;
    private static final int CAPACITY = 8;

    /**
     * Constructor to init empty MyArrayList
     */
    public MyArrayList() {
        array = new Object[CAPACITY];
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка
     *
     * @param element - элемент для добавления
     */
    public void add(T element) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = element;
    }

    /**
     * Заменяет элемент в списке по указанному индексу на новый элемент
     *
     * @param index   индекс по которому требуется сделать замену
     * @param element новый элемент
     */
    public void set(int index, T element) {
        checkIndex(index);
        array[index] = element;
    }

    /**
     * Добавляет элемент в указанный индекс в списке
     *
     * @param index   - индекс, в который нужно добавить элемент
     * @param element - элемент для добавления
     */

    public void add(int index, T element) {
        checkIndex(index);
        if (size == array.length) {
            increaseCapacity();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    /**
     * Метод проверяет находится ли индекс в пределах списка
     *
     * @param index индекс для проверки
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Actual size: " + size);
        }
    }

    /**
     * Метод возвращает элемент по указанному индексу
     *
     * @param index - индекс элемента
     * @return Элемент по индексу
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    /**
     * Метод возвращает размер списка
     *
     * @return количество элементов списка
     */
    public int size() {
        return size;
    }

    /**
     * Метод увеличивает размер списка
     */
    private void increaseCapacity() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * Метод очищает список, удаляя все элементы списка
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * Метод удаляет элемент по индексу
     *
     * @param index - индекс элемента для удаления
     */
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    /**
     * Сортирует элементы списка
     */
    public void sort() {
        MyQuickSort<T> quickSort = new MyQuickSort<>();
        quickSort.quickSort(this);
    }

}
