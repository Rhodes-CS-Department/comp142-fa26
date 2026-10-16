package class1016;

import java.util.ArrayList;
import java.util.Scanner;

public class Words {

    public static void main(String[] args) {
        testWarmup();

        // testReversedSmall();
        // testReversedBackwardsSmall();

        // testReversed();
        // testReversedBackwards();
        // testRemoveContaining();
        // testLastOfEachLetter();
        // testNoDuplicates();
    }

    // Together: a reversed copy of list, using a for-each loop.
    public static ArrayList<String> reversed(ArrayList<String> list) {
        return null;
    }

    // Together: a reversed copy of list, looping backwards.
    public static ArrayList<String> reversedBackwards(ArrayList<String> list) {
        return null;
    }

    // 1. Removes every word containing letter from words.
    // How long does it take? Can you make it faster?
    public static void removeContaining(ArrayList<String> words, String letter) {
    }

    // 2. The last word starting with each letter: "azymous", "bz", ..., "zyzzyvas".
    public static ArrayList<String> lastOfEachLetter(ArrayList<String> words) {
        return null;
    }

    // 3. Returns a new list with each element of list, but only once.
    // What happens to the time when the list doubles?
    public static ArrayList<String> noDuplicates(ArrayList<String> list) {
        return null;
    }

    public static ArrayList<String> smallList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        return list;
    }

    public static ArrayList<String> readWords() {
        Scanner scan = new Scanner("words.txt");
        ArrayList<String> words = new ArrayList<String>();
        while (scan.hasNextLine()) {
            words.add(scan.nextLine());
        }

        scan.close();
        return words;
    }

    public static void testWarmup() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(list.size() - 1 - i));
        }
        System.out.println(list);
    }

    public static void testReversedSmall() {
        System.out.println(reversed(smallList()));
    }

    public static void testReversedBackwardsSmall() {
        System.out.println(reversedBackwards(smallList()));
    }

    public static void testReversed() {
        ArrayList<String> words = readWords();
        long start = System.currentTimeMillis();
        reversed(words);
        System.out.println("reversed: " + (System.currentTimeMillis() - start) + " ms");
    }

    public static void testReversedBackwards() {
        ArrayList<String> words = readWords();
        long start = System.currentTimeMillis();
        reversedBackwards(words);
        System.out.println("reversedBackwards: " + (System.currentTimeMillis() - start) + " ms");
    }

    public static void testRemoveContaining() {
        ArrayList<String> words = readWords();
        long start = System.currentTimeMillis();
        removeContaining(words, "e");
        System.out.println("removeContaining: " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(words.size() + " words left");
    }

    public static void testLastOfEachLetter() {
        System.out.println(lastOfEachLetter(readWords()));
    }

    public static void testNoDuplicates() {
        ArrayList<String> words = readWords();
        for (int n = 10000; n <= 80000; n *= 2) {
            ArrayList<String> firstN = new ArrayList<String>(words.subList(0, n));
            long start = System.currentTimeMillis();
            noDuplicates(firstN);
            System.out.println("noDuplicates of " + n + " words: " + (System.currentTimeMillis() - start) + " ms");
        }
    }
}
