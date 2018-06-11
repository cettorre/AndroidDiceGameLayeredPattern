package game.dice.com.dicegameapp.domain;

import java.util.ArrayList;

public class Result {

    private int numberOfRolls;
    private double percentageOfVictories;
    private String playerName;
    private static ArrayList<Game> games=new ArrayList<>();


    public Result() {  }

    public ArrayList<Game> getGames() {
        return games;
    }

    public Game getCurrentGame(){

        return getGames().get(games.size()-1);
    }

    @Override
    public String toString() {
        return "Result{" +games.toString()+
                '}';
    }
}
