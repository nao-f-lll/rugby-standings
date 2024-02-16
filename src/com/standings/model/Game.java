package com.standings.model;

import java.io.FileWriter;
import java.io.Serializable;

/**
 * Clase que representa un juego entre dos equipos.
 * 
 * <p>
 * Esta clase almacena información sobre el juego, incluyendo los equipos locales y visitantes,
 * los puntajes, el número de semana, y otros detalles relacionados.
 * </p>
 * 
 * @author SomeOne 
 * @version 1.0
 * @since 2024-02-02
 */
public class Game implements Serializable{
		
	    
	 	private static final long serialVersionUID = 5936600953675640410L;
		private final Team localTeam;
	    private final Team visitorTeam;
	    private int localScore;
	    private int visitorScore;
	    private String localScoreString;
	    private String visitorScoreString;
	    private int weekNumber;
	    private String oldLocalScoreString;
	  	private String  oldVisitorScoreString;	
	    private int oldLocalScore;
		private int  oldVisitorScore;	    
	    private Fecha fecha;
	    public  transient FileWriter fileWriter;
	    private boolean active;
	    private boolean activeForLocalTeam;
	    private boolean activeForVisitorTeam;
	    

	    /**
	     * Constructor de la clase Game.
	     * 
	     * @param localTeam       Equipo local.
	     * @param visitorTeam     Equipo visitante.
	     * @param localScore      Puntaje del equipo local.
	     * @param visitorScore    Puntaje del equipo visitante.
	     * @param oldLocalScore   Puntaje antiguo del equipo local.
	     * @param oldVisitorScore Puntaje antiguo del equipo visitante.
	     * @param week            Número de semana.
	     */
	    
	     public Game(Team localTeam, Team visitorTeam, int localScore, int visitorScore, int oldLocalScore, int oldVisitorScore, int weekNumber) {
	    	
	        this.localTeam = localTeam;
	        this.visitorTeam = visitorTeam;
	        this.localScore = localScore;
	        this.visitorScore = visitorScore;	          
	        this.weekNumber = weekNumber;
	        this.oldLocalScore = oldLocalScore;
	        this.oldVisitorScore = oldVisitorScore;
	    }
	    
	    
	    public Game(Team localTeam, Team visitorTeam, String localScoreString, String visitorScoreString, String oldLocalScoreString, String oldVisitorScoreString, int weekNumber) {
	    	
	        this.localTeam = localTeam;
	        this.visitorTeam = visitorTeam;
	        this.localScoreString = localScoreString;
	        this.visitorScoreString = visitorScoreString;	          
	        this.weekNumber = weekNumber;
	        this.oldLocalScoreString = oldLocalScoreString;
	        this.oldVisitorScoreString = oldVisitorScoreString;
	        this.active = false;
	        this.activeForLocalTeam = false;
	        this.activeForVisitorTeam = false;
	    }

	    // getters
	    
	    
	    
	    /**
	     * Obtiene el equipo local.
	     * 
	     * @return Equipo local.
	     */
	    public Team getLocalTeam() { return localTeam; }
	  
	    /**
	     * Obtiene el puntaje antiguo del equipo local.
	     * 
	     * @return Puntaje antiguo del equipo local.
	     */
	    public int getOldLocalScore() {return oldLocalScore;}

	    
	    public boolean isActive() {
	    	return active;
	    }
	    
	    
	
	    /**
	     * Obtiene el puntaje antiguo del equipo visitante.
	     * 
	     * @return Puntaje antiguo del equipo visitante.
	     */
		public int getOldVisitorScore() {return oldVisitorScore;}

		
		 /**
	     * Obtiene el equipo visitante.
	     * 
	     * @return Equipo visitante.
	     */
		
		public Team getVisitorTeam() { return visitorTeam; }

		/**
	     * Obtiene el puntaje del equipo local.
	     * 
	     * @return Puntaje del equipo local.
	     */
	    public int getLocalScore() { return localScore; }

	    /**
	     * Obtiene el puntaje del equipo local.
	     * 
	     * @return Puntaje del equipo local.
	     */
	    public int getVisitorScore() { return visitorScore; }
	    
	    /**
	     * Obtiene el número de semana del juego.
	     * 
	     * @return Número de semana del juego.
	     */
	    public int getWeekNumber() { return weekNumber;}
	    
	    // setters

	    public void setLocalScore(int localScore)     {  this.localScore = localScore; }

	    public void setVisitorScore(int visitorScore) {  this.visitorScore = visitorScore;}

		public void setOldVisitorScore(int oldVisitorScore) {
			this.oldVisitorScore = oldVisitorScore;
		}
		
		public void setActive(boolean active) {
			this.active = active;
		}

		public void setOldLocalScore(int oldLocalScore) {
			this.oldLocalScore = oldLocalScore;
		}
	    
		
		
		  public boolean isActiveForLocalTeam() {
			return activeForLocalTeam;
		}


		public void setActiveForLocalTeam(boolean activeForLocalTeam) {
			this.activeForLocalTeam = activeForLocalTeam;
		}


		public boolean isActiveForVisitorTeam() {
			return activeForVisitorTeam;
		}


		public void setActiveForVisitorTeam(boolean activeForVisitorTeam) {
			this.activeForVisitorTeam = activeForVisitorTeam;
		}


		/**
	     * Obtiene una representación en cadena del objeto Game.
	     * 
	     * @return Cadena que representa el objeto Game.
	     */
		@Override
		public String toString() {
			return "Game " + localTeam.getName() + ", " + visitorTeam.getName() + "," + localScore
					+ ", " + visitorScore + ", " + weekNumber + ", " + fecha + "]";
		}
		

		
}


