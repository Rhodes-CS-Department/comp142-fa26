package hearts;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private List<Card> currentTrick;
    private int leaderIndex;

    public GameState(List<Card> currentTrick, int leaderIndex) {
        this.currentTrick = new ArrayList<>(currentTrick);
        this.leaderIndex = leaderIndex;
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
}
