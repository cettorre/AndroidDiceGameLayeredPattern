package game.dice.com.dicegameapp.domain;


import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;

	Game game;

	List<Game> games=new ArrayList<>();
	
	public Player(String name){		
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void addGame(Game game){
		games.add(game);
    }

	public List<Game> getAllGames() {return games;}

	public void resetGamesList(){games.clear();}

	public Game getGame() {
		return game;
	}

	public boolean rollDices() {
		game= new Game();
		game.getDice1().rollDice();
		game.getDice2().rollDice();

		return game.hasWon();
	}

    public int getDice1Value() { return game.getDice1().getValue();}

    public int getDice2Value() {return game.getDice2().getValue();}

		public double getPlayerRanking() {
			double wins = 0.0;
			for (Game game : games) {
				if (game.hasWon()) {
					wins++;
				}
			}
			return wins / games.size()*100;
		}

	}

