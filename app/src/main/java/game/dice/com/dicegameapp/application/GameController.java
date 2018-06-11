package game.dice.com.dicegameapp.application;

import android.util.Log;
import java.util.ArrayList;
import game.dice.com.dicegameapp.application.dto.ResultsRecordDTO;
import game.dice.com.dicegameapp.domain.*;


public class GameController {

	public GameController() {}


	private static Player player;
	//TODO
	//eliminar
	private static ArrayList<ResultsRecordDTO> results=new ArrayList<>();

	public ResultsRecordDTO createRecord(){
		return new ResultsRecordDTO(player);
	}

	public void addRecordToList(ResultsRecordDTO resultsRecordDTO){
		results.add(resultsRecordDTO);
	}

	//
	public ArrayList<ResultsRecordDTO> getResults() {
		//generar la lista a partir de Player
		return results;
	}

	public Player getPlayer() {
		return player;
	}

	public void createPlayer(String name) {
		this.player = new Player(name);
		Log.e("created player", "created");
	}

	public String getPlayerName() {	return player.getName();}

	public boolean playGame() {
        boolean hasWon = player.rollDices();
        player.addGame(player.getGame());
	    return hasWon;
	}

	public int getDice1Value(){	return player.getDice1Value();}

	public int getDice2Value(){	return player.getDice2Value();}

	public void resetGamesList(){player.resetGamesList();}

	public int getRolledTimes(){ return player.getAllGames().size();}

}
