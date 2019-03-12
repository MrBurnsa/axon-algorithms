package axon.data.collections.lrucache;

class LRUNode<K, V> {
    K key;
    V val;
    LRUNode<K, V> prev;
    LRUNode<K, V> next;
}