package ru.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length; i++) {
            products[i] = i < products.length-1 ? products[i + 1] : null;
            if (products[i] == null) break;
        }
        return products;
    }
}