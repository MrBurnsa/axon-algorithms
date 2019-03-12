package axon.data.collections.map;

import java.util.Iterator;
import java.util.LinkedList;

public class HashMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_BUCKETS = 16;

    private final LinkedList<Entry<K, V>>[] buckets;

    public HashMap() {
        this(DEFAULT_BUCKETS);
    }

    public HashMap(final int bucketCount) {
        buckets = new LinkedList[bucketCount];
    }

    @Override
    public final V get(final K key) {
        final LinkedList<Entry<K, V>> bucket = getBucket(key);
        if (bucket == null) return null;
        for (final Iterator<Entry<K, V>> iterator = bucket.iterator(); iterator.hasNext();) {
            final Entry<K, V> next = iterator.next();
            if (next.keyEquals(key)) return next.value;
        }
        return null;
    }

    @Override
    public final void put(final K key, final V value) {
        final LinkedList<Entry<K, V>> bucket = getBucket(key);
        if (bucket == null) putAndCreateBucket(key, value);
        else put(key, value, getBucket(key));
    }

    @Override
    public final V remove(final K key) {
        final LinkedList<Entry<K, V>> bucket = getBucket(key);
        if (bucket == null) return null;
        for (final Iterator<Entry<K, V>> iterator = bucket.iterator(); iterator.hasNext();) {
            final Entry<K, V> next = iterator.next();
            if (next.keyEquals(key)) iterator.remove();
            return next.value;
        }
        return null;
    }

    @Override
    public boolean containsKey(final K key) {
        return true;
    }

    protected final LinkedList<Entry<K, V>> getBucket(final K key) {
        return buckets[compress(key)];
    }

    protected final void putAndCreateBucket(final K key, final V value) {
        final LinkedList<Entry<K, V>> bucket = new LinkedList<>();
        buckets[compress(key)] = bucket;
        putIfNotFound(key, value, bucket);
    }

    protected final void put(final K key, final V value, final LinkedList<Entry<K, V>> bucket) {
        boolean found = false;
        for (final Iterator<Entry<K, V>> iterator = bucket.iterator(); iterator.hasNext();) {
            final Entry<K, V> next = iterator.next();
            if (next.keyEquals(key)) {
                next.value = value;
                found = true;
            }
        }
        if (!found) putIfNotFound(key, value, bucket);
    }

    protected void putIfNotFound(K key, V value, final LinkedList<Entry<K, V>> bucket) {
        bucket.add(new Entry<>(key, value));
    }

    private int compress(final K key) {
        return key == null ? 0 : key.hashCode() & (buckets.length - 1);
    }
}