package hearts;

import java.util.List;

public interface Player {

    boolean isHuman();

    Card play(GameState s, List<Card> hand);

    Card[] pass(GameState s, List<Card> hand);

}
