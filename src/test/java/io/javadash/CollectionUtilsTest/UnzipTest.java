package io.javadash.CollectionUtilsTest;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static io.javadash.CollectionUtils.*;  // Correct import for the collection utility methods
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UnzipTest {

    @Test
    void testUnzip() {
        List<List<Integer>> grouped = new ArrayList<>();
        grouped.add(new ArrayList<>(List.of(1, 2, 3)));
        grouped.add(new ArrayList<>(List.of(4, 5, 6)));
        grouped.add(new ArrayList<>(List.of(7, 8, 9)));

        List<List<Integer>> result = unzip(grouped);

        // The result should be a transposed list of lists:
        // [
        //     [1, 4, 7],
        //     [2, 5, 8],
        //     [3, 6, 9]
        // ]
        assertEquals(new ArrayList<>(List.of(
            new ArrayList<>(List.of(1, 4, 7)),
            new ArrayList<>(List.of(2, 5, 8)),
            new ArrayList<>(List.of(3, 6, 9)))
        ), result);
    }

    @Test
    void testUnzipEmptyList() {
        List<List<Integer>> grouped = new ArrayList<>();

        List<List<Integer>> result = unzip(grouped);

        // The result should be an empty list
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    void testUnzipNullList() {
        List<List<Integer>> grouped = null;

        List<List<Integer>> result = unzip(grouped);

        // The result should be an empty list because the input is null
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    void testUnzipUnevenLists() {
        List<List<Integer>> grouped = new ArrayList<>();
        grouped.add(new ArrayList<>(List.of(1, 2)));
        grouped.add(new ArrayList<>(List.of(3, 4, 5)));
        grouped.add(new ArrayList<>(List.of(6)));

        List<List<Integer>> result = unzip(grouped);

        // The result should be a transposed list with nulls where elements are missing
        assertEquals(new ArrayList<>(List.of(
            new ArrayList<>(List.of(1, 3, 6)),
            new ArrayList<>(Arrays.asList(2, 4, null)),
            new ArrayList<>(Arrays.asList(null, 5, null)))
        ), result);
    }

    @Test
    void testUnzipWithNullSublist() {
        List<List<Integer>> grouped = new ArrayList<>();
        grouped.add(new ArrayList<>(List.of(1, 2, 3)));
        grouped.add(null);  // One of the sublists is null

        List<List<Integer>> result = unzip(grouped);

        // The result should be a transposed list with null values for the null sublist
        assertEquals(new ArrayList<>(List.of(
            new ArrayList<>(Arrays.asList(1, null)),
            new ArrayList<>(Arrays.asList(2, null)),
            new ArrayList<>(Arrays.asList(3, null)))
        ), result);
    }
}




