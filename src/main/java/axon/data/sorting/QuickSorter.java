package axon.data.sorting;

import java.util.List;

public final class QuickSorter implements Sorter {
    @Override
    public <T extends Comparable> void sort(final List<T> list) {
        sort(list, 0, list.size() - 1);
    }

    public <T extends Comparable> void sort(final List<T> list, final int l, final int r) {
        if (l < r) {
            final int partition = partition(list, l, r);
            sort(list, l, partition - 1);
            sort(list, partition + 1, r);
        }
    }

    private static <T extends Comparable> int partition(final List<T> list, final int l, final int r) {
        final T pivot = list.get(r);
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                ++i;
                swap(list, i, j);
            }
        }
        ++i;
        swap(list, i, r);
        return i;
    }

    private static <T extends Comparable> void swap(final List<T> list, final int i, final int j) {
        final T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}