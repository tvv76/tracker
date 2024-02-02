package ru.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key != null && key.equals(value[i])) {
                result = i;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element " + key + " is not found in array.");
        }
        /* цикл fori, поскольку нам надо найти индекс искомого элемента в массиве */
        return result;
    }

    public static void main(String[] args) {
        String[] value = {"Один", "Два", "Три", "Четыре"};
        try {
            indexOf(value, "Пять");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
