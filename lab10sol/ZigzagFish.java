package lab10sol;

public class ZigzagFish extends Fish {

    public ZigzagFish(int size, int locx, int locy) {
        super(size, locx, locy);
        pickNewDirection();
    }

    /**
     * Make the ZigzagFish change directions abruptly.
     */
    private void pickNewDirection() {
        setSpeedX((int) (Math.random() * 20) - 10);
        setSpeedY((int) (Math.random() * 20) - 10);
    }

    /**
     * Move like a regular fish, with a 10% chance of changing direction first.
     */
    public void move(int canvasWidth, int canvasHeight) {
        if (Math.random() < 0.1) {
            pickNewDirection();
        }
        super.move(canvasWidth, canvasHeight);
    }

    /**
     * Get the name of the image that holds the picture of the fish.
     */
    public String getImageFilename() {
        return "lab10sol/orangefish.png";
    }

    /**
     * Return the number of points earned when catching the fish.
     */
    public int getPoints() {
        return 2 * super.getPoints();
    }

    public String toString() {
        return "ZigzagFish: size=" + getSize() + " x=" + getLocationX() + " y=" + getLocationY()
                + " speedx=" + getSpeedX() + " speedy=" + getSpeedY();
    }
}
