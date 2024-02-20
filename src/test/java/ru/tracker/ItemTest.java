package ru.tracker;


import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    void whenAscSorListOfItems() {
        Item item1 = new Item(1, "G");
        Item item2 = new Item(2, "A");
        Item item3 = new Item(3, "D");
        Item item4 = new Item(4, "A");

        List<Item> items = Arrays.asList(
                item1,
                item2,
                item3,
                item4
        );

        items.sort(new ItemAscByName());

        List<Item> expected = Arrays.asList(
                item2,
                item4,
                item3,
                item1
        );
        assertThat(items.get(0)).isEqualTo(expected.get(0));
        assertThat(items.get(1)).isEqualTo(expected.get(1));
        assertThat(items.get(2)).isEqualTo(expected.get(2));
        assertThat(items.get(3)).isEqualTo(expected.get(3));
    }

    @Test
    void whenDescSorListOfItems() {
        Item item1 = new Item(1, "G");
        Item item2 = new Item(2, "A");
        Item item3 = new Item(3, "D");
        Item item4 = new Item(4, "A");

        List<Item> items = Arrays.asList(
                item1,
                item2,
                item3,
                item4
        );

        items.sort(new ItemDescByName());

        List<Item> expected = Arrays.asList(
                item1,
                item3,
                item2,
                item4
        );
        assertThat(items.get(0)).isEqualTo(expected.get(0));
        assertThat(items.get(1)).isEqualTo(expected.get(1));
        assertThat(items.get(2)).isEqualTo(expected.get(2));
        assertThat(items.get(3)).isEqualTo(expected.get(3));
    }
}