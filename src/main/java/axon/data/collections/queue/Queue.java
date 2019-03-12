package axon.data.collections.queue;

public interface Queue<T> {
    void push(T value);
    T pop();
    T peek();
    boolean isEmpty();
}
