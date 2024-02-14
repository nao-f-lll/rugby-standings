package com.standings.model;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.standings.ui.page.LoginPage;

/**
 * Clase que representa un marco principal (ventana) extendido desde JFrame con funcionalidades adicionales.
 *
 * <p>
 * Esta clase proporciona un marco básico para otras ventanas en la aplicación.
 * Contiene métodos para cambiar el ícono de la ventana y redimensionar imágenes.
 * </p>
 *
 * <p>
 * Esta clase es utilizada como una clase base para otras ventanas en la aplicación.
 * </p>
 *
 * @author SomeOne 
 * @version 1.0
 * @since 2024-02-02
 */
public class ParentFrame extends JFrame {

	// declaracion de variables 
	private static final long serialVersionUID = 1L;
	private final ImageIcon nflIconFrame = new ImageIcon(LoginPage.class.getResource("/images/worldRugbyLogoBlack.png"));
	private Image logo;
	private static  Image logoStatic;

	
	 /**
     * Constructor de la clase ParentFrame.
     * Inicializa el ícono de la ventana y establece la operación de cierre.
     */
	public ParentFrame () {
	    this.setIconImage(nflIconFrame.getImage());
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	
	
	/**
     * Cambia el tamaño de una imagen dada según las dimensiones proporcionadas.
     *
     * @param imagePath Ruta de la imagen.
     * @param width     Ancho deseado.
     * @param height    Altura deseada.
     * @return Objeto de imagen redimensionado.
     * 
     * @requires La ruta de la imagen debe ser válida y contener una imagen.
     * @modifies Este objeto.
     * @effects Cambia el tamaño de la imagen dada para que coincida con el ancho y la altura dados, y luego la devuelve.
     */
	protected Image ResizeIcon(String ImagePath, int width, int height) {
		logo = new ImageIcon(LoginPage.class.getResource(ImagePath)).getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT);
		return logo;
	}
	
	
	 /**
     * Método estático para cambiar el tamaño de una imagen según las dimensiones proporcionadas.
     *
     * @param imagePath Ruta de la imagen.
     * @param width     Ancho deseado.
     * @param height    Altura deseada.
     * @return Objeto de imagen redimensionado.
     * 
     * @requires La ruta de la imagen debe ser válida y contener una imagen.
     * @modifies ParentFrame.
     * @effects Cambia el tamaño de la imagen dada para que coincida con el ancho y la altura dados, y luego la devuelve.
     */
	public static Image ResizeIconStatic(String ImagePath, int width, int height) {
		logoStatic = new ImageIcon(LoginPage.class.getResource(ImagePath)).getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT);
		return logoStatic;
	}
	
	
	
	
	

}