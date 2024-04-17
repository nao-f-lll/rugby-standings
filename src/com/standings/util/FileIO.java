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

/**
 * Clase para manejar las operaciones de entrada/salida de archivos.
 *
 * @param <T> Tipo de objeto generico.
 */
public class FileIO <T> implements Serializable{


	
	private static final long serialVersionUID = -3718018196140010999L;
	private static   BufferedWriter bufferWriter;
	public static   FileWriter fileWriter; 
 
	 /**
     * Constructor de la clase FileIO.
     */
	public FileIO() {
		
	}
	
	 /**
     * Escribe datos en un archivo.
     *
     * @param timeStamps     Marca de tiempo para el registro.
     * @param data           Datos a escribir.
     * @param filePath       Ruta del archivo.
     * @param additionalInfo Información adicional para el registro.
     * @param sessionId      ID de sesión.
     */
	public void writeToFile(String timeStamps, String filePath, String additionalInfo, String userName, int sessionId) {
		
		if (sessionId == -1) {
			sessionId = (int) (Math.random()  * 100);
		}
		
		try {
			fileWriter = new FileWriter(filePath, true);
			bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write("Registro: " + additionalInfo + ", ID de sesion: " + sessionId + ", nombre de usuario o email: " + userName + ", tiempo: " + timeStamps);
			bufferWriter.newLine();
			bufferWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public void writeToFile(String timeStamps, String filePath, String additionalInfo, String teamName) {
		
	
		try {
			fileWriter = new FileWriter(filePath, true);
			bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write("Registro: " + additionalInfo + ", nombre de equipo: " + teamName + ", tiempo: " + timeStamps);
			bufferWriter.newLine();
			bufferWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void writeToFile(String timeStamps, String filePath, String additionalInfo, int seasonId, int seasonYear) {
		
		
		try {
			fileWriter = new FileWriter(filePath, true);
			bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write("Registro: " + additionalInfo + ", id de temporada: " + seasonId + ", año de temporada: " + seasonYear + ", tiempo: " + timeStamps);
			bufferWriter.newLine();
			bufferWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Escribe los datos de on objeto en un archivo.
	 *
	 * @param timeStamps     Marca de tiempo para el registro.
	 * @param data           Datos a escribir.
	 * @param filePath       Ruta del archivo.
	 * @param additionalInfo Información adicional para el registro.
	 * @param sessionId      ID de sesión.
	 */
	
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
	
	
	/// need revision /////
	
	/**
     * Lee datos de un archivo.
     *
     * @param filePath Ruta del archivo.
     * @return Datos leídos del archivo.
     */
	
	public String readFile(String filePath) { 
        return null;
	}
	
	
	 /**
     * Lee un objeto desde un archivo.
     *
     * @param filePath Ruta del archivo.
     * @param object   Objeto a leer.
     * @return Objeto leído desde el archivo.
     */
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
	
	
	/**
     * Convierte una lista de jornadas en formato XML y la escribe en un archivo.
     *
     * @param weeks Lista de jornadas a convertir.
     */
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
					 orden = "<orden> Uno  </orden>";			
					 break;
				 case 2:
					 orden = "<orden> Dos  </orden>";	;
					 break;
				 case 3:
					 orden = "<orden> Tres  </orden>";	;
					 break;
				 case 4:
					 orden = "<orden> Cuatro  </orden>";	;
					 break;
				 case 5:
					 orden = "<orden> Cinco  </orden>";	;
					 break;
				 case 6:
					 orden = "<orden> Seis  </orden>";	;
					 break;
				 case 7:
					 orden = "<orden> Siete  </orden>";	;
					 break;
				 case 8:
					 orden = "<orden> Ocho  </orden>";	;
					 break;
				 case 9:
					 orden = "<orden> Nueve  </orden>";	;
					 break;
				 case 10:
					 orden = "<orden> Diez  </orden>";	;
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
				 String localTeamPoints;
				 
				 if (game.isActive()) {
					 localTeamPoints = "<puntos>" + game.getLocalScore() + "</puntos>";
				 } else {
					 localTeamPoints = "<puntos> ? </puntos>";

				 }
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
				 
				 String visitorTeamPoints;
				 
				 if (game.isActive()) {
					 visitorTeamPoints  = "<puntos>" + game.getVisitorScore() + "</puntos>";
				 } else {
					 visitorTeamPoints = "<puntos> ? </puntos>";

				 }
				 
				 
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
		
		
		/**
	     * Convierte los metadatos de las temporadas en formato XML y la escribe en un archivo.
	     *
	     * @param seasons Lista de temporadas.
	     */
		
		public void writeMetaData(ArrayList<Season> seasons) {
		
			try {
			fileWriter = new FileWriter("C:\\Users\\ik_1DW3A\\Documents\\nao-f-lll.github.io/clasificacion/temporadas.xml");
			String header = """
					<?xml version="1.0" encoding="UTF-8"?>
					<?xml-stylesheet href="clasificacion.xsl" type="text/xsl"?>
					<temporadas xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="temporadas.xsd">
										        """;
		

		bufferWriter = new BufferedWriter(fileWriter);
		
		String footer = """ 
				</temporadas>
				""";
		
		bufferWriter.write(header); 
		bufferWriter.newLine();
		System.out.println(seasons.size());
		for (int i = 0; i < seasons.size(); i++) {
			 bufferWriter.write("<temporada id=\"" + seasons.get(i).getId() + "\">"); 
			 bufferWriter.newLine();			 
			 bufferWriter.write("<year>" + seasons.get(i).getYear() + "</year>"); 
			 bufferWriter.newLine();			 
			 bufferWriter.write("<estado>" + seasons.get(i).getState() + "</estado>"); 
			 bufferWriter.newLine();
			 bufferWriter.write("</temporada>"); 
			 bufferWriter.newLine();
		}
		 bufferWriter.write(footer); 
		 bufferWriter.newLine();
		 
		 bufferWriter.close();
		fileWriter.close();
			
		} catch (EOFException e) {
			System.out.println("Archivo vacio");
		} catch (FileNotFoundException e) {
			System.out.println("No existe el archivo");
		}  catch (IOException e) {
		    e.printStackTrace();
		} catch (ClassCastException e)  {
			System.out.println("El objeto no es el mismo");
		}
	}
}

