package class1113;

/**
 * A playing card. Ranks run from 2 to 14:
 * - 11 is a jack
 * - 12 is a queen
 * - 13 is a king,
 * - 14 is an ace.
 */
public class Card {
    private int rank;
    private Suit suit;

    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    /**
     * Two cards are equal if they have the same rank and suit.
     */
    public boolean equals(Object other) {
        if (!(other instanceof Card)) {
            return false;
        }

        Card c = (Card) other;
        return rank == c.rank && suit == c.suit;
    }

    /**
     * This method makes hashsets of Cards work correctly; you can ignore it.
     */
    public int hashCode() {
        return 13 * suit.ordinal() + rank;
    }

    /**
     * Returns a short name for the card, e.g.:
     * - "QS" for the queen of spades.
     * - "10H" for the ten of hearts.
     */
    public String toString() {
        String r;
        if (rank == 11) {
            r = "J";
        } else if (rank == 12) {
            r = "Q";
        } else if (rank == 13) {
            r = "K";
        } else if (rank == 14) {
            r = "A";
        } else {
            r = "" + rank;
        }

        return r + suit.name().charAt(0);
    }

    /**
     * Returns the card named by s, in the same form toString() uses.
     * Allows lowercase; returns null if s doesn't name a card.
     */
    public static Card fromString(String s) {
        for (Suit suit : Suit.values()) {
            for (int rank = 2; rank <= 14; rank++) {
                Card c = new Card(rank, suit);
                if (c.toString().equalsIgnoreCase(s)) {
                    return c;
                }
            }
        }
        return null;
    }
}
