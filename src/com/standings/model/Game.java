package com.standings.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	    private transient BufferedWriter bufferWriter;
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
		
	/*	
		public void convertToXML() {
			
			try {
				fileWriter = new FileWriter("C:\\Users\\ik_1DW3A\\Documents\\nao-f-lll.github.io/resultados.xml");
				String header = """
	<?xml version="1.0" encoding="UTF-8"?>
	<?xml-stylesheet href="xml/clasificacion.xsl" type="text/xsl"?>
	<clasificacion xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="xml/resultados.xsd">
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
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
		
}


