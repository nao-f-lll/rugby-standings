package com.standings.ui;

import java.awt.EventQueue;

import com.standings.credentials.LoginCredentials;
import com.standings.ui.page.LoginPage;

/**
 * Clase principal que inicia la aplicación.
 * 
 * <p>
 * Esta clase contiene el método <code>main</code> que inicia la aplicación . 
 * Seencarga de crear una instancia de <code>LoginCredentials</code>
 * para manejar las credenciales de inicio de sesión y pasarla a la página de
 * inicio de sesión.
 * </p>
 * 
 * <p>
 * La aplicación se ejecuta en el hilo de eventos de Swing para
 * garantizar la concurrencia segura de Swing.
 * </p>
 * 
 * @see com.standings.credentials.LoginCredentials
 * @see com.standings.ui.page.LoginPage
 */
public class Drawing {

	  /**
     * Método principal que inicia la aplicación.
     * 
     * <p>
     * Este método crea una instancia de <code>LoginCredentials</code> y la pasa
     * a la página de inicio de sesión para iniciar la aplicación.
     * </p>
     * 
     * <p>
     * La aplicación se ejecuta en el hilo de eventos de Swing para
     * garantizar la concurrencia segura de Swing.
     * </p>
     * 
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCredentials credentials = new LoginCredentials();
			        new LoginPage(credentials);			    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}