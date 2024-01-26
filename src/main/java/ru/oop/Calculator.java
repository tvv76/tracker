package ru.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public double divide(int a) {
        return a / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double sumAllOperation(int b) {
        return sum(b) + multiply(b) + minus(b) + divide(b);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Static sum(10) = " + Calculator.sum(10));
        System.out.println("Static minus(10) = " + Calculator.minus(10));
        System.out.println("Non-static multiplay(10) = " + calc.multiply(10));
        System.out.println("Non-static divide(10) = " + calc.divide(10));
        System.out.println("Non-static sumAllOperation(10) = " + calc.sumAllOperation(10));
    }
}
