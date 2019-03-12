package axon.data.collections;

class BinaryTreeNode<T extends Comparable> implements Comparable<BinaryTreeNode<T>> {
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    T value;

    BinaryTreeNode(final T value) {
        this.value = value;
    }

    @Override
    public int compareTo(final BinaryTreeNode<T> o) {
        return value.compareTo(o.value);
    }
}