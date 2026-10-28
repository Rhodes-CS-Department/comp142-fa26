package lab09;

import graphics.SimpleCanvas;

public class Tree {

    // Draws a line from p to q.
    public static void drawLine(SimpleCanvas canvas, Point p, Point q) {
    }

    // Draws a binary tree with n levels, with `root` at the top center.
    public static void btree(SimpleCanvas canvas, Point root, double width, double height, int n) {
    }

    // Draws an H-tree with n levels.
    // Start with a horizontal line of given width centered at `center`.
    public static void htree(SimpleCanvas canvas, Point center, double width, int n) {
    }

    // Draws an H-tree with n levels.
    // Start with a vertical line of given height centered at `center`.
    public static void vtree(SimpleCanvas canvas, Point center, double height, int n) {
    }

    public static void main(String[] args) {
        SimpleCanvas canvas = new SimpleCanvas(1000, 1000);

        canvas.show();
    }

}
