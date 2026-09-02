package lab02sol;

import graphics.SimpleCanvas;

import java.awt.Color;

public class Fireworks {
    public static void main(String[] args) {
        SimpleCanvas c = new SimpleCanvas(1000, 1000, "Fireworks");
        c.setBackgroundColor(Color.BLACK);
        c.clear();

        for (int i = 0; i < 20; i++) {
            // randomly choose an (x, y) point for the explosion:
            // - `x` is in [200, 800], `y` is in [200, 400].
            // - make `x` & `y` multiples of 10 for `drawLineAnimated()`.
            int x = 500 + 10 * randomInt(-30, 30);
            int y = 300 + 10 * randomInt(-10, 10);

            c.setPenColor(randomColor());
            drawLineAnimated(c, 500, 800, x, y);

            // randomly decide between dots & tree.
            if (Math.random() < 0.5) {
                dots(c, x, y, randomInt(40, 60));
            } else {
                tree(c, x, y);
            }
            
            c.pause(randomInt(400, 600));
        }
    }

    /**
     * Draw a single firework as a cluster of dots.
     */
    public static void dots(SimpleCanvas c, int x, int y, int radius) {
        for (int i = 0; i < 50; i++) {
            int dx = randomInt(-radius, radius);
            int dy = randomInt(-radius, radius);

            // make sure (x + dx, y + dy) is within `radius` of (x, y).
            if (dx * dx + dy * dy <= radius * radius) {
                c.drawFilledCircle(x + dx, y + dy, 3);
                c.show();
                c.pause(10);
            }
        }
    }

    /**
     * Draw a single firework as a tree of lines.
     */
    public static void tree(SimpleCanvas c, int x, int y) {

        c.pause(100);

        // store the branch coordinates in arrays.
        int[] xs = new int[10];
        int[] ys = new int[10];
        for (int i = 0; i < 10; i++) {
            // calculate a random angle; note angles are in radians.
            double angle = Math.random() * 2 * Math.PI;
            int radius = randomInt(40, 80);

            // convert polar coordinates to rectangular.
            xs[i] = x + (int) (radius * Math.cos(angle));
            ys[i] = y + (int) (radius * Math.sin(angle));
            c.drawLine(x, y, xs[i], ys[i]);
        }

        // show first stage of branching, then pause.
        c.show();
        c.pause(200);

        // handle second stage of branching.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                // calculate a random angle; note angles are in radians.
                double angle = Math.random() * 2 * Math.PI;
                int radius = randomInt(20, 30);

                // convert polar coordinates to rectangular.
                int x2 = xs[i] + (int) (radius * Math.cos(angle));
                int y2 = ys[i] + (int) (radius * Math.sin(angle));
                c.drawLine(xs[i], ys[i], x2, y2);
            }
        }

        c.show();
    }

    /**
     * Draw an animated line in 10 parts from (x1, y1) to (x2, y2).
     * 
     * Note: `x2 - x1` and `y2 - y1` should be multiples of 10.
     */
    public static void drawLineAnimated(SimpleCanvas c, int x1, int y1, int x2, int y2) {
        int dx = (x2 - x1) / 10;
        int dy = (y2 - y1) / 10;

        for (int i = 0; i < 10; i++) {
            c.drawLine(x1 + i * dx, y1 + i * dy, x1 + (i + 1) * dx, y1 + (i + 1) * dy);
            c.show();
            c.pause(10);
        }
    }

    /**
     * Generate a random integer between min & max, inclusive.
     */
    public static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /**
     * Generate a random color from a handful of options; exclude black & gray.
     */
    public static Color randomColor() {
        int i = randomInt(0, 8);

        if (i == 0) {
            return Color.WHITE;
        } else if (i == 1) {
            return Color.RED;
        } else if (i == 2) {
            return Color.ORANGE;
        } else if (i == 3) {
            return Color.YELLOW;
        } else if (i == 4) {
            return Color.GREEN;
        } else if (i == 5) {
            return Color.CYAN;
        } else if (i == 6) {
            return Color.BLUE;
        } else if (i == 7) {
            return Color.MAGENTA;
        } else {
            return Color.PINK;
        }
    }
}
