package class1012;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    public static void main(String[] args) {
        // trace1();
        // trace2();
        // testLongest();
        // testSecondLast();
        // testSum();
        // testRange();
        // testRemoveAll();
    }

    public static void trace1() {
        ArrayList<String> a = new ArrayList<String>();
        a.add("hello");
        a.add("world");
        a.add(1, "there");
        String s = a.get(2);
        String old = a.set(0, "goodbye");
        a.add(s);
        String r = a.remove(1);
        System.out.println(old + " " + r + " " + a.size());
        System.out.println(a.indexOf("world"));
        System.out.println(a.contains("there"));
        a.remove("world");
        System.out.println(a);
    }

    public static void trace2() {
        ArrayList<Integer> b = new ArrayList<Integer>();
        System.out.println(b.isEmpty());
        b.add(4);
        b.add(7);
        b.add(1);
        System.out.println(b.size());
        b.set(1, 2);
        System.out.println(b.get(1));
        b.add(0, 3);
        System.out.println(b.indexOf(2));
        b.remove(1);
        System.out.println(b);
    }

    // Returns the longest word in words; if there's a tie, the first one.
    public static String longest(ArrayList<String> words) {
        return null;
    }

    // Returns the second-to-last element of list, which has at least two elements.
    public static String secondLast(ArrayList<String> list) {
        return null;
    }

    // Returns the sum of the numbers in nums.
    public static int sum(ArrayList<Integer> nums) {
        return 0;
    }

    // Returns a list of the numbers from a up to, but not including, b.
    public static ArrayList<Integer> range(int a, int b) {
        return null;
    }

    // Removes every occurrence of value from list.
    public static void removeAll(ArrayList<String> list, String value) {
        
    }

    public static void testLongest() {
        ArrayList<String> words = new ArrayList<String>(List.of("fig", "banana", "kiwi", "cherry"));
        System.out.println(longest(words) + " (expected banana)");
        words = new ArrayList<String>(List.of("a", "bb", "ccc"));
        System.out.println(longest(words) + " (expected ccc)");
    }

    public static void testSecondLast() {
        ArrayList<String> list = new ArrayList<String>(List.of("x", "y", "z"));
        System.out.println(secondLast(list) + " (expected y)");
        list = new ArrayList<String>(List.of("first", "second"));
        System.out.println(secondLast(list) + " (expected first)");
    }

    public static void testSum() {
        ArrayList<Integer> nums = new ArrayList<Integer>(List.of(3, 1, 4, 1, 5));
        System.out.println(sum(nums) + " (expected 14)");
        nums = new ArrayList<Integer>();
        System.out.println(sum(nums) + " (expected 0)");
    }

    public static void testRange() {
        System.out.println(range(2, 6) + " (expected [2, 3, 4, 5])");
        System.out.println(range(0, 1) + " (expected [0])");
        System.out.println(range(5, 5) + " (expected [])");
    }

    public static void testRemoveAll() {
        ArrayList<String> list = new ArrayList<String>(List.of("a", "b", "a", "c"));
        removeAll(list, "a");
        System.out.println(list + " (expected [b, c])");
        list = new ArrayList<String>(List.of("x", "x", "y", "x", "x"));
        removeAll(list, "x");
        System.out.println(list + " (expected [y])");
    }
}
