//package io.javadash.CollectionUtilsTest;
//
//import static io.javadash.CollectionUtils.last;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//import java.util.List;
//import org.junit.jupiter.api.Test;
//
//public class LastTest {
//
//    @Test
//    void testLastWithNonEmptyList() {
//        List<String> array = List.of("apple", "banana", "cherry");
//
//        String result = last(array);
//
//        assertEquals("cherry", result);
//    }
//
//    @Test
//    void testLastWithSingleElementList() {
//        List<Integer> array = List.of(42);
//
//        Integer result = last(array);
//
//        assertEquals(42, result);
//    }
//
//    @Test
//    void testLastWithEmptyList() {
//        List<String> array = List.of();
//
//        String result = last(array);
//
//        assertNull(result);
//    }
//
//    @Test
//    void testLastWithNullList() {
//        List<Integer> array = null;
//
//        Integer result = last(array);
//
//        assertNull(result);
//    }
//}
//
