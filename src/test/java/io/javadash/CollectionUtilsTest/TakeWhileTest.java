package io.javadash.CollectionUtilsTest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import static io.javadash.CollectionUtils.*;  // Correct import for the collection utility methods
import static org.junit.jupiter.api.Assertions.*;

public class TakeWhileTest {

    @Test
    void testTakeWhileWithValidList() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");

        Predicate<String> predicate = s -> s.length() > 5;  // Only select strings with length > 5

        List<String> takenList = takeWhile(list, predicate);  // Using the takeWhile method directly

        assertEquals(new ArrayList<>(List.of("banana", "cherry")), takenList);  // Should return ["banana", "cherry"]
    }

    @Test
    void testTakeWhileWithEmptyList() {
        List<String> list = new ArrayList<>();

        Predicate<String> predicate = s -> s.length() > 3;

        List<String> takenList = takeWhile(list, predicate);  // Using the takeWhile method directly

        assertEquals(new ArrayList<>(), takenList);  // Should return an empty list
    }

    @Test
    void testTakeWhileWithNullList() {
        List<String> list = null;

        Predicate<String> predicate = s -> s.length() > 3;

        List<String> takenList = takeWhile(list, predicate);  // Using the takeWhile method directly

        assertEquals(new ArrayList<>(), takenList);  // Should return an empty list
    }

    @Test
    void testTakeWhileWithPredicateReturningFalseForAll() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        Predicate<String> predicate = s -> s.length() > 10;  // No string has length > 10

        List<String> takenList = takeWhile(list, predicate);  // Using the takeWhile method directly

        assertEquals(new ArrayList<>(), takenList);  // Should return an empty list since the predicate is false for all elements
    }

    @Test
    void testTakeWhileWithPredicateReturningTrueForAll() {
        List<String> list = new ArrayList<>();
        list.add("orange");
        list.add("mango");
        list.add("papaya");

        Predicate<String> predicate = s -> s.length() > 3;  // All strings have length > 3

        List<String> takenList = takeWhile(list, predicate);  // Using the takeWhile method directly

        assertEquals(new ArrayList<>(List.of("orange", "mango", "papaya")), takenList);  // Should return the whole list
    }

    @Test
    void testTakeWhileWithPredicateReturningTrueAndFalse() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");

        Predicate<String> predicate = s -> s.length() > 5;  // Select strings with length > 5

        List<String> takenList = takeWhile(list, predicate);  // Using the takeWhile method directly

        assertEquals(new ArrayList<>(List.of("banana", "cherry")), takenList);  // Should return the elements where the predicate is true at the start
    }
}


