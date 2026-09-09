package lab03sol;

import graphics.SimpleCanvas;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bounce {
    public static void simulate() {
        Ball[] ball = new Ball[10];
        boolean[] infected = new boolean[10];
        infected[0] = true;

        for (int i = 0; i < 10; i++) {
            ball[i] = new Ball(500, 500);
        }

        SimpleCanvas c = new SimpleCanvas(500, 500);

        while (true) {
            c.clear();

            for (int i = 0; i < 10; i++) {
                if (infected[i]) {
                    c.setPenColor(Color.RED);
                } else {
                    c.setPenColor(Color.BLACK);
                }

                c.drawFilledCircle(ball[i].getPositionX(), ball[i].getPositionY(), 5);
            }

            c.show();
            c.pause(10);

            for (Ball b : ball) {
                b.step();
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (infected[i] && ball[i].collide(ball[j])) {
                        infected[j] = true;
                    }
                }
            }
        }
    }

    public static void simulateFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("lab03/input.txt"));
        int numBalls = scanner.nextInt();
        
        Ball[] ball = new Ball[numBalls];
        for (int i = 0; i < numBalls; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int dx = scanner.nextInt();
            int dy = scanner.nextInt();
            ball[i] = new Ball(500, 500, x, y, dx, dy);
        }

        SimpleCanvas c = new SimpleCanvas(500, 500);

        while (true) {
            c.clear();

            for (int i = 0; i < numBalls; i++) {
                c.drawFilledCircle(ball[i].getPositionX(), ball[i].getPositionY(), 5);
            }

            c.show();
            c.pause(15);

            for (Ball b : ball) {
                b.step();
            }
        }

    }
    
    public static void main(String[] args) throws FileNotFoundException {
        simulateFile();
    }
}