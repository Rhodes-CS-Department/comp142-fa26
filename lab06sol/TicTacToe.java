package lab06sol;

public class TicTacToe {
    public static void main(String[] args) {
        playGUI();
    }

    public static void play() {
        Board board = new Board();

        while (!board.gameOver()) {
            board.showState();
            board.nextMove();
        }

        board.showWinner();
    }

    public static void playGUI() {
        BoardGUI board = new BoardGUI();

        while (!board.gameOver()) {
            board.showState();
            board.nextMove();
        }

        board.showWinner();
    }
}
