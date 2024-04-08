
/*
 
 package com.standings.test;
 


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.standings.util.SignUpValidationUtil;

public class SignUpValidationUtilTest {

	private String userFullName;
	private String userEmail;
	private String userPassword;

	@Before 
	public void setUp() {
		 userFullName = "user";
		 userEmail    = "user@gmail.com";
		 userPassword = "Password!1";
	}
	
    @Test
    public void testCheckForEmptyFieldNoFieldIsEmpty() {
        boolean result = SignUpValidationUtil.checkForEmptyField(userFullName, userEmail, userPassword);
        assertFalse(result);
    }
    
    @Test
    public void testCheckForEmptyFieldAllFieldsAreEmpty() {
        boolean result = SignUpValidationUtil.checkForEmptyField("", "", "");
        assertTrue(result);
    }

    @Test
    public void testCheckForEmptyFieldTwoFieldsNoOneIsEmpty() {
        boolean result = SignUpValidationUtil.checkForEmptyField(userFullName, userEmail);
        assertFalse(result);
    }

    @Test
    public void testCheckForEmptyFieldTwoFieldsBothAreEmpty() {
        boolean result = SignUpValidationUtil.checkForEmptyField("", "");
        assertTrue(result);
    }

    
    @Test
    public void testCheckForEmptyFieldOneFieldIsNotEmpty() {
        boolean result = SignUpValidationUtil.checkForEmptyField(userFullName);
        assertFalse(result);
    }
    
    @Test
    public void testCheckForEmptyFieldOneFieldIsEmpty() {
        boolean result = SignUpValidationUtil.checkForEmptyField("");
        assertTrue(result);
    }
    
    
    
    @Test
    public void isValidEmailValidOne() {
        boolean result = SignUpValidationUtil.isValidEmail(userEmail);
        assertTrue(result);
    }
    
    @Test
    public void isValidEmailNotValidOne() {
        boolean result = SignUpValidationUtil.isValidEmail("not,valid.email");
        assertFalse(result);
    }
    
    
    @Test
    public void isValidPasswordValidOne() {
        boolean result = SignUpValidationUtil.isValidPassword(userPassword);
        assertTrue(result);
    }
    
    @Test
    public void isValidPasswordNotValidOne() {
        boolean result = SignUpValidationUtil.isValidPassword("password");
        assertFalse(result);
    }
    
    @Test
    public void isValidFullNameValidOne() {
        boolean result = SignUpValidationUtil.isValidFullName(userFullName);
        assertTrue(result);
    }
    
    @Test
    public void isValidFullNameNotValidOne() {
        boolean result = SignUpValidationUtil.isValidFullName("544James 44");
        assertFalse(result);
    }
    
}
*/
