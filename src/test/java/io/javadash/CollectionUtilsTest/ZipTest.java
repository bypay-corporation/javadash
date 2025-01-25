package io.javadash.CollectionUtilsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static io.javadash.CollectionUtils.*;  // Correct import for the collection utility methods
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ZipTest {

    @Test
    void testZipWithEqualLengthLists() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 6);

        // Zip operation between two lists with equal lengths
        List<List<Integer>> result = zip(list1, list2);

        // The result should group the elements at corresponding indices
        assertEquals(List.of(List.of(1, 4), List.of(2, 5), List.of(3, 6)), result);
    }

    @Test
    void testZipWithUnequalLengthLists() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5);

        // Zip operation between two lists with unequal lengths
        List<List<Integer>> result = zip(list1, list2);

        // The result should handle shorter lists by adding null for missing elements
        assertEquals(List.of(List.of(1, 4), List.of(2, 5), Arrays.asList(3, null)), result);
    }

    @Test
    void testZipWithEmptyLists() {
        List<Integer> list1 = List.of();
        List<Integer> list2 = List.of();

        // Zip operation between two empty lists
        List<List<Integer>> result = zip(list1, list2);

        // The result should be an empty list
        assertEquals(List.of(), result);
    }

    @Test
    void testZipWithNullAndEmptyLists() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of();

        // Zip operation where one list is empty
        List<List<Integer>> result = zip(list1, list2);

        // The result should handle the empty list and add null for each index
        assertEquals(List.of(Arrays.asList(1, null), Arrays.asList(2, null), Arrays.asList(3, null)), result);
    }

    @Test
    void testZipWithMultipleLists() {
        List<Integer> list1 = List.of(1, 2);
        List<Integer> list2 = List.of(3, 4);
        List<Integer> list3 = List.of(5, 6);

        // Zip operation with three lists of equal length
        List<List<Integer>> result = zip(list1, list2, list3);

        // The result should group the elements at corresponding indices
        assertEquals(List.of(List.of(1, 3, 5), List.of(2, 4, 6)), result);
    }

    @Test
    void testZipWithNullListInTheMiddle() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = null;
        List<Integer> list3 = List.of(4, 5, 6);

        // Zip operation with a null list in the middle
        List<List<Integer>> result = zip(list1, list2, list3);

        // The result should handle the null list by adding null for its elements
        assertEquals(List.of(Arrays.asList(1, null, 4), Arrays.asList(2, null, 5), Arrays.asList(3, null, 6)), result);
    }

    @Test
    void testZipWithNullAndEmpty() {
        List<Integer> list1 = List.of();
        List<Integer> list2 = null;

        // Zip operation with an empty list and a null list
        List<List<Integer>> result = zip(list1, list2);

        // The result should return an empty list
        assertEquals(List.of(), result);
    }
}






