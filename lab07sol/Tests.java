package lab07sol;

public class Tests {
    public static void main(String[] args) {
        testMove();
    }

    public static void testToString() {
        Location loc = new Location(3, 5);
        Snake snake = new Snake(loc);
        System.out.println(snake);

        Location loc2 = new Location(8, 2);
        Snake snake2 = new Snake(loc2);
        System.out.println(snake2);
    }

    public static void testMove() {
        Location loc = new Location(1, 4);
        Snake snake = new Snake(loc);
        System.out.println(snake);
        snake.grow();
        System.out.println(snake);
        snake.grow();
        System.out.println(snake);
        snake.changeDirection(Direction.RIGHT);
        System.out.println(snake);
        snake.grow();
        System.out.println(snake);
        snake.move();
        System.out.println(snake);
        snake.grow();
        System.out.println(snake);
        snake.changeDirection(Direction.DOWN);
        System.out.println(snake);
        snake.move();
        System.out.println(snake);
        snake.grow();
        System.out.println(snake);
        snake.move();
        System.out.println(snake);
    }
}
