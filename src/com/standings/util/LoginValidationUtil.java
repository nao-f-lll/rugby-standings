package com.standings.util;

import java.util.HashMap;

import com.standings.credentials.LoginCredentials;



public class LoginValidationUtil {
	
	public static final int ALL_FIELDS_ARE_EMPTY = 1;
	public static final int EMAIL_FIELD_IS_EMPTY = 2;
	public static final int PASSWORD_FIELD_IS_EMPTY = 3; 
	public static final int EMAIL_NOT_FOUND = 4;  
	public static final int INCORRECT_PASSWORD = 5;
	public static final int ALL_CHECKS_PASSED = 6;
	
	
    
	//REQUIRES: userEmail and userPassword musn't be a null value.
	//EFFECTS : returns the appropriate number case based on the given case.
	
    public static int validateLogin(HashMap<String, String> loginInfo,  String userEmail, String userPassword) {
    	 if (userEmail.isEmpty() && userPassword.isEmpty()) {
             return ALL_FIELDS_ARE_EMPTY;
         } else if (userEmail.isEmpty()) {
             
             return EMAIL_FIELD_IS_EMPTY;
         } else if (userPassword.isEmpty()) {
          
             return PASSWORD_FIELD_IS_EMPTY;
         } else if (!loginInfo.containsKey(userEmail)) {
          
             return EMAIL_NOT_FOUND;
         } else if (!loginInfo.get(userEmail).equals(userPassword)) {
             
             return INCORRECT_PASSWORD;
         }
       
         return ALL_CHECKS_PASSED;
     }
    
    
    public static int getUserSessionId(LoginCredentials credentials, String userEmail) {
    	int sessionId = -1;
    	for (int i = 0; i < credentials.getUsers().size(); i++) {
			if (credentials.getUsers().get(i).getEmail().equals(userEmail)) {
				sessionId = credentials.getUsers().get(i).getSessionId();
				break;
			}
		}
    	return sessionId;
    }
    
    	
 }

