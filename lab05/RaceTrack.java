package lab05;

import graphics.SimpleCanvas;
import java.awt.*;

public class RaceTrack {
    private char[][] trackDiagram;
    private int[][] flagPositions;
    private Car[] cars;
    private SimpleCanvas canvas;

    private static int SQUARESIZE = 40;

    public RaceTrack(int numCars, char[][] track) {
        cars = new Car[numCars];
        trackDiagram = track;
        flagPositions = new int[track.length][track[0].length];

        canvas = new SimpleCanvas(track[0].length * SQUARESIZE, track.length * SQUARESIZE);
        canvas.show();
    }

    public void addCar(int pos, Car c) {
        cars[pos] = c;
    }

    public void addFlagToTrack(int row, int col, int flagNumber) {
        flagPositions[row][col] = flagNumber;
    }

    public void startCars() {
        int PAUSETIME = 500;
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

                    // get the track info for the four cardinal directions around this car
                    char roadNorthOfMe = trackDiagram[currentRow - 1][currentCol];
                    char roadSouthOfMe = trackDiagram[currentRow + 1][currentCol];
                    char roadEastOfMe = trackDiagram[currentRow][currentCol + 1];
                    char roadWestOfMe = trackDiagram[currentRow][currentCol - 1];

                    // get the car info for the four cardinal directions around this car
                    Car carNorthOfMe = getCarAtLocation(currentRow - 1, currentCol);
                    Car carSouthOfMe = getCarAtLocation(currentRow + 1, currentCol);
                    Car carEastOfMe = getCarAtLocation(currentRow, currentCol + 1);
                    Car carWestOfMe = getCarAtLocation(currentRow, currentCol - 1);

                    // get the flag info
                    int flagNorthOfMe = flagPositions[currentRow - 1][currentCol];
                    int flagSouthOfMe = flagPositions[currentRow + 1][currentCol];
                    int flagEastOfMe = flagPositions[currentRow][currentCol + 1];
                    int flagWestOfMe = flagPositions[currentRow][currentCol - 1];

                    // configure cameras (only 3 of these actually exist for the car, the other one will be ignored)
                    CameraView viewNorthOfMe = new CameraView(roadNorthOfMe, carNorthOfMe);
                    CameraView viewSouthOfMe = new CameraView(roadSouthOfMe, carSouthOfMe);
                    CameraView viewEastOfMe = new CameraView(roadEastOfMe, carEastOfMe);
                    CameraView viewWestOfMe = new CameraView(roadWestOfMe, carWestOfMe);

                    // figure out which direction this car is facing,
                    // get the info from each camera, and ask the car where it wants to go
                    char carDirection = currentCar.getDirection();
                    int desiredMove = 0;

                    if (carDirection == 'N') { // left = west, ahead = north, right = east
                        desiredMove = currentCar.drive(viewWestOfMe, viewNorthOfMe, viewEastOfMe);
                    } else if (carDirection == 'S') { // left = east, ahead = south, right = west
                        desiredMove = currentCar.drive(viewEastOfMe, viewSouthOfMe, viewWestOfMe);
                    } else if (carDirection == 'E') { // left = north, ahead = east, right = south
                        desiredMove = currentCar.drive(viewNorthOfMe, viewEastOfMe, viewSouthOfMe);
                    } else if (carDirection == 'W') { // left = south, ahead = west, right = north
                        desiredMove = currentCar.drive(viewSouthOfMe, viewWestOfMe, viewNorthOfMe);
                    }

                    String directionsToRight = "NESW";
                    int currentDir = directionsToRight.indexOf(carDirection);
                    int newDir = (currentDir + desiredMove + 4) % 4;
                    char desiredDir = directionsToRight.charAt(newDir);

                    // move the car according to what the car wants to do
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
                    canvas.pause(PAUSETIME / 2);

                    // detect crashes: loop through cars and look for row/col matches
                    for (int k = 0; k < cars.length; k++) {
                        // don't compare ourselves to ourselves
                        if (cars[k] == currentCar) {
                            continue;
                        } else if (cars[k].getRow() == currentCar.getRow() && cars[k].getCol() == currentCar.getCol()) {
                            currentCar.crashInto(cars[k]);
                        }
                    }

                    draw(canvas);
                    canvas.pause(PAUSETIME / 2);
                }
            }
        }
    }

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

            // draw circle or triangle representing the car
            int basePointX = carCol * SQUARESIZE;
            int basePointY = carRow * SQUARESIZE;
            int half = SQUARESIZE / 2;

            if (currentCar.isBroken()) {  // if broken, draw as circle
                canvas.drawFilledCircle(basePointX + half, basePointY + half, half);
            } else if (carDirection == 'N') { // if not broken, draw as triangle
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

    private Car getCarAtLocation(int row, int col) {
        // look for a car at this new location
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getRow() == row && cars[i].getCol() == col) {
                return cars[i];
            }
        }
        return null;
    }
}
