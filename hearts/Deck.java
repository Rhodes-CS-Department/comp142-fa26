package hearts;

import java.util.ArrayList;
import java.util.Random;

/**
 * A deck of playing cards. A new deck has all 52 cards, shuffled.
 */
public class Deck {
    private ArrayList<Card> cards;
    private Random random;

    public Deck() {
        cards = new ArrayList<Card>();
        random = new Random();
        shuffle();
    }

    /**
     * Puts all 52 cards back in the deck, in a random order.
     */
    public void shuffle() {
        cards.clear();
        for (Suit suit : Suit.values()) {
            for (int rank = 2; rank <= 14; rank++) {
                cards.add(new Card(rank, suit));
            }
        }

        for (int i = cards.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    /**
     * Removes the top card from the deck and returns it.
     */
    public Card draw() {
        return cards.remove(cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
