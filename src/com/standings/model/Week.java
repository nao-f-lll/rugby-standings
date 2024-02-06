package com.standings.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Week implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2277868385094501915L;
	private int weekID;
	private ArrayList<Game> games;
	private final int GAMES_NUMBER = 30;
	
	
	public Week(int weekID, ArrayList<Game> games) {
		this.weekID = weekID;
		this.games = games;
	}


	public int getWeekID() {
		return weekID;
	}


	public void setWeekID(int weekID) {
		this.weekID = weekID;
	}


	public ArrayList<Game> getGames() {
		return games;
	}


	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}


	public int getGAMESNUMBER() {
		return GAMES_NUMBER;
	}

	
	
}
