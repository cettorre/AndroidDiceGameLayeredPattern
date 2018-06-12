package game.dice.com.dicegameapp.domain;

import java.util.ArrayList;

public class Result {
    //Lista de resultados. Cada Resultado tiene una lista de games.
    private static ArrayList<Game> games=new ArrayList<>();

    public Result() {  }

    public ArrayList<Game> getGames() {
        return games;
    }

    public Game getCurrentGame(){
        return getGames().get(games.size()-1);
    }
}
