package com.standings.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	private  BufferedWriter bufferWriter;
	public  FileWriter fileWriter; 
	
	
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
	
	
	public void convertToXML() {
		
		try {
			fileWriter = new FileWriter("C:\\Users\\ik_1DW3A\\Documents\\nao-f-lll.github.io/clasificacion.xml");
			String header = """
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet href="xml/clasificacion.xsl" type="text/xsl"?>
<clasificacion xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="xml/clasificacion.xsd">
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
				String imagePath = "media/Imagenes/logos/south_Africa_national_rugby_union_team.png";
				bufferWriter.write("<logo>"+ imagePath + "</logo>"); 
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
