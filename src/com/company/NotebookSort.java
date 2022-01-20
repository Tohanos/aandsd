package com.company;

import java.util.Arrays;

public class NotebookSort {

    public static void main(String[] args) {
        Notebook[] notebooks = new Notebook[100];
        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i] = Notebook.generateRandom();
        }

        System.out.println(Arrays.deepToString(notebooks));

        sort(notebooks);

        System.out.println(Arrays.deepToString(notebooks));

    }

    public static void sort(Notebook[] notebooks) {
        for (int i = 0; i < notebooks.length - 1; i++) {
            boolean isSorted = false;
            while(!isSorted) {
                isSorted = true;
                for (int j = 0; j < notebooks.length-1; j++) {
                    if(notebooks[j].getPrice() > notebooks[j + 1].getPrice()) {
                        isSorted = false;

                        SelectionSort.swap(notebooks, j, j + 1);
                    }
                    if (notebooks[j].getPrice() == notebooks[j + 1].getPrice()) {
                        if (notebooks[j].getRam() > notebooks[j + 1].getRam()) {
                            isSorted = false;

                            SelectionSort.swap(notebooks, j, j + 1);
                        }

                        if (notebooks[j].getRam() == notebooks[j + 1].getRam()) {
                            if (notebooks[j].getName().ordinal() > notebooks[j + 1].getName().ordinal()) {
                                isSorted = false;

                                SelectionSort.swap(notebooks, j, j + 1);
                            }
                        }
                    }
                }
            }

        }
    }

}
