package game.dice.com.dicegameapp.application;

import java.util.List;
import game.dice.com.dicegameapp.domain.*;


public class GameController {

	private static Player player;
	//added field
	private Game game;


	public GameController() {

	}

	public static Player getPlayer() {
		return player;
	}

	public void createPlayer(String name) {
		this.player = new Player(name);
	}

	public String getPlayerName() {
		return player.getName();
	}

	public boolean playGame() {
		 game = new Game();
		boolean hasWon = game.playGame();
		player.addGame(game);
		return hasWon;
	}
	//added methods
	public int getDice1Value(){

		return game.getDice1();
	}

	public int getDice2Value(){

		return game.getDice2();
	}

	public String getPlayerGamesToString() {
		String text = "";
		List<Game> games = player.getAllGames();

		for (Game game : games) {
			text += "SUMA: " + game.getSumDices() + " RESULTAT: " + game.hasWon();
		}
		return text;
	}

	public double getPlayerRanking() {
		List<Game> games = player.getAllGames();

		double wins = 0.0;
		for (Game game : games) {
			if (game.hasWon())
				wins++;
		}
		return wins / games.size();
	}

	@Override
	public String toString() {
		return "GameController{" +
				"player=" + player +
				'}';
	}
}
