package ru.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Java for dummies", 240);
        books[1] = new Book("Clean code", 512);
        books[2] = new Book("Война и мир", 780);
        books[3] = new Book("Тихий Дон", 684);
        for (int i = 0; i < books.length; i++) {
            System.out.println(String.format("В книге: %s %d страниц", books[i].getName(), books[i].getPages()));
        }

        Book mem = books[0];
        books[0] = books[3];
        books[3] = mem;

        System.out.println();
        for (int i = 0; i < books.length; i++) {
            System.out.println(String.format("В книге: %s %d страниц", books[i].getName(), books[i].getPages()));
        }

        System.out.println();
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println(String.format("Рекомендуемая книга: %s, в ней всего %d страниц",
                        books[i].getName(), books[i].getPages()));
            }
        }
    }
}
