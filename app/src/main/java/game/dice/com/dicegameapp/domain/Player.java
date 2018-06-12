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

	public Player(String name){		
		this.name=name;
	}
	
	public String getName(){
		return name;
	}

	public ArrayList<Result> getResults() {
		return results;
	}

	public Result getCurrentResult(){
		return getResults().get(results.size()-1);
	}

	public List<Game> getAllGames() {return getCurrentResult().getGames();}

	public void resetGamesList(){getCurrentResult().getGames().clear();}

	public boolean playGame() {
	// variable global games error 100%->static ok teoria
		//eliminar
		Result result=new Result();// no crearlo tiene que ser el ultimo de la lista
		//TODO crear y jugar-> añadir-> recuperar



		//	Result res=getCurrentResult(); antes de resuperarlo hay que ponerlo en la lista
		results.add(result);//recuperar ultimo resultado
		rollTheDices();
		Log.e("results",results.toString());
		return getCurrentResult().getCurrentGame().hasWon();
	}

	private void rollTheDices(){

		Game game= new Game();
		game.getDice1().rollDice();
		game.getDice2().rollDice();
		addGame(game);

	}

	private void addGame(Game game){
		try{
			if (game==null) throw new Exception();
			getCurrentResult().getGames().add(game);
		}catch (Exception e){
			e.printStackTrace();
		}
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

