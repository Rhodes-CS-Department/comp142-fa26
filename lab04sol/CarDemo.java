package lab04sol;

public class CarDemo {
    public static void main(String[] args) {
        // Let's get used to our new self-driving racecar class!
        Car racecar1 = new Car();
        racecar1.setLocation(2, 5);
        racecar1.setDirection('S');
        racecar1.setSpeed(3);

        Car racecar2 = new Car();
        racecar2.setLocation(6, 2);
        racecar2.setDirection('W');
        racecar2.setSpeed(5);

        System.out.println("Here are some details about our car: ");
        System.out.println(racecar1);
        System.out.println(racecar2);
    }
}
