package game.dice.com.dicegameapp.domain;


import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import game.dice.com.dicegameapp.application.dto.ResultsRecordDTO;

public class Player {

	private String name;
	//cada player tiene una lista de resultados
	private ArrayList<Result> results=new ArrayList<>();

	private static ArrayList<ResultsRecordDTO> resultsRecordsList =new ArrayList<>();

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

	public List<Game> getAllGames() {return getCurrentResult().getGames();}//change

	public static ArrayList<ResultsRecordDTO> getResultsRecordsList() {
		return resultsRecordsList;
	}

	public void addGame(Game game){
		try{
			if (game==null) throw new Exception();
			getCurrentResult().getGames().add(game);//change
		}catch (Exception e){
			e.printStackTrace();
		}
    }

	public void resetGamesList(){getCurrentResult().getGames().clear();}//change

	public void rollTheDices(){
		Game game= new Game();
		game.getDice1().rollDice();
		game.getDice2().rollDice();
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

