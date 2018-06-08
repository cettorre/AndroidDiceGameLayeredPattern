package game.dice.com.dicegameapp.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private Dice dice1=new Dice();
    private Dice dice2=new Dice();;
	Game game= new Game();


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

	public void resetGamesList(){games.clear();}

	public Game getGame() {
		return game;
	}

	//TODO not matching getDice1Value playgame
	public boolean playGame() {
		boolean hasWon = game.rollDices();
	//	addGame(game);
		Log.e("game", game.toString());
		return hasWon;
	}

	public boolean rollDices() {
		dice1.rollDice();
		dice2.rollDice();

		return game.hasWon();
	}
	//added methods(before into Game)
    public int getDice1() {
        return dice1.getValue();
    }
    public int getDice2() {
        return dice2.getValue();
    }

    //todo done moved method to player
		public double getPlayerRanking() {
		//	List<Game> games = getAllGames();
			double wins = 0.0;
			for (Game game : games) {
				if (game.hasWon())
					wins++;
			}
			Log.e("added", games.toString());
			return wins / games.size()*100;
		}

	}

