package com.standings.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.standings.credentials.LoginCredentials;

public class SignUpValidationUtil {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*\\d).{8,}$");
    private static final Pattern FULL_NAME_PATTERN = Pattern.compile("^[a-zA-Z]+( [a-zA-Z]+)*$");
    //private static final Pattern FULL_NAME_PATTERN = Pattern.compile("^[a-zA-ZñÑçÇáÁóÓíÍéÉúÚ]+( [a-zA-ZñÑçÇáÁóÓíÍéÉúÚ]+)*$");

    
    
	//REQUIRES: fields musn't be a null value.
	//EFFECTS : returns false if no field is empty; otherwise return true.
    
	public static boolean checkForEmptyField(String... fields) {
	    for (String field : fields) {
	        if (!field.isEmpty()) {
	            return false;
	        }
	    }
	    return true;
	}
 
	//EFFECTS: check if the email comply with format of an email.
	 
    public static boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    //EFFECTS: check if the password comply with format of PASSWORD_PATTERN,
    //        (e.g at least 8 characters one of them is upper case and one number).
    
    public static boolean isValidPassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }
    
    public static boolean arePasswordsTheSame(String password, String ConfirmationPassword) {
    	return password.equals(ConfirmationPassword);
    }

    //EFFECTS: check if the full name hasn't any numbers or special characters.
    
    public static boolean isValidFullName(String fullName) {
        Matcher matcher = FULL_NAME_PATTERN.matcher(fullName);
        return matcher.matches();
    }
    
    
    public static int getUserSessionId(LoginCredentials credentials) {
    	int lastUser =  credentials.getUsers().size() - 1;
    	int sessionId = credentials.getUsers().get(lastUser).getSessionId();
    	return sessionId;
    }
}
