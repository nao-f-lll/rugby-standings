package com.standings.util;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;

import com.standings.model.Game;
import com.standings.model.Week;

public class FileIO <T>   implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3718018196140010999L;
	private static   BufferedWriter bufferWriter;
	public static   FileWriter fileWriter; 
 
	
	public FileIO() {
		
	}
	
	public void writeToFile(String timeStamps, String data, String filePath, String additionalInfo, int sessionId) {
		
		if (sessionId == -1) {
			sessionId = (int) (Math.random()  * 100);
		}
		
		try {
			fileWriter = new FileWriter(filePath, true);
			bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write("Registro: " + additionalInfo + ", Datos: " + data + ", ID de sesion: " + sessionId + ", tiempo: " + timeStamps);
			bufferWriter.newLine();
			bufferWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void writeObject(String filePath, ArrayList<T> object) {

    	try {
			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream streamOut = new ObjectOutputStream(fileOut);
			streamOut.writeObject(object);
			streamOut.close();
			fileOut.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
	}
	
	
	public String readFile(String filePath) {
     
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> readObject(String filePath, ArrayList<T> object) {

        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream streamIn = new ObjectInputStream(fileIn);    
            object = (ArrayList<T>) streamIn.readObject();
            
            streamIn.close();
            fileIn.close();
        }catch (EOFException e) {
        	System.out.println("Archivo vacio");
        } 
        catch (FileNotFoundException e) {
        	System.out.println("no existe el archivo");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	System.out.println("no existe la clase");
            
        } catch (ClassCastException e) {
        	System.out.println("el objeto no es el mismo");
        }
        
        return object;
	}
	
	
	
	
		public void convertToXML(ArrayList<Week> weeks) {
		
		try {
			//fileWriter = new FileWriter("C:\\Users\\ik_1DW3A\\Documents\\nao-f-lll.github.io/resultados.xml");
			fileWriter = new FileWriter("data/resultados.xml");
			bufferWriter = new BufferedWriter(fileWriter);
			String header = """
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet href="xml/resultados.xsl" type="text/xsl"?>
<resultados xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="xml/resultados.xsd">
					        """;
			String footer = """ 
					</resultados>
					""";
			
			bufferWriter.write(header); 
			bufferWriter.newLine();
		
			
			
			for (int i = 0; i < weeks.size(); i++) {
				
				String weekID =  String.valueOf(weeks.get(i).getWeekID());
				 String week = "<jornada id=\"" + weekID + "\">";
				 bufferWriter.write(week); 
				 bufferWriter.newLine();
				 
			for (int j = 0; j < 3; j++) {
				String gameID = String.valueOf(j + 1);
				 String orden;
				 switch (i) {
				 case 1:
					 orden = "<order UNO \">";
					 bufferWriter.write(orden); 
					 break;
				 }
				 String game = "<partido id=\"" + gameID + "\">";
			}
			/*

				String posiscion = " <posicion>" + id +"</posicion>";
				
				
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
				bufferWriter.write("</jornada>"); 
				bufferWriter.newLine();
				*/
		
		
			bufferWriter.write(footer); 
			bufferWriter.newLine();
			bufferWriter.close();
			fileWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
