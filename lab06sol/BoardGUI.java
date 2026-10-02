package lab06sol;

import graphics.SimpleCanvas;
import java.awt.Color;

public class BoardGUI {
    private SimpleCanvas canvas;
    private Symbol[][] state;
    private Symbol turn;

    private static final int SQUARESIZE = 100;
    private static final int MESSAGEHEIGHT = 60;

    public BoardGUI() {
        canvas = new SimpleCanvas(3 * SQUARESIZE, 3 * SQUARESIZE + MESSAGEHEIGHT, "Tic-Tac-Toe");
        canvas.show();
        state = new Symbol[3][3];
        turn = Symbol.X;
    }

    private static Symbol nextTurn(Symbol s) {
        if (s == Symbol.X) {
            return Symbol.O;
        } else {
            return Symbol.X;
        }
    }

    public void nextMove() {
        // wait until the player clicks on an empty square
        while (true) {
            canvas.waitForClick();
            int x = canvas.getMouseClickX();
            int y = canvas.getMouseClickY();
            if (x < 0 || y < 0) {
                continue;
            }

            int row = y / SQUARESIZE;
            int col = x / SQUARESIZE;
            if (row < 3 && col < 3 && state[row][col] == null) {
                state[row][col] = turn;
                turn = nextTurn(turn);
                return;
            }
        }
    }

    public boolean isFull() {
        for (Symbol[] row : state) {
            for (Symbol symbol : row) {
                if (symbol == null) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isWinner(Symbol s) {
        return state[0][0] == s && state[0][1] == s && state[0][2] == s
            || state[1][0] == s && state[1][1] == s && state[1][2] == s
            || state[2][0] == s && state[2][1] == s && state[2][2] == s
            || state[0][0] == s && state[1][0] == s && state[2][0] == s
            || state[0][1] == s && state[1][1] == s && state[2][1] == s
            || state[0][2] == s && state[1][2] == s && state[2][2] == s
            || state[0][0] == s && state[1][1] == s && state[2][2] == s
            || state[0][2] == s && state[1][1] == s && state[2][0] == s;
    }

    public Symbol getWinner() {
        if (isWinner(Symbol.X)) {
            return Symbol.X;
        } else if (isWinner(Symbol.O)) {
            return Symbol.O;
        } else {
            return null;
        }
    }

    public boolean gameOver() {
        return isFull() || getWinner() != null;
    }

    private void draw(String message) {
        canvas.clear();
        canvas.setLineThickness(4);

        // draw the two vertical and two horizontal grid lines
        canvas.setPenColor(Color.GRAY);
        for (int line = 1; line < 3; line++) {
            canvas.drawLine(line * SQUARESIZE, 0, line * SQUARESIZE, 3 * SQUARESIZE);
            canvas.drawLine(0, line * SQUARESIZE, 3 * SQUARESIZE, line * SQUARESIZE);
        }

        // draw each X and O inside its square, leaving a margin from the grid lines
        int margin = SQUARESIZE / 5;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int leftX = col * SQUARESIZE + margin;
                int centerX = col * SQUARESIZE + SQUARESIZE / 2;
                int rightX = (col + 1) * SQUARESIZE - margin;
                int topY = row * SQUARESIZE + margin;
                int centerY = row * SQUARESIZE + SQUARESIZE / 2;
                int bottomY = (row + 1) * SQUARESIZE - margin;

                if (state[row][col] == Symbol.X) {
                    canvas.setPenColor(Color.BLUE);
                    canvas.drawLine(leftX, topY, rightX, bottomY);
                    canvas.drawLine(leftX, bottomY, rightX, topY);
                } else if (state[row][col] == Symbol.O) {
                    canvas.setPenColor(Color.RED);
                    canvas.drawCircle(centerX, centerY, centerX - leftX);
                }
            }
        }

        // draw the message centered in the area below the board
        canvas.setPenColor(Color.BLACK);
        canvas.drawStringCentered(3 * SQUARESIZE / 2, 3 * SQUARESIZE + 2 * MESSAGEHEIGHT / 3, message, 24);

        canvas.update();
    }

    public void showState() {
        draw(turn + " to play.");
    }

    public void showWinner() {
        Symbol winner = getWinner();
        if (winner != null) {
            draw(winner + " wins!");
        } else {
            draw("Tie.");
        }
    }

    public String toString() {
        String result = "";

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Symbol symbol = state[row][col];
                if (symbol != null) {
                    result += " " + symbol + " ";
                } else {
                    result += "   ";
                }

                if (col < 2) {
                    result += "│";
                }
            }

            result += "\n";
            if (row < 2) {
                result += "───┼───┼───\n";
            }
        }

        return result;
    }
}
