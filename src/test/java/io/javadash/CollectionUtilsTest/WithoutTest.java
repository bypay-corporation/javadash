package io.javadash.CollectionUtilsTest;

import org.junit.jupiter.api.Test;
import static io.javadash.CollectionUtils.*;  // Correct import for the collection utility methods
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WithoutTest {

    @Test
    void testWithout() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        // Remove 2 and 4 from the list
        List<Integer> result = without(list, 2, 4);

        // The result should contain the elements 1, 3, 5
        assertEquals(List.of(1, 3, 5), result);
    }

    @Test
    void testWithoutEmptyList() {
        List<Integer> list = List.of();

        // Remove 2 and 4 from the empty list
        List<Integer> result = without(list, 2, 4);

        // The result should be an empty list
        assertEquals(List.of(), result);
    }

    @Test
    void testWithoutNullList() {
        List<Integer> list = null;

        // Remove 2 and 4 from the null list
        List<Integer> result = without(list, 2, 4);

        // The result should be an empty list since the input is null
        assertEquals(List.of(), result);
    }

    @Test
    void testWithoutValuesNotInList() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        // Remove values not in the list
        List<Integer> result = without(list, 6, 7);

        // The result should be the same as the original list since no values were removed
        assertEquals(List.of(1, 2, 3, 4, 5), result);
    }

    @Test
    void testWithoutAllValues() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        // Remove all values from the list
        List<Integer> result = without(list, 1, 2, 3, 4, 5);

        // The result should be an empty list
        assertEquals(List.of(), result);
    }

    @Test
    void testWithoutDuplicates() {
        List<Integer> list = List.of(1, 2, 2, 3, 3, 4);

        // Remove 2 and 3 from the list
        List<Integer> result = without(list, 2, 3);

        // The result should contain [1, 4], removing duplicates as well
        assertEquals(List.of(1, 4), result);
    }
}






