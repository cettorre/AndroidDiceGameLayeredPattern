package game.dice.com.dicegameapp.domain;


import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import game.dice.com.dicegameapp.view.Dashboard;
import game.dice.com.dicegameapp.view.MainActivity;

public class Player {

	private String name;
	private ArrayList<Result> results=new ArrayList<>();
	//TODO
	//cada player tiene una lista de resultados
	//Lista de resultados. Cada Resultado tiene una lista de games.
	//todo eliminar
	//private Result result;
//	private Game game;
//	private ArrayList<Game> games=new ArrayList<>();//todo error inside method 100% teoria

	public Player(String name){		
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void addGame(Game game){
		try{
			if (game==null) throw new Exception();
			getCurrentResult().getGames().add(game);//change
		}catch (Exception e){
			e.printStackTrace();
		}
    }

	public List<Game> getAllGames() {return getCurrentResult().getGames();}//change

	public void resetGamesList(){getCurrentResult().getGames().clear();}//change

	public void rollTheDices(){

		Game game= new Game();//change
		game.getDice1().rollDice();//change
		game.getDice2().rollDice();//change
		addGame(game);

	}

	public boolean addResult() {
	// variable global games error 100%->static ok teoria
		Result result=new Result();
		results.add(result);
		rollTheDices();
		Log.e("results",results.toString());
		return getCurrentResult().getCurrentGame().hasWon();
	}

	public ArrayList<Result> getResults() {
		return results;
	}

	public Result getCurrentResult(){
		return getResults().get(results.size()-1);
	}

	public double getPlayerRanking() {
		double wins = 0.0;
		for (Game game : getCurrentResult().getGames()) {
			if (game.hasWon()) {
				wins++;
	 		}
		}
	return wins / getCurrentResult().getGames().size()*100;
	}

}

