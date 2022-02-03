package com.lesson5;

public class Knapsack {
    public static int knapsackRecursive(int[] weights, int[] values, int n, int maxWeight) {
        if (n <= 0) {
            return 0;
        } else if (weights[n - 1] > maxWeight) {
            return knapsackRecursive(weights, values, n - 1, maxWeight);
        } else {
            return Math.max(knapsackRecursive(weights, values, n - 1, maxWeight), values[n - 1]
                    + knapsackRecursive(weights, values, n - 1, maxWeight - weights[n - 1]));
        }
    }

    public static int knapsackNonRecursive(int[] weights, int[] values, int n, int maxWeight) {
        if (n <= 0 || maxWeight <= 0) {
            return 0;
        }

        int[][] solutionMatrix = new int[n + 1][maxWeight + 1];
        for (int j = 0; j <= maxWeight; j++) {
            solutionMatrix[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (weights[i - 1] > j) {
                    solutionMatrix[i][j] = solutionMatrix[i - 1][j];
                } else {
                    solutionMatrix[i][j] = Math.max(
                            solutionMatrix[i - 1][j],
                            solutionMatrix[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }

        for (int[] vals:
             solutionMatrix) {
            for (int val:
                 vals) {
                System.out.printf("%2d ", val);
            }
            System.out.println();
        }
        return solutionMatrix[n][maxWeight];
    }

    public static void main(String[] args) {
        int[] w = {12, 25, 22, 6, 1, 18, 9};
        int[] v = {1, 2, 3, 4, 6, 8, 10};
        int n = w.length;
        int maxW = 50;
        System.out.println(knapsackRecursive(w, v, n, maxW));
        System.out.println(knapsackNonRecursive(w, v, n, maxW));


    }

}
