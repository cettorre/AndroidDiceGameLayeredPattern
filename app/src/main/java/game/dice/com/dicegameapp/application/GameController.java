package game.dice.com.dicegameapp.application;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import game.dice.com.dicegameapp.application.dto.ResultsRecordDTO;
import game.dice.com.dicegameapp.domain.*;


public class GameController {

	private static Player player;
	//added field
	private Game game;

	private static ArrayList<ResultsRecordDTO> results=new ArrayList<>();

	public ResultsRecordDTO createRecord(){
		return new ResultsRecordDTO(player);
	}

	public void addRecordToList(ResultsRecordDTO resultsRecordDTO){
		results.add(resultsRecordDTO);
	}

	public ArrayList<ResultsRecordDTO> getResults() {
		return results;
	}

	public GameController() {}

	public Player getPlayer() {
		return player;
	}

	public void createPlayer(String name) {
		this.player = new Player(name);
		Log.e("created player", "created");
	}

	public String getPlayerName() {	return player.getName();}

	public boolean playGame() {
	    game = new Game();
		boolean hasWon = game.playGame();
		player.addGame(game);
		Log.e("game", game.toString());
		return hasWon;
	}
	//TODO use player instead of game
	public int getDice1Value(){	return game.getDice1();}
	public int getDice2Value(){	return game.getDice2();}

	public void resetGamesList(){player.resetGamesList();}

	public String getPlayerGamesToString() {
		String text = "";
		List<Game> games = player.getAllGames();

		for (Game game : games) {
			text += "SUMA: " + game.getSumDices() + " RESULTAT: " + game.hasWon();
		}
		return text;
	}

	//TODO puede moverse a player
	public double getPlayerRanking() {
		List<Game> games = player.getAllGames();

		double wins = 0.0;
		for (Game game : games) {
			if (game.hasWon())
				wins++;
		}
		Log.e("added", games.toString());
		return wins / games.size()*100;
	}

	//added method
	public int getRolledTimes(){ return player.getAllGames().size();}

	@Override
	public String toString() {
		return "GameController{" +
				"player=" + player +
				'}';
	}
}
