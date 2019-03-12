package axon.data.collections.lrucache;

import java.util.HashMap;
import java.util.Map;

public final class LRUCache<K, V> implements Cache<K, V> {
    private final Map<K, LRUNode> map = new HashMap<>();
    private LRUNode head;
    private LRUNode end;
    private int capacity;

    public LRUCache(final int capacity) {
        this.capacity = capacity;
    }

    @Override
    public V get(K key) {
        if (!map.containsKey(key)) return null;
        final LRUNode<K, V> node = map.get(key);
        if (node != head) moveNode(node);
        return node.val;
    }

    @Override
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            get(key);
            return;
        }
        if (map.size() == capacity) {
            if (end == null) return;
            map.remove(end.key);
            end = end.prev;
            if (end != null) end.next = null;
        }
        final LRUNode<K, V> node = createNode(key, value);
        node.next = head;
        if (head != null) head.prev = node;
        else end = node;
        head = node;
        map.put(key, node);
    }

    private LRUNode<K, V> createNode(final K key, final V value) {
        final LRUNode<K, V> node = new LRUNode<>();
        node.key = key;
        node.val = value;
        return node;
    }

    private void moveNode(LRUNode<K, V> node) {
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
            if (end == node) end = node.prev;
        }
        head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;
    }
}