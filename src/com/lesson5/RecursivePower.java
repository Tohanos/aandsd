package com.lesson5;

public class RecursivePower {
    public static double recursivePower(double base, int power) {
        if (power == 0) return 1;
        return base * recursivePower(base, power - 1);
    }

    public static void main(String[] args) {
        System.out.println(recursivePower(4, 4));

    }
}
