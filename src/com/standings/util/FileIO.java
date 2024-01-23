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

public class FileIO <T>   {


	private static  BufferedWriter bufferWriter;
	public static FileWriter fileWriter; 
 
	
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
}
