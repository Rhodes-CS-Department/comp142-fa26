package lab11;

public interface Player {
    
    boolean isHuman();

    Card play(GameState s, Card[] hand);

    Card[] pass(GameState s, Card[] hand);

}
