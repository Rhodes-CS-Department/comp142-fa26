package lab05;

import java.awt.*;

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
                ".*.****.*.",
                ".*.*..*.*.",
                ".*.*..*.*.",
                ".***..***.",
                ".........."
        };

        char[][] trackLayout = to2DCharArray(trackString);
        RaceTrack track = new RaceTrack(2, trackLayout);

        Car myCar = new Car(Color.RED);
        myCar.setLocation(1, 8);
        myCar.setDirection('W');
        track.addCar(0, myCar);

        Car myCar2 = new Car(Color.BLUE);
        myCar2.setLocation(1, 1);
        myCar2.setDirection('E');
        track.addCar(1, myCar2);

        track.startCars();
    }

    public static void demo2() {
        String[] trackString = new String[]{
                "..........",
                ".********.",
                ".*......*.",
                ".********.",
                ".********.",
                ".*......*.",
                ".********.",
                ".........."
        };

        char[][] trackLayout = to2DCharArray(trackString);
        RaceTrack track = new RaceTrack(1, trackLayout);
        track.addFlagToTrack(3, 2, 1);
        track.addFlagToTrack(4, 8, 2);
        track.addFlagToTrack(4, 2, 3);
        track.addFlagToTrack(3, 8, 4);

        Car myCar = new Car(Color.YELLOW);
        myCar.setLocation(5, 8);
        myCar.setDirection('S');
        track.addCar(0, myCar);

        //Car myCar2 = new Car(Color.MAGENTA);
        //myCar2.setLocation(5, 8);
        //myCar2.setDirection('N');
        //track.addCar(1, myCar2);

        track.startCars();
    }

    public static char[][] to2DCharArray(String[] array) {
        char[][] newArray = new char[array.length][];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i].toCharArray();
        }
        return newArray;
    }
}
