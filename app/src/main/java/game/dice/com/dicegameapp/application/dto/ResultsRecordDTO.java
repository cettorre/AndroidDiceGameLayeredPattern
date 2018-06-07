package game.dice.com.dicegameapp.application.dto;

import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.domain.Player;

public class ResultsRecordDTO {

    private String playerName;
    private int numberOfRolls;
    private double percentageOfVictories;
    GameController gameController= new GameController();


    //TODO PEDIR INFO A PLAYER
    public ResultsRecordDTO(Player player) {
        this.playerName = player.getName();
        this.numberOfRolls = player.getAllGames().size();
        this.percentageOfVictories = gameController.getPlayerRanking();
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getNumberOfRolls() {
        return numberOfRolls;
    }


    public double getPercentageOfVictories() {
        return percentageOfVictories;
    }


    @Override
    public String toString() {
        return "ResultsRecordDTO{" +
                "playerName='" + playerName + '\'' +
                ", numberOfRolls=" + numberOfRolls +
                ", percentageOfVictories=" + percentageOfVictories +
                '}';
    }
}