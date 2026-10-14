package lab07;

public class Tests {
    public static void main(String[] args) {
        testToString();
    }

    public static void testToString() {
        Location loc = new Location(3, 5);
        Snake snake = new Snake(loc);
        System.out.println(snake);

        Location loc2 = new Location(8, 2);
        Snake snake2 = new Snake(loc2);
        System.out.println(snake2);
    }
}
