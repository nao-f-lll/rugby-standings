package com.standings.test;

import org.junit.Before;
import org.junit.Test;

import com.standings.util.LoginValidationUtil;

import java.util.HashMap;
import static org.junit.Assert.assertEquals;

public class LoginValidationUtilTest {
    private HashMap<String, String> loginInfo;

    @Before
    public void setUp() {
        loginInfo = new HashMap<>();
        loginInfo.put("user@google.com", "Password");
    }

    @Test
    public void testValidateLoginAllFieldsEmpty() {
        int result = LoginValidationUtil.validateLogin(loginInfo, "", "");
        assertEquals(LoginValidationUtil.ALL_FIELDS_ARE_EMPTY, result);
    }

    @Test
    public void testValidateLoginEmailFieldEmpty() {
        int result = LoginValidationUtil.validateLogin(loginInfo, "", "password");
        assertEquals(LoginValidationUtil.EMAIL_FIELD_IS_EMPTY, result);
    }

    @Test
    public void testValidateLoginPasswordFieldEmpty() {
        int result = LoginValidationUtil.validateLogin(loginInfo, "user@example.com", "");
        assertEquals(LoginValidationUtil.PASSWORD_FIELD_IS_EMPTY, result);
    }

    @Test
    public void testValidateLoginEmailNotFound() {
        int result = LoginValidationUtil.validateLogin(loginInfo, "nonexistent@example.com", "password");
        assertEquals(LoginValidationUtil.EMAIL_NOT_FOUND, result);
    }

    @Test
    public void testValidateLoginIncorrectPassword() {
        int result = LoginValidationUtil.validateLogin(loginInfo, "user@google.com", "wrongPassword");
        assertEquals(LoginValidationUtil.INCORRECT_PASSWORD, result);
    }

    @Test
    public void testValidateLoginAllChecksPassed() {
        int result = LoginValidationUtil.validateLogin(loginInfo, "user@google.com", "Password");
        assertEquals(LoginValidationUtil.ALL_CHECKS_PASSED, result);
    }
}

