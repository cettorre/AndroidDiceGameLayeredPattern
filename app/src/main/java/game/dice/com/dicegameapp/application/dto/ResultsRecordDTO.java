package game.dice.com.dicegameapp.application.dto;

import game.dice.com.dicegameapp.domain.Player;

public class ResultsRecordDTO {

    private String playerName;
    private int numberOfRolls;
    private double percentageOfVictories;

    public ResultsRecordDTO(Player player) {
        this.playerName = player.getName();
        this.numberOfRolls = player.getAllGames().size();
        this.percentageOfVictories = player.getPlayerRanking();
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

}
