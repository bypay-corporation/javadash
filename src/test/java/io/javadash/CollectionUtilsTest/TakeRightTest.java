package io.javadash.CollectionUtilsTest;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static io.javadash.CollectionUtils.*;  // Correct import for the collection utility methods
import static org.junit.jupiter.api.Assertions.*;

public class TakeRightTest {

    @Test
    void testTakeRightWithValidList() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");

        List<String> takenList = takeRight(list, 2);  // Using the takeRight method directly

        assertEquals(new ArrayList<>(List.of("cherry", "date")), takenList);  // Should return the last 2 elements
    }

    @Test
    void testTakeRightWithSingleElementList() {
        List<String> list = new ArrayList<>();
        list.add("apple");

        List<String> takenList = takeRight(list, 1);  // Using the takeRight method directly

        assertEquals(new ArrayList<>(List.of("apple")), takenList);  // Should return the only element in the list
    }

    @Test
    void testTakeRightWithEmptyList() {
        List<String> list = new ArrayList<>();

        List<String> takenList = takeRight(list, 3);  // Using the takeRight method directly

        assertEquals(new ArrayList<>(), takenList);  // Should return an empty list
    }

    @Test
    void testTakeRightWithNullList() {
        List<String> list = null;

        List<String> takenList = takeRight(list, 2);  // Using the takeRight method directly

        assertEquals(new ArrayList<>(), takenList);  // Should return an empty list
    }

    @Test
    void testTakeRightWithNegativeN() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        List<String> takenList = takeRight(list, -1);  // Using the takeRight method directly

        assertEquals(new ArrayList<>(), takenList);  // Should return an empty list when n is negative
    }

    @Test
    void testTakeRightWithNGreaterThanListSize() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");

        List<String> takenList = takeRight(list, 5);  // Using the takeRight method directly

        assertEquals(new ArrayList<>(List.of("apple", "banana")), takenList);  // Should return the whole list as n exceeds the list size
    }
}

