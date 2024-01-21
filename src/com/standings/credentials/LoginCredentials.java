package com.standings.credentials;

import java.util.ArrayList;
import java.util.HashMap;

import com.standings.model.User;
import com.standings.util.FileIO;

public class LoginCredentials {

    private HashMap<String, String> loginInfo = new HashMap<String, String>();
    private final String FILE_PATH = "data/objects/users.ser";
    private ArrayList<User> users;
    private ArrayList<Integer> sessionIds;
    private User user;
    private FileIO<User> fileIo;
    
    public LoginCredentials() {
    	sessionIds = new ArrayList<>();
    	users = new ArrayList<>();
    	fileIo = new FileIO<>();
    	readUserData(); 	  	
    }
      
    // getters
    public HashMap<String, String> getLogingInfo() { return loginInfo; }
    public ArrayList<User> getUsers() {
    	return users;
    }
    
    
    public void saveUserData(String name,String userEmail, String userPassword){
    	loginInfo.put(userEmail, userPassword);
    	User user = new User(name, userEmail, userPassword, sessionIds); 
    	users.add(user);
    	fileIo.writeObject(FILE_PATH, users);	
    }
    
   
    private void  readUserData() {
    	user = null;	
    	users = fileIo.readObject( FILE_PATH, users);
    	
    	 for (int i = 0; i < users.size(); i++) {
         	user = users.get(i);
         	 loginInfo.put(user.getEmail(), user.getPassword());
         }
    	
    	/// remove that later
    	for (int i = 0; i < users.size(); i++) {
    		System.out.println(users.get(i).toString());
    	}
    }    
}