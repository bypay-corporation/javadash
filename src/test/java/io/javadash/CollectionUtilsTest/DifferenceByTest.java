//package io.javadash.CollectionUtilsTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import io.javadash.CollectionUtils;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import org.junit.jupiter.api.Test;
//
//public class DifferenceByTest {
//
//    @Test
//    public void testDifferenceBy_withNonOverlappingElements() {
//        List<Double> array = Arrays.asList(2.1, 1.2);
//        List<Double> exclude = Arrays.asList(2.3, 3.4);
//
//        List<Double> result = CollectionUtils.differenceBy(array, Math::floor, exclude);
//
//        assertEquals(Arrays.asList(1.2), result);
//    }
//
//    @Test
//    public void testDifferenceBy_withMultipleExcludeLists() {
//        List<Double> array = Arrays.asList(2.1, 1.2, 3.3);
//        List<Double> exclude1 = Arrays.asList(2.3, 3.4);
//        List<Double> exclude2 = Arrays.asList(3.3, 1.5);
//
//        List<Double> result = CollectionUtils.differenceBy(array, Math::floor, exclude1, exclude2);
//
//        assertEquals(Arrays.asList(), result);
//    }
//
//    @Test
//    public void testDifferenceBy_withNullArray() {
//        List<Double> array = null;
//        List<Double> exclude = Arrays.asList(2.3, 3.4);
//
//        // Testing when the array is null (should return empty list)
//        List<Double> result = CollectionUtils.differenceBy(array, Math::floor, exclude);
//
//        assertEquals(Collections.emptyList(), result);
//    }
//
//    @Test
//    public void testDifferenceBy_withEmptyArray() {
//        List<Double> array = Collections.emptyList();
//        List<Double> exclude = Arrays.asList(2.3, 3.4);
//
//        // Testing when the array is empty (should return empty list)
//        List<Double> result = CollectionUtils.differenceBy(array, Math::floor, exclude);
//
//        assertEquals(Collections.emptyList(), result);
//    }
//
//    @Test
//    public void testDifferenceBy_withNullValuesInExclude() {
//        List<Double> array = Arrays.asList(2.1, 1.2, 3.3);
//        List<Double> exclude = Arrays.asList(2.3, null, 3.3);
//
//        // Testing when there are null values in the exclude list (should ignore nulls)
//        List<Double> result = CollectionUtils.differenceBy(array, Math::floor, exclude);
//
//        assertEquals(Arrays.asList(1.2), result);
//    }
//
//    @Test
//    public void testDifferenceBy_withNullInArray() {
//        List<Double> array = Arrays.asList(2.1, null, 3.3);
//        List<Double> exclude = Arrays.asList(3.3, 2.3);
//
//        // Testing when there are null values in the array (should ignore nulls)
//        List<Double> result = CollectionUtils.differenceBy(array, Math::floor, exclude);
//
//        assertEquals(Arrays.asList(), result);
//    }
//
//    @Test
//    public void testDifferenceBy_withMapList() {
//        List<Map<String, Integer>> array = Arrays.asList(
//            Map.of("x", 2),
//            Map.of("x", 1)
//        );
//        List<Map<String, Integer>> exclude = Arrays.asList(
//            Map.of("x", 1)
//        );
//
//        // Testing with list of maps, filtering based on a property 'x'
//        List<Map<String, Integer>> result = CollectionUtils.differenceBy(
//            array,
//            map -> map.get("x"),
//            exclude
//        );
//
//        assertEquals(Arrays.asList(Map.of("x", 2)), result);
//    }
//
//    @Test
//    public void testDifferenceBy_withNullIteratee() {
//        List<Double> array = Arrays.asList(2.1, 1.2, 3.3);
//        List<Double> exclude = Arrays.asList(2.3, 3.4);
//
//        // Testing with a null iteratee (should return the array as it is)
//        List<Double> result = CollectionUtils.differenceBy(array, null, exclude);
//
//        assertEquals(Arrays.asList(2.1, 1.2, 3.3), result);
//    }
//}
//
