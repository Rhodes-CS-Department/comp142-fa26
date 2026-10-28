package lab09sol;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Returns the point halfway between p and q.
    public static Point midpoint(Point p, Point q) {
        return new Point((p.x + q.x) / 2, (p.y + q.y) / 2);
    }
}
