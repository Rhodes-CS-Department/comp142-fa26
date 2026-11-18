package hearts;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private List<Card> currentTrick;
    private int leaderIndex;
    private List<List<Card>> previousTricks;

    public GameState(List<Card> currentTrick, int leaderIndex) {
        this(currentTrick, leaderIndex, new ArrayList<>());
    }

    public GameState(List<Card> currentTrick, int leaderIndex,
            List<List<Card>> previousTricks) {
        this.currentTrick = new ArrayList<>(currentTrick);
        this.leaderIndex = leaderIndex;
        this.previousTricks = new ArrayList<>(previousTricks);
    }

    public Suit getLeadingSuit() {
        if (currentTrick.isEmpty()) {
            return null;
        }
        return currentTrick.get(0).getSuit();
    }

    public List<Card> currentTrick() {
        return new ArrayList<>(currentTrick);
    }

    public int getLeaderIndex() {
        return leaderIndex;
    }

    /**
     * Returns the tricks already played in this hand, oldest first. Each
     * trick lists its cards in the order they were played.
     */
    public List<List<Card>> previousTricks() {
        List<List<Card>> result = new ArrayList<>();
        for (List<Card> trick : previousTricks) {
            result.add(new ArrayList<>(trick));
        }
        return result;
    }
}
