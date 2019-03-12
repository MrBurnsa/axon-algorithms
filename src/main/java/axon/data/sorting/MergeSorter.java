package axon.data.sorting;

import java.util.List;

public final class MergeSorter implements Sorter {
    @Override
    public <T extends Comparable> void sort(final List<T> list) {
        sort(list, 0, list.size() - 1);
    }

    public <T extends Comparable> void sort(final List<T> list, final int l, final int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(list, l, m);
            sort(list, m + 1, r);
            merge(list, l, m, r);
        }
    }

    private static <T extends Comparable> void merge(final List<T> list, final int l, final int m, final int r) {
        final int lSize = m - l + 1;
        final int rSize = r - m;
        final Object[] left = createSubArray(list, lSize, l);
        final Object[] right = createSubArray(list, rSize, m + 1);
        int i = 0, j = 0;
        int k = l;
        while (i < lSize && j < rSize) {
            T castLeft = (T) left[i];
            T castRight = (T) right[j];
            if (castLeft.compareTo(castRight) <= 0) {
                list.set(k, castLeft);
                ++i;
            } else {
                list.set(k, castRight);
                ++j;
            }
            ++k;
        }
        while (i < lSize) {
            list.set(k, (T) left[i++]);
            ++k;
        }
        while (j < rSize) {
            list.set(k, (T) right[j++]);
            ++k;
        }
    }

    private static <T extends Comparable> Object[] createSubArray(final List<T> list, final int length, final int offset) {
        final Object[] array = new Object[length];
        for (int i = 0; i < length; i++) {
            array[i] = list.get(i + offset);
        }
        return array;
    }

//    public void sort(final int[] arr, final int left, final int right) {
//        if (left < right) {
//            int middle = (left + right) / 2;
//            sort(arr, left, middle);
//            sort(arr, middle + 1, right);
//            merge(arr, left, middle, right);
//        }
//    }
//
//    private void merge(final int[] arr, final int left, final int middle, final int right) {
//        int leftSize = middle - left + 1;
//        int rightSize = right - middle;
//        int[] leftArr = new int[middle - left];
//        for (int i = 0; i < leftArr.length; i++) {
//            leftArr[i] = arr[i];
//        }
//        int[] rightArr = new int[right - (middle + 1)];
//        for (int i = 0; i < rightArr.length; i++) {
//            rightArr[i] = arr[middle + i];
//        }
//        int i = 0, j = 0;
//        int k = left;
//        while (i < leftSize && j < rightSize) {
//            if (left <= right) {
//                arr[k] = leftArr[i++];
//            } else {
//                arr[k] = rightArr[j++];
//            }
//            ++k;
//        }
//        while (i < leftSize) {
//            arr[k] = leftArr[i++];
//            ++k;
//        }
//        while (j < rightSize) {
//            arr[k] = rightArr[j++];
//            k++;
//        }
//    }
}