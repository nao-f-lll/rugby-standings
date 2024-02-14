package com.standings.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa una temporada de rugby.
 * 
 * <p>
 * Esta clase almacena información sobre una temporada de rugby,
 * incluyendo el estado, el año, las semanas, los equipos, los juegos y si está activa.
 * Proporciona métodos para acceder y modificar esta información, así como para convertir la información a XML.
 * </p>
 * 
 * <p>
 * La información de la temporada se puede convertir a un archivo XML con detalles sobre la clasificación de los equipos.
 * </p>
 * 
 * @author SomeOne
 * @version 1.0
 * @since 2024-02-02
 */
public class Season implements Serializable{
	
	private static final long serialVersionUID = -2800306066578213671L;
	private int id;
	private String state;
	private int year;
	private ArrayList<Week>  weeks;
	private ArrayList<Team> teams;
	private ArrayList<Game> games;
	private boolean active;
	private transient BufferedWriter bufferWriter;
	public  transient FileWriter fileWriter; 
	
	/**
     * Constructor de la clase Season.
     * 
     * @param id     Identificador único de la temporada.
     * @param year   Año de la temporada.
     * @param state  Estado de la temporada.
     * @param weeks  Lista de semanas en la temporada.
     * @param teams  Lista de equipos en la temporada.
     * @param games  Lista de juegos en la temporada.
     */
	public Season( int id, int year, String state, ArrayList<Week>  weeks,  ArrayList<Team> teams, ArrayList<Game> games) {
		this.state = state;
		this.id = id;
		this.year = year;
		this.weeks = weeks;
		this.teams = teams;
		this.games = games;
		this.active = true;
	}
	
    /**
     * Constructor de la clase Season con código de temporada y año.
     * 
     * @param seasonCode Código de temporada.
     * @param year       Año de la temporada.
     */
	
	public Season(int seasonCode, int year) {
		this.year = year;
		this.weeks = new ArrayList<>();
		this.teams = new ArrayList<>();
	}

	
	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public boolean isActive() {
		return active;
	}
	

	public ArrayList<Game> getGames() {
		return games;
	}

	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}

	



	public int getYear() {
		return this.year;
	}

	
	
	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	
	public ArrayList<Week>   getWeeks() {
		return weeks;
	}
	
	

	
	public void setActive(boolean active) {
		this.active = active;
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
	
	
	 /**
     * Convierte la información de la temporada a un archivo XML.
     * 
     * <p>
     * La información incluye detalles sobre la clasificación de los equipos, juegos jugados, victorias, derrotas, empates y puntos.
     * </p>
      * @throws IOException Si ocurre un error durante la escritura del archivo.

     */
	public void convertToXML() {
		
		try {
			fileWriter = new FileWriter("C:\\Users\\ik_1DW3A\\Documents\\nao-f-lll.github.io/clasificacion/"+ this.getYear() + ".xml");
			String header = """
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet href="clasificacion.xsl" type="text/xsl"?>
<clasificacion xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="clasificacion.xsd">
					        """;
			String footer = """ 
					</clasificacion>
					""";
			bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write(header); 
			bufferWriter.newLine();
		
			
			
			for (int i = 0; i < teams.size(); i++) {
			    String id = String.valueOf(i + 1);
				String fila = "<fila id=\"" + id + "\">";
				String posiscion = " <posicion>" + id +"</posicion>";
				bufferWriter.write(fila); 
				bufferWriter.newLine();
				bufferWriter.write(posiscion); 
				bufferWriter.newLine();
				bufferWriter.write("<equipo>"); 
				bufferWriter.newLine();
				String imagePath = teams.get(i).getIconPath();
				bufferWriter.write("<logo>"+  "../" + imagePath + "</logo>");
				bufferWriter.newLine();
				bufferWriter.write("<nombre>"+ teams.get(i).getName() + "</nombre>"); 
				bufferWriter.newLine();
				bufferWriter.write("</equipo>"); 
				bufferWriter.newLine();
				bufferWriter.write("<partidos>" + teams.get(i).getGamesPlayed() + "</partidos>"); 
				bufferWriter.newLine();
				bufferWriter.write("<victorias>" + teams.get(i).getWins()+ "</victorias>"); 
				bufferWriter.newLine();
				bufferWriter.write("<derrotas>" + teams.get(i).getLosses() + "</derrotas>"); 
				bufferWriter.newLine();
				bufferWriter.write("<empates>" + teams.get(i).getTies() + "</empates>"); 
				bufferWriter.newLine();
				bufferWriter.write("<puntos>" + teams.get(i).getPoints() + "</puntos>"); 
				bufferWriter.newLine();
				bufferWriter.write("</fila>"); 
				bufferWriter.newLine();
				
			}
		
			bufferWriter.write(footer); 
			bufferWriter.newLine();
			bufferWriter.close();
			fileWriter.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
