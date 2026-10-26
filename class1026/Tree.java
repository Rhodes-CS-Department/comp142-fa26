package class1026;

import java.util.ArrayList;

public class Tree {
    
    private int value;
    private Tree left;
    private Tree right;

    // construct a new Tree with left/right branches.
    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    // construct a new Tree which is just a leaf.
    public Tree(int value) {
        this.value = value;
    }

    // Get the number of levels in the tree.
    public int levels() {
        return 0;
    }

    // Swap the left & right branches at each node.
    public void reverse() {
        
    }

    // Get the number of nodes in the tree.
    public int size() {
        return 0;
    }

    // Compute the sum of the values in the tree.
    public int sum() {
        return 0;
    }

    // Get the largest value in the tree.
    public int max() {
        return 0;
    }

    // Convert the given tree to a list (left, then value, then right).
    public ArrayList<Integer> toList() {
        return null;
    }

    // Construct a complete tree with n levels.
    // - "complete" means that all leaves are at the bottom level.
    // - use 0 for all of the values.
    public static Tree complete(int n) {
        return null;
    }

    public String toString() {
        String l, r;
        if (left == null) {
            l = "";
        } else {
            l = "(" + left + ") / ";
        }

        if (right == null) {
            r = "";
        } else {
            r = " \\ (" + right + ")";
        }

        return l + value + r;
    }

    public static void main(String[] args) {
        Tree t =
            new Tree(1,
                new Tree(4,
                    new Tree(3),
                    new Tree(13)),
                new Tree(2));
        System.out.println(t);
    }

}
