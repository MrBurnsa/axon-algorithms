package axon.data.sorting;

import java.util.List;

public interface Sorter {
    <T extends Comparable> void sort(List<T> list);

    void sort(int[] arr);
}