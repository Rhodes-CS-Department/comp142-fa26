package lab09sol;

import graphics.SimpleCanvas;

public class Tree {

    // Draws a line from p to q.
    public static void drawLine(SimpleCanvas canvas, Point p, Point q) {
        canvas.drawLine((int) p.getX(), (int) p.getY(), (int) q.getX(), (int) q.getY());
        canvas.show();
        canvas.pause(10);
    }

    // Draws a binary tree with n levels, with `root` at the top center.
    public static void btree(SimpleCanvas canvas, Point root, double width, double height, int n) {
        if (n > 0) {
            Point left = new Point(root.getX() - width / 4, root.getY() + height / 2);
            Point right = new Point(root.getX() + width / 4, root.getY() + height / 2);
            drawLine(canvas, root, left);
            drawLine(canvas, root, right);
            btree(canvas, left, width / 2, height / 2, n - 1);
            btree(canvas, right, width / 2, height / 2, n - 1);
        }
    }

    // Draws an H-tree with n levels.
    // Start with a horizontal line of given width centered at `center`.
    public static void htree(SimpleCanvas canvas, Point center, double width, int n) {
        if (n > 0) {
            Point left = new Point(center.getX() - width / 2, center.getY());
            Point right = new Point(center.getX() + width / 2, center.getY());
            drawLine(canvas, left, right);
            vtree(canvas, left, width / Math.sqrt(2), n - 1);
            vtree(canvas, right, width / Math.sqrt(2), n - 1);
        }
    }

    // Draws an H-tree with n levels.
    // Start with a vertical line of given height centered at `center`.
    public static void vtree(SimpleCanvas canvas, Point center, double height, int n) {
        if (n > 0) {
            Point top = new Point(center.getX(), center.getY() - height / 2);
            Point bottom = new Point(center.getX(), center.getY() + height / 2);
            drawLine(canvas, top, bottom);
            htree(canvas, top, height / Math.sqrt(2), n - 1);
            htree(canvas, bottom, height / Math.sqrt(2), n - 1);
        }
    }

    public static void main(String[] args) {
        SimpleCanvas canvas = new SimpleCanvas(1000, 1000);

        btree(canvas, new Point(500, 100), 800, 800, 8);
        // htree(canvas, new Point(500, 500), 500, 10);
        canvas.show();
    }

}
