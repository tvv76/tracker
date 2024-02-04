package ru.ex;

public class FactorialRecursion {
    public static int calc(int n) {
        if (n > 2) {
            return calc(n - 1) * n;
        } else if (n == 0) {
            return 1;
        }
        return n;
    }

    public static void main(String[] args) {
        int result = calc(3);
        System.out.println(result);
    }
}
