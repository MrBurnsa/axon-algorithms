package axon.data.collections.map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HashMapTest {
    private final Map<String, Integer> classUnderTest = new HashMap<>();

    @Test
    public void get_whenAnEntryHasBeenPutIntoTheHashMapThenTheValueShouldBeReturned() {
        final String key = "fakeKey";
        final Integer value = 5;

        classUnderTest.put(key, value);

        final Integer response = classUnderTest.get(key);

        assertEquals(value, response);
    }

    @Test
    public void get_whenAnEntryHasBeenPutIntoTheHashMapTwiceThenTheLastValueShouldBeReturned() {
        final String key = "fakeKey";
        final Integer valueOne = 5;
        final Integer valueTwo = 64;

        classUnderTest.put(key, valueOne);
        classUnderTest.put(key, valueTwo);

        final Integer response = classUnderTest.get(key);

        assertEquals(valueTwo, response);
    }

    @Test
    public void get_whenAnEntryHasNotBeenPutIntoTheHashMapThenNullShouldBeReturned() {
        final Integer response = classUnderTest.get("Key That Does Not Exist");
        assertNull(response);
    }

    @Test
    public void remove_whenAnEntryIsRemovedThenItsValueShouldBeReturned() {
        final String key = "Key To Remove";
        final Integer value = 54;

        classUnderTest.put(key, value);

        final Integer response = classUnderTest.remove(key);

        assertEquals(value, response);
    }

    @Test
    public void remove_whenAnEntryIsRemovedThenItShouldNotBeReturnedWithAGetCall() {
        final String key = "Key To Remove";
        final Integer value = 54;

        classUnderTest.put(key, value);
        classUnderTest.remove(key);

        final Integer response = classUnderTest.get(key);

        assertNull(response);
    }
}
