package lab08sol;

import java.util.Scanner;

// Extension: solve the puzzle yourself, typing moves in the terminal.
public class PlayHanoi {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Hanoi h = new Hanoi(3, 0);
        int moves = 0;

        while (!h.isSolved()) {
            System.out.print("Move from pole (0-2): ");
            int from = scan.nextInt();
            System.out.print("Move to pole (0-2): ");
            int to = scan.nextInt();

            int disk = h.topDisk(from);
            int below = h.topDisk(to);
            if (disk == -1 || from == to || (below != -1 && below < disk)) {
                System.out.println("You can't make that move.");
            } else {
                h.move(disk, to);
                moves++;
                System.out.println("Moves so far: " + moves);
            }
        }

        System.out.println("Solved in " + moves + " moves!");
        scan.close();
    }

}
