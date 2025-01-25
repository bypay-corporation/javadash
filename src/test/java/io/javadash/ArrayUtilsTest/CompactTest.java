package io.javadash.ArrayUtilsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.javadash.ArrayUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CompactTest {
    @Test
    void testCompactWithMixedValues() {
        Object[] input = {0, 1, false, 2, "", 3, null, Double.NaN};
        List<Object> expected = Arrays.asList(1, 2, 3);

        List<Object> actual = ArrayUtils.compact(input);
        assertEquals(expected, actual);
    }

    @Test
    void testCompactWithIntegerValues() {
        Object[] input = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        List<Object> expected = Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE);

        List<Object> actual = ArrayUtils.compact(input);
        assertEquals(expected, actual);
    }

    @Test
    void testCompactWithDoubleValues() {
        Object[] input =
            {Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE,
                Double.MIN_NORMAL, Double.MIN_EXPONENT, Double.MAX_EXPONENT, Double.BYTES};
        List<Object> expected =
            Arrays.asList(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE,
                Double.MIN_NORMAL, Double.MIN_EXPONENT, Double.MAX_EXPONENT, Double.BYTES);

        List<Object> actual = ArrayUtils.compact(input);
        assertEquals(expected, actual);
    }

    @Test
    void testCompactWithAllFalseyValues() {
        Object[] input = {0, false, "", null, Double.NaN};
        List<Object> expected = Collections.emptyList(); // Expect empty list

        List<Object> actual = ArrayUtils.compact(input);
        assertEquals(expected, actual);
    }

    @Test
    void testCompactWithAllTruthyValues() {
        Object[] input = {true, 42, "Hello", 3.14};
        List<Object> expected = Arrays.asList(true, 42, "Hello", 3.14);

        List<Object> actual = ArrayUtils.compact(input);
        assertEquals(expected, actual);
    }

    @Test
    void testCompactWithEmptyArray() {
        Object[] input = {};
        List<Object> expected = Collections.emptyList(); // Expect empty list

        List<Object> actual = ArrayUtils.compact(input);
        assertEquals(expected, actual);
    }

    @Test
    void testCompactWithNullArray() {
        Object[] input = null;
        List<Object> expected = Collections.emptyList(); // Expect empty list

        List<Object> actual = ArrayUtils.compact(input);
        assertEquals(expected, actual);
    }

    @Test
    void testCompactWithNumbersOnly() {
        Object[] input = {0, 1, 2, 3, -1, 0.0, Double.NaN};
        List<Object> expected = Arrays.asList(1, 2, 3, -1);

        List<Object> actual = ArrayUtils.compact(input);
        assertEquals(expected, actual);
    }

    @Test
    void testCompactWithStringsOnly() {
        Object[] input = {"", "Hello", "World", null};
        List<Object> expected = Arrays.asList("Hello", "World");

        List<Object> actual = ArrayUtils.compact(input);
        assertEquals(expected, actual);
    }

    @Test
    void testCompactWithBooleansOnly() {
        Object[] input = {true, false, null};
        List<Object> expected = Collections.singletonList(true);

        List<Object> actual = ArrayUtils.compact(input);
        assertEquals(expected, actual);
    }
}
