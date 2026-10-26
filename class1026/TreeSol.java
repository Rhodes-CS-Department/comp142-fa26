package class1026;

import java.util.ArrayList;

public class TreeSol {
    
    private int value;
    private TreeSol left;
    private TreeSol right;

    public TreeSol(int value, TreeSol left, TreeSol right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeSol(int value) {
        this.value = value;
    }

    // Get the number of levels in the tree.
    public int levels() {
        int l, r;
        if (left == null) {
            l = 0;
        } else {
            l = left.levels();
        }

        if (right == null) {
            r = 0;
        } else {
            r = right.levels();
        }

        return 1 + Math.max(l, r);
    }

    public void reverse() {
        if (left != null) {
            left.reverse();
        }

        if (right != null) {
            right.reverse();
        }

        TreeSol temp = left;
        left = right;
        right = temp;
    }

    public int size() {
        int l, r;
        if (left == null) {
            l = 0;
        } else {
            l = left.size();
        }

        if (right == null) {
            r = 0;
        } else {
            r = right.size();
        }

        return 1 + l + r;
    }

    public int sum() {
        int l, r;
        if (left == null) {
            l = 0;
        } else {
            l = left.sum();
        }

        if (right == null) {
            r = 0;
        } else {
            r = right.sum();
        }

        return value + l + r;
    }

    public int max() {
        int l, r;
        if (left == null) {
            l = Integer.MIN_VALUE;
        } else {
            l = left.max();
        }

        if (right == null) {
            r = Integer.MIN_VALUE;
        } else {
            r = right.max();
        }

        return Math.max(value, Math.max(l, r));
    }

    public ArrayList<Integer> toList() {
        ArrayList<Integer> result = new ArrayList<>();

        if (left != null) {
            result.addAll(left.toList());
        }

        result.add(value);

        if (right != null) {
            result.addAll(right.toList());
        }

        return result;
    }

    public static TreeSol complete(int n) {
        if (n == 0) {
            return null;
        } else {
            return new TreeSol(0, complete(n - 1), complete(n - 1));
        }
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
        TreeSol t =
            new TreeSol(1,
                new TreeSol(4,
                    new TreeSol(3),
                    new TreeSol(13)),
                new TreeSol(2));
        System.out.println(t);
    }

}
