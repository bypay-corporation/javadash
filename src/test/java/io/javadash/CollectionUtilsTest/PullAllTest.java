package io.javadash.CollectionUtilsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.javadash.CollectionUtils.pullAll;
import static org.junit.jupiter.api.Assertions.*;

public class PullAllTest {

    @Test
    void testPullAllWithValidListAndValuesToRemove() {
        List<String> array = new ArrayList<>();
        array.add("apple");
        array.add("banana");
        array.add("cherry");
        array.add("date");
        array.add("banana");

        List<String> result = pullAll(array, new ArrayList<>(List.of("banana", "cherry")));

        assertEquals(new ArrayList<>(List.of("apple", "date")), result);
    }

    @Test
    void testPullAllWithValidListAndNoMatchingValues() {
        List<String> array = new ArrayList<>();
        array.add("apple");
        array.add("banana");
        array.add("cherry");

        List<String> result = pullAll(array, new ArrayList<>(List.of("orange")));

        assertEquals(new ArrayList<>(List.of("apple", "banana", "cherry")), result);
    }

    @Test
    void testPullAllWithEmptyList() {
        List<String> array = new ArrayList<>();

        List<String> result = pullAll(array, new ArrayList<>(List.of("banana")));

        assertEquals(new ArrayList<>(), result);
    }

    @Test
    void testPullAllWithNullList() {
        List<String> array = null;

        List<String> result = pullAll(array, new ArrayList<>(List.of("banana")));

        assertNull(result);
    }

    @Test
    void testPullAllWithNullValues() {
        List<String> array = new ArrayList<>();
        array.add("apple");
        array.add("banana");
        array.add("cherry");
        List<String> result = pullAll(array, null);

        assertEquals(new ArrayList<>(List.of("apple", "banana", "cherry")), result);
    }

    @Test
    void testPullAllWithNullValuesInArray() {
        List<String> array = new ArrayList<>();
        array.add("apple");
        array.add("banana");
        array.add("cherry");

        List<String> result = pullAll(array, new ArrayList<>(Arrays.asList("banana", null)));

        assertEquals(new ArrayList<>(List.of("apple", "cherry")), result);
    }

    @Test
    void testPullAllWithMultipleIdenticalValues() {
        List<String> array = new ArrayList<>();
        array.add("apple");
        array.add("banana");
        array.add("banana");
        array.add("cherry");

        List<String> result = pullAll(array, new ArrayList<>(List.of("banana")));

        assertEquals(new ArrayList<>(List.of("apple", "cherry")), result);
    }

    @Test
    void testPullAllWithEmptyValuesList() {
        List<String> array = new ArrayList<>();
        array.add("apple");
        array.add("banana");
        array.add("cherry");

        List<String> result = pullAll(array, new ArrayList<>());

        assertEquals(new ArrayList<>(List.of("apple", "banana", "cherry")), result);
    }
}

