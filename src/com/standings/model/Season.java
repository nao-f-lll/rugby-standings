package com.standings.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Season implements Serializable{
	

	private static final long serialVersionUID = -2800306066578213671L;
	private int seasonID;
	private int year;
	private ArrayList<Week>  weeks;
	private ArrayList<Team> teams;
	private ArrayList<Game> games;
	private boolean state;
	
	
	public Season(int seasonCode, int year, ArrayList<Week>  weeks,  ArrayList<Team> teams, ArrayList<Game> games) {
		this.seasonID = seasonCode;
		this.year = year;
		this.weeks = weeks;
		this.teams = teams;
		this.games = games;
	}
	
	public int getSeasonID() {
		return seasonID;
	}

	public void setSeasonID(int seasonID) {
		this.seasonID = seasonID;
	}

	public ArrayList<Game> getGames() {
		return games;
	}

	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}

	public Season(int seasonCode, int year) {
		this.seasonID = seasonCode;
		this.year = year;
		this.weeks = new ArrayList<>();
		this.teams = new ArrayList<>();
	}


	public int getYear() {
		return this.year;
	}

	public int getSeasonCode() {
		return seasonID;
	}
	
	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	
	public ArrayList<Week>   getWeeks() {
		return weeks;
	}
	
	

	public void setSeasonCode(int seasonCode) {
		this.seasonID = seasonCode;
	}


	public void setWeeks(ArrayList<Week> weeks) {
		this.weeks = weeks;
	}



	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
