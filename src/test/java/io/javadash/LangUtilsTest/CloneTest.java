//package io.javadash.LangUtilsTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotSame;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertSame;
//
//import io.javadash.LangUtils;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import org.junit.jupiter.api.Test;
//
//class CloneTest {
//
//    @Test
//    void testCloneWithList() {
//        List<String> original = new ArrayList<>();
//        original.add("A");
//        original.add("B");
//        original.add("C");
//
//        List<String> cloned = LangUtils.clone(original);
//
//        // Assert that the cloned list is not the same object as the original
//        assertNotSame(original, cloned, "Cloning should create a new object.");
//
//        // Assert that the cloned list contains the same elements as the original
//        assertEquals(original, cloned, "Cloned list should have the same elements.");
//    }
//
//    @Test
//    void testCloneWithMap() {
//        Map<String, Integer> original = new HashMap<>();
//        original.put("One", 1);
//        original.put("Two", 2);
//
//        Map<String, Integer> cloned = LangUtils.clone(original);
//
//        // Assert that the cloned map is not the same object as the original
//        assertNotSame(original, cloned, "Cloning should create a new object.");
//
//        // Assert that the cloned map contains the same key-value pairs
//        assertEquals(original, cloned, "Cloned map should have the same key-value pairs.");
//    }
//
//    @Test
//    void testCloneWithSet() {
//        Set<String> original = new HashSet<>();
//        original.add("A");
//        original.add("B");
//
//        Set<String> cloned = LangUtils.clone(original);
//
//        // Assert that the cloned set is not the same object as the original
//        assertNotSame(original, cloned, "Cloning should create a new object.");
//
//        // Assert that the cloned set contains the same elements
//        assertEquals(original, cloned, "Cloned set should have the same elements.");
//    }
//
//    @Test
//    void testCloneWithImmutableType() {
//        String originalString = "Hello";
//        String clonedString = LangUtils.clone(originalString);
//
//        // Assert that the cloned string is the same as the original
//        assertSame(originalString, clonedString, "Cloning should return the same string for immutable types.");
//    }
//
//    @Test
//    void testCloneWithInteger() {
//        Integer originalInteger = 42;
//        Integer clonedInteger = LangUtils.clone(originalInteger);
//
//        // Assert that the cloned integer is the same as the original
//        assertSame(originalInteger, clonedInteger, "Cloning should return the same integer for immutable types.");
//    }
//
//    @Test
//    void testCloneWithNull() {
//        Object original = null;
//        Object cloned = LangUtils.clone(original);
//
//        // Assert that cloning a null value returns null
//        assertNull(cloned, "Cloning null should return null.");
//    }
//}
//
