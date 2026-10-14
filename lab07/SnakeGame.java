package lab07;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import graphics.SimpleCanvas;

public class SnakeGame {
    private Snake snake1;   // the snake object on the board
    private Location appleLoc;  // the position of the "apple" a snake wants to eat
    private int numRows, numCols;  // dimensions of the board
    private SimpleCanvas canvas;  // the canvas itself
    private final int SQUARESIZE = 25;  // size of a "square" on the canvas

    // Variables controlling game speed:
    private final int GAMESPEED = 5; // set this LOWER to have the snake move faster
    private int snakeUpdateCounter = 0;

    public SnakeGame(int rows, int cols) {
        // initialize the number of rows and columns
        numCols = cols;
        numRows = rows;

        // initialize the snake and the apple starting location
        snake1 = new Snake(new Location(cols/2, rows/2));
        appleLoc = new Location((int)(Math.random() * cols), (int)(Math.random() * rows));

        // initialize canvas
        canvas = new SimpleCanvas(cols * SQUARESIZE, rows * SQUARESIZE);
        canvas.setBackgroundColor(Color.BLACK);
        canvas.show();
    }

    /**
     * Draw the state of the game on the canvas.
     */
    public void draw() {
        canvas.clear(); // always clear first.

        // Draw snake 1:
        ArrayList<Location> snake1Body = snake1.getBody();
        canvas.setPenColor(Color.GREEN);  // change the snake's color if you want.

        // Use a loop to iterate over the body of snake 1, get the location
        // of each "segment" of the body, and draw a filled rectangle for that "segment."
        // Hint: the drawing command will look similar to this:
        //   canvas.drawFilledRectangle(xLocation * SQUARESIZE, yLocation * SQUARESIZE, SQUARESIZE, SQUARESIZE);
        //   where xLocation and yLocation are the (x, y) coordinates on the board of the
        //   current snake segment.

        // Draw apple:
        canvas.setPenColor(Color.RED);
        canvas.drawFilledCircle(appleLoc.getX() * SQUARESIZE + SQUARESIZE/2,
                appleLoc.getY() * SQUARESIZE + SQUARESIZE/2, SQUARESIZE/2);

        canvas.update();  // always update last.
    }

    /**
     * Start the game running.
     */
    public void runGame() {
        // Create starting screen
        draw();
        canvas.setPenColor(Color.WHITE);
        canvas.drawString(10, 10, "Click canvas to start!");
        canvas.update();
        canvas.waitForClick();

        // Loop while the game is not over:
        boolean keepPlaying = true;
        while (keepPlaying) {

            // handle keyboard
            handleKeyboard();

            // update the state of the game:
            //   when the snake update counter is equal to game speed, we move the snake on the board and reset the counter
            //   otherwise, we just increment the counter.
            // (This is necessary because we need to check the status of the keyboard relatively frequently (every 20ms),
            //   but we don't want the snake to move that fast.)

            if (snakeUpdateCounter == GAMESPEED) {  // time to move the snake on the board
                //snake1.move();  // move the snake
                snakeUpdateCounter = 0;   // reset the snake update counter

                // Detect snake 1 eating apple

                // Detect snake 1 collision with wall

                // Detect snake 1 collision with self


            }
            else {
                snakeUpdateCounter++;
            }

            // draw the state of the game
            draw();

            canvas.pause(20); // freeze for a split-second so the animation works.
        }
    }

    private void handleKeyboard() {
        // Snake 1 controls:
        if (canvas.isKeyPressed(KeyEvent.VK_UP)) {
            System.out.println("up arrow pressed");

        }
        if (canvas.isKeyPressed(KeyEvent.VK_DOWN)) {
            System.out.println("down arrow pressed");

        }
        if (canvas.isKeyPressed(KeyEvent.VK_LEFT)) {
            System.out.println("left arrow pressed");

        }
        if (canvas.isKeyPressed(KeyEvent.VK_RIGHT)) {
            System.out.println("right arrow pressed");

        }

        // Snake 2 controls:
        if (canvas.isKeyPressed(KeyEvent.VK_W)) {
            System.out.println("'W' key pressed");

        }
        if (canvas.isKeyPressed(KeyEvent.VK_S)) {
            System.out.println("'S' key pressed");

        }
        if (canvas.isKeyPressed(KeyEvent.VK_A)) {
            System.out.println("'A' key pressed");

        }
        if (canvas.isKeyPressed(KeyEvent.VK_D)) {
            System.out.println("'D' pressed");

        }
    }
}
