package lab10;

public class CarDemo {

    public static void main(String[] args) {
        Car car1 = new Car(80);   // top speed is 80 mph
        Car car2 = new Car(90);   // top speed is 90 mph

        for (int time = 1; time <= 60; time++) {
            car1.drive();
            car2.drive();
            System.out.println("Time elapsed = " + time + " seconds.");
            System.out.println("Car 1 has traveled " + car1.getDistance() + " miles.");
            System.out.println("Car 2 has traveled " + car2.getDistance() + " miles.");
        }
    }

}
