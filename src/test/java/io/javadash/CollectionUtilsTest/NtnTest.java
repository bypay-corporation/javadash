package io.javadash.CollectionUtilsTest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static io.javadash.CollectionUtils.nth;
import static org.junit.jupiter.api.Assertions.*;

public class NtnTest {

    @Test
    void testNthWithValidListAndPositiveIndex() {
        List<String> array = List.of("apple", "banana", "cherry", "date");

        String result = nth(array, 2);

        assertEquals("cherry", result);
    }

    @Test
    void testNthWithValidListAndNegativeIndex() {
        List<String> array = List.of("apple", "banana", "cherry", "date");

        String result = nth(array, -1);

        assertEquals("date", result);
    }

    @Test
    void testNthWithIndexOutOfBoundsPositive() {
        List<String> array = List.of("apple", "banana", "cherry");

        String result = nth(array, 5);

        assertNull(result);
    }

    @Test
    void testNthWithIndexOutOfBoundsNegative() {
        List<String> array = List.of("apple", "banana", "cherry");

        String result = nth(array, -4);

        assertNull(result);
    }

    @Test
    void testNthWithNullList() {
        List<String> array = null;

        String result = nth(array, 1);

        assertNull(result);
    }

    @Test
    void testNthWithEmptyList() {
        List<String> array = List.of();

        String result = nth(array, 1);

        assertNull(result);
    }

    @Test
    void testNthWithValidListAndZeroIndex() {
        List<String> array = List.of("apple", "banana", "cherry");

        String result = nth(array, 0);

        assertEquals("apple", result);
    }

    @Test
    void testNthWithNegativeIndexForLastElement() {
        List<String> array = List.of("apple", "banana", "cherry");

        String result = nth(array, -3);

        assertEquals("apple", result);
    }
}

