package lab09sol;

import graphics.SimpleCanvas;

public class Sierpinski {

    // Draws a Sierpinski triangle with n levels, whose corners are p, q, and r.
    public static void sierpinski(SimpleCanvas canvas, Point p, Point q, Point r, int n) {
        if (n == 0) {
            int[] xs = {(int) p.getX(), (int) q.getX(), (int) r.getX()};
            int[] ys = {(int) p.getY(), (int) q.getY(), (int) r.getY()};
            canvas.drawFilledPolygon(xs, ys);
        } else {
            Point pq = Point.midpoint(p, q);
            Point qr = Point.midpoint(q, r);
            Point rp = Point.midpoint(r, p);
            sierpinski(canvas, p, pq, rp, n - 1);
            sierpinski(canvas, q, qr, pq, n - 1);
            sierpinski(canvas, r, rp, qr, n - 1);
        }
    }

    public static void main(String[] args) {
        SimpleCanvas canvas = new SimpleCanvas(500, 500);
        Point p = new Point(250, 250 - 100 * Math.sqrt(3));
        Point q = new Point(50, 250 + 100 * Math.sqrt(3));
        Point r = new Point(450, 250 + 100 * Math.sqrt(3));

        sierpinski(canvas, p, q, r, 7);
        canvas.show();
    }

}
