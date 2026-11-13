package hearts;

import graphics.SimpleCanvas;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A simplified graphical view of a Hearts game.
 *
 * <p>Player numbers are 0 (bottom), 1 (left), 2 (top), and 3 (right).
 * The hands are passed to draw separately from the GameState, since players
 * shouldn't be able to see each other's hands.
 *
 * <p>A game engine should create one GUI and call draw whenever its state
 * changes. The main method is only an optional demonstration; it does not
 * need to be run by the engine.
 *
 * <pre>
 * GUI gui = new GUI();
 * gui.draw(gameState, hands);
 * </pre>
 */
public class GUI {
    public static final int BOTTOM = 0;
    public static final int LEFT = 1;
    public static final int TOP = 2;
    public static final int RIGHT = 3;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 700;
    private static final int CARD_WIDTH = 60;
    private static final int CARD_HEIGHT = 90;
    private static final Color TABLE_GREEN = new Color(0, 145, 55);

    private final SimpleCanvas canvas;
    private final boolean[] faceUp = {true, false, false, false};

    /** Creates the window with only the bottom hand face-up. */
    public GUI() {
        canvas = new SimpleCanvas(WIDTH, HEIGHT, "Hearts");
        canvas.setBackgroundColor(TABLE_GREEN);
        canvas.show();
    }

    /** Runs a demonstration with four full hands and a four-card trick. */
    public static void main(String[] args) {
        List<List<Card>> hands = new ArrayList<>();
        for (int player = 0; player < 4; player++) {
            List<Card> hand = new ArrayList<>();
            for (int rank = 2; rank <= 14; rank++) {
                Suit suit = Suit.values()[(rank + player) % Suit.values().length];
                hand.add(new Card(rank, suit));
            }
            hands.add(hand);
        }

        List<Card> trick = new ArrayList<>();
        trick.add(new Card(14, Suit.SPADES));
        trick.add(new Card(13, Suit.HEARTS));
        trick.add(new Card(12, Suit.CLUBS));
        trick.add(new Card(11, Suit.DIAMONDS));
        GameState state = new GameState(trick, 0);

        GUI gui = new GUI();
        gui.draw(state, hands);
        System.out.println("GUI test drawn: bottom hand face-up, other hands face-down.");
    }

    /** Chooses whether a player's hand shows card faces or card backs. */
    public void setHandFaceUp(int player, boolean isFaceUp) {
        if (player < 0 || player >= faceUp.length) {
            throw new IllegalArgumentException("player must be from 0 to 3");
        }
        faceUp[player] = isFaceUp;
    }

    /** Waits for the given number of milliseconds. */
    public void pause(int milliseconds) {
        canvas.pause(milliseconds);
    }

    /** Redraws all four hands and the current trick. */
    public void draw(GameState state, List<List<Card>> hands) {
        canvas.clear();

        drawHorizontalHand(hands.get(TOP), WIDTH / 2, 35, faceUp[TOP]);
        drawHorizontalHand(hands.get(BOTTOM), WIDTH / 2, HEIGHT - 125,
                faceUp[BOTTOM]);
        drawVerticalHand(hands.get(LEFT), 35, HEIGHT / 2, faceUp[LEFT]);
        drawVerticalHand(hands.get(RIGHT), WIDTH - 35 - CARD_WIDTH,
                HEIGHT / 2, faceUp[RIGHT]);

        drawTrick(state.currentTrick());
        canvas.update();
    }

    private void drawHorizontalHand(List<Card> hand, int centerX, int topY,
            boolean isFaceUp) {
        if (hand == null || hand.isEmpty()) {
            return;
        }
        int spacing = spacing(hand.size(), 520);
        int handWidth = CARD_WIDTH + (hand.size() - 1) * spacing;
        int x = centerX - handWidth / 2;
        for (Card card : hand) {
            drawCard(card, x, topY, isFaceUp);
            x += spacing;
        }
    }

    private void drawVerticalHand(List<Card> hand, int leftX, int centerY,
            boolean isFaceUp) {
        if (hand == null || hand.isEmpty()) {
            return;
        }
        int spacing = spacing(hand.size(), 410);
        int handHeight = CARD_HEIGHT + (hand.size() - 1) * spacing;
        int y = centerY - handHeight / 2;
        for (Card card : hand) {
            drawCard(card, leftX, y, isFaceUp);
            y += spacing;
        }
    }

    private int spacing(int cardCount, int availableSpace) {
        if (cardCount <= 1) {
            return 0;
        }
        int preferred = 38;
        int maximum = (availableSpace - CARD_WIDTH) / (cardCount - 1);
        return Math.max(12, Math.min(preferred, maximum));
    }

    private void drawCard(Card card, int x, int y, boolean isFaceUp) {
        if (isFaceUp && card != null) {
            drawCardFace(card, x, y);
        } else {
            drawCardBack(x, y);
        }
    }

    private void drawCardFace(Card card, int x, int y) {
        canvas.setPenColor(Color.WHITE);
        canvas.drawFilledRectangle(x, y, CARD_WIDTH, CARD_HEIGHT);
        canvas.setPenColor(Color.GRAY);
        canvas.setLineThickness(1);
        canvas.drawRectangle(x, y, CARD_WIDTH, CARD_HEIGHT);

        Color suitColor = suitColor(card.getSuit());
        canvas.setPenColor(suitColor);
        canvas.drawString(x + 5, y + 19, rankText(card.getRank()), 16);
        drawSuit(card.getSuit(), x + CARD_WIDTH / 2, y + 53, 15);
    }

    private void drawCardBack(int x, int y) {
        canvas.setPenColor(Color.WHITE);
        canvas.drawFilledRectangle(x, y, CARD_WIDTH, CARD_HEIGHT);
        canvas.setPenColor(new Color(210, 35, 45));
        canvas.drawFilledRectangle(x + 3, y + 3, CARD_WIDTH - 6, CARD_HEIGHT - 6);

        canvas.setPenColor(new Color(255, 150, 150));
        canvas.setLineThickness(1);
        for (int lineX = x + 7; lineX < x + CARD_WIDTH - 5; lineX += 6) {
            canvas.drawLine(lineX, y + 5, lineX, y + CARD_HEIGHT - 5);
        }
        for (int lineY = y + 7; lineY < y + CARD_HEIGHT - 5; lineY += 6) {
            canvas.drawLine(x + 5, lineY, x + CARD_WIDTH - 5, lineY);
        }
        canvas.setPenColor(Color.GRAY);
        canvas.drawRectangle(x, y, CARD_WIDTH, CARD_HEIGHT);
    }

    private String rankText(int rank) {
        switch (rank) {
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 14:
                return "A";
            default:
                return Integer.toString(rank);
        }
    }

    private Color suitColor(Suit suit) {
        return suit == Suit.HEARTS || suit == Suit.DIAMONDS
                ? Color.RED : Color.BLACK;
    }

    private void drawSuit(Suit suit, int cx, int cy, int size) {
        canvas.setPenColor(suitColor(suit));
        switch (suit) {
            case HEARTS:
                drawHeart(cx, cy, size);
                break;
            case DIAMONDS:
                drawDiamond(cx, cy, size);
                break;
            case SPADES:
                drawSpade(cx, cy, size);
                break;
            case CLUBS:
                drawClub(cx, cy, size);
                break;
        }
    }

    private void drawTrick(List<Card> trick) {
        if (trick == null || trick.isEmpty()) {
            return;
        }
        int gap = 10;
        int trickWidth = trick.size() * CARD_WIDTH + (trick.size() - 1) * gap;
        int x = (WIDTH - trickWidth) / 2;
        int y = (HEIGHT - CARD_HEIGHT) / 2;
        for (Card card : trick) {
            drawCard(card, x, y, true);
            x += CARD_WIDTH + gap;
        }
    }

    /** Draws a spade from two circles, a triangle, and an overlapping stem. */
    private void drawSpade(int cx, int cy, int size) {
        int radius = size / 2;
        int lobeY = cy + size / 4;
        int stemWidth = Math.max(2, size / 5);

        // The triangle's base passes through the circle centers, giving
        // the pointed top a smooth overlap with both rounded lobes.
        int[] xs = {cx - 2 * radius, cx, cx + 2 * radius};
        int[] ys = {lobeY, cy - size, lobeY};
        canvas.drawFilledPolygon(xs, ys);
        canvas.drawFilledCircle(cx - radius, lobeY, radius);
        canvas.drawFilledCircle(cx + radius, lobeY, radius);

        // Start the stem inside the circles rather than underneath them.
        canvas.drawFilledRectangle(cx - stemWidth / 2, lobeY,
                stemWidth, size + radius);
    }

    /** Draws a heart from two overlapping circles and a triangle. */
    private void drawHeart(int cx, int cy, int size) {
        int radius = size / 2;
        int lobeY = cy - size / 4;

        // The circles touch at the center, forming the heart's upper cleft.
        canvas.drawFilledCircle(cx - radius, lobeY, radius);
        canvas.drawFilledCircle(cx + radius, lobeY, radius);

        // The base passes through the circle centers so the shapes overlap
        // across the full width without leaving gaps or pointed shoulders.
        int[] xs = {cx - 2 * radius, cx, cx + 2 * radius};
        int[] ys = {lobeY, cy + size, lobeY};
        canvas.drawFilledPolygon(xs, ys);
    }

    private void drawDiamond(int cx, int cy, int size) {
        int[] xs = {cx, cx + size, cx, cx - size};
        int[] ys = {cy - size, cy, cy + size, cy};
        canvas.drawFilledPolygon(xs, ys);
    }

    private void drawClub(int cx, int cy, int size) {
        int r = size / 2;
        int offsetY = size / 4;
        int stemWidth = Math.max(2, size / 5);
        canvas.drawFilledCircle(cx, cy - size / 3, r);
        canvas.drawFilledCircle(cx - r, cy + offsetY, r);
        canvas.drawFilledCircle(cx + r, cy + offsetY, r);
        canvas.drawFilledRectangle(cx - stemWidth / 2, cy + offsetY,
                stemWidth, size + r - stemWidth / 2);
    }
}
