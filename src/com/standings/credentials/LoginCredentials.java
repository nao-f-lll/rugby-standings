package com.standings.credentials;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    	writeUserDataFromRationalDB(user);
    	
    	
    	
    	
    	
    }
    
    
    private void writeUserDataFromRationalDB(User user)  {
    	
    	try {
    		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/usuarios", "root", "");

			Statement st = conexion.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 
			try  {
				st.executeUpdate("INSERT INTO usuarios.usuario(username, email, sessionID, upassword) VALUES ('" + user.getName() +"','" + user.getEmail() + "','" + user.getSessionId() + "','" + user.getPassword() + "');");
				st.close();
			
				conexion.close();
			} catch (SQLException e) {
				int errorcode = e.getErrorCode();
				if (errorcode == 1062) {
					System.out.println("Error Clave Duplicada. Ya existe un registro con esa clave.");
				}
			}
    	}  
    		catch (SQLException e) {
		
	
			e.printStackTrace();
		}
    }
   
    
    /**
     * 	Lee los datos de usuario almacenados en el archivo y actualiza la información de
     *  inicio de sesión.
     */
    private void  readUserData() {
    
    	
    	readUserDataFromRationalDB();
 
    	
    }   
    
    
    private void readUserDataFromRationalDB() {
    	
    	user = null;
    	
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/usuarios", "root", "");
		

			Statement st = conexion.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	
			
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios.usuario;");
		
			if(rs.first()) {
		
				rs.beforeFirst();
				while (rs.next()){
					
					user = new User((String) rs.getObject("username"), (String) rs.getObject("email"), (String) rs.getObject("upassword"), (int) rs.getObject("sessionID"));
			    	users.add(user);
				}
				
			}
			else {
			
			}
			
			rs.close();
	
			st.close();
			
			conexion.close();
		} catch (SQLException e) {
		
	
			e.printStackTrace();
		}
    	
    			
   	 for (int i = 0; i < users.size(); i++) {
        	user = users.get(i);
        	 loginInfo.put(user.getEmail(), user.getPassword());
        }
    }
}