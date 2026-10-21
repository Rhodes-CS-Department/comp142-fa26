package lab08;

public class HanoiSolver {

    // Solve the Towers of Hanoi game for 2 disks.
    public static void solveSize2(Hanoi h) {
        h.move(0, 1);
    }

    // Solve the Towers of Hanoi game for 3 disks.
    public static void solveSize3(Hanoi h) {

    }

    // Move the top two disks from one pole to another.
    public static void solveSize2(Hanoi h, int from, int other, int to) {

    }

    // Move the top three disks from one pole to another.
    public static void solveSize3(Hanoi h, int from, int other, int to) {

    }

    // Solve the Towers of Hanoi game for 4 disks.
    public static void solveSize4(Hanoi h) {

    }

    // Move the top n disks from one pole to another.
    public static void solve(Hanoi h, int n, int from, int other, int to) {

    }

    // Solve the Towers of Hanoi game for n disks.
    public static void solve(Hanoi h) {

    }

    public static void main(String[] args) {
        Hanoi h = new Hanoi(2);
        solveSize2(h);
    }

}
