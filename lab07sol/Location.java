package lab07sol;

public class Location {
    private final int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Location other) {
        return (other.x == x && other.y == y);
    }

    // get the adjacent Location in the given direction.
    public Location adjacent(Direction direction) {
        if (direction == Direction.UP) {
            return new Location(x, y - 1);
        } else if (direction == Direction.DOWN) {
            return new Location(x, y + 1);
        } else if (direction == Direction.LEFT) {
            return new Location(x - 1, y);
        } else {
            return new Location(x + 1, y);
        }
    }
}
