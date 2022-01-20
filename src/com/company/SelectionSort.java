package com.company;

public class SelectionSort {
    public static void sort(Integer[] arr, boolean ascending) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (ascending) {
                int min = i;
                for (int j = min + 1; j < arr.length; j++) {
                    if (arr[j] < arr[min]) {
                        min = j;
                    }
                }
                swap(arr, i, min);
            } else {
                int max = i;
                for (int j = max + 1; j < arr.length; j++) {
                    if (arr[j] > arr[max]) {
                        max = j;
                    }
                }
                swap(arr, i, max);
            }
        }
    }

    public static <T> void swap(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = RandomArray.generate(100, 100);
        printIntArray(arr);
        sort(arr, true);
        printIntArray(arr);
        sort(arr, false);
        printIntArray(arr);

    }

    public static void printIntArray(Integer[] arr) {
        for (Integer arri:
                arr) {
            System.out.print(arri + " ");
        }
        System.out.println();
    }

}
