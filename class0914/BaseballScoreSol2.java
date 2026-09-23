package class0914;

public class BaseballScoreSol {
    private String homeTeam;
    private String awayTeam;
    private int[] homeScore;
    private int[] awayScore;
    private int completedInnings;

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

    public enum Leader {
        HOME, AWAY, TIE
    }

    public BaseballScore() {
        homeTeam = "HOME";
        awayTeam = "AWAY";
    }

    public BaseballScore(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;

        homeScore = new int[9];
        awayScore = new int[9];
    }

    public int getHomeScore() {
        int total = 0;
        for (int inningScore : homeScore) {
            total += inningScore;
        }

        return total;
    }

    public int getAwayScore() {
        int total = 0;
        for (int inningScore : awayScore) {
            total += inningScore;
        }

        return total;
    }

    public Leader getLeader() {
        int homeScore = getHomeScore();
        int awayScore = getAwayScore();
        
        if (homeScore > awayScore) {
            return Leader.HOME;
        } else if (awayScore > homeScore) {
            return Leader.AWAY;
        } else {
            return Leader.TIE;
        }
    }

    public void simulateInning() {
        homeScore[completedInnings] = randomInning();
        awayScore[completedInnings] = randomInning();
        completedInnings++;
    }

    // Replace the scores with simulated scores.
    public void simulate() {
        for (int i = 0; i < 9; i++) {
            simulateInning();
        }
    }

    private String scoreString(int[] score) {
        String result = "";
        for (int i = 0; i < completedInnings; i++) {
            result += score[i] + "\t";
        }

        return result;
    }

    public String toString() {
        Leader leader = getLeader();

        String leaderString;
        if (leader == Leader.HOME) {
            leaderString = homeTeam;
        } else if (leader == Leader.AWAY) {
            leaderString = awayTeam;
        } else {
            leaderString = "tie";
        }
        
        String result = "";
        result += homeTeam + "\t" + scoreString(homeScore) + "\t" + getHomeScore() + "\n";
        result += awayTeam + "\t" + scoreString(awayScore) + "\t" + getAwayScore() + "\n";
        result += "Leader: " + leaderString + "\n";
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        BaseballScore score = new BaseballScore("MEM", "DUR");
        for (int i = 0; i < 9; i++) {
            score.simulateInning();
            System.out.println(score);
            Thread.sleep(2000);
        }
    }
}