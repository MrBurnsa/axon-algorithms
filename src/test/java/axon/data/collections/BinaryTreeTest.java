package axon.data.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public final class BinaryTreeTest {
    private final BinaryTree<Integer> classUnderTest = new BinaryTree<>();

    @Before
    public void init() {
        classUnderTest.insert(34);
        classUnderTest.insert(10);
        classUnderTest.insert(15);
        classUnderTest.insert(54);
        classUnderTest.insert(5);
        classUnderTest.insert(42);
        classUnderTest.insert(69);
        classUnderTest.insert(7);
    }

    @Test
    public void getInOrder_whenValuesAreEnteredThenTheyShouldBeReturnedInOrder() {
        final List<Integer> list = classUnderTest.getInOrder();

        assertEquals(new Integer(5), list.get(0));
        assertEquals(new Integer(7), list.get(1));
        assertEquals(new Integer(10), list.get(2));
        assertEquals(new Integer(15), list.get(3));
        assertEquals(new Integer(34), list.get(4));
        assertEquals(new Integer(42), list.get(5));
        assertEquals(new Integer(54), list.get(6));
        assertEquals(new Integer(69), list.get(7));
    }

    @Test
    public void getPreOrder_whenValuesAreEnteredThenTheyShouldBeReturnedPreOrder() {
        final List<Integer> list = classUnderTest.getPreOrder();

        assertEquals(new Integer(34), list.get(0));
        assertEquals(new Integer(10), list.get(1));
        assertEquals(new Integer(5), list.get(2));
        assertEquals(new Integer(7), list.get(3));
        assertEquals(new Integer(15), list.get(4));
        assertEquals(new Integer(54), list.get(5));
        assertEquals(new Integer(42), list.get(6));
        assertEquals(new Integer(69), list.get(7));
    }
}
