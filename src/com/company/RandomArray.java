package com.company;

public class RandomArray {
    public static Integer[] generate(int size, int maxValue) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * maxValue);
        }
        return arr;
    }
}
