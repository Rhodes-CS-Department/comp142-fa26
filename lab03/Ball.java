package lab03;

public class Ball {
    
    // position of ball
    private int x;

    // velocity of ball
    private int dx;

    // construct a standard Ball.
    public Ball() {
        x = 250;
        dx = -2;
    }

    // let the ball move one time step.
    public void step() {
        x += dx;
    }

    // get the current position of the ball.
    public int getPosition() {
        return x;
    }

}
