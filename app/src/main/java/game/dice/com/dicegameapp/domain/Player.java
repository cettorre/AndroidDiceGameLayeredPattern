package game.dice.com.dicegameapp.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	 List<Game> games=new ArrayList<>();
	
	public Player(String name){		
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void addGame(Game game){ this.games.add(game);
		Log.e("games_list",games.toString());}

	public List<Game> getAllGames() {return games;}

	public void resetGamesList(){games.clear();

	}
}
