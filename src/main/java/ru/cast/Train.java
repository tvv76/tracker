package ru.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Едем и стучим колесами по рельсам");
    }
}
