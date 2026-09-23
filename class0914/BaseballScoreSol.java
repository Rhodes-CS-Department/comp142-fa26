// this is the code written in class.
package class0914;

public class BaseballScore {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

    public BaseballScore() {
        homeTeam = "HOME";
        awayTeam = "AWAY";
    }

    public BaseballScore(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    // getHomeScore
    public int getHomeScore() {
        return homeScore;
    }
    
    // setHomeScore
    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public void simulate() {
        for (int i = 0; i < 9; i++) {
            homeScore += randomInning();
            awayScore += randomInning();
        }
    }

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

    public String toString() {
        String result = "";
        result += awayTeam + "\t" + awayScore + "\n";
        result += homeTeam + "\t" + homeScore + "\n";
        return result;
    }

    public static void main(String[] args) {
        BaseballScore score = new BaseballScore("MEM", "DUR");
        System.out.println(score);
        score.simulate();
        System.out.println(score);
    }
    
    
}
