package lab04sol;

public class RaceDemos {

    public static void main(String[] args) {
        //demo1();
        demo2();
    }

    public static void demo1() {
        String[] trackString = new String[]{
                "..........",
                ".********.",
                ".*......*.",
                ".*......*.",
                ".*......*.",
                ".********.",
                ".........."
        };

        char[][] trackLayout = to2DCharArray(trackString);
        Racetrack track = new Racetrack(2, trackLayout);

        // lower right corner is 5, 8

        Car car1 = new Car();
        car1.setLocation(5, 8);
        car1.setDirection('N');
        car1.setSpeed(1);

        Car car2 = new Car();
        car2.setLocation(1, 1);
        car2.setDirection('E');
        car2.setSpeed(2);

        track.addCar(0, car1);
        track.addCar(1, car2);
        track.startRace();
    }

    public static void demo2() {
        String[] trackString = new String[]{
                "..........",
                ".*******P.",
                ".*......*.",
                ".*.****.*.",
                ".*.*..*.*.",
                ".*.*..*.*.",
                ".***..***.",
                ".........."
        };

        char[][] trackLayout = to2DCharArray(trackString);
        Racetrack track = new Racetrack(2, trackLayout);

        Car myCar = new Car();
        myCar.setLocation(1, 1);
        myCar.setDirection('E');
        myCar.setSpeed(1);
        track.addCar(0, myCar);

        Car myCar2 = new Car();
        myCar2.setLocation(6, 8);
        myCar2.setDirection('W');
        myCar2.setSpeed(1);
        track.addCar(1, myCar2);

        track.startRace();
    }

    public static char[][] to2DCharArray(String[] array) {
        char[][] newArray = new char[array.length][];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i].toCharArray();
        }
        return newArray;
    }
}
