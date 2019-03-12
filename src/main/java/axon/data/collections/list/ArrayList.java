package axon.data.collections.list;

public final class ArrayList<T> implements List<T> {
    private final static int DEFAULT_CAPACITY = 10;
    private final static int CAPACITY_MULTIPLIER = 2;

    private int capacity;
    private int index = 0;
    private Object[] array;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(final int initialCapacity) {
        capacity = initialCapacity;
        array = new Object[initialCapacity];
    }

    @Override
    public void add(final T value) {
        if (isFull()) resizeArray();
        array[index++] = value;
    }

    @Override
    public T get(final int index) {
        return (T) array[index];
    }

    private void resizeArray() {
        final Object[] newArray = new Object[capacity * CAPACITY_MULTIPLIER];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public boolean isFull() {
        return index == capacity - 1;
    }
}