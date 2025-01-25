package io.javadash.CollectionUtilsTest;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.javadash.CollectionUtils.lastIndexOf;
import static org.junit.jupiter.api.Assertions.*;

public class LastIndexOfTest {

    @Test
    void testLastIndexOfWithValidListAndExistingValue() {
        List<String> array = List.of("apple", "banana", "cherry", "banana", "apple");

        int result = lastIndexOf(array, "banana", array.size() - 1);

        assertEquals(3, result);
    }

    @Test
    void testLastIndexOfWithValidListAndNonExistingValue() {
        List<String> array = List.of("apple", "banana", "cherry");

        int result = lastIndexOf(array, "orange", array.size() - 1);

        assertEquals(-1, result);
    }

    @Test
    void testLastIndexOfWithNullValue() {
        List<String> array = Arrays.asList("apple", null, "cherry", null);

        int result = lastIndexOf(array, null, array.size() - 1);

        assertEquals(3, result);
    }

    @Test
    void testLastIndexOfWithFromIndexInBounds() {
        List<String> array = List.of("apple", "banana", "cherry", "banana");

        int result = lastIndexOf(array, "banana", 2);

        assertEquals(1, result);
    }

    @Test
    void testLastIndexOfWithFromIndexOutOfBoundsHigh() {
        List<String> array = List.of("apple", "banana", "cherry");

        int result = lastIndexOf(array, "cherry", 10);

        assertEquals(2, result);
    }

    @Test
    void testLastIndexOfWithFromIndexOutOfBoundsLow() {
        List<String> array = List.of("apple", "banana", "cherry");

        int result = lastIndexOf(array, "apple", -10);

        assertEquals(0, result);
    }

    @Test
    void testLastIndexOfWithNullList() {
        List<String> array = null;

        int result = lastIndexOf(array, "apple", 0);

        assertEquals(-1, result);
    }

    @Test
    void testLastIndexOfWithEmptyList() {
        List<String> array = List.of();

        int result = lastIndexOf(array, "apple", 0);

        assertEquals(-1, result);
    }
}

