package axon.data.collections.lrucache;

public interface Cache<K, V> {
    V get(K key);
    void put(K key, V value);
}
