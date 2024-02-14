package com.standings.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa una semana en el calendario de partidos de la temporada.
 * 
 * <p>
 * Esta clase almacena información sobre una semana específica, incluyendo su identificador
 * y la lista de partidos asociados a esa semana.
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

public class Week implements Serializable{
	
	//Declaracion de las variables
	private static final long serialVersionUID = -2277868385094501915L;
	private int weekID;
	private ArrayList<Game> games;
	private final int GAMESNUMBER = 30;
	
	/**
     * Constructor de la clase Week.
     * 
     * @param weekID Identificador único de la semana.
     * @param games  Lista de partidos asociados a la semana.
     */
	
	public Week(int weekID, ArrayList<Game> games) {
		this.weekID = weekID;
		this.games = games;
	}


	 // Métodos getters
	
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
