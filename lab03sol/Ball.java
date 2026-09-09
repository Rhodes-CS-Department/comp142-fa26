package lab03sol;

public class Ball {
    
    // position of ball
    private int x;
    private int y;

    // velocity of ball
    private int dx;
    private int dy;

    // width of canvas
    private int width;
    private int height;

    // construct a random Ball with given canvas width.
    public Ball(int myWidth, int myHeight) {
        width = myWidth;
        height = myHeight;
        x = (int) (Math.random() * width);
        y = (int) (Math.random() * height);
        dx = (int) (Math.random() * 10 + 1);
        dy = (int) (Math.random() * 10 + 1);
    }

    public Ball(int width, int height, int x, int y, int dx, int dy) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    // let the ball move one time step.
    public void step() {
        x += dx;
        y += dy;
        
        // make the ball bounce off the sides.
        if (x < 0) {
            x = -x;
            dx = -dx;
        } else if (x > width) {
            x = width - (x - width);
            dx = -dx;
        }

        if (y < 0) {
            y = -y;
            dy = -dy;
        } else if (y > height) {
            y = height - (y - height);
            dy = -dy;
        }
    }

    // get the current position of the ball.
    public int getPositionX() {
        return x;
    }

    public int getPositionY() {
        return y;
    }

    public boolean collide(Ball other) {
        return Math.abs(x - other.getPositionX()) <= 5
          && Math.abs(y - other.getPositionY()) <= 5;
    }
}
