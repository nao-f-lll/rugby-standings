package com.standings.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.ImageIcon;


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
		private String name;
	    private int points;
	    private int gamesPlayed;
	    private int wins;
	    private int losses;
	    private int ties;
	    private String iconPath;
	    private ImageIcon escudo;
	    private String ciudad;
	    private Estadio estadio;
	    private ArrayList<Jugador> jugadores;
	    private int fundacion;
	  
	    
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
	    
	    
	    public Team(String name, ImageIcon escudo, String ciudad, Estadio estadio, int fundacion) {
	        this.name = name;
	        this.escudo = escudo;
	        this.ciudad = ciudad;
	        this.estadio = estadio;
	        this.fundacion = fundacion;      
	    }
	    
	    // getters y setters
	    
	    /**
	     * Obtiene el nombre del equipo.
	     * 
	     * @return Nombre del equipo.
	     */
	    public String getName() { return name; }
	    
	    public void setName(String name) { 
	    	this.name = name;
	    }
	    
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
	    
	    
	    
	    
	    public ImageIcon getEscudo() {
			return escudo;
		}

		public void setEscudo(ImageIcon escudo) {
			this.escudo = escudo;
		}

		public String getCiudad() {
			return ciudad;
		}

		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}

		public Estadio getEstadio() {
			return estadio;
		}

		public void setEstadio(Estadio estadio) {
			this.estadio = estadio;
		}

		public ArrayList<Jugador> getJugadores() {
			return jugadores;
		}

		public void setJugadores(ArrayList<Jugador> jugadores) {
			this.jugadores = jugadores;
		}

		public int getFundacion() {
			return fundacion;
		}

		public void setFundacion(int fundacion) {
			this.fundacion = fundacion;
		}

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

	    
	    public void setGamesPlayed(int gamesPlayed) {
	    	this.gamesPlayed = gamesPlayed;
	    }
	    
	    
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


		@Override
		public int hashCode() {
			return Objects.hash(name);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Team other = (Team) obj;
			return Objects.equals(name, other.name);
		}
		
				    
}


