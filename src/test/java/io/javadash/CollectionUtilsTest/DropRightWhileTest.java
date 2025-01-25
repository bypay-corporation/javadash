package io.javadash.CollectionUtilsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.javadash.CollectionUtils;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DropRightWhileTest {
    // Additional test cases if needed
    @Test
    public void testDropRightWhileWithEmptyList() {
        List<Integer> emptyList = List.of();
        List<Integer> result = CollectionUtils.dropRightWhile(emptyList, num -> num > 3);
        assertTrue(result.isEmpty(), "Result should be empty for an empty list");
    }

    @Test
    public void testDropRightWhileWithValidPredicate() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> result = CollectionUtils.dropRightWhile(numbers, num -> num > 3);
        assertEquals(List.of(1, 2, 3), result, "List should exclude numbers greater than 3");
    }
}
