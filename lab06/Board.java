package lab06;

import java.util.Scanner;

// a tic-tac-toe board that two players take turns playing on in the terminal.
public class Board {
    // reads the players' moves from the keyboard.
    private Scanner scanner;

    // state[row][col] is the symbol in that square, or null if it's empty.
    // rows and columns are numbered 0-2, starting from the top left.
    private Symbol[][] state;

    // construct an empty board.
    public Board() {
        scanner = new Scanner(System.in);
        state = new Symbol[3][3];
    }

    // ask for a row or column until the player types 0, 1, or 2, and return it.
    private int nextCoordinate(String display) {
        while (true) {
            System.out.print(display + " (0-2): ");
            int input = scanner.nextInt();
            if (0 <= input && input <= 2) {
                return input;
            }
        }
    }

    // ask the current player for a square, put their symbol there, and
    // switch to the other player.
    public void nextMove() {
        int row = nextCoordinate("Row");
        int col = nextCoordinate("Col");
        System.out.println();
    }

    // return true if every square is filled in.
    public boolean isFull() {
        return false;
    }

    // return true if s has three in a row: across a row, down a column, or
    // along a diagonal.
    private boolean isWinner(Symbol s) {
        return false;
    }

    // return the symbol that has won, or null if nobody has won.
    public Symbol getWinner() {
        return null;
    }

    // return true if someone has won or the board is full.
    public boolean gameOver() {
        return false;
    }

    // print the board and whose turn it is.
    public void showState() {

    }

    // print the final board and who won, or that it's a tie.
    public void showWinner() {

    }

    // return the board as a string, with lines between the squares.
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
