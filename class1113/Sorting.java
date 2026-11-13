package class1113;

import java.util.ArrayList;

public class Sorting {

    public static boolean isSorted(ArrayList<String> list) {
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        words.add("pie");
        words.add("ham");
        words.add("yam");
        words.add("corn");
        words.add("gravy");
        words.add("beans");
        words.add("rolls");

        System.out.println(isSorted(words));
        sortStrings(words);
        System.out.println(isSorted(words));

        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(11, Suit.CLUBS));
        hand.add(new Card(4, Suit.DIAMONDS));
        hand.add(new Card(6, Suit.HEARTS));
        hand.add(new Card(3, Suit.SPADES));
        hand.add(new Card(14, Suit.DIAMONDS));
        hand.add(new Card(12, Suit.CLUBS));
        hand.add(new Card(10, Suit.HEARTS));

        System.out.println(hand);
        sortCards(hand);
        System.out.println(hand);
    }

    public static void swap(ArrayList<String> list, int i, int j) {
    }

    public static void sortStrings(ArrayList<String> list) {
    }

    public static void sortCards(ArrayList<Card> list) {
    }

    // Challenge, if you have extra time: sort the list using insertion sort.
    // https://www.youtube.com/watch?v=Q1JdRUh1_98
    public static void insertionSort(ArrayList<String> list) {
    }
}
