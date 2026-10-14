package lab07;

import java.util.ArrayList;

/**
 * This class represents a snake that slithers around a 2d grid.
 */
public class Snake {
    /* The body arraylist represents the entire snake.  Segment/index 0 is the head. */
    private ArrayList<Location> body;

    // add an instance variable here to keep track of the *direction*
    // that the snake is facing.

    /**
     * Construct a new snake of size 1, with a specific starting location.
     */
    public Snake(Location startLoc) {
        body = new ArrayList<Location>();
        // Add the starting location of the snake to the snake's body.
        // Set the direction of the snake to whatever direction you want it to start.
    }

    /**
     * Return the location of the head of the snake (first item in the body arraylist).
     */
    public Location getHeadLocation() {
        return null; // Fix this.
    }

    /**
     * Retrieve the arraylist corresponding to the body of the snake.  Remember, "body" means all
     * the segments of the snake, including the "head" segment.
     */
    public ArrayList<Location> getBody() {
        return null; // Fix this.
    }

    /**
     * Change the direction the snake is facing.
     */
    public void changeDirection() {
        // Write this.  You will need to add an argument to this method.
    }

    /**
     * Increase the length of this snake by 1.  This is done by using the same logic
     * as moving the snake, but don't remove the last item in the arraylist.
     */
    public void grow() {
        // Write this method.
    }

    /**
     * Advance the snake 1 position in the direction it is facing.  This is done
     * by adding a new first item in the arraylist (a new "head" of the snake) and removing
     * the last item in the arraylist.  The position of the new head is calculated from
     * the direction the snake is facing.
     */
    public void move() {
        // Write this method.
    }

    public String toString() {
        return "Aaah a snake!";
    }
}
