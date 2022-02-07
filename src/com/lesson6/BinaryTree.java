package com.lesson6;

public class BinaryTree {

    public static void main(String[] args) {
        int numBalanced = 0;
        int numTrees = 20;
        for (int i = 0; i < numTrees; i++) {
            Tree<Integer> tree = new TreeImpl<>();
            while (tree.height() < 5) {
                tree.add((int)(Math.random() * 50 - 25));
            }
            tree.display();
            System.out.println(tree.isBalanced());
            numBalanced = numBalanced + (tree.isBalanced() ? 1 : 0);
        }
        System.out.println("Percent of balanced = " + (double)numBalanced / (double) numTrees * 100.0);
    }

}
