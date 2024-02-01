package ru.cast;

public class Transport {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[6];
        vehicles[0] = new Plane();
        vehicles[1] = new Bus();
        vehicles[2] = new Train();
        vehicles[3] = new Plane();
        vehicles[4] = new Bus();
        vehicles[5] = new Train();
        for (Vehicle vehicle : vehicles) {
            System.out.print(vehicle + ".move() ---> ");
            vehicle.move();
        }
    }
}
