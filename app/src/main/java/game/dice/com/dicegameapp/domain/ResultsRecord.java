package game.dice.com.dicegameapp.domain;

public class ResultsRecord {

    private String playerName;
    private int numberOfRolls;
    private double percentageOfVictories;

    public ResultsRecord(String playerName, int numberOfRolls, double percentageOfVictories) {
        this.playerName = playerName;
        this.numberOfRolls = numberOfRolls;
        this.percentageOfVictories = percentageOfVictories;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getNumberOfRolls() {
        return numberOfRolls;
    }

    public void setNumberOfRolls(int numberOfRolls) {
        this.numberOfRolls = numberOfRolls;
    }

    public double getPercentageOfVictories() {
        return percentageOfVictories;
    }

    public void setPercentageOfVictories(double percentageOfVictories) {
        this.percentageOfVictories = percentageOfVictories;
    }

    @Override
    public String toString() {
        return "ResultsRecord{" +
                "playerName='" + playerName + '\'' +
                ", numberOfRolls=" + numberOfRolls +
                ", percentageOfVictories=" + percentageOfVictories +
                '}';
    }
}
