package lab10;

public class Car {
    private int topSpeed, currentSpeed;
    private double totalDistanceTraveled;

    public Car(int topSpeed) {
        this.topSpeed = topSpeed;
        currentSpeed = 0;
        totalDistanceTraveled = 0;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double getDistance() {
        return totalDistanceTraveled;
    }

    public void setDistance(double totalDistanceTraveled) {
        this.totalDistanceTraveled = totalDistanceTraveled;
    }

    /**
     * Drive the car for one second of time.
     */
    public void drive() {
        if (currentSpeed + 5 <= topSpeed) {
            currentSpeed += 5;
        }

        System.out.println("Driving regular car at " + currentSpeed + " mph.");

        // 1 mph = 0.0002777 miles per second
        totalDistanceTraveled += currentSpeed * 0.0002777;
    }
}
