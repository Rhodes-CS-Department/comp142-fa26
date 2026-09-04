package class0904;

public class Die {
    // the number of dots on the face-up side of the die.
    private int dots;

    // the number of sides on the die (e.g., 6 for a standard die).
    private int sides;

    // construct a new die with the given number of sides.
    public Die(int mySides) {
        sides = mySides;
        roll();
    }

    // roll the die.
    public void roll() {
        dots = (int) (Math.random() * sides) + 1;
    }

    // get the number of dots.
    public int getDots() {
        return dots;
    }

    // set the number of sides & re-roll.
    public void setSides(int newSides) {
        sides = newSides;
    }
}
