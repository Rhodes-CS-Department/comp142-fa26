package lab10;

/**
 * This class represents a fish living in a fishbowl (a canvas).
 * Fish are drawn as pictures on a canvas.  The pictures are always square.
 */
public class Fish {
    /**
     * The size of the fish (length of one side of the square picture of the fish).
     */
    private int size;

    /**
     * Location of the fish on the canvas (x, y).
     */
    private int locx, locy;

    /**
     * Speed of the fish when it moves --- how many pixels it changes in x- and y-directions.
     */
    private int speedx, speedy;

    /**
     * Constructor.
     */
    public Fish(int size, int locx, int locy) {
        this.size = size;
        this.locx = locx;
        this.locy = locy;
        this.speedx = (int) (Math.random() * 5 + 1);
        this.speedy = (int) (Math.random() * 5 + 1);
    }

    /**
     * Return the x coordinate of the location of the fish.
     */
    public int getLocationX() {
        return locx;
    }

    /**
     * Return the y coordinate of the location of the fish.
     */
    public int getLocationY() {
        return locy;
    }

    /**
     * Return the size the fish.
     */
    public int getSize() {
        return size;
    }

    /**
     * Return the number of points earned when catching the fish.
     */
    public int getPoints() {
        return 100 / size;
    }

    /**
     * Move the fish on the canvas according to the speedx/y variables.
     */
    public void move(int canvasWidth, int canvasHeight) {
        // update location
        locx += speedx;
        locy += speedy;

        // check for hitting walls
        if (locx + size >= canvasWidth) {
            speedx = -(int) (Math.random() * 5) - 1;
        }
        if (locx <= 0) {
            speedx = (int) (Math.random() * 5) + 1;
        }
        if (locy + size >= canvasHeight) {
            speedy = -(int) (Math.random() * 5) - 1;
        }
        if (locy <= 0) {
            speedy = (int) (Math.random() * 5) + 1;
        }
    }

    /**
     * Get the name of the image that holds the picture of the fish.
     */
    public String getImageFilename() {
        return "lab10/bluefish.png";
    }

    /**
     * Determine if a click on the canvas is within the boundaries
     * of this fish's picture on the canvas.
     */
    public boolean isClickWithinBoundary(int clickx, int clicky) {
        return clickx >= locx && clickx <= locx + size &&
                clicky >= locy && clicky <= locy + size;
    }

    public String toString() {
        return "Fish: size=" + size + " x=" + locx + " y=" + locy
                + " speedx=" + speedx + " speedy=" + speedy;
    }
}
