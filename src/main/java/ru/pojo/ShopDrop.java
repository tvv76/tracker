package ru.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
            if (products[i + 1] == null) break;
            products[i + 1] = null;
        }
        return products;
    }
}
