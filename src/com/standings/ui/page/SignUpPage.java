package com.standings.ui.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.standings.credentials.LoginCredentials;
import com.standings.model.ParentFrame;
import com.standings.model.User;
import com.standings.util.FileIO;
import com.standings.util.SignUpValidationUtil;
import com.standings.util.Time;

/**
 * La clase SignUpPage implementa la interfaz grafica y utiliza la logica de {@link SignUpValidationUtil}
 * para permitir a los usuarios crear cuentas
 * 
 * 
 * @author SomeOne
 */
public class SignUpPage extends ParentFrame implements ActionListener, KeyListener {

	
	/*
	 *declaracion de variables y constantes
	 */
	private static final long serialVersionUID = -4747175902106077767L;
	 
    private ImageIcon nflIcon;
    
	private HashMap<String, String> loginInfo;
	
    private JLabel nflIconLabel;
    private JLabel copyRights;
    private JLabel loginLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel creatAccountLabel;
    private JLabel repeatPasswordLabel;
    
	private JPanel mainPanel;
	private JPanel leftIneerPanel;   
    private JPanel rightInnerPanel;
    
    
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton signUpButton;
    private JLabel fullNameLabel;
    private JTextField fullNameField;
    private JPasswordField repeatPasswordField;
    private JButton loginButton;
	
    private JLabel errorMessageForEmail;
    private JLabel errorMessageForPassword ;
    private JLabel errorMessageForFullName;
    private JLabel errorMessageForRepeatPassword;
    
    private LoginCredentials credentials;
    private int sessionId;
    private FileIO<User> fileIo;
   
    
	
    
    /**
     * Constructor de la clase SignUpPage.
     * 
     * @param credentials Las credenciales de inicio de sesión.
     */
	public SignUpPage(LoginCredentials credentials) {
		
		setTitle("Registrar");
		initializFrameGraphics(credentials);
		initializePanelsGraphics();

	}
	
	/**
	 * Inicializa los gráficos del marco de la página de registro.
	 * 
	 * @param credentials Las credenciales de inicio de sesión.
	 */
	private void initializFrameGraphics( LoginCredentials credentials) {
		this.credentials = credentials;
		this.fileIo = new FileIO<>();
		this.setLocationRelativeTo(null);
		this.loginInfo = credentials.getLogingInfo();
		this.setResizable(false);
		this.setSize(650,479);
		setSizeAndCenter();
	}
	
	/**
	 * Establece el tamaño y centra el marco en la pantalla.
	 */
    private void setSizeAndCenter() {
	    Toolkit tool = getToolkit();
	    Dimension screenSize = tool.getScreenSize();
	    this.setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
    }
	
    /**
     * Inicializa los gráficos de los paneles principales.
     */
    private void initializePanelsGraphics() {
    	initializeMainPanel();
    	initializeRightInnerPanel();
    	initializeLeftInnerPanel();
    }
    
    /**
     * inicializa el panel principal
     */
    private void initializeMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(238, 238, 236));
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
    }
    
    /**
     * Inicializa el panel derecho interno.
     */
    private void initializeRightInnerPanel() {
	    rightInnerPanel = new JPanel();
		rightInnerPanel.setBounds(323, 0, 317, 442);
		mainPanel.add(rightInnerPanel);
		rightInnerPanel.setLayout(null);
		initializeLoginLabel();
		initializeEmail();
		initializePassword();
		initializeFullName();
		initializeCreatAcountLabel();
		initializeButtons();
		initializeErrorMessages();
    }
    
    /**
     *  Inicializa la etiqueta de inicio de sesión.
     */
   private void initializeLoginLabel() {
		loginLabel = new JLabel("Registrarse");
		loginLabel.setBounds(60, 23, 188, 42);
		loginLabel.setVerticalAlignment(SwingConstants.TOP);
		loginLabel.setFont(new Font(null, Font.PLAIN, 35));
		rightInnerPanel.add(loginLabel);
    }
   
   
   /**
    * Inicializa la etiqueta y el campo de entrada de correo electrónico.
    */
   private void initializeEmail() {
       emailLabel = new JLabel("Email");
       emailLabel.setBounds(34, 147, 50, 25);
	   rightInnerPanel.add(emailLabel);
	   
	   emailField = new JTextField();	
	   emailField.setBounds(34, 167, 200, 25);
	   rightInnerPanel.add(emailField);
	   emailField.addKeyListener(this); 
	   
   }
   
   /**
    * Inicializa las etiquetas y campos de entrada de contraseña y confirmación de contraseña.
    */
   private void initializePassword() {
	    passwordLabel = new JLabel("Clave");
	    passwordLabel.setBounds(34, 203, 70, 15);
	    rightInnerPanel.add(passwordLabel);
	    passwordField = new JPasswordField();
	    passwordField.setBounds(34, 219, 200, 25);
	    rightInnerPanel.add(passwordField);
	    passwordField.addKeyListener(this); 

	    
		repeatPasswordField = new JPasswordField();
		repeatPasswordField.setBounds(34, 268, 200, 25);
		repeatPasswordField.addKeyListener(this); 
		rightInnerPanel.add(repeatPasswordField);

		
		repeatPasswordLabel = new JLabel("Confirmar clave");
		repeatPasswordLabel.setBounds(34, 255, 146, 15);
		rightInnerPanel.add(repeatPasswordLabel);
   }

   
   /**
    *Inicializa la etiqueta y el campo de entrada de nombre completo.
    */
   private void initializeFullName() {
		fullNameLabel = new JLabel("Nombre");
		fullNameLabel.setBounds(34, 103, 70, 13);
		rightInnerPanel.add(fullNameLabel);
		
		fullNameField = new JTextField();
		fullNameField.setBounds(34, 116, 200, 25);
		rightInnerPanel.add(fullNameField);
		fullNameField.addKeyListener(this); 
		
   }
   
 
   /**
    * 
    */
   private void initializeCreatAcountLabel() {
	    creatAccountLabel = new JLabel("¿Ya tienes una cuenta?");
	    creatAccountLabel.setBounds(21, 379, 159, 15);
	    rightInnerPanel.add(creatAccountLabel);
   }
   
   /**
    * Inicializa los botones de "Iniciar sesión" y "Registrar".
    */
   private void initializeButtons() {
	   initializeLoginButton();
	   initializeSignUpButton();
   }
   
   /**
    * 
    */
   private void initializeLoginButton() {	
		loginButton = new JButton("Inicia sesión");
		loginButton.setBounds(183, 374, 111, 25);
		loginButton.setFocusable(false);
		loginButton.setBackground(Color.LIGHT_GRAY);
		rightInnerPanel.add(loginButton);
		loginButton.addActionListener(this);
   }
   
   /**
    * 
    */
   private void initializeSignUpButton() {
       signUpButton = new JButton("Registrar");
       signUpButton.setBounds(34, 316, 100, 25);
       signUpButton.addActionListener(this);
       signUpButton.setFocusable(false); 
       signUpButton.setBackground(Color.lightGray);
	   rightInnerPanel.add(signUpButton);	
   }
   
   /**
    * 
    */
   private void initializeErrorMessages() {
	   initializeEmailErrorMessage();
	   initializePasswordErrorMessage();
	   initializeFullNameErrorMessage();
   }
    
   /**
    * 
    */
   private void initializeEmailErrorMessage() {	   
	   	errorMessageForEmail = new JLabel();
		errorMessageForEmail.setForeground(Color.RED);
		rightInnerPanel.add(errorMessageForEmail);
		errorMessageForEmail.setBounds(137, 147, 111, 25);
   }
   
   /**
    * 
    */
   private void initializePasswordErrorMessage() {
	    errorMessageForPassword = new JLabel();
		errorMessageForPassword.setForeground(Color.RED);
		rightInnerPanel.add(errorMessageForPassword);
		errorMessageForPassword.setBounds(137, 193, 111, 25);
		
		errorMessageForRepeatPassword = new JLabel();
		errorMessageForRepeatPassword.setForeground(Color.RED);
		errorMessageForRepeatPassword.setBounds(137, 244, 111, 25);
		rightInnerPanel.add(errorMessageForRepeatPassword);
   }
   
   /**
    * Inicializa el mensaje de error para el campo de nombre completo del usuario.
    */
   private void initializeFullNameErrorMessage() {
	    errorMessageForFullName = new JLabel();
		errorMessageForFullName.setForeground(Color.RED);
		rightInnerPanel.add(errorMessageForFullName);
		errorMessageForFullName.setBounds(137, 91, 111, 25);
   }
   
   /**
    * 
    */
    private void initializeLeftInnerPanel() {
    	leftIneerPanel = new JPanel();   
		leftIneerPanel.setBackground(new Color(238, 238, 236));
		leftIneerPanel.setBounds(0, 0, 322, 442);
		mainPanel.add(leftIneerPanel);
		leftIneerPanel.setLayout(null);
		leftIneerPanel.setBackground(new Color(255,255,255));
		initializeNflIcon();
		initializeCopyRights();
    }
    
    /**
     * 
     */
    private void initializeNflIcon() {
		nflIcon = new ImageIcon(ResizeIcon("/images/worldRugbyLogoBlack.png",150,200));
		nflIconLabel = new JLabel("");
		nflIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nflIconLabel.setIcon(nflIcon);
		nflIconLabel.setBounds(61, 88, 172, 200);
		leftIneerPanel.add(nflIconLabel);
    }
    
    /**
     * 
     */
    private void initializeCopyRights() {
		copyRights = new JLabel("<html> Copyright © 2024 World Rugby.<br> all rights reserved </html>");
		leftIneerPanel.add(copyRights);
		copyRights.setBounds(85,288,148,40);
	    copyRights.setFont(new Font(null, Font.PLAIN,10));
    }
    
    /**
     * Maneja la lógica cuando se realiza una acción, como hacer clic en un botón.
     * Llama al método userClickLoginLogic para procesar la acción del evento.
     * 
     * @param e El evento de acción que desencadena la llamada al método.
     */
    
	@Override
	public void actionPerformed(ActionEvent e) {
		userClickLoginLogic(e);
	}
	
	/**
	 * Maneja el evento de tecla tipeada. Si la tecla tipeada no es Enter, limpia los mensajes de error en los campos.
	 * 
	 * @param e El evento de tecla tipeada.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		char keyChar = e.getKeyChar();
		if (keyChar != KeyEvent.VK_ENTER) {
			errorMessageForPassword.setText("");
			errorMessageForEmail.setText("");
			errorMessageForFullName.setText("");
			errorMessageForRepeatPassword.setText("");
           
        }
	}


	@Override
	public void keyPressed(KeyEvent e) {
		userKeyboardLoginLogic(e);
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	
	
	/**
	 * Maneja la lógica cuando se presiona la tecla Enter. Valida el inicio de sesión si se presiona la tecla Enter.
	 * 
	 * @param e El evento de tecla presionada.
	 */
	private void userKeyboardLoginLogic(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
        	validateLogin(fullNameField.getText(),emailField.getText(),String.valueOf(passwordField.getPassword()), String.valueOf(repeatPasswordField.getPassword()));
		
        }
	}
	
	/**
	 * Maneja la lógica cuando se hace clic en los botones de inicio de sesión o registro.
	 * 
	 * @param e El evento de acción que desencadena la llamada al método.
	 */
	private void userClickLoginLogic(ActionEvent e) {
		
		if (e.getSource() == signUpButton) {	

			validateLogin(fullNameField.getText(), emailField.getText(), String.valueOf(passwordField.getPassword()), String.valueOf(repeatPasswordField.getPassword()));
			
		} else if (e.getSource() == loginButton) {
			this.dispose();
			new LoginPage(credentials);
		}
	}
	
	
	
	/**
	 * Valida los campos de entrada del usuario y maneja la lógica de inicio de sesión.
	 * Si los campos están completos, llama al método handleCredentialvalidation para validar las credenciales.
	 * 
	 * @param userFullName             Nombre completo proporcionado por el usuario.
	 * @param userEmail                Correo electrónico proporcionado por el usuario.
	 * @param userPassword             Contraseña proporcionada por el usuario.
	 * @param userConfirmationPassword Confirmación de la contraseña proporcionada por el usuario.
	 */
	private void validateLogin(String userFullName, String userEmail, String userPassword, String userConfirmationPassword) {
		
		if(handleEmptyFields(userFullName, userEmail, userPassword, userConfirmationPassword)) {
			handleCredentialvalidation(userFullName, userEmail, userPassword, userConfirmationPassword);
		}
	}
	

	/**
	 * Verifica si algún campo de entrada está vacío.
	 * Si hay campos vacíos, muestra un mensaje de error correspondiente.
	 * 
	 * @param userFullName             Nombre completo proporcionado por el usuario.
	 * @param userEmail                Correo electrónico proporcionado por el usuario.
	 * @param userPassword             Contraseña proporcionada por el usuario.
	 * @param userConfirmationPassword Confirmación de la contraseña proporcionada por el usuario.
	 * @return true si todos los campos están completos, de lo contrario, false.
	 */
	private boolean handleEmptyFields(String userFullName, String userEmail, String userPassword, String userConfirmationPassword) {

			int numberOfEmptyFields = 0;
		
			if (SignUpValidationUtil.checkForEmptyField(userFullName)) {
				promptErrorMessage(1, 0, 0, 0,"Campo obligatorio");
				numberOfEmptyFields++;
			}
			
			if (SignUpValidationUtil.checkForEmptyField(userEmail)) {
				promptErrorMessage(0, 1, 0, 0,"Campo obligatorio");
				numberOfEmptyFields++;
			}
			
			if (SignUpValidationUtil.checkForEmptyField(userPassword)) {
				promptErrorMessage(0, 0, 1, 0,"Campo obligatorio");
				numberOfEmptyFields++;
			}
			
			if (SignUpValidationUtil.checkForEmptyField(userConfirmationPassword)) {
				promptErrorMessage(0, 0, 0, 1,"Campo obligatorio");
				numberOfEmptyFields++;
			}
			
			if (numberOfEmptyFields > 0) {
				return false;
			} else {
				return true;
			}		
	}

	/**
	 * Valida los campos de entrada del usuario y maneja las credenciales.
	 * Si algún campo no cumple con los requisitos de validación, muestra un mensaje de error correspondiente.
	 * 
	 * @param userFullName             Nombre completo proporcionado por el usuario.
	 * @param userEmail                Correo electrónico proporcionado por el usuario.
	 * @param userPassword             Contraseña proporcionada por el usuario.
	 * @param userConfirmationPassword Confirmación de la contraseña proporcionada por el usuario.
	 */
	private void handleCredentialvalidation(String userFullName, String userEmail, String userPassword, String userConfirmationPassword) {
		
		if (!SignUpValidationUtil.isValidFullName(userFullName)) {
			errorMessageForFullName.setBounds(114, 91, 144, 25);
			promptErrorMessage(1, 0, 0, 0, "Solo se permite texto");
		} else if (!SignUpValidationUtil.isValidEmail(userEmail)) {
			promptErrorMessage(0, 1, 0, 0, "Formato inválido");
		} else if (loginInfo.containsKey(userEmail)) {
			promptErrorMessage(0, 1, 0, 0, "El email ya existe");
		} else if (!SignUpValidationUtil.isValidPassword(userPassword)) {
			userDialog("La contraseña debe tener un mínimo de 8 caracteres"
					+ " y debe incluir al menos una mayúscula y un número", "Requisito de contraseña");
		} else if (!SignUpValidationUtil.arePasswordsTheSame(userPassword, userConfirmationPassword)) {
			userDialog("Las contraseñas no coinciden", "Requisito de contraseña");
		} else {
			credentials.saveUserData(userFullName, userEmail, userPassword);
			sessionId = SignUpValidationUtil.getUserSessionId(credentials);
			fileIo.writeToFile(Time.getCurrentTime(), "data/logs/account_created.cvs", "Cuenta creada", userFullName, sessionId);
			this.dispose();
			new LoginPage(credentials);
		}
	}
	
	
	/**
	 * Este metodo muestra el mensaje "errorMessage" basando en el bit que representa cada field
	 * 
	 * @param fullNameBit un intero que refiere al nombre del usuario, 1 muestra un error; 0 nada
	 * @param emailBit un intero que refiere al email del usuario, 1 muestra un error; 0 nada
	 * @param passwordBit un intero que refiere a la contraseña del usuario, 1 muestra un error; 0 nada
	 * @param repeatPasswordBit un intero que refiere a la confirmacion del contraseña del usuario, 1 muestra un error; 0 nada
	 * @param errorMessage el mensaje que se va a mostrar
	 */
	private void promptErrorMessage(int fullNameBit, int emailBit, int passwordBit, int repeatPasswordBit, String errorMessage) {
	    	if (fullNameBit == 1) {
	    		 errorMessageForFullName.setText(errorMessage);
	    	}
	    	if (emailBit == 1) {
	    		 errorMessageForEmail.setText(errorMessage);
	    	}
	    	if (passwordBit == 1) {
	    		errorMessageForPassword.setText(errorMessage);
	    	}
	    	if (repeatPasswordBit == 1) {
	    		errorMessageForRepeatPassword.setText(errorMessage);
	    	}
	}
	

	/**
	 * Este metodo muestra un ventana que contiene un mensaje de error
	 * 
	 * @param warrningText  la descripcion del error
	 * @param warrningTitle el titulo mensaje de error
	 */
	private void userDialog(String warrningText, String warrningTitle) {
		
        JOptionPane passwordRequirementPane = new JOptionPane(warrningText, JOptionPane.YES_OPTION);

        passwordRequirementPane.setMessageType(JOptionPane.WARNING_MESSAGE);

        JPanel buttonPanel = (JPanel)passwordRequirementPane.getComponent(1);
        
        JButton accepetButton = (JButton)buttonPanel.getComponent(0);
        accepetButton.setText("Acceptar");
        accepetButton.setFocusable(false);
        accepetButton.setBackground(Color.LIGHT_GRAY);
        
        JDialog passwordRequirementdialog = passwordRequirementPane.createDialog(this, warrningTitle);
        passwordRequirementdialog.setVisible(true);
	}
}