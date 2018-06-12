package game.dice.com.dicegameapp.application;

import android.util.Log;
import java.util.ArrayList;
import game.dice.com.dicegameapp.application.dto.ResultsRecordDTO;
import game.dice.com.dicegameapp.domain.*;


public class GameController {

	public GameController() {}


	private static Player player;
	//TODO
	//situar
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
        boolean hasWon = player.playGame();
      //  player.addGame(player.getCurrentResult().getCurrentGame());//fixed add x2
	    return hasWon;
	}

	public int getDice1Value(){	return player.getCurrentResult().getCurrentGame().getDice1().getValue();}

	public int getDice2Value(){	return player.getCurrentResult().getCurrentGame().getDice2().getValue();}

	public void resetGamesList(){player.resetGamesList();}

	public int getRolledTimes(){ return player. getCurrentResult().getGames().size();}

}

