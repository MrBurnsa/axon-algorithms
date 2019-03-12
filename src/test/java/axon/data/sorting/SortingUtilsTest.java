package axon.data.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SortingUtilsTest {
    private final SortingUtils classUnderTest = new SortingUtils();

    @Test
    public void fgd() {
        final int count = 10;
        final InsertionSorter insertionSorter = new InsertionSorter();
        final MergeSorter mergeSorter = new MergeSorter();


        List<Integer> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(i);
            //list.add(ThreadLocalRandom.current().nextInt(-7598, Integer.MAX_VALUE));
        }

        long start = System.nanoTime();
        insertionSorter.sort(list);


        list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(ThreadLocalRandom.current().nextInt(-7598, Integer.MAX_VALUE));
        }

        start = System.nanoTime();
        insertionSorter.sort(list);
        System.out.println((System.nanoTime() - start) + " is INSERT time");


        list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(ThreadLocalRandom.current().nextInt(-7598, Integer.MAX_VALUE));
        }

        start = System.nanoTime();
        mergeSorter.sort(list);
        System.out.println((System.nanoTime() - start) + " is MERGE time");


        list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(ThreadLocalRandom.current().nextInt(-7598, Integer.MAX_VALUE));
        }

        start = System.nanoTime();
        insertionSorter.sort(list);
        System.out.println((System.nanoTime() - start) + " is INSERT time");


        list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(ThreadLocalRandom.current().nextInt(-7598, Integer.MAX_VALUE));
        }

        start = System.nanoTime();
        mergeSorter.sort(list);
        System.out.println((System.nanoTime() - start) + " is MERGE time");

    }
}
