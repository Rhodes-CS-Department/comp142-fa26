package lab08sol;

public class HanoiSolver {

    // Solve the Towers of Hanoi game for 2 disks.
    public static void solveSize2(Hanoi h) {
        h.move(0, 1);
        h.move(1, 2);
        h.move(0, 2);
    }

    // Solve the Towers of Hanoi game for 3 disks.
    // Written out by hand, this was:
    //     h.move(0, 2); h.move(1, 1); h.move(0, 1);
    //     h.move(2, 2);
    //     h.move(0, 0); h.move(1, 2); h.move(0, 2);
    public static void solveSize3(Hanoi h) {
        solveSize2(h, 0, 2, 1);
        h.move(2, 2);
        solveSize2(h, 1, 0, 2);
    }

    // Move the top two disks from one pole to another.
    public static void solveSize2(Hanoi h, int from, int other, int to) {
        h.move(0, other);
        h.move(1, to);
        h.move(0, to);
    }

    // Move the top three disks from one pole to another.
    public static void solveSize3(Hanoi h, int from, int other, int to) {
        solveSize2(h, from, to, other);
        h.move(2, to);
        solveSize2(h, other, from, to);
    }

    // Solve the Towers of Hanoi game for 4 disks.
    public static void solveSize4(Hanoi h) {
        solveSize3(h, 0, 2, 1);
        h.move(3, 2);
        solveSize3(h, 1, 0, 2);
    }

    // Move the top n disks from one pole to another.
    // Returns the number of moves made (extension).
    // With n = 1 as the base case instead:
    //     if (n == 1) {
    //         h.move(0, to);
    //     } else {
    //         solve(h, n - 1, from, to, other);
    //         h.move(n - 1, to);
    //         solve(h, n - 1, other, from, to);
    //     }
    public static int solve(Hanoi h, int n, int from, int other, int to) {
        if (n == 0) {
            return 0;
        } else {
            int before = solve(h, n - 1, from, to, other);
            h.move(n - 1, to);
            int after = solve(h, n - 1, other, from, to);
            return before + 1 + after;
        }
    }

    // Solve the Towers of Hanoi game for n disks.
    public static int solve(Hanoi h) {
        return solve(h, h.getSize(), 0, 1, 2);
    }

    // Extension: 2^n - 1 moves; for 64 disks at one move per second that's
    // 18,446,744,073,709,551,615 seconds, about 585 billion years.
    public static void main(String[] args) {
        Hanoi h = new Hanoi(20, 10);
        System.out.println(solve(h) + " moves");
    }

}
