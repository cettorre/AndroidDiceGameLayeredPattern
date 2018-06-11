package game.dice.com.dicegameapp.domain;


import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import game.dice.com.dicegameapp.view.Dashboard;
import game.dice.com.dicegameapp.view.MainActivity;

public class Player {

	private String name;

	private Game game;
	private Result result;

	//TODO
	//cada player tiene una lista de resultados
    //Lista de resultados. Cada Resultado tiene una lista de games.
	private ArrayList<Game> games=new ArrayList<>();//change
	//new list
	private ArrayList<Result> results=new ArrayList<>();
	
	public Player(String name){		
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void addGame(Game game){
		//comprovar que no sea null

		try{
			if (game==null) throw new Exception();
			games.add(game);//change
		}catch (Exception e){
			e.printStackTrace();
		}

    }

	public List<Game> getAllGames() {return games;}//change

	public void resetGamesList(){games.clear();}//change

	public Game getGame() {
		return game;//change
	}

	public boolean rollDices() {
		game= new Game();//change
		game.getDice1().rollDice();//change
		game.getDice2().rollDice();//change

		//new version
		games.add(game);
		result=new Result(games);
		results.add(result);
		//---

		return game.hasWon();//change to new version using Result obj
		//return result.getGames().get(results.size()-1).hasWon();//modificar texto en pantalla metodo hasWon del objeto en la lista
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

