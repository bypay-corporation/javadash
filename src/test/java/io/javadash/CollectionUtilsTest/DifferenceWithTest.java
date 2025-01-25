//package io.javadash.CollectionUtilsTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import io.javadash.CollectionUtils;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.junit.jupiter.api.Test;
//
//public class DifferenceWithTest {
//    @Test
//    void differenceWithTestBasic() {
//        // Test 1: Basic case with numbers
//        List<Integer> array1 = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> exclude1 = Arrays.asList(2, 4);
//        List<Integer> exclude2 = Arrays.asList(3);
//
//        List<Integer> result1 = CollectionUtils.differenceWith(array1, (a, b) -> a.equals(b), exclude1, exclude2);
//
//        List<Integer> expected1 = Arrays.asList(1, 5);
//        assertEquals(expected1, result1, "Test 1: The difference with exclusions should return [1, 5]");
//    }
//
//    @Test
//    void differenceWithTestObjects() {
//        // Test 2: Case with objects (maps in this case)
//        List<Map<String, Integer>> objects = new ArrayList<>();
//        Map<String, Integer> obj1 = new HashMap<>();
//        obj1.put("x", 1);
//        obj1.put("y", 2);
//        Map<String, Integer> obj2 = new HashMap<>();
//        obj2.put("x", 2);
//        obj2.put("y", 1);
//        objects.add(obj1);
//        objects.add(obj2);
//
//        List<Map<String, Integer>> values1 = new ArrayList<>();
//        Map<String, Integer> objToExclude1 = new HashMap<>();
//        objToExclude1.put("x", 1);
//        objToExclude1.put("y", 2);
//        values1.add(objToExclude1);
//
//        List<Map<String, Integer>> values2 = new ArrayList<>();
//        Map<String, Integer> objToExclude2 = new HashMap<>();
//        objToExclude2.put("x", 2);
//        objToExclude2.put("y", 1);
//        values2.add(objToExclude2);
//
//        // Use a custom comparator (BiPredicate) to compare map equality
//        List<Map<String, Integer>> result2 =
//            CollectionUtils.differenceWith(objects, (a, b) -> a.equals(b), values1, values2);
//
//        List<Map<String, Integer>> expected2 = new ArrayList<>();
//        assertEquals(expected2, result2, "Test 2: No objects should be left after exclusion.");
//    }
//
//    @Test
//    void differenceWithTestNoExclusions() {
//        // Test 3: Edge case with no exclusions
//        List<Integer> array2 = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> result3 = CollectionUtils.differenceWith(array2, (a, b) -> a.equals(b));
//
//        List<Integer> expected3 = Arrays.asList(1, 2, 3, 4, 5);
//        assertEquals(expected3, result3, "Test 3: No exclusions should return the original list.");
//    }
//
//    @Test
//    void differenceWithTestInvalidValue() {
//        // Test 3: Edge case with no exclusions
//        List<Integer> array2 = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> result3 = CollectionUtils.differenceWith(array2, (a, b) -> a.equals(b), List.of(), null);
//
//        List<Integer> expected3 = Arrays.asList(1, 2, 3, 4, 5);
//        assertEquals(expected3, result3, "Test 3: No exclusions should return the original list.");
//    }
//
//    @Test
//    void differenceWithTestNullValue() {
//        // Test 3: Edge case with no exclusions
//        List<Integer> array2 = Arrays.asList(1, 2, 3, null, 5);
//        List<Integer> result3 =
//            CollectionUtils.differenceWith(array2, (a, b) -> a.equals(b), null, Arrays.asList(5, null, null), null);
//
//        List<Integer> expected3 = Arrays.asList(1, 2, 3);
//        assertEquals(expected3, result3, "Test 3: No exclusions should return the [1, 2, 3] list.");
//    }
//
//    @Test
//    void differenceWithTestNullComparatorValue() {
//        // Test 3: Edge case with no exclusions
//        List<Integer> array2 = Arrays.asList(1, 2, 3, null, 5);
//        List<Integer> result3 =
//            CollectionUtils.differenceWith(array2, null, null, Arrays.asList(5, null, null), null);
//
//        List<Integer> expected3 = Arrays.asList(1, 2, 3, null, 5);
//        assertEquals(expected3, result3, "Test 3: No exclusions should return the [1, 2, 3] list.");
//    }
//}
