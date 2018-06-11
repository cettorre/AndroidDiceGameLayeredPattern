package game.dice.com.dicegameapp.domain;

import java.util.ArrayList;

public class Result {

    private int numberOfRolls;
    private double percentageOfVictories;
    private String playerName;
    private ArrayList<Game> games;


    public Result() {  }

    public Result(ArrayList<Game> games) {
        this.games = games;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
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

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
