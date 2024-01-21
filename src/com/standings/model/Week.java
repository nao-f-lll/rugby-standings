package com.standings.model;

import java.util.ArrayList;

public class Week {
	private int weekID;
	private ArrayList<Game> games;
	private final int GAMESNUMBER = 30;
	
	
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
		return GAMESNUMBER;
	}

	
	
}
