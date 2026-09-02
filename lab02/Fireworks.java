package lab02;

import graphics.SimpleCanvas;

import java.awt.Color;

public class Fireworks {
    public static void main(String[] args) {
        SimpleCanvas c = new SimpleCanvas(1000, 1000, "Fireworks");
        c.setBackgroundColor(Color.BLACK);
        c.clear();

        c.show();
        c.pause(1000);

        c.setPenColor(Color.WHITE);

        // generate a random x-coordinate for a firework explosion.
        int x1 = 200 + (int) (Math.random() * 600);
        c.drawLine(500, 800, x1, 200);

        c.show();
        c.pause(1000);

        // generate another random x-coordinate for a firework explosion.
        int x2 = 200 + (int) (Math.random() * 600);
        c.drawLine(500, 800, x2, 200);

        c.show();
    }
}
