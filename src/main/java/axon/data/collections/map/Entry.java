package axon.data.collections.map;

import java.util.Objects;

public class Entry<K, V> {
    final K key;
    V value;

    public Entry(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    public boolean keyEquals(final K target) {
        return Objects.equals(key, target);
    }
}