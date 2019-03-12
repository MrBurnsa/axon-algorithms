package axon.data.sorting;

import java.util.List;

public final class HeapSorter implements Sorter {
    @Override
    public <T extends Comparable> void sort(final List<T> list) {
        final int n = list.size();
        for (int i = n / 2 - 1; i >= 0; i--) { //1
            heapify(list, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            final T temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);
            heapify(list, i, 0);
        }
    }

    private <T extends Comparable> void heapify(final List<T> list, final int n, final int index) {
        int largest = index;
        int left = 2 * index + 1; //i = 2, i = 1
        int right = 2 * index + 2; //i = 3, i = 2
        if (left < n && list.get(left).compareTo(list.get(largest)) > 0) largest = left; //8 < 9, 9 > 4
        if (right < n && list.get(right).compareTo(list.get(largest)) > 0) largest = right; //2 < 9, 8 < 9
        if (largest != index) {
            final T temp = list.get(index);
            list.set(index, list.get(largest));
            list.set(largest, temp);
            heapify(list, n, largest);
        }
    }
}