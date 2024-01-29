package com.standings.model;

import java.io.FileWriter;
import java.io.Serializable;

public class Game implements Serializable{
		
	    
	 	private static final long serialVersionUID = 5936600953675640410L;
		private final Team localTeam;
	    private final Team visitorTeam;
	    private int localScore;
	    private int visitorScore;
	    private int weekNumber;
		private int oldLocalScore;
		private int  oldVisitorScore;
	    private Fecha fecha;
	    public  transient FileWriter fileWriter; 

	    public Game(Team localTeam, Team visitorTeam, int localScore, int visitorScore, int oldLocalScore, int oldVisitorScore, int weekNumber) {
	    	
	        this.localTeam = localTeam;
	        this.visitorTeam = visitorTeam;
	        this.localScore = localScore;
	        this.visitorScore = visitorScore;	          
	        this.weekNumber = weekNumber;
	        this.oldLocalScore = oldLocalScore;
	        this.oldVisitorScore = oldVisitorScore;
	    }

	    // getters
	    
	    
	    
	    
	    public Team getLocalTeam() { return localTeam; }

	    public int getOldLocalScore() {return oldLocalScore;}

	

		public int getOldVisitorScore() {return oldVisitorScore;}

		
		
		
		public Team getVisitorTeam() { return visitorTeam; }

	    public int getLocalScore() { return localScore; }

	    public int getVisitorScore() { return visitorScore; }
	    
	    public int getWeekNumber() { return weekNumber;}
	    
	    // setters

	    public void setLocalScore(int localScore)     {  this.localScore = localScore; }

	    public void setVisitorScore(int visitorScore) {  this.visitorScore = visitorScore;}

		public void setOldVisitorScore(int oldVisitorScore) {
			this.oldVisitorScore = oldVisitorScore;
		}

		public void setOldLocalScore(int oldLocalScore) {
			this.oldLocalScore = oldLocalScore;
		}
	    
		@Override
		public String toString() {
			return "Game " + localTeam.getName() + ", " + visitorTeam.getName() + "," + localScore
					+ ", " + visitorScore + ", " + weekNumber + ", " + fecha + "]";
		}
		

		
}


