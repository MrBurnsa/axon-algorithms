package axon.data.collections.set;

import axon.data.collections.map.Entry;

import java.util.LinkedList;

public final class HashSet<T> {
    private static final int DEFAULT_BUCKETS = 16;

    private final LinkedList<T>[] buckets;

    public HashSet() {
        this(DEFAULT_BUCKETS);
    }

    public HashSet(final int bucketAmt) {
        buckets = new LinkedList[bucketAmt];
    }

    public void add(final T value) {
        final int bucketId = compress(value);
        if (buckets[bucketId] == null) buckets[bucketId] = new LinkedList<>();
        buckets[bucketId].add(value);
    }

    private int compress(final T value) {
        return value == null ? 0 : value.hashCode() & (buckets.length - 1);
    }
}