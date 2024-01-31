package ru.poly;

public class Bus implements Transport {

    @Override
    public void run() {
        System.out.println("Поехали!");
    }

    @Override
    public void passangers(int qty) {
        System.out.println("На борту " + qty + " пассажиров");
    }

    @Override
    public double fillFuel(int qty) {
        double price = 1.2;
        return qty * price;
    }
}
