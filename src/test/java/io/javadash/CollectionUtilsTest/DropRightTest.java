package io.javadash.CollectionUtilsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.javadash.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DropRightTest {

    @Test
    public void testDropRight_OneElementDropped() {
        List<Integer> input = List.of(1, 2, 3);
        List<Integer> result = CollectionUtils.dropRight(input, 1);
        assertEquals(List.of(1, 2), result, "The last element should be dropped");
    }

    @Test
    public void testDropRight_TwoElementsDropped() {
        List<Integer> input = List.of(1, 2, 3);
        List<Integer> result = CollectionUtils.dropRight(input, 2);
        assertEquals(List.of(1), result, "Two elements should be dropped");
    }

    @Test
    public void testDropRight_MoreThanListSize() {
        List<Integer> input = List.of(1, 2, 3);
        List<Integer> result = CollectionUtils.dropRight(input, 5);
        assertEquals(List.of(), result, "When n > list size, it should return an empty list");
    }

    @Test
    public void testDropRight_ZeroElementsDropped() {
        List<Integer> input = List.of(1, 2, 3);
        List<Integer> result = CollectionUtils.dropRight(input, 0);
        assertEquals(List.of(1, 2, 3), result, "When n is 0, the list should remain unchanged");
    }

    @Test
    public void testDropRight_EmptyList() {
        List<Integer> emptyList = List.of();
        List<Integer> result = CollectionUtils.dropRight(emptyList, 1);
        assertEquals(List.of(), result, "Dropping elements from an empty list should return an empty list");
    }

    @Test
    public void testDropRight_SingleElementList() {
        List<Integer> singleElementList = List.of(5);
        List<Integer> result = CollectionUtils.dropRight(singleElementList, 1);
        assertEquals(List.of(), result, "Dropping the only element in a list should return an empty list");
    }

    @Test
    public void testDropRight_ListWithNullValues() {
        List<Integer> listWithNull = new ArrayList<>();
        listWithNull.add(1);
        listWithNull.add(null);
        listWithNull.add(3);

        List<Integer> expect = new ArrayList<>();
        expect.add(1);
        expect.add(null);

        List<Integer> result = CollectionUtils.dropRight(listWithNull, 1);

        assertEquals(expect, result, "Dropping the last element should remove it, even if it's null");
    }
}

