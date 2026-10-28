package lab09;

import graphics.SimpleCanvas;

public class Sierpinski {

    // Draws a Sierpinski triangle with n levels, whose corners are p, q, and r.
    public static void sierpinski(SimpleCanvas canvas, Point p, Point q, Point r, int n) {
    }

    public static void main(String[] args) {
        SimpleCanvas canvas = new SimpleCanvas(500, 500);
        Point p = new Point(250, 250 - 100 * Math.sqrt(3));
        Point q = new Point(50, 250 + 100 * Math.sqrt(3));
        Point r = new Point(450, 250 + 100 * Math.sqrt(3));

        canvas.show();
    }

}
