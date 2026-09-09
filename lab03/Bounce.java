package lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import graphics.SimpleCanvas;

public class Bounce {
    public static void simulate() {
        Ball ball = new Ball();

        SimpleCanvas canvas = new SimpleCanvas(500, 500);

        while (true) {
            canvas.clear();
            canvas.drawFilledCircle(ball.getPosition(), 200, 5);
            canvas.show();
            canvas.pause(10);

            ball.step();
        }
    }
    
    // do a simulation using the file input.txt.
    public static void simulateFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("lab03/input.txt"));
        int numBalls = scanner.nextInt();

        System.out.println(numBalls);
        scanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        simulate();
    }
}