package ru.tracker;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        item.setId(111);
        item.setName("Test item");
        System.out.println(item);
    }
}
