package io.javadash.CollectionUtilsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.javadash.CollectionUtils;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DropTest {

    @Test
    public void testDropWithValidInput() {
        // Test case 1: Drop 1 element from the start
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<Integer> result = CollectionUtils.drop(list, 1);
        assertEquals(List.of(2, 3, 4, 5), result);

        // Test case 2: Drop 2 elements from the start
        result = CollectionUtils.drop(list, 2);
        assertEquals(List.of(3, 4, 5), result);

        // Test case 3: Drop 5 elements (entire list)
        result = CollectionUtils.drop(list, 5);
        assertEquals(List.of(), result);

        // Test case 4: Drop 0 elements (should return the same list)
        result = CollectionUtils.drop(list, 0);
        assertEquals(List.of(1, 2, 3, 4, 5), result);
    }

    @Test
    public void testDropWithNegativeN() {
        // Test case 5: Negative n value, should treat as 0 (return full list)
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<Integer> result = CollectionUtils.drop(list, -1);
        assertEquals(List.of(1, 2, 3, 4, 5), result);
    }

    @Test
    public void testDropWithEmptyList() {
        // Test case 6: Drop from an empty list, should return empty list
        List<Integer> list = List.of();
        List<Integer> result = CollectionUtils.drop(list, 1);
        assertEquals(List.of(), result);
    }

    @Test
    public void testDropWithNullList() {
        // Test case 7: Null list input, should return empty list
        List<Integer> result = CollectionUtils.drop(null, 1);
        assertEquals(List.of(), result);
    }

    @Test
    public void testDropWithNGreaterThanListSize() {
        // Test case 8: Drop more elements than the size of the list, should return empty list
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<Integer> result = CollectionUtils.drop(list, 10);
        assertEquals(List.of(), result);
    }
}

