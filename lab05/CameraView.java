package lab05;

/**
 * A CameraView represents the view from one of the three
 * cameras mounted on a self-driving car.
 */
public class CameraView {
    // instance variables:
    private char ground;
    private Car car;

    // methods:

    /**
     * Construct a new CameraView object.
     */
    public CameraView(char theRoad, Car theCar) {
        ground = theRoad;
        car = theCar;
    }

    /**
     * Getter for the road instance variable.
     */
    public char getGround() {
        return ground;
    }

    /**
     * Getter for the car instance variable.
     */
    public Car getCar() {
        return car;
    }
}
