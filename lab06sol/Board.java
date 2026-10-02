package lab06sol;

import java.util.Scanner;

public class Board {
    private Scanner scanner;
    private Symbol[][] state;
    private Symbol turn;

    public Board() {
        scanner = new Scanner(System.in);
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

    private int nextCoordinate(String display) {
        while (true) {
            System.out.print(display + " (0-2): ");
            int input = scanner.nextInt();
            if (0 <= input && input <= 2) {
                return input;
            }
        }
    }

    public void nextMove() {
        int row = nextCoordinate("Row");
        int col = nextCoordinate("Col");
        System.out.println();
        state[row][col] = turn;
        turn = nextTurn(turn);
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

    public void showState() {
        System.out.println(this);
        System.out.println(turn + " to play.");
    }

    public void showWinner() {
        System.out.println(this);
        Symbol winner = getWinner();
        if (winner != null) {
            System.out.println(winner + " wins!");
        } else {
            System.out.println("Tie.");
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
