package lab05;

import java.awt.*;

public class Car {
    /**
     * The color of the car.
     */
    private Color color;

    /**
     * The current speed of the car.
     */
    private int speed;

    /**
     * The current row of the car on the track.
     */
    private int row;

    /**
     * The current column of the car on the track.
     */
    private int col;

    /**
     * The current direction the car is facing: 'N', 'E', 'S', or 'W'.
     */
    private char direction;

    /**
     * Is the car broken or not?
     */
    private boolean isBroken;

    /**
     * Constructor; sets initial speed of the car.
     */
    public Car(Color theColor) {
        color = theColor;
        speed = 1;
        direction = 'N';
        isBroken = false;
    }

    /**
     * Determine which direction to drive next.  Directions are based
     * on which way the car is facing.  Return 0 to try to drive straight,
     * return -1 to try to turn left, 1 = turn right.
     * <p>
     * The three parameters below may be '.' for grass or '*' for the road
     * the car may drive on.
     *
     * @param leftOfMe:  the view from the camera on the left side of the car
     * @param aheadOfMe: the view from the camera on the front of the car
     * @param rightOfMe: the view from the camera on the right side of the car
     */
    public int drive(CameraView leftOfMe, CameraView aheadOfMe, CameraView rightOfMe) {
        // red and blue cars are for the first demo
        if (color.equals(Color.RED) || color.equals(Color.BLUE)) {
            if (aheadOfMe.getGround() == '*') {
                return 0;
            } else if (leftOfMe.getGround() == '*') {
                return -1;
            } else
                return 1;
        }

        // yellow and magenta cars are for the second demo
        else if (color.equals(Color.YELLOW) || color.equals(Color.MAGENTA)) {
            if (aheadOfMe.getGround() == '*') {
                return 0;
            } else if (leftOfMe.getGround() == '*') {
                return -1;
            } else
                return 1;
        }

        // default driving code for any other color car
        else {
            if (aheadOfMe.getGround() == '*') {
                return 0;
            } else if (leftOfMe.getGround() == '*') {
                return -1;
            } else
                return 1;
        }
    }

    /**
     * What to do when we crash into another car.
     */
    public void crashInto(Car otherCar) {

    }

    /**
     * Return the color of the car.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Return the current speed of the car.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Set the current speed of the car.
     */
    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    /**
     * Return true if the car is broken, false if not.
     */
    public boolean isBroken() {
        return isBroken;
    }

    /**
     * Get the direction the car is facing.
     */
    public char getDirection() {
        return direction;
    }

    /**
     * Set the direction the car is facing.
     */
    public void setDirection(char newDirection) {
        direction = newDirection;
    }

    /**
     * Get the row the car is in.
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the column the car is in.
     */
    public int getCol() {
        return col;
    }

    /**
     * Set the (row, col) location of the car.
     */
    public void setLocation(int newRow, int newCol) {
        row = newRow;
        col = newCol;
    }

    /**
     * Automatically called by println.
     */
    public String toString() {
        return "Car: color=" + color + " dir=" + direction + " row=" + row + " col=" + col;
    }
}
