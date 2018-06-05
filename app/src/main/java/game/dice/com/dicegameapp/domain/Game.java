package game.dice.com.dicegameapp.domain;

import android.util.Log;

public class Game {


	private Dice dice1=new Dice();
	private Dice dice2=new Dice();
	
	public Game(){
		
	}
	
	public boolean playGame() {
		dice1.rollDice();
		dice2.rollDice();

		return hasWon();
	}
	
	public int getSumDices(){
		return dice1.getValue()+dice2.getValue();	
	}
	
	public boolean hasWon() {
		return getSumDices()==7;
	}

	//added methods
	public int getDice1() {
		return dice1.getValue();
	}

	public int getDice2() {
		return dice2.getValue();
	}

	@Override
	public String toString() {
		return "Game{" +
				"dice1=" + dice1 +
				", dice2=" + dice2 +
				'}';
	}
}
