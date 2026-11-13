package hearts;

import java.util.List;

/**
 * Implements the core rules of the card game Hearts.
 *
 * <p>The Hearts rules implemented here include:
 * <ul>
 *   <li>Following suit (a player must play the leading suit if they have it).</li>
 *   <li>Determining the winner of a trick (highest card of the leading suit).</li>
 *   <li>Scoring a trick (each heart is 1 point, the Queen of Spades is 13 points).</li>
 * </ul>
 */
public class Rules {

    /**
     * Checks whether a card that a player wants to play is legal under
     * the standard Hearts follow-suit rule.
     *
     * <p>A play is valid if either:
     * <ul>
     *   <li>The player is leading, and either has played the two of clubs
     *       or doesn't have it, <b>or</b></li>
     *   <li>The played card matches the leading suit, <b>or</b></li>
     *   <li>The player has no cards of the leading suit in their hand
     *       (and may therefore play any card).</li>
     * </ul>
     *
     * @param s          the current state of the game
     * @param playerHand the list of cards the player currently holds
     * @param playedCard the card the player intends to play
     * @return {@code true} if the card may legally be played;
     *         {@code false} if the player holds a card of the leading suit
     *         but tried to play a different suit
     */
    public static boolean playValid(GameState s, List<Card> playerHand, Card playedCard) {
        if (s.currentTrick().isEmpty()) {
            Card twoOfClubs = new Card(2, Suit.CLUBS);
            if (playerHand.contains(twoOfClubs)) {
                return playedCard.equals(twoOfClubs);
            }
            return true;
        }
        Suit p = s.currentTrick().get(0).getSuit();
        boolean noSuited = true;
        if (playedCard.getSuit() == p) {
            return true;
        }
        for (Card i: playerHand) {
            if (i.getSuit() == p) {
                noSuited = false;
            }
        }
        return noSuited;
    }

    /**
     * Determines which player wins a trick.
     *
     * <p>The trick is won by the player who played the highest-ranked
     * card of the <strong>leading suit</strong>. Cards of other suits
     * cannot win the trick, regardless of rank.
     *
     * @param trick  the four cards played in the trick, in the order they
     *               were played
     * @return the index in the trick of the winning card (0 means the
     *         player who led the trick won it)
     */
    public static int trickWinner(List<Card> trick) {
        Suit p = trick.get(0).getSuit();
        int max = 0;
        int winningIndex = -1;
        for (int i = 0; i < 4; i++) {
            if (trick.get(i).getSuit() == p) {
                if (max < trick.get(i).getRank()) {
                    max = trick.get(i).getRank();
                    winningIndex = i;
                }
            }
        }
        return winningIndex;
    }

    /**
     * Calculates the total point value of the cards in the current trick.
     *
     * <p>In Hearts:
     * <ul>
     *   <li>Each heart card is worth <strong>1 point</strong>.</li>
     *   <li>The Queen of Spades (rank 12, suit SPADES) is worth
     *       <strong>13 points</strong>.</li>
     *   <li>All other cards are worth 0 points.</li>
     * </ul>
     *
     * @param trick  the cards played in the trick
     * @return the total point value of the trick
     */
    public static int trickPoint(List<Card> trick) {
        int points = 0;
        for (Card i : trick) {
            if (i.getSuit() == Suit.HEARTS) {
                points+=1;
            }
            if ((i.getSuit() == Suit.SPADES) && (i.getRank() == 12)) {
                points += 13;
            }
        }
        return points;
    }
}
