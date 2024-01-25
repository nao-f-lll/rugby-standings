package com.standings.model;

import java.io.Serializable;

public class Team implements Serializable{
	 	private static final long serialVersionUID = -1464726276085058824L;
		private final String name;
	    private int points;
	    private int gamesPlayed;
	    private int wins;
	    private int losses;
	    private int ties;
	    private String iconPath;
	  
	    

	    public Team(String name, String iconPath) {
	        this.name = name;
	        this.points = 0;
	        this.gamesPlayed = 0;
	        this.wins = 0;
	        this.losses = 0;
	        this.ties = 0;
	        this.iconPath = iconPath;
	        
	    }
	    
	    // getters
	    
	    public String getName() { return name; }
	    
	    public String getIconPath() { return iconPath; }
	 

	    public int getPoints() { return points; }
	    
	    public int getGamesPlayed() { return gamesPlayed; }
	    
	    public int getWins() { return wins; }
	    
	    public int getTies() { return ties; }
	    
	    public int getLosses() { return losses; }


	 // setters
	    
	    public void setIconPath(String iconPath) {  this.iconPath = iconPath; }
	    
	    public void setPoints(int points) { this.points = points; }

	    public void incrementWins() { wins++; }

	    public void incrementLosses() { losses++; }

	    public void incrementTies() { ties++; }
	    
	    public void incrementGamesPlayed() { gamesPlayed++; }
	    
	    
	    public void decrementWins() { wins--; }
	    
	    public void decrementLosses() { losses--; }
	    
	    public void decrementTies() { ties--; }
	    
	    public void decrementGamesPlayed() { gamesPlayed--; }

		@Override
		public String toString() {
			return name ;
		}


	    
	    
}


