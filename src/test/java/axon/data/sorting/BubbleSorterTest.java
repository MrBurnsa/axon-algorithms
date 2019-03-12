package axon.data.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public final class BubbleSorterTest {
    private final BubbleSorter classUnderTest = new BubbleSorter();

    @Test
    public void sort_int_array_when() {
        final List<Integer> list = new ArrayList<>(10);
        list.add(43);
        list.add(3);
        list.add(33);
        list.add(10);
        list.add(5);
        list.add(20923);
        list.add(77);
        list.add(12);
        list.add(58);
        list.add(230);
        classUnderTest.sort(list);

        assertEquals(new Integer(3), list.get(0));
        assertEquals(new Integer(5), list.get(1));
        assertEquals(new Integer(10), list.get(2));
        assertEquals(new Integer(12), list.get(3));
        assertEquals(new Integer(33), list.get(4));
        assertEquals(new Integer(43), list.get(5));
        assertEquals(new Integer(58), list.get(6));
        assertEquals(new Integer(77), list.get(7));
        assertEquals(new Integer(230), list.get(8));
        assertEquals(new Integer(20923), list.get(9));
    }
}