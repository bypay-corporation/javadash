package io.javadash.CollectionUtilsTest;

import static io.javadash.CollectionUtils.slice;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SliceTest {

    @Test
    void testSliceWithValidStartAndEnd() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");

        List<String> slicedList = slice(list, 1, 3);

        assertEquals(new ArrayList<>(List.of("banana", "cherry")), slicedList);
    }

    @Test
    void testSliceWithStartGreaterThanEnd() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");

        List<String> slicedList = slice(list, 3, 1);

        assertEquals(new ArrayList<>(), slicedList);  // The result should be an empty list
    }

    @Test
    void testSliceWithOutOfBoundStart() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");

        List<String> slicedList = slice(list, -1, 2);

        assertEquals(new ArrayList<>(List.of("apple", "banana")), slicedList);
    }

    @Test
    void testSliceWithOutOfBoundEnd() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");

        List<String> slicedList = slice(list, 1, 10);

        assertEquals(new ArrayList<>(List.of("banana", "cherry", "date")), slicedList);
    }

    @Test
    void testSliceWithEmptyList() {
        List<String> list = new ArrayList<>();

        List<String> slicedList = slice(list, 0, 2);

        assertEquals(new ArrayList<>(), slicedList);
    }

    @Test
    void testSliceWithSingleElement() {
        List<String> list = new ArrayList<>();
        list.add("apple");

        List<String> slicedList = slice(list, 0, 1);

        assertEquals(new ArrayList<>(List.of("apple")), slicedList);
    }

    @Test
    void testSliceWithStartEqualEnd() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");

        List<String> slicedList = slice(list, 2, 2);

        assertEquals(new ArrayList<>(), slicedList);  // Start and end are the same, should return empty list
    }
}

