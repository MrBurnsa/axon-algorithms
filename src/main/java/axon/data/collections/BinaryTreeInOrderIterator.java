package axon.data.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public final class BinaryTreeInOrderIterator<T extends Comparable> implements Iterator<T> {
    private final Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();

    public BinaryTreeInOrderIterator(final BinaryTreeNode<T> root) {
        fillStack(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        final BinaryTreeNode<T> node = stack.pop();
        fillStack(node.right);
        return node.value;
    }

    private void fillStack(final BinaryTreeNode<T> root) {
        BinaryTreeNode<T> currentNode = root;
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.left;
        }
    }
}