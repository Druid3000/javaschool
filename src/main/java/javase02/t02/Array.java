package javase02.t02;

import java.util.Comparator;

public class Array<T> {
    private final int DEFAULT_CAPACITY = 10;
    private Object[] array = new Object[DEFAULT_CAPACITY];
    private int cursor = 0;

    private void resizeArray(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, cursor);
        array = newArray;
    }

    public void addItem(T item) {
        if (cursor == array.length - 1)
            resizeArray(array.length * 2);
        array[cursor++] = item;
    }

    public T getItem(int index) {
        return (T) array[index];
    }

    public void removeItem(int index) {
        int cutRate = 8;

        for (int i = index; i < cursor; i++)
            array[i] = array[i + 1];
        array[cursor] = null;
        cursor--;
        if (array.length > DEFAULT_CAPACITY && cursor < array.length / cutRate)
            resizeArray(array.length / 2);
    }

    public int size() {
        return cursor;
    }

    public void sort(Comparator c) {
        int n = this.size();
        Object temp = null;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (c.compare(array[j - 1], array[j]) > 0) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
