package lab04;

public class RaceDemos {

    public static void main(String[] args) {
        demo1();
        //demo2();
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
        Racetrack track = new Racetrack(1, trackLayout);

        // lower right corner is 5, 8

        Car myCar = new Car();
        myCar.setLocation(5, 8);
        myCar.setDirection('N');
        myCar.setSpeed(1);
        track.addCar(0, myCar);

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
