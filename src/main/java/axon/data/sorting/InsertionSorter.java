package axon.data.sorting;

import java.util.List;

/**
 * Best: O(n)
 * Average: O(n^2)
 * Worst: O(n^2)
 */
public final class InsertionSorter implements Sorter {
    @Override
    public <T extends Comparable> void sort(final List<T> list) {
        final int size = list.size();
        for (int i = 1; i < list.size(); i++) {
            T initValue = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(initValue) == 1) {
                list.set(j + 1, list.get(j));
                --j;
            }
            list.set(j + 1, initValue);
        }
    }
}