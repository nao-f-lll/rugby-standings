package com.standings.ui.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.standings.credentials.LoginCredentials;
import com.standings.model.ParentFrame;
import com.standings.model.Season;
import com.standings.util.FileIO;
import com.standings.util.LoginValidationUtil;
import com.standings.util.Time;


/**
 * Clase que representa la página de inicio de sesión de la aplicación.
 * 
 * <p>
 * Esta clase contiene la interfaz gráfica de la página de inicio de sesión,
 * que incluye campos para ingresar el correo electrónico y la contraseña,
 * botones para iniciar sesión y registrarse, y mensajes de error para manejar
 * diferentes casos de validación.
 * </p>
 * 
 * <p>
 * La clase implementa ActionListener y KeyListener para manejar eventos de
 * acción y teclado respectivamente.
 * </p>
 * 
 * <p>
 * Utiliza la clase LoginCredentials para acceder a la información de inicio de
 * sesión y la clase LoginValidationUtil para validar las credenciales
 * ingresadas por el usuario.
 * </p>
 * 
 * <p>
 * Esta clase extiende ParentFrame, que es una clase personalizada que
 * encapsula las configuraciones básicas de la interfaz de usuario.
 * </p>
 * 
 * @see com.standings.credentials.LoginCredentials
 * @see com.standings.util.LoginValidationUtil
 * @see com.standings.model.ParentFrame
 * @see java.awt.event.ActionListener
 * @see java.awt.event.KeyListener
 * @author SomeOne
 * @version 1.01.1
 */
public class LoginPage extends ParentFrame  implements ActionListener, KeyListener  {
	
	// delcaracion de las variables 
	private static final long serialVersionUID = 6002789331622401022L;

	private final int ALL_FIELDS_ARE_EMPTY = 1;
	private final int EMAIL_FIELD_IS_EMPTY = 2;
	private final int PASSWORD_FIELD_IS_EMPTY = 3; 
	private final int EMAIL_NOT_FOUND = 4;  
	private final int INCORRECT_PASSWORD = 5; 
	private final int GUEST_SESSION_ID = -1;
	
    private ImageIcon nflIcon;
    
	private  HashMap<String, String> loginInfo;
	
    private JLabel nflIconLabel;
    private JLabel copyRights;
    private JLabel loginLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel creatAccountLabel;
    
	private JPanel mainPanel;
	private JPanel leftIneerPanel;   
    private JPanel rightInnerPanel;
    
    
    private JTextField emailField;
    private JPasswordField passwordField;
      
    private JButton loginButton;
    private JButton signUpButton;
    
    private JLabel errorMessageForEmail;
    private JLabel errorMessageForPassword;
    
    private int validationNumber;
    private LoginCredentials credentials;
    private int sessionId;
   
   
    private FileIO<Season> fileIo;
   
    /**
	 * Constructor de la página de inicio de sesión.
	 * 
	 * @param credentials Objeto LoginCredentials utilizado para manejar las
	 *                    credenciales de inicio de sesión.
	 */
	public LoginPage(LoginCredentials credentials ) {	
		
		initializeFrameGraphics( credentials );	
		initializePanelGraphics();	
	}
	
	
	
	
	private void initializeFrameGraphics(LoginCredentials credentials ) {
		this.credentials = credentials;
		fileIo = new FileIO<>();
		this.setTitle("Iniciar sesión");	
		this.setLocationRelativeTo(null);	
		this.loginInfo = credentials.getLogingInfo();
		this.setResizable(false);
		this.setSize(650,400);
		setSizeAndCenter();

		
	}
	
    
	 /** 
     * Establece el tamaño y centra la ventana en la pantalla.
     */
    private void setSizeAndCenter() {
	    Toolkit tool = getToolkit();
	    Dimension screenSize = tool.getScreenSize();
	    this.setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
	   
    }
	

    /** 
     * Inicializa los gráficos del panel principal y sus subpaneles.
     */
	 private void initializePanelGraphics() {
		 initialMainPanel();
		 initialLeftPanel();
		 initialRightPanel();
	 }
	
	 /** 
	  * Inicializa el panel principal.
	  */
	 private void initialMainPanel() {
			mainPanel = new JPanel();
			mainPanel.setBackground(new Color(238, 238, 236));
			getContentPane().add(mainPanel, BorderLayout.CENTER);
			mainPanel.setLayout(null);
	 }
	 
	/** 
	* Inicializa el subpanel izquierdo.
	*/
	 private void initialLeftPanel() {
			leftIneerPanel = new JPanel();   
			leftIneerPanel.setBounds(0, 0, 322, 376);		
			leftIneerPanel.setLayout(null);
			leftIneerPanel.setBackground(new Color(255,255,255));
			mainPanel.add(leftIneerPanel);
			initialNflIcon();
			initialCopyRights();
	 }
	 
	 	/** 
	     * Inicializa el icono del subpanel izquierdo.
	     */
	 
	 private void initialNflIcon() {
			nflIcon = new ImageIcon(ResizeIcon("/images/worldRugbyLogoBlack.png",150,200));
			nflIconLabel = new JLabel("");
			nflIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
			nflIconLabel.setIcon(nflIcon);
			nflIconLabel.setBounds(83, 49, 150, 211);
			leftIneerPanel.add(nflIconLabel);
	 }
	 
		/** 
	     * Inicializa los derechos de autor en el subpanel izquierdo.
	     */
	 private void initialCopyRights() {
			copyRights = new JLabel("<html> Copyright © 2024 World Rugby.<br> All rights reserved. </html>");
			copyRights.setBounds(83,251,160,40);
		    copyRights.setFont(new Font(null, Font.PLAIN,10));
		    leftIneerPanel.add(copyRights);
	 }
	 
	 
	 	/** 
	     * Inicializa el subpanel derecho.
	     */
	 private void initialRightPanel() {
		 rightInnerPanel = new JPanel();
		 rightInnerPanel.setBounds(323, 0, 317, 376); 
		 rightInnerPanel.setLayout(null);
		 mainPanel.add(rightInnerPanel);
		 initializeLabeles();
		 initializeEmail();
		 initializePassword();
		 initialzeButtons();
	
	 }
	 
	/** 
	* Inicializa las etiquetas de la interfaz de usuario, como "Iniciar sesión" y "¿Crear una cuenta?".
	*/
	 private void initializeLabeles() {
			loginLabel = new JLabel("Iniciar sesión");
			loginLabel.setVerticalAlignment(SwingConstants.TOP);
	        loginLabel.setBounds(45,22,184,42);
	        loginLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
	        rightInnerPanel.add(loginLabel);
	            
		    creatAccountLabel = new JLabel("¿Crear una cuenta?");
		    creatAccountLabel.setBounds(24, 310, 159, 15);
		    rightInnerPanel.add(creatAccountLabel);
	 }
	 
	 private void initializeEmail() {
	        emailLabel = new JLabel("Email");
		    emailLabel.setBounds(34,75,50,25);
		    rightInnerPanel.add(emailLabel);
			emailField = new JTextField();
			emailField.setBounds(34,100,200,25);
			emailField.addKeyListener(this);  
			rightInnerPanel.add(emailField);
			fieldFocusListener(emailField,null);
			
	 }
	 
	 
	 private void initializePassword() {
		    passwordLabel = new JLabel("Contraseña");
		    passwordLabel.setBounds(34,140,70,15);
		    rightInnerPanel.add(passwordLabel);    
		    passwordField = new JPasswordField();
		    passwordField.setBounds(34, 162, 200, 25);   
		    passwordField.addKeyListener(this);
		    rightInnerPanel.add(passwordField); 
		    fieldFocusListener(null,passwordField);
	 }
	 
	 	/** 
		 * Establece los controladores de eventos de foco para los campos de correo electrónico y contraseña.
		 */
	 public void fieldFocusListener(JTextField emailField, JPasswordField passwordField) {
		 if (emailField != null) {
			 emailField.addFocusListener(new FocusListener() {
				    @Override
				    public void focusGained(FocusEvent e) {
				        errorMessageForEmail.setText("");
				    }

				    @Override
				    public void focusLost(FocusEvent e) {
				     
				    }
				});
		 } else if (passwordField != null) {
				passwordField.addFocusListener(new FocusListener() {
				    @Override
				    public void focusGained(FocusEvent e) {
				    	errorMessageForPassword.setText("");
				    }

				    @Override
				    public void focusLost(FocusEvent e) {
				       
				    }
				});
		 }
	}
	 
	 	/** 
		 * Inicializa los botones "Iniciar sesión" y "Registrarse".
		 */
	 private void initialzeButtons() {
		    loginButton = new JButton("Iniciar sesión");
			loginButton.setBounds(34, 215, 111, 25);
	        loginButton.setFocusable(false);
	        loginButton.addActionListener(this);
	        loginButton.setBackground(Color.lightGray);
	        rightInnerPanel.add(loginButton);
		    
	        signUpButton = new JButton("Regístrar");
			signUpButton.setBounds(190, 305, 100, 25);
	        signUpButton.setFocusable(false);
	        signUpButton.addActionListener(this);
	        signUpButton.setBackground(Color.lightGray);
			rightInnerPanel.add(signUpButton);	
			
			initializeErrorMessages();
	 }
	 
	 	/** 
		 * Inicializa los mensajes de error para el campo de correo electrónico y la contraseña.
		 */
	 
	private void initializeErrorMessages() {
		errorMessageForEmail = new JLabel();
		errorMessageForEmail.setText("");
		errorMessageForEmail.setBounds(136, 75, 130, 25);
		errorMessageForEmail.setForeground(Color.RED);
		rightInnerPanel.add(errorMessageForEmail);
			
		errorMessageForPassword = new JLabel();
		errorMessageForPassword.setForeground(Color.RED);
		errorMessageForPassword.setBounds(134, 136, 111, 25);
		rightInnerPanel.add(errorMessageForPassword);	
	}
		 
	
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		userClickLoginLogic(e);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		userKeyboardLoginLogic(e);

    }

	@Override
	public void keyTyped(KeyEvent e) {
		char keyChar = e.getKeyChar();
		if (keyChar != KeyEvent.VK_ENTER) {
			errorMessageForPassword.setText("");
			  errorMessageForEmail.setText("");
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	
	/** 
	 * Maneja la lógica cuando se presiona una tecla mientras se está en un campo de texto.
	 * Si la tecla presionada es 'Enter', valida las credenciales y ejecuta la lógica correspondiente.
	 * @param e El evento de tecla que desencadena la llamada al método.
	 */
	
	private void userKeyboardLoginLogic(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
        	validationNumber = LoginValidationUtil.validateLogin(loginInfo, emailField.getText(),String.valueOf(passwordField.getPassword()));
        	handleValidationNumber(validationNumber);
        }
	}
	
	
	
	/** 
	 * Maneja la lógica cuando se hace clic en los botones de inicio de sesión o registro.
	 * @param e El evento de acción que desencadena la llamada al método.
	 */
	
	private void userClickLoginLogic(ActionEvent e) {
		
		Object component = e.getSource(); 
		if (component == loginButton) {		
	     	validationNumber = LoginValidationUtil.validateLogin(loginInfo, emailField.getText(),String.valueOf(passwordField.getPassword()));
        	handleValidationNumber(validationNumber);

		} else if (component == signUpButton) {
			this.dispose();
			new SignUpPage(credentials);
			
		}
	}
	

	/** 
	 * Maneja los diferentes casos de validación de inicio de sesión y muestra mensajes de error apropiados o inicia sesión según corresponda.
	 * @param validationNumber El número que representa el resultado de la validación del inicio de sesión.
	 */
	
	private void handleValidationNumber(int validationNumber) {
		switch (validationNumber) {
		case ALL_FIELDS_ARE_EMPTY:
			errorMessageForEmail.setText("Campo obligatorio");
			errorMessageForPassword.setText("Campo obligatorio");
			break;
		case EMAIL_FIELD_IS_EMPTY:
			errorMessageForEmail.setText("Campo obligatorio");
			break;
		case PASSWORD_FIELD_IS_EMPTY:
			errorMessageForPassword.setText("Campo obligatorio");
			break;
		case EMAIL_NOT_FOUND:
			errorMessageForEmail.setText("Email no registrado");
			fileIo.writeToFile(Time.getCurrentTime(), "data/logs/failed_attempts.cvs", "Email no registrado", emailField.getText() , GUEST_SESSION_ID);
			break;
		case INCORRECT_PASSWORD:
			errorMessageForPassword.setText("Clave incorrecta");
			sessionId = LoginValidationUtil.getUserSessionId(credentials, emailField.getText());
			fileIo.writeToFile(Time.getCurrentTime(), "data/logs/failed_attempts.cvs", "Contraseña incorrecta",emailField.getText(), sessionId);
			break;
		default :
			this.dispose(); 
			sessionId = LoginValidationUtil.getUserSessionId(credentials, emailField.getText());
			fileIo.writeToFile(Time.getCurrentTime(), "data/logs/successful_attempts.cvs", "Inicio de sesion correcto",emailField.getText(), sessionId); 
	
			new SportsDashboardPage();
		}
	}	
}