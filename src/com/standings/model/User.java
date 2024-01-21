package com.standings.model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2123744883602981956L;
	private int sessionId;
	private String name;
	private String email;
	private String password;
	
	
	public User(String name, String email, String password, ArrayList<Integer> sessionIds) {
		this.sessionId = checkForSessionId(sessionIds);
		this.name = name;
		this.email = email;
		this.password =	password;
	}
	
	
	public int getSessionId() {
		return sessionId;
	}


	public String getPassword() {
		return password;
	}




	public String getName() {
		return name;
	}

	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public void setName(String name) {
		this.name = name;
	}



	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	private int checkForSessionId(ArrayList<Integer> sessionIds) {
		int tempsessionId = 0;
		do {
			tempsessionId = (int) (Math.random() * 100);
		} while(sessionIds.contains(tempsessionId));
		
		return tempsessionId;
	}



	@Override
	public String toString() {
		return "User [sessionId= " + sessionId + ", name= " + name + ", email= " + email + ", password= " + password + "]";
	}
	
	
	
}
