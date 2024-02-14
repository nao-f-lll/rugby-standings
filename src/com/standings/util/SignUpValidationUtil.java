package com.standings.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.standings.credentials.LoginCredentials;

/**
 * Clase utilizada para validar datos de registro de usuarios.
 */
public class SignUpValidationUtil {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*\\d).{8,}$");
    private static final Pattern FULL_NAME_PATTERN = Pattern.compile("^[a-zA-ZñÑçÇáÁóÓíÍéÉúÚ]+( [a-zA-ZñÑçÇáÁóÓíÍéÉúÚ]+)*$");

    
    

    /**
     * Verifica si algun campo esta¡ vacio.
     *
     * @param fields Campos a verificar.
     * @return true si algun campo esta¡ vaci­o, false de lo contrario.
     */
    
	public static boolean checkForEmptyField(String... fields) {
	    for (String field : fields) {
	        if (!field.isEmpty()) {
	            return false;
	        }
	    }
	    return true;
	}
 
	/**
     * Verifica si un email es valido.
     *
     * @param email Email a verificar.
     * @return true si el email es valido, false de lo contrario.
     */
	 
    public static boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

   
    /**
     * Verifica si una contraseña es valida.
     *
     * @param password Contraseña a verificar.
     * @return true si la contraseña es valida, false de lo contrario.
     */
    public static boolean isValidPassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }
    
    /**
     * Verifica si dos contraseñas son iguales.
     *
     * @param password Contraseña a comparar.
     * @param confirmationPassword Confirmacion de la contraseña.
     * @return true si las contraseñas son iguales, false de lo contrario.
     */
    public static boolean arePasswordsTheSame(String password, String ConfirmationPassword) {
    	return password.equals(ConfirmationPassword);
    }

    /**
     * Verifica si un nombre completo es valido.
     *
     * @param fullName Nombre completo a verificar.
     * @return true si el nombre completo es valido, false de lo contrario.
     */
    
    public static boolean isValidFullName(String fullName) {
        Matcher matcher = FULL_NAME_PATTERN.matcher(fullName);
        return matcher.matches();
    }
    
    
    /**
     * Obtiene el ID de sesion del ultimo usuario registrado.
     *
     * @param credentials Credenciales de inicio de sesion.
     * @return El ID de sesiÃ³n del ultimo usuario registrado.
     */
    public static int getUserSessionId(LoginCredentials credentials) {
    	int lastUser =  credentials.getUsers().size() - 1;
    	int sessionId = credentials.getUsers().get(lastUser).getSessionId();
    	return sessionId;
    }
}
