package io.javadash.CollectionUtilsTest;

import static io.javadash.CollectionUtils.intersectionWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import org.junit.jupiter.api.Test;

public class IntersectionWithTest {

    @Test
    void testIntersectionWithMatchingElements() {
        List<Integer> array = List.of(1, 2, 3, 4);
        List<Integer> values1 = List.of(3, 4, 5);
        List<Integer> values2 = List.of(4, 5, 6);

        BiPredicate<Integer, Integer> comparator = Objects::equals;

        List<Integer> result = intersectionWith(array, comparator, values1, values2);

        assertEquals(List.of(4), result);
    }

    @Test
    void testIntersectionWithNoMatchingElements() {
        List<Integer> array = List.of(1, 2, 3);
        List<Integer> values1 = List.of(4, 5, 6);

        BiPredicate<Integer, Integer> comparator = Objects::equals;

        List<Integer> result = intersectionWith(array, comparator, values1);

        assertTrue(result.isEmpty());
    }

    @Test
    void testIntersectionWithOneMatchingList() {
        List<String> array = List.of("apple", "banana", "cherry");
        List<String> values1 = List.of("banana", "cherry");
        List<String> values2 = List.of("date", "cherry");

        BiPredicate<String, String> comparator = String::equals;

        List<String> result = intersectionWith(array, comparator, values1);

        assertEquals(List.of("banana", "cherry"), result);
    }

    @Test
    void testIntersectionWithNullList() {
        List<Integer> array = null;
        List<Integer> values1 = List.of(1, 2, 3);

        BiPredicate<Integer, Integer> comparator = Objects::equals;

        List<Integer> result = intersectionWith(array, comparator, values1);

        assertTrue(result.isEmpty());
    }

    @Test
    void testIntersectionWithNullValuesList() {
        List<Integer> array = List.of(1, 2, 3);
        List<Integer> values1 = null;
        List<Integer> values2 = null;
        List<Integer> values3 = Arrays.asList(11, 23, null);

        BiPredicate<Integer, Integer> comparator = Objects::equals;

        List<Integer> result = intersectionWith(array, comparator, values1, values2, values3);

        assertTrue(result.isEmpty());
    }

    @Test
    void testIntersectionWithCustomComparator() {
        List<String> array = List.of("apple", "banana", "cherry");
        List<String> values1 = List.of("APPLE", "BANANA");

        BiPredicate<String, String> comparator = (a, b) -> a.equalsIgnoreCase(b);

        List<String> result = intersectionWith(array, comparator, values1);

        assertEquals(List.of("apple", "banana"), result);
    }

    @Test
    void testIntersectionWithEmptyArray() {
        List<String> array = Collections.emptyList();
        List<String> values1 = List.of("apple", "banana");

        BiPredicate<String, String> comparator = String::equals;

        List<String> result = intersectionWith(array, comparator, values1);

        assertTrue(result.isEmpty());
    }

    @Test
    void testIntersectionWithEmptyValues() {
        List<String> array = List.of("apple", "banana", "cherry");
        List<String> values1 = Collections.emptyList();

        BiPredicate<String, String> comparator = String::equals;

        List<String> result = intersectionWith(array, comparator, values1);

        assertTrue(result.isEmpty());
    }
}

