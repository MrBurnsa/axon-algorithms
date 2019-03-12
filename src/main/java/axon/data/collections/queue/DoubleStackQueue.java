package axon.data.collections.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public final class DoubleStackQueue<T> implements Queue<T> {
    private Deque<T> inbound = new ArrayDeque<>();
    private Deque<T> outbound = new ArrayDeque<>();

    public void push(T value) {
        inbound.push(value);
    }

    @Override
    public T pop() {
        if (!outbound.isEmpty()) {
            return outbound.pop();
        }
        if (inbound.isEmpty()) return null;
        reload();
        return pop();
    }

    @Override
    public T peek() {
        if (!outbound.isEmpty()) {
            return outbound.peek();
        }
        if (inbound.isEmpty()) return null;
        reload();
        return peek();
    }

    private void reload() {
        while (!inbound.isEmpty()) {
            outbound.push(inbound.pop());
        }
    }

    @Override
    public boolean isEmpty() {
        return outbound.isEmpty() && inbound.isEmpty();
    }
}