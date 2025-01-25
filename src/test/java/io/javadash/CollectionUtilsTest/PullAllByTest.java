//package io.javadash.CollectionUtilsTest;
//
//import static io.javadash.CollectionUtils.pullAllBy;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.jupiter.api.Test;
//
//public class PullAllByTest {
//
//    @Test
//    void testPullAllByWithValidListAndMatchingValues() {
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
//        List<String> result = pullAllBy(array, values, String::toLowerCase);
//
//        assertEquals(new ArrayList<>(List.of("apple", "date")), result);
//    }
//
//    @Test
//    void testPullAllByWithValidListAndNoMatchingValues() {
//        List<String> array = new ArrayList<>();
//        array.add("apple");
//        array.add("banana");
//        array.add("cherry");
//
//        List<String> values = new ArrayList<>();
//        values.add("orange");
//
//        List<String> result = pullAllBy(array, values, String::toLowerCase);
//
//        assertEquals(new ArrayList<>(List.of("apple", "banana", "cherry")), result);
//    }
//
//    @Test
//    void testPullAllByWithEmptyList() {
//        List<String> array = new ArrayList<>();
//
//        List<String> values = new ArrayList<>();
//        values.add("banana");
//
//        List<String> result = pullAllBy(array, values, String::toLowerCase);
//
//        assertEquals(new ArrayList<>(), result);
//    }
//
//    @Test
//    void testPullAllByWithNullList() {
//        List<String> array = null;
//
//        List<String> values = new ArrayList<>();
//        values.add("banana");
//
//        List<String> result = pullAllBy(array, values, String::toLowerCase);
//
//        assertNull(result);
//    }
//
//    @Test
//    void testPullAllByWithNullValues() {
//        List<String> array = new ArrayList<>();
//        array.add("apple");
//        array.add("banana");
//        array.add("cherry");
//
//        List<String> result = pullAllBy(array, null, String::toLowerCase);
//
//        assertEquals(new ArrayList<>(List.of("apple", "banana", "cherry")), result);
//    }
//
//    @Test
//    void testPullAllByWithMultipleMatchingValues() {
//        List<String> array = new ArrayList<>();
//        array.add("apple");
//        array.add("banana");
//        array.add("banana");
//        array.add("cherry");
//
//        List<String> values = new ArrayList<>();
//        values.add("banana");
//
//        List<String> result = pullAllBy(array, values, String::toLowerCase);
//
//        assertEquals(new ArrayList<>(List.of("apple", "cherry")), result);
//    }
//
//    @Test
//    void testPullAllByWithEmptyValuesList() {
//        List<String> array = new ArrayList<>();
//        array.add("apple");
//        array.add("banana");
//        array.add("cherry");
//
//        List<String> result = pullAllBy(array, new ArrayList<>(), String::toLowerCase);
//
//        assertEquals(new ArrayList<>(List.of("apple", "banana", "cherry")), result);
//    }
//}
//
