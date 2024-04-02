package ru.stream;

import java.util.List;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
    List<String> result = products.stream()
            .filter(product -> product.getStandard() - product.getActual() >= 0
                    && product.getStandard() - product.getActual() <= 3)
            .map(product -> new Label(product.getName(), product.getPrice() / 2).toString())
            .toList();
    return result;
    }
}
