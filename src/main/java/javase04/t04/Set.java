package javase04.t04;

public class Set<T> implements java.io.Serializable {
    private final int DEFAULT_CAPACITY = 3;
    private Object[] array = new Object[DEFAULT_CAPACITY];
    private int cursor = 0;

    public void put(T item) {
        if (!containsKey(item)) {
            if (cursor == array.length - 1)
                resizeArray(array.length * 2);
            array[cursor] = item;
            cursor++;
        } else {
            array[findIndexOfKeyInTheArray(item)] = item;
        }
    }

    public void remove(T item) {
        int cutRate = 8;
        if (containsKey(item)) {
            for (int i = findIndexOfKeyInTheArray(item); i < cursor; i++) {
                array[i] = array[i + 1];
            }
            array[cursor] = null;
            cursor--;
            if (array.length > DEFAULT_CAPACITY && cursor < array.length / cutRate)
                resizeArray(array.length / 2);
        }
    }

    public int size() {
        return cursor;
    }

    public boolean containsKey(T item) {
        for (int i = 0; i < cursor; i++) {
            if (item.equals(array[i])) return true;
        }
        return false;
    }

    private int findIndexOfKeyInTheArray(T item) {
        for (int i = 0; i < cursor; i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    private void resizeArray(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, cursor);
        array = newArray;
    }

    private String itemsToString(){

        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < cursor; i++) {
            tmp.append(array[i].toString());
        }
        return tmp.toString();
    }

    @Override
    public String toString() {
        return "Set{" +itemsToString()+ '}';
    }
}
