package axon.data.collections.map;

import java.util.LinkedList;

public final class LinkedHashMap<K, V> extends HashMap<K, V> {
    private final LinkedList<K> orderedKeys = new LinkedList<>();

    @Override
    protected void putIfNotFound(K key, V value, final LinkedList<Entry<K, V>> bucket) {
        bucket.add(new Entry<>(key, value));
        addKeyToOrderedKeys(key);
    }

    private void addKeyToOrderedKeys(final K key) {
        orderedKeys.add(key);
    }
}