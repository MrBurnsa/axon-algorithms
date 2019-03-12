package axon.data.collections;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable> {
    private BinaryTreeNode<T> root;

    public void insert(final T value) {
        root = insert(root, value);
    }

    public BinaryTreeNode<T> insert(final BinaryTreeNode<T> currentNode, final T value) {
        if (currentNode == null) return new BinaryTreeNode<>(value);
        final int compare = currentNode.value.compareTo(value);
        if (compare == 1) currentNode.left = insert(currentNode.left, value);
        else if (compare == -1) currentNode.right = insert(currentNode.right, value);
        return currentNode;
    }

    public void remove(final T value) {
        this.root = remove(root, value);
    }

    public List<T> getInOrder() {
        final List<T> list = new ArrayList<>();
        getInOrder(root, list);
        return list;
    }

    public void getInOrder(final BinaryTreeNode<T> currentNode, final List<T> list) {
        if (currentNode != null) {
            getInOrder(currentNode.left, list);
            list.add(currentNode.value);
            getInOrder(currentNode.right, list);
        }
    }

    public List<T> getPreOrder() {
        final List<T> list = new ArrayList<>();
        getPreOrder(root, list);
        return list;
    }

    public void getPreOrder(final BinaryTreeNode<T> currentNode, final List<T> list) {
        if (currentNode != null) {
            list.add(currentNode.value);
            getPreOrder(currentNode.left, list);
            getPreOrder(currentNode.right, list);
        }
    }

    private BinaryTreeNode<T> remove(final BinaryTreeNode<T> currentNode, final T value) {
        if (currentNode == null) return currentNode;
        final int compare = currentNode.value.compareTo(value);
        if (compare == 1) currentNode.left = remove(currentNode.left, value);
        else if (compare == -1) currentNode.right = remove(currentNode.right, value);
        else {
            if (currentNode.left == null) return currentNode.right;
            else if (currentNode.right == null) return currentNode.left;
            else {
                currentNode.value = findMinValue(currentNode.right);
                currentNode.right = remove(currentNode.right, currentNode.value);
            }
        }
        return currentNode;
    }

    private T findMinValue(final BinaryTreeNode<T> node) {
        BinaryTreeNode<T> currentNode = node;
        T minValue = currentNode.value;
        while (currentNode.left != null) {
            minValue = currentNode.left.value;
            currentNode = currentNode.left;
        }
        return minValue;
    }
}