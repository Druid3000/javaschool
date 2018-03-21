package javase02.t05;

public class Map<T1, T2> {
    private final int DEFAULT_CAPACITY = 10;
    private Object[][] array = new Object[DEFAULT_CAPACITY][2];
    private int cursor = 0;

    public void put(T1 key, T2 value) {
        if (!containsKey(key)) {
            if (cursor == array.length - 1)
                resizeArray(array.length * 2);
            array[cursor][0] = key;
            array[cursor][1] = value;
            cursor++;
        } else {
            array[findIndexOfKeyInTheArray(key)][0] = key;
            array[findIndexOfKeyInTheArray(key)][1] = value;
        }
    }

    public T2 get(T1 key) {
        return (T2) array[findIndexOfKeyInTheArray(key)][1];
    }

    public void remove(T1 key) {
        int cutRate = 8;
        if (containsKey(key)) {
            for (int i = findIndexOfKeyInTheArray(key); i < cursor; i++) {
                array[i][0] = array[i + 1][0];
                array[i][1] = array[i + 1][1];
            }
            array[cursor][0] = null;
            array[cursor][1] = null;
            cursor--;
            if (array.length > DEFAULT_CAPACITY && cursor < array.length / cutRate)
                resizeArray(array.length / 2);
        }
    }

    public int size() {
        return cursor;
    }

    public boolean containsKey(T1 key) {
        for (int i = 0; i < cursor; i++) {
            if (key.equals(array[i][0])) return true;
        }
        return false;
    }

    private int findIndexOfKeyInTheArray(T1 key) {
        for (int i = 0; i < cursor; i++) {
            if (key.equals(array[i][0])) {
                return i;
            }
        }
        return -1;
    }

    private void resizeArray(int newLength) {
        Object[][] newArray = new Object[newLength][2];
        System.arraycopy(array, 0, newArray, 0, cursor);
        array = newArray;
    }
}
