package hearts;

import java.util.List;

public class SimplePlayer implements Player {

    public SimplePlayer() {
    }

    public boolean isHuman() {
        return false;
    }

    public Card play(GameState s, List<Card> hand) {
        for (int i = 0; i < hand.size(); i++) {
            if (Rules.playValid(s, hand, hand.get(i))) {
                return hand.get(i);
            }
        }
        return null;
    }

    public Card[] pass(GameState s, List<Card> hand) {
        return new Card[]{hand.get(0), hand.get(1), hand.get(2)};
    }
}
