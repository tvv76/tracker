package ru.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        /* делаем приведение к типу родителя Student. */
        Student studen = freshman;
        /* делаем приведение к типу родителя Object. */
        Object odj = studen;
    }
}
