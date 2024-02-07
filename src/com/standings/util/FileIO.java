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

import com.standings.model.Game;
import com.standings.model.Season;
import com.standings.model.Team;
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
	
		public void convertToXML(ArrayList<Week> weeks, Season season) {
		
		try {
		
			

				fileWriter = new FileWriter("C:\\Users\\ik_1DW3A\\Documents\\nao-f-lll.github.io/resultados/"+ season.getYear() + ".xml");
				String header = """
						<?xml version="1.0" encoding="UTF-8"?>
						<?xml-stylesheet href="resultados.xsl" type="text/xsl"?>
						<resultados xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="resultados.xsd">
											        """;
			
	
			bufferWriter = new BufferedWriter(fileWriter);
			
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
				 String orden = "";
				 switch (i + 1) {
				 case 1:
					 orden = "<orden> UNO  </orden>";			
					 break;
				 case 2:
					 orden = "<orden> DOS  </orden>";	;
					 break;
				 case 3:
					 orden = "<orden> TRES  </orden>";	;
					 break;
				 case 4:
					 orden = "<orden> CUATRO  </orden>";	;
					 break;
				 case 5:
					 orden = "<orden> CINCO  </orden>";	;
					 break;
				 case 6:
					 orden = "<orden> SIES  </orden>";	;
					 break;
				 case 7:
					 orden = "<orden> SIETE  </orden>";	;
					 break;
				 case 8:
					 orden = "<orden> OCHO  </orden>";	;
					 break;
				 case 9:
					 orden = "<orden> NUEVE  </orden>";	;
					 break;
				 case 10:
					 orden = "<orden> DIEZ  </orden>";	;
					 break;
				default:
					break;
				 }
				 
				 

				 bufferWriter.write(orden); 
				 bufferWriter.newLine();
				 
			for (int j = 0; j < 3; j++) {
				String gameID = String.valueOf(j + 1);
				 String gameStarter = "<partido id=\"" + gameID + "\">";
				 bufferWriter.write(gameStarter); 
				 bufferWriter.newLine();
				 String localTeamStarter = """
				<equipo_local>
				<logo> 		
				 		""";
				 bufferWriter.write(localTeamStarter); 
				
				 Team localTeam = weeks.get(i).getGames().get(j).getLocalTeam();
				 Game game = weeks.get(i).getGames().get(j);
				
				 
				
				 String localTeamImage = "<image>" +  "../" + localTeam.getIconPath() + "</image>";
				 
					 bufferWriter.write(localTeamImage); 
			
				 
				 
				 bufferWriter.newLine();
				 bufferWriter.write("</logo>"); 
				 bufferWriter.newLine();
				 String localTeamPoints = "<puntos>" + game.getLocalScore() + "</puntos>";
				 bufferWriter.write(localTeamPoints); 
				 bufferWriter.newLine();
				 bufferWriter.write("</equipo_local>"); 
				 bufferWriter.newLine();
				 String visitorTeamStarter = """
							<equipo_visitante>
							<logo> 		
							 		""";
				 bufferWriter.write(visitorTeamStarter); 
				
				 Team visitorTeam = weeks.get(i).getGames().get(j).getVisitorTeam();
				 

				 String visitorTeamImage  = "<image>" +  "../" + visitorTeam.getIconPath() + "</image>";;
				 
					 bufferWriter.write(visitorTeamImage); 
				 
				 
				 
				 bufferWriter.newLine();
				 bufferWriter.write("</logo>"); 
				 bufferWriter.newLine();
				 String visitorTeamPoints = "<puntos>" + game.getVisitorScore() + "</puntos>";
				 bufferWriter.write(visitorTeamPoints); 
				 bufferWriter.newLine();
				 bufferWriter.write("</equipo_visitante>"); 
				 bufferWriter.newLine();
				 bufferWriter.write("<fecha> LUN 28 OCT </fecha>"); 
				 bufferWriter.newLine();
				 bufferWriter.write("<hora>21:00</hora>"); 
				 bufferWriter.newLine();
				 bufferWriter.write("<estadio>Stade de France</estadio>"); 
				 bufferWriter.newLine();
				 bufferWriter.write("<ciudad>&#x20;Paris</ciudad>"); 
				 bufferWriter.newLine();
				 bufferWriter.write("</partido>"); 
				 bufferWriter.newLine();
			}
			 bufferWriter.write("</jornada>"); 
			 bufferWriter.newLine();
			}
		
			bufferWriter.write(footer); 
			bufferWriter.newLine();
			
			
			bufferWriter.close();
			fileWriter.close();
			
		} catch (EOFException e) {
			System.out.println("Archivo vacio");
		} catch (FileNotFoundException e) {
			System.out.println("no existe el archivo");
		}  catch (IOException e) {
		    e.printStackTrace();
		} catch (ClassCastException e)  {
			System.out.println("el objeto no es el mismo");
		}
			
	}	
}

