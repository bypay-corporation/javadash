package io.javadash.CollectionUtilsTest;

import static io.javadash.CollectionUtils.pull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PullTest {

    @Test
    void testPullWithValidListAndValuesToRemove() {
        List<String> array = new ArrayList<>(List.of("apple", "banana", "cherry", "date", "banana"));

        List<String> result = pull(array, "banana", "cherry");

        assertEquals(List.of("apple", "date"), result);
    }

    @Test
    void testPullWithValidListAndNoMatchingValues() {
        List<String> array = new ArrayList<>(List.of("apple", "banana", "cherry"));

        List<String> result = pull(array, "orange");

        assertEquals(List.of("apple", "banana", "cherry"), result);
    }

    @Test
    void testPullWithEmptyList() {
        List<String> array = new ArrayList<>(List.of());

        List<String> result = pull(array, "banana");

        assertEquals(List.of(), result);
    }

    @Test
    void testPullWithNullList() {
        List<String> array = null;

        List<String> result = pull(array, "banana");

        assertNull(result);
    }

    @Test
    void testPullWithNullValues() {
        List<String> array = new ArrayList<>(List.of("apple", "banana", "cherry"));

        List<String> result = pull(array, (String[]) null);

        assertEquals(List.of("apple", "banana", "cherry"), result);
    }

    @Test
    void testPullWithNullValuesInArray() {
        List<String> array = new ArrayList<>(List.of("apple", "banana", "cherry"));

        List<String> result = pull(array, "banana", null);

        assertEquals(List.of("apple", "cherry"), result);
    }

    @Test
    void testPullWithMultipleIdenticalValues() {
        List<String> array = new ArrayList<>(List.of("apple", "banana", "banana", "cherry"));

        List<String> result = pull(array, "banana");

        assertEquals(List.of("apple", "cherry"), result);
    }
}

