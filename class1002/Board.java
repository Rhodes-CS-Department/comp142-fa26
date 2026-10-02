package class1002;

public class Board {
    private Symbol[][] state;

    public Board() {
        state = new Symbol[3][3];
    }

    // return true if every square is filled in.
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] == null) {
                    return false;
                }
            }
        }

        return true;
    }

    // return the number of X's on the board.
    public int countX() {
        // add code here.
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // add code here.

            }
        }

        // fix this return.
        return 0;
    }

    // swap all X's for O's & vice versa.
    public void swapAll() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // add code here.

            }
        }
    }
}
