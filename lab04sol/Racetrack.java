package lab04sol;

import graphics.SimpleCanvas;
import java.awt.*;

/**
 * A Racetrack contains a description of a racetrack that cars may drive on.
 * It holds details about the track, the cars, the flags on the track, and it
 * has the ability to draw itself on a SimpleCanvas.
 */
public class Racetrack {
    /**
     * The layout of the track the cars will drive on.
     * Asterisks (*) are the road, periods (.) are grass (don't drive on the grass!)
     * and "P" is a powerup (ignore powerups until needed in the lab).
     */
    private char[][] trackDiagram;

    /**
     * The positions of any flags on the track.  Must be same dimensions as the
     * track diagram.  Can ignore until needed in the lab.
     */
    private int[][] flagPositions;

    /**
     * An array of cars that will drive around the track.
     */
    private Car[] cars;

    /**
     * The Canvas on which we will draw the cars.
     */
    private SimpleCanvas canvas;

    /**
     * Some constants controlling the size of each square on the canvas,
     * and the time to pause between drawing the state of the track.
     */
    private static int SQUARESIZE = 40;

    /**
     * Initialize a new racetrack.  You must specify the number of cars that will
     * race, and the track itself.
     */
    public Racetrack(int numCars, char[][] track) {
        cars = new Car[numCars];
        trackDiagram = track;
        flagPositions = new int[track.length][track[0].length];

        canvas = new SimpleCanvas(
                track[0].length * SQUARESIZE,
                track.length * SQUARESIZE, "Self-Driving Car Race");
        canvas.show();
    }

    /**
     * Add a car to the track.  You must specify the index in the car array.
     */
    public void addCar(int index, Car c) {
        cars[index] = c;
    }

    /**
     * Add a flag to the track.
     */
    public void addFlagToTrack(int row, int col, int flagNumber) {
        flagPositions[row][col] = flagNumber;
    }

    /**
     * Start the race.
     */
    public void startRace() {
        int PAUSETIME = 500; // time to pause between drawings of the canvas

        System.out.println("Start your engines!");
        draw(canvas);
        canvas.pause(PAUSETIME);

        while (true) {
            // move each car
            for (int i = 0; i < cars.length; i++) {
                Car currentCar = cars[i];
                int timesToDrive = currentCar.getSpeed();

                for (int j = 0; j < timesToDrive; j++) {
                    System.out.println("Driving " + currentCar);
                    int currentRow = currentCar.getRow();
                    int currentCol = currentCar.getCol();

                    // check for power-ups (Uncomment code here when asked).
                    if (trackDiagram[currentRow][currentCol] == 'P') {
                        System.out.println("Powerup for car " + currentCar);
                        currentCar.powerup();
                    }

                    // get the track info for the four cardinal directions around this car
                    char northOfMe = trackDiagram[currentRow - 1][currentCol];
                    char southOfMe = trackDiagram[currentRow + 1][currentCol];
                    char eastOfMe = trackDiagram[currentRow][currentCol + 1];
                    char westOfMe = trackDiagram[currentRow][currentCol - 1];

                    // Get the flag info for the four cardinal directions around this car
                    // (Add this code when asked).

                    // figure out which direction this car is facing,
                    // get the info from each camera, and ask the car where it wants to go
                    char carDirection = currentCar.getDirection();
                    int desiredMove = 0;  // what direction does the car want to go?

                    if (carDirection == 'N') { // left = west, ahead = north, right = east
                        desiredMove = currentCar.drive(westOfMe, northOfMe, eastOfMe);
                    } else if (carDirection == 'S') { // left = east, ahead = south, right = west
                        desiredMove = currentCar.drive(eastOfMe, southOfMe, westOfMe);
                    } else if (carDirection == 'E') { // left = north, ahead = east, right = south
                        desiredMove = currentCar.drive(northOfMe, eastOfMe, southOfMe);
                    } else if (carDirection == 'W') { // left = south, ahead = west, right = north
                        desiredMove = currentCar.drive(southOfMe, westOfMe, northOfMe);
                    }

                    // Convert the car's desired move (0, 1, or -1) into a direction (N, S, E, W).
                    String directionsToRight = "NESW";
                    int currentDir = directionsToRight.indexOf(carDirection);
                    int newDir = (currentDir + desiredMove + 4) % 4;
                    char desiredDir = directionsToRight.charAt(newDir);

                    // move the car according to what the car wanted to do
                    if (desiredDir == 'N') {
                        currentCar.setLocation(currentRow - 1, currentCol);
                    } else if (desiredDir == 'S') {
                        currentCar.setLocation(currentRow + 1, currentCol);
                    } else if (desiredDir == 'E') {
                        currentCar.setLocation(currentRow, currentCol + 1);
                    } else if (desiredDir == 'W') {
                        currentCar.setLocation(currentRow, currentCol - 1);
                    }
                    currentCar.setDirection(desiredDir);

                    draw(canvas);
                    canvas.pause(PAUSETIME);
                }
            }
        }
    }

    /**
     * Draw the track and cars on the canvas.
     */
    private void draw(SimpleCanvas canvas) {
        canvas.clear();

        // draw track and surface
        for (int row = 0; row < trackDiagram.length; row++) {
            for (int col = 0; col < trackDiagram[row].length; col++) {
                if (trackDiagram[row][col] == '.')  // open area (draw as green)
                {
                    canvas.setPenColor(Color.GREEN);
                    canvas.drawFilledRectangle(col * SQUARESIZE, row * SQUARESIZE, SQUARESIZE, SQUARESIZE);
                } else if (trackDiagram[row][col] == '*')  // road (draw as black)
                {
                    canvas.setPenColor(Color.BLACK);
                    canvas.drawFilledRectangle(col * SQUARESIZE, row * SQUARESIZE, SQUARESIZE, SQUARESIZE);
                } else if (trackDiagram[row][col] == 'P')  // power-up (draw as yellow)
                {
                    canvas.setPenColor(Color.YELLOW);
                    canvas.drawFilledRectangle(col * SQUARESIZE, row * SQUARESIZE, SQUARESIZE, SQUARESIZE);
                }

                if (flagPositions[row][col] != 0) {
                    canvas.setPenColor(Color.WHITE);
                    canvas.drawStringCentered(col * SQUARESIZE + SQUARESIZE / 2, row * SQUARESIZE + SQUARESIZE / 2,
                            String.valueOf(flagPositions[row][col]), 16);
                }
            }
        }

        // draw cars
        for (int i = 0; i < cars.length; i++) {
            Car currentCar = cars[i];
            canvas.setPenColor(currentCar.getColor());
            int carRow = currentCar.getRow();
            int carCol = currentCar.getCol();
            char carDirection = currentCar.getDirection();

            // draw triangle representing the car
            int basePointX = carCol * SQUARESIZE;
            int basePointY = carRow * SQUARESIZE;
            int half = SQUARESIZE / 2;

            if (carDirection == 'N') {
                canvas.drawFilledPolygon(
                        new int[]{basePointX + half, basePointX + SQUARESIZE, basePointX},
                        new int[]{basePointY, basePointY + SQUARESIZE, basePointY + SQUARESIZE});
            } else if (carDirection == 'S') {
                canvas.drawFilledPolygon(
                        new int[]{basePointX, basePointX + SQUARESIZE, basePointX + half},
                        new int[]{basePointY, basePointY, basePointY + SQUARESIZE});
            } else if (carDirection == 'E') {
                canvas.drawFilledPolygon(
                        new int[]{basePointX, basePointX + SQUARESIZE, basePointX},
                        new int[]{basePointY, basePointY + half, basePointY + SQUARESIZE});
            } else if (carDirection == 'W') {
                canvas.drawFilledPolygon(
                        new int[]{basePointX + SQUARESIZE, basePointX, basePointX + SQUARESIZE},
                        new int[]{basePointY, basePointY + half, basePointY + SQUARESIZE});
            }
        }

        canvas.update();
    }
}
