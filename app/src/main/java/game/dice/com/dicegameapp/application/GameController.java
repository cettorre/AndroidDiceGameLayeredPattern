package game.dice.com.dicegameapp.application;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import game.dice.com.dicegameapp.application.dto.ResultsRecordDTO;
import game.dice.com.dicegameapp.domain.*;


public class GameController {

	private static Player player;
	//added field

    //TODO eliminar game. Use class Player instead.?
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


	//TODO use player instead of game
	public boolean playGame() {
	    game = new Game();//use player instead
		boolean hasWon = game.rollDices();
		player.addGame(game);//player.addGame(player.getGame());
	//	Log.e("game", game.toString());
	//	return player.playGame();//
		return hasWon;
	}
	//TODO use player instead of game OK
	public int getDice1Value(){	return game.getDice1();}//use player instead
	public int getDice2Value(){	return game.getDice2();}//use player instead

	public void resetGamesList(){player.resetGamesList();}

	//added method
	public int getRolledTimes(){ return player.getAllGames().size();}

	@Override
	public String toString() {
		return "GameController{" +
				"player=" + player +
				'}';
	}
}
