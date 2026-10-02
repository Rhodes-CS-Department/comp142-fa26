package class1002;

import java.awt.Color;
import java.util.ArrayList;

public class Practice {
    // return a copy of `s` with the spaces removed.
    public static String removeSpaces(String s) {
        return "";
    }

    public static void testArrayLists() {
        ArrayList<Color> colors = new ArrayList<Color>();
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(0, Color.GREEN);
        System.out.println(colors);
        System.out.println(colors.get(1));
        System.out.println(colors.contains(Color.RED));
        System.out.println();

        colors.remove(1);
        System.out.println(colors);
        System.out.println(colors.get(1));
        System.out.println(colors.size());
        System.out.println();

        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }
    }

    public static void main(String[] args) {
        testArrayLists();
    }

    // increment each element of lst, in place.
    public static void incrementAll(ArrayList<Integer> lst) {

    }

    // return the first even number in lst, or -1 if none.
    public static int firstEven(ArrayList<Integer> lst) {
        return -1;
    }

    // return a new ArrayList containing just the positive elements of lst.
    public static ArrayList<Integer> filterPositive(ArrayList<Integer> lst) {
        return null;
    }
}
