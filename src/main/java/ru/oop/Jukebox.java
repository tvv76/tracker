package ru.oop;

public class Jukebox {
    public void music(int position) {
        switch (position) {
            case 1:
                System.out.println("Пусть бегут неуклюже");
                System.out.println("Пешеходы по лужам...");
                break;
            case 2:
                System.out.println("Спят усталые игрушки, книжки спят.");
                System.out.println("Одеяла и подушки ждут ребят....");
                break;
            default:
                System.out.println("Песня не найдена");
                break;
        }
    }
}
