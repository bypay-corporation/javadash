package io.javadash.CollectionUtilsTest;

import static io.javadash.CollectionUtils.fromPairs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class FromPairsTest {

    @Test
    void testFromPairsNormalInput() {
        // Given
        List<List<Object>> pairs = Arrays.asList(
            Arrays.asList("a", 1),
            Arrays.asList("b", 2)
        );

        // When
        Map<String, Object> result = fromPairs(pairs);

        // Then
        assertEquals(2, result.size());
        assertEquals(1, result.get("a"));
        assertEquals(2, result.get("b"));
    }

    @Test
    void testFromPairsEmptyInput() {
        // Given
        List<List<Object>> pairs = Arrays.asList();

        // When
        Map<String, Object> result = fromPairs(pairs);

        // Then
        assertTrue(result.isEmpty());
    }

    @Test
    void testFromPairsNullInput() {
        // Given
        List<List<Object>> pairs = null;

        // When
        Map<String, Object> result = fromPairs(pairs);

        // Then
        assertTrue(result.isEmpty());
    }

    @Test
    void testFromPairsInvalidPairSize() {
        // Given
        List<List<Object>> pairs = Arrays.asList(
            Arrays.asList("a", 1),
            Arrays.asList("b")
        );

        // When
        Map<String, Object> result = fromPairs(pairs);

        // Then
        assertEquals(2, result.size());
        assertEquals(1, result.get("a"));
        assertEquals(null, result.get("b"));
    }
}
