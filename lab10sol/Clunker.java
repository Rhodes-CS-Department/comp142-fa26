package lab10sol;

public class Clunker extends Car {
    private int numDrives;

    public Clunker() {
        super(50);
        numDrives = 0;
    }

    /**
     * Drive the clunker for one second of time. After three drives, it has broken down.
     */
    public void drive() {
        if (numDrives < 3) {
            numDrives++;

            if (getCurrentSpeed() + 3 <= getTopSpeed()) {
                setCurrentSpeed(getCurrentSpeed() + 3);
            }

            System.out.println("Driving clunker at " + getCurrentSpeed() + " mph.");

            // 1 mph = 0.0002777 miles per second
            setDistance(getDistance() + getCurrentSpeed() * 0.0002777);
        }
    }
}
