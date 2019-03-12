package axon.data.collections.list;

public class SinglyLinkedList<T> implements List<T> {
    private T value;
    private SinglyLinkedList<T> next;

    @Override
    public void add(final T value) {
        next = add(next, value);
    }

    private SinglyLinkedList add(final SinglyLinkedList<T> node, final T value) {
        if (node == null) {
            final SinglyLinkedList<T> newNode = new SinglyLinkedList<>();
            newNode.value = value;
            return newNode;
        }
        node.next = add(node.next, value);
        return node;
    }

    @Override
    public T get(final int index) {
        return find(index).value;
    }

    private SinglyLinkedList<T> find(final int index) {
        SinglyLinkedList<T> currentNode = next;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}
