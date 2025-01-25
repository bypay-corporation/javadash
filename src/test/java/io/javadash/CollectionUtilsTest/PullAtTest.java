package io.javadash.CollectionUtilsTest;

import static io.javadash.CollectionUtils.pullAt;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PullAtTest {

    @Test
    void testPullAtWithValidIndexes() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");

        List<Integer> indexes = new ArrayList<>();
        indexes.add(1);
        indexes.add(3);

        List<String> removedElements = pullAt(list, indexes);

        assertEquals(new ArrayList<>(List.of("banana", "date")), removedElements);
        assertEquals(new ArrayList<>(List.of("apple", "cherry")), list);
    }

    @Test
    void testPullAtWithNoMatchingIndexes() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        List<Integer> indexes = new ArrayList<>();
        indexes.add(5); // An index out of range

        List<String> removedElements = pullAt(list, indexes);

        assertEquals(new ArrayList<>(), removedElements);
        assertEquals(new ArrayList<>(List.of("apple", "banana", "cherry")), list);
    }

    @Test
    void testPullAtWithEmptyIndexes() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        List<Integer> indexes = new ArrayList<>(); // Empty list

        List<String> removedElements = pullAt(list, indexes);

        assertEquals(new ArrayList<>(), removedElements);
        assertEquals(new ArrayList<>(List.of("apple", "banana", "cherry")), list);
    }

    @Test
    void testPullAtWithNullList() {
        List<String> list = null;

        List<Integer> indexes = new ArrayList<>();
        indexes.add(0);

        List<String> removedElements = pullAt(list, indexes);

        assertEquals(new ArrayList<>(), removedElements);
    }

    @Test
    void testPullAtWithNullIndexes() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");

        List<Integer> indexes = null; // Null indexes

        List<String> removedElements = pullAt(list, indexes);

        assertEquals(new ArrayList<>(), removedElements);
        assertEquals(new ArrayList<>(List.of("apple", "banana")), list);
    }

    @Test
    void testPullAtWithMultipleIndexes() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");

        List<Integer> indexes = new ArrayList<>();
        indexes.add(0);
        indexes.add(2);

        List<String> removedElements = pullAt(list, indexes);

        assertEquals(new ArrayList<>(List.of("apple", "cherry")), removedElements);
        assertEquals(new ArrayList<>(List.of("banana", "date")), list);
    }

    @Test
    void testPullAtWithIndexesInDescendingOrder() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");

        List<Integer> indexes = new ArrayList<>();
        indexes.add(3);
        indexes.add(1);

        List<String> removedElements = pullAt(list, indexes);

        assertEquals(new ArrayList<>(List.of("banana", "date")), removedElements);
        assertEquals(new ArrayList<>(List.of("apple", "cherry")), list);
    }
}

