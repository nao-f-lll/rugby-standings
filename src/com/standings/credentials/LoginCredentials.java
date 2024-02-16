package com.standings.credentials;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import com.standings.model.User;
import com.standings.util.FileIO;

/**
 * 
 * Clase que maneja las credenciales de inicio de sesión y la información del usuario.
 *
 * @author SomeOne
 * @version 1.0
 * @since 2024-02-02
 */

public class LoginCredentials implements Serializable{

	// declaracion de variables y metodos
	
	private static final long serialVersionUID = -8698867336887932284L;
	private HashMap<String, String> loginInfo = new HashMap<String, String>();
    private final String FILE_PATH = "data/objects/users.ser";
    private ArrayList<User> users;
    private ArrayList<Integer> sessionIds;
    private User user;
    private FileIO<User> fileIo;
    
    
    /**
     * Constructor de la clase. Inicializa listas y lee los datos de usuario almacenados.
     */
    
    public LoginCredentials() {
    	sessionIds = new ArrayList<>();
    	users = new ArrayList<>();
    	fileIo = new FileIO<>();
    	readUserData(); 	  	
    }
      
    // getters
    
    /**
     * Obtiene el mapa de información de inicio de sesión (email -> contraseña).
     *
     * @return El mapa de información de inicio de sesión.
     */
    
    public HashMap<String, String> getLogingInfo() {
    	return loginInfo; }
    
    /**
     * Obtiene la lista de usuarios almacenados.
     *
     * @return La lista de usuarios.
     */
    public ArrayList<User> getUsers() {
    	return users;
    }
    
   
    /**
     * Guarda los datos de un nuevo usuario y su información de inicio de sesión.
     *
     * @param name          Nombre del usuario.
     * @param userEmail     Correo electrónico del usuario.
     * @param userPassword  Contraseña del usuario.
     */
    public void saveUserData(String name,String userEmail, String userPassword){
    	loginInfo.put(userEmail, userPassword);
    	User user = new User(name, userEmail, userPassword, sessionIds); 
    	users.add(user);
    	fileIo.writeObject(FILE_PATH, users);	
    }
    
   
    
    /**
     * 	Lee los datos de usuario almacenados en el archivo y actualiza la información de
     *  inicio de sesión.
     */
    private void  readUserData() {
    	user = null;	
    	users = fileIo.readObject( FILE_PATH, users);
    	
    	 for (int i = 0; i < users.size(); i++) {
         	user = users.get(i);
         	 loginInfo.put(user.getEmail(), user.getPassword());
         }
    }    
}