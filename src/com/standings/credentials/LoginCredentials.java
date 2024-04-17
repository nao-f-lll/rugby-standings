package com.standings.credentials;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.*;
import com.standings.model.User;

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
    private ArrayList<User> users;
    private ArrayList<Integer> sessionIds;
    
    
    /**
     * Constructor de la clase. Inicializa listas y lee los datos de usuario almacenados.
     */
    
    public LoginCredentials() {
    	sessionIds = new ArrayList<>();
    	users = new ArrayList<>();
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
    	
    	
    	writeDataToOODataBase(user);
    }
     
    
    // TO DO
    private void writeDataToOODataBase(User user) {
    	
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("objectdb:db/users.odb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();	
    }
   
    /**
     * 	Lee los datos de usuario almacenados en el archivo y actualiza la información de
     *  inicio de sesión.
     */
    
    
    private void  readUserData() {
    	readUserdataFromOODataBase();
			
    }    
    
    private void readUserdataFromOODataBase() {
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("objectdb:db/users.odb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
		
		List<User> results = typedQuery.getResultList();
			
		for (User user : results) {
			loginInfo.put(user.getEmail(), user.getPassword());
			users.add(user);
		}  
		
    }
}