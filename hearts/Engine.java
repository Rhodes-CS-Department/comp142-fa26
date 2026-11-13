package hearts;

import java.util.ArrayList;
import java.util.List;

/**
 * Runs a game of Hearts. Players are numbered 0 to 3, in the order they play;
 * if there's a human player, it should be player 0.
 */
public class Engine {
    private static final int PAUSE = 500;

    private Player[] players;
    private List<List<Card>> hands;
    private int[] scores;
    private boolean[] disqualified;
    private GUI gui;

    public Engine(Player[] players) {
        this.players = players;
        hands = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            hands.add(new ArrayList<>());
        }
        scores = new int[4];
        disqualified = new boolean[4];
        gui = new GUI();

        // If there's no human player, show all four hands.
        boolean anyHuman = false;
        for (int i = 0; i < 4; i++) {
            if (players[i].isHuman()) {
                anyHuman = true;
            }
        }
        if (!anyHuman) {
            for (int i = 0; i < 4; i++) {
                gui.setHandFaceUp(i, true);
            }
        }
    }

    /**
     * Plays hands until a player reaches 100 points.
     */
    public void playGame() {
        int handNumber = 0;
        while (!gameOver()) {
            deal();
            if (handNumber % 4 == 0) {
                passCards(1); // left
            } else if (handNumber % 4 == 1) {
                passCards(3); // right
            } else if (handNumber % 4 == 2) {
                passCards(2); // across
            }
            playHand();
            printScores();
            handNumber++;
        }

        // The lowest score wins, among players who weren't disqualified.
        int lowest = -1;
        for (int i = 0; i < 4; i++) {
            if (!disqualified[i] && (lowest == -1 || scores[i] < lowest)) {
                lowest = scores[i];
            }
        }
        if (lowest == -1) {
            System.out.println("Every player was disqualified, so no one wins.");
        }
        for (int i = 0; i < 4; i++) {
            if (!disqualified[i] && scores[i] == lowest) {
                System.out.println("Player " + i + " wins!");
            }
        }
    }

    /**
     * Logs an illegal move by player p, and disqualifies p if p is a computer
     * player. The engine then makes a legal move for p, so the game can go on.
     */
    private void illegalMove(int p, String message) {
        System.out.println("Player " + p + " " + message + "; playing for them.");
        if (!players[p].isHuman() && !disqualified[p]) {
            disqualified[p] = true;
            System.out.println("Player " + p + " is disqualified.");
        }
    }

    private boolean gameOver() {
        for (int i = 0; i < 4; i++) {
            if (scores[i] >= 100) {
                return true;
            }
        }
        return false;
    }

    private void printScores() {
        System.out.println("Scores:");
        for (int i = 0; i < 4; i++) {
            String note = "";
            if (disqualified[i]) {
                note = " (disqualified)";
            }
            System.out.println("  Player " + i + ": " + scores[i] + note);
        }
    }

    /**
     * Shuffles and deals 13 cards to each player.
     */
    private void deal() {
        Deck deck = new Deck();
        for (int i = 0; i < 4; i++) {
            hands.get(i).clear();
        }
        for (int i = 0; i < 13; i++) {
            for (int p = 0; p < 4; p++) {
                hands.get(p).add(deck.draw());
            }
        }
    }

    /**
     * Each player passes three cards to the player offset seats after them:
     * 1 is left, 2 is across, and 3 is right.
     */
    private void passCards(int offset) {
        gui.draw(new GameState(new ArrayList<>(), 0), hands);

        // Every player chooses before any cards change hands.
        Card[][] passed = new Card[4][3];
        for (int p = 0; p < 4; p++) {
            List<Card> hand = hands.get(p);
            GameState state = new GameState(new ArrayList<>(), 0);
            Card[] cards = players[p].pass(state, new ArrayList<>(hand));
            if (!passValid(hand, cards)) {
                illegalMove(p, "made an illegal pass");
                cards = new SimplePlayer().pass(state, new ArrayList<>(hand));
            }
            passed[p] = cards;
        }

        for (int p = 0; p < 4; p++) {
            for (Card c : passed[p]) {
                hands.get(p).remove(c);
                hands.get((p + offset) % 4).add(c);
            }
        }
    }

    /**
     * Says whether cards is three different cards from hand.
     */
    private boolean passValid(List<Card> hand, Card[] cards) {
        if (cards == null || cards.length != 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (!hand.contains(cards[i])) {
                return false;
            }
            for (int j = 0; j < i; j++) {
                if (cards[i].equals(cards[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Plays the 13 tricks of a hand, and adds the points to the scores.
     */
    private void playHand() {
        int leader = 0;
        for (int p = 0; p < 4; p++) {
            if (hands.get(p).contains(new Card(2, Suit.CLUBS))) {
                leader = p;
            }
        }

        int[] handPoints = new int[4];
        for (int t = 0; t < 13; t++) {
            List<Card> trick = playTrick(leader);
            int winner = (leader + Rules.trickWinner(trick)) % 4;
            handPoints[winner] += Rules.trickPoint(trick);
            leader = winner;
        }

        // Shooting the moon: one player took all 26 points.
        for (int p = 0; p < 4; p++) {
            if (handPoints[p] == 26) {
                System.out.println("Player " + p + " shot the moon!");
                for (int i = 0; i < 4; i++) {
                    handPoints[i] = 26;
                }
                handPoints[p] = 0;
            }
        }

        for (int p = 0; p < 4; p++) {
            scores[p] += handPoints[p];
        }
    }

    /**
     * Plays one trick, starting with the given leader, and returns the cards
     * played, in the order they were played.
     */
    private List<Card> playTrick(int leader) {
        List<Card> trick = new ArrayList<>();
        gui.draw(new GameState(trick, leader), hands);

        for (int i = 0; i < 4; i++) {
            int p = (leader + i) % 4;
            List<Card> hand = hands.get(p);
            GameState state = new GameState(trick, leader);
            Card card = players[p].play(state, new ArrayList<>(hand));
            if (!hand.contains(card) || !Rules.playValid(state, hand, card)) {
                illegalMove(p, "made an illegal play (" + card + ")");
                card = new SimplePlayer().play(state, new ArrayList<>(hand));
            }
            hand.remove(card);
            trick.add(card);
            gui.draw(new GameState(trick, leader), hands);
            gui.pause(PAUSE);
        }
        return trick;
    }

    public static void main(String[] args) {
        Player[] players = new Player[4];
        players[0] = new HumanPlayer();
        players[1] = new SimplePlayer();
        players[2] = new SimplePlayer();
        players[3] = new SimplePlayer();

        Engine engine = new Engine(players);
        engine.playGame();
    }
}
