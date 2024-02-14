package com.standings.model;

import java.io.Serializable;


/**
 * Clase que representa un equipo en el contexto de un torneo de rugby.
 * 
 * <p>
 * Esta clase almacena información sobre un equipo, incluyendo el nombre del equipo,
 * puntos, juegos jugados, victorias, derrotas, empates y la ruta del icono asociado al equipo.
 * </p>
 * 
 * <p>
 * Los métodos proporcionados permiten acceder y modificar esta información.
 * </p>
 * 
 * @author SomeOne
 * @version 1.0
 * @since 2024-02-02
 */

public class Team implements Serializable{
	
		// declaracion de las variables
	 	private static final long serialVersionUID = -1464726276085058824L;
		private final String name;
	    private int points;
	    private int gamesPlayed;
	    private int wins;
	    private int losses;
	    private int ties;
	    private String iconPath;
	  
	    
	    /**
	     * Constructor de la clase Team.
	     * 
	     * @param name     Nombre del equipo.
	     * @param iconPath Ruta del icono asociado al equipo.
	     */
	    public Team(String name, String iconPath) {
	        this.name = name;
	        this.points = 0;
	        this.gamesPlayed = 0;
	        this.wins = 0;
	        this.losses = 0;
	        this.ties = 0;
	        this.iconPath = iconPath;
	        
	    }
	    
	    // getters y setters
	    
	    /**
	     * Obtiene el nombre del equipo.
	     * 
	     * @return Nombre del equipo.
	     */
	    public String getName() { return name; }
	    
	    /**
	     * Obtiene la ruta del icono asociado al equipo.
	     * 
	     * @return Ruta del icono del equipo.
	     */
	    public String getIconPath() { return iconPath; }
	 
	    
	    /**
	     * Obtiene la cantidad de puntos del equipo.
	     * 
	     * @return Puntos del equipo.
	     */
	    public int getPoints() { return points; }
	    
	    
	    /**
	     * Obtiene la cantidad de juegos jugados por el equipo.
	     * 
	     * @return Juegos jugados por el equipo.
	     */
	    public int getGamesPlayed() { return gamesPlayed; }
	    
	    
	    /**
	     * Obtiene la cantidad de victorias del equipo.
	     * 
	     * @return Victorias del equipo.
	     */
	    public int getWins() { return wins; }
	    
	    
	    /**
	     * Obtiene la cantidad de empates del equipo.
	     * 
	     * @return Empates del equipo.
	     */
	    public int getTies() { return ties; }
	    
	    /**
	     * Obtiene la cantidad de derrotas del equipo.
	     * 
	     * @return Derrotas del equipo.
	     */
	    public int getLosses() { return losses; }


	 // setters
	    
	    /**
	     * Establece la ruta del icono asociado al equipo.
	     * 
	     * @param iconPath Nueva ruta del icono del equipo.
	     */
	    public void setIconPath(String iconPath) {  this.iconPath = iconPath; }
	    
	    /**
	     * Establece la cantidad de puntos del equipo.
	     * 
	     * @param points Nuevos puntos del equipo.
	     */
	    public void setPoints(int points) { this.points = points; }

	    
	    /**
	     * Incrementa el contador de victorias del equipo.
	     */
	    public void incrementWins() { wins++; }

	    
	    /**
	     * Incrementa el contador de derrotas del equipo.
	     */
	    public void incrementLosses() { losses++; }

	    /**
	     * Incrementa el contador de empates del equipo.
	     */
	    
	    public void incrementTies() { ties++; }
	    
	    
	    /**
	     * Incrementa el contador de juegos jugados por el equipo.
	     */
	    public void incrementGamesPlayed() { gamesPlayed++; }
	    
	    
	    
	    /**
	     * Decrementa el contador de victorias del equipo.
	     */
	    public void decrementWins() { wins--; }
	    
	    
	    /**
	     * Decrementa el contador de derrotas del equipo.
	     */
	    public void decrementLosses() { losses--; }
	    
	    
	    /**
	     * Decrementa el contador de empates del equipo.
	     */
	    public void decrementTies() { ties--; }
	    
	    
	    /**
	     * Decrementa el contador de juegos jugados por el equipo.
	     */
	    public void decrementGamesPlayed() { gamesPlayed--; }

	    
	    /**
	     * Representación en cadena (String) del equipo.
	     * 
	     * @return Nombre del equipo.
	     */
		@Override
		public String toString() {
			return name ;
		}


	    
	    
}


