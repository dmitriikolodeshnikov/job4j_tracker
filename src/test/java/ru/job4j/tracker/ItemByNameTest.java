package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ItemByNameTest {
    @Test
    public void ascByName() {
        List<Item> items = Arrays.asList(
                new Item("test"),
                new Item("next"),
                new Item("after")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("after"),
                new Item("next"),
                new Item("test")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void descByName() {
        List<Item> items = Arrays.asList(
                new Item("test"),
                new Item("next"),
                new Item("after")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("test"),
                new Item("next"),
                new Item("after")
        );
        assertThat(items).isEqualTo(expected);
    }

}