package com.standings.model;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.standings.util.UserDialogUtil;

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
	
	
	public Season( int id, int year, String state, ArrayList<Week>  weeks,  ArrayList<Team> teams, ArrayList<Game> games) {
		this.state = state;
		this.id = id;
		this.year = year;
		this.weeks = weeks;
		this.teams = teams;
		this.games = games;
		this.active = true;
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

	public Season(int seasonCode, int year) {
		this.year = year;
		this.weeks = new ArrayList<>();
		this.teams = new ArrayList<>();
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
				String imagePath = teams.get(i).getIconPath();
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
		
		
		} catch (EOFException e) {
        	UserDialogUtil.userDialog("El archivo no contiene ningun dato", "Expecion de escritura", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (FileNotFoundException e) {
        	UserDialogUtil.userDialog("Expecion de escritura", "El archivo no existe, se va crea uno nuevo", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
			e.printStackTrace();
        }
	}
}
