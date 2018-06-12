package game.dice.com.dicegameapp.application;

import android.util.Log;
import java.util.ArrayList;
import game.dice.com.dicegameapp.application.dto.ResultsRecordDTO;
import game.dice.com.dicegameapp.domain.*;


public class GameController {

	public GameController() {}

	private static Player player;

	public ResultsRecordDTO createRecord(){
		return new ResultsRecordDTO(player);
	}

	public void addRecordToList(ResultsRecordDTO resultsRecordDTO){
		player.getResultsRecordsList().add(resultsRecordDTO);
	}

	public ArrayList<ResultsRecordDTO> getResults() {
		return player.getResultsRecordsList();
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
        boolean hasWon = player.addResult();
	    return hasWon;
	}

	public int getDice1Value(){	return player.getCurrentResult().getCurrentGame().getDice1().getValue();}

	public int getDice2Value(){	return player.getCurrentResult().getCurrentGame().getDice2().getValue();}

	public void resetGamesList(){player.resetGamesList();}

	public int getRolledTimes(){ return player. getCurrentResult().getGames().size();}

}
