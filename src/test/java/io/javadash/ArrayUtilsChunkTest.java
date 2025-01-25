package io.javadash;

import static io.javadash.ArrayUtils.chunk;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ArrayUtilsChunkTest {
    @Test
    void testValidChunks() {
        String[] input = {"a", "b", "c", "d"};
        int size = 2;

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("c", "d")
        );

        List<List<String>> actual = chunk(input, size);
        assertEquals(expected, actual);
    }

    @Test
    void testUnevenChunks() {
        String[] input = {"a", "b", "c", "d", "e"};
        int size = 3;

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("a", "b", "c"),
            Arrays.asList("d", "e")
        );

        List<List<String>> actual = chunk(input, size);
        assertEquals(expected, actual);
    }

    @Test
    void testEmptyArray() {
        String[] input = {};
        int size = 2;

        List<List<String>> expected = new ArrayList<>();

        List<List<String>> actual = chunk(input, size);
        assertEquals(expected, actual);
    }

    @Test
    void testNullArray() {
        String[] input = null;
        int size = 2;

        List<List<String>> expected = new ArrayList<>();

        List<List<String>> actual = chunk(input, size);
        assertEquals(expected, actual);
    }

    @Test
    void testInvalidChunkSize() {
        String[] input = {"a", "b", "c"};
        int size = 0;

        List<List<String>> expected = new ArrayList<>();

        List<List<String>> actual = chunk(input, size);
        assertEquals(expected, actual);
    }

    @Test
    void testSingleElementChunks() {
        Integer[] input = {1, 2, 3};
        int size = 1;

        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(3)
        );

        List<List<Integer>> actual = chunk(input, size);
        assertEquals(expected, actual);
    }

    @Test
    void testChunkSizeLargerThanArray() {
        String[] input = {"a", "b", "c"};
        int size = 5;

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("a", "b", "c")
        );

        List<List<String>> actual = chunk(input, size);
        assertEquals(expected, actual);
    }
}
