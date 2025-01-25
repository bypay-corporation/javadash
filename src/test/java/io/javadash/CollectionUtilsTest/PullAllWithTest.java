//package io.javadash.CollectionUtilsTest;
//
//import static io.javadash.CollectionUtils.pullAllWith;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.BiPredicate;
//import org.junit.jupiter.api.Test;
//
//public class PullAllWithTest {
//
//    @Test
//    void testPullAllWithWithValidListAndMatchingValues() {
//        List<String> array = new ArrayList<>();
//        array.add("apple");
//        array.add("banana");
//        array.add("cherry");
//        array.add("date");
//
//        List<String> values = new ArrayList<>();
//        values.add("banana");
//        values.add("cherry");
//
//        // Comparator checks if elements are equal
//        BiPredicate<String, String> comparator = String::equals;
//
//        List<String> result = pullAllWith(array, values, comparator);
//
//        assertEquals(new ArrayList<>(List.of("apple", "date")), result);
//    }
//
//    @Test
//    void testPullAllWithWithValidListAndNoMatchingValues() {
//        List<String> array = new ArrayList<>();
//        array.add("apple");
//        array.add("banana");
//        array.add("cherry");
//
//        List<String> values = new ArrayList<>();
//        values.add("orange");
//
//        // Comparator checks if elements are equal
//        BiPredicate<String, String> comparator = String::equals;
//
//        List<String> result = pullAllWith(array, values, comparator);
//
//        assertEquals(new ArrayList<>(List.of("apple", "banana", "cherry")), result);
//    }
//
//    @Test
//    void testPullAllWithWithEmptyList() {
//        List<String> array = new ArrayList<>();
//
//        List<String> values = new ArrayList<>();
//        values.add("banana");
//
//        // Comparator checks if elements are equal
//        BiPredicate<String, String> comparator = String::equals;
//
//        List<String> result = pullAllWith(array, values, comparator);
//
//        assertEquals(new ArrayList<>(), result);
//    }
//
//    @Test
//    void testPullAllWithWithNullList() {
//        List<String> array = null;
//
//        List<String> values = new ArrayList<>();
//        values.add("banana");
//
//        // Comparator checks if elements are equal
//        BiPredicate<String, String> comparator = String::equals;
//
//        List<String> result = pullAllWith(array, values, comparator);
//
//        assertNull(result);
//    }
//
//    @Test
//    void testPullAllWithWithNullValues() {
//        List<String> array = new ArrayList<>();
//        array.add("apple");
//        array.add("banana");
//        array.add("cherry");
//
//        // Comparator checks if elements are equal
//        BiPredicate<String, String> comparator = String::equals;
//
//        List<String> result = pullAllWith(array, null, comparator);
//
//        assertEquals(new ArrayList<>(List.of("apple", "banana", "cherry")), result);
//    }
//
//    @Test
//    void testPullAllWithWithMultipleMatchingValues() {
//        List<String> array = new ArrayList<>();
//        array.add("apple");
//        array.add("banana");
//        array.add("banana");
//        array.add("cherry");
//
//        List<String> values = new ArrayList<>();
//        values.add("banana");
//
//        // Comparator checks if elements are equal
//        BiPredicate<String, String> comparator = String::equals;
//
//        List<String> result = pullAllWith(array, values, comparator);
//
//        assertEquals(new ArrayList<>(List.of("apple", "cherry")), result);
//    }
//
//    @Test
//    void testPullAllWithWithCustomComparator() {
//        List<String> array = new ArrayList<>();
//        array.add("apple");
//        array.add("banana");
//        array.add("cherry");
//
//        List<String> values = new ArrayList<>();
//        values.add("banana");
//        values.add("date");
//
//        // Custom comparator: Ignore case for string comparison
//        BiPredicate<String, String> comparator = (s1, s2) -> s1.equalsIgnoreCase(s2);
//
//        List<String> result = pullAllWith(array, values, comparator);
//
//        assertEquals(new ArrayList<>(List.of("apple", "cherry")), result);
//    }
//}
//
