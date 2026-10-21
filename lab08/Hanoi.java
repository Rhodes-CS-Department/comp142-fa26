package lab08;

import java.awt.Color;

import graphics.SimpleCanvas;

public class Hanoi {

    public static final int WIDTH = 200;   // distance between poles
    public static final int HEIGHT = 20;   // height of each disk
    public static final int DEFAULT_PAUSE = 1000;

    private int size;
    private int[] pole;
    private int pauseTime;
    private SimpleCanvas canvas;

    public Hanoi(int size, int pauseTime) {
        canvas = new SimpleCanvas(4 * WIDTH, (size + 3) * HEIGHT, "Towers of Hanoi");

        this.size = size;
        pole = new int[size]; // pole[i] = pole (0-2) that disk i is on

        this.pauseTime = pauseTime;

        canvas.show();
        draw();
    }

    public Hanoi(int size) {
        this(size, DEFAULT_PAUSE);
    }

    // draw the current state of the Towers of Hanoi game
    private void draw() {

        int N = pole.length;
        int bottom = canvas.getHeight() - HEIGHT;

        // draw 3 poles
        canvas.clear();
        canvas.setPenColor(Color.BLACK);
        canvas.setLineThickness(2);
        for (int i = 0; i < 3; i++) {
            int x = (i + 1) * WIDTH;
            canvas.drawLine(x, bottom, x, bottom - (N + 1) * HEIGHT);
        }

        // draw N disks
        int[] disks = new int[3]; // disks[p] = # disks on pole p
        for (int i = N - 1; i >= 0; i--) {
            Color color = Color.getHSBColor(1.0f * i / N, .7f, .7f);
            canvas.setPenColor(color);
            int width = (int) (0.9 * WIDTH * (i + 1) / N);
            int p = pole[i];
            int x = (p + 1) * WIDTH - width / 2;
            int y = bottom - (disks[p] + 1) * HEIGHT;
            canvas.drawFilledRectangle(x, y, width, HEIGHT - 2);
            ++disks[p];
        }

        canvas.update();
        canvas.pause(pauseTime);

    }

    // returns the total number of disks in this Hanoi puzzle
    public int getSize() {
        return size;
    }

    // moves disk i to pole p
    // disks are numbered from smallest to largest
    //     0 is the smallest, (size - 1) is the largest
    // poles are numbered from 0 to 2
    // examples:
    //     move(0, 1): moves the smallest disk to the middle pole
    //     move(2, 0): moves the 3rd smallest disk to the left pole
    public void move(int i, int p) {
        int from = pole[i];
        for (int j = 0; j < i; j++) {
            if (pole[j] == from || pole[j] == p) {
                throw new IllegalArgumentException("can't move disk " + i + " to pole " + p
                        + ": disk " + j + " is in the way");
            }
        }
        pole[i] = p;
        draw();
    }

}
