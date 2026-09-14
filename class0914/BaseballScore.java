package class0914;

public class BaseballScore {
    private String homeTeam;
    private String awayTeam;

    private int randomInning() {
        double x = Math.random();

        if (x < 0.72) {
            return 0;
        } else if (x < 0.87) {
            return 1;
        } else if (x < 0.94) {
            return 2;
        } else if (x < 0.97) {
            return 3;
        } else if (x < 0.98) {
            return 4;
        } else if (x < 0.99) {
            return 5;
        } else {
            return 6;
        }
    }

    
    
}