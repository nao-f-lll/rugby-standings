package com.standings.ui.page.panel;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.standings.model.Game;
import com.standings.model.ParentFrame;
import com.standings.model.Season;
import com.standings.model.Team;
import com.standings.model.design.CustomCheckBox;
import com.standings.ui.page.SportsDashboardPage;
//import com.standings.util.AddGameUtil;
import com.standings.util.StandingsCalculation;
//import com.standings.util.StandingsDataUtil;
import com.standings.util.StandingsDataUtil;


/**
 * Panel para actualizar datos de juegos
 * @author SomeOne
 * @version 1
 */
public class UpdateDataPanel extends JPanel  implements ActionListener {

	private static final long serialVersionUID = -3261993617585437616L;
	
	private final static String EXISTING_STANDINGS_TYPE = "Exisitng entry";

	private final int SOME_OR_ALL_FIELDS_ARE_EMPTY = 1;
	private final int NO_CHECK_BOX_IS_SELECTED_UPDATE_CASE = 4;
	private final int MULTIPLE_CHEC_BOXES_ARE_SELECTED_UPDATE_CASE = 5;
	private final int ALL_POINTS_ARE_INVALID = 6;
	private final int LOCAL_POINTS_ARE_INVALID = 7;
	private final int VISITOR_POINTS_ARE_INVALID = 8; 
	private final int WEEK_NUMBER_IS_INCORRECT = 10;  
	 
	private final int WARRNING_MESSAGE_TYPE = 2;
	private final int INFORMATION_MESSAGE_TYPE = 1;
	 
	
    private JTextField localClubField;
    private JTextField localClubPointsField;
    

    private JTextField visitorClubField;
    private JTextField visitorClubPointsField;
    
  
    private JComboBox<String> weekComboBox;
    private DefaultComboBoxModel<String> comboWeekModel;
    
   
    private JButton updateButton;
  
    
    private JLabel titleInstructionsLabel;
    private JPanel instructionPanel;
    private JLabel instructionsLabel;
    private ImageIcon nflIcon;
    private JLabel termsOfUse;

	private int validationNumber;
	private int selectedWeekNumber;
    


    
    private List<Game> games;
	private ArrayList<Team> teams;
	private Season season;
	private StandingsPanel standingsPanel;
	private ScoresPanel scoresPanel;


	
	private JLabel firstLocalTeamName;
	
	private JTextField firstLocalTeamPointField;
	private JLabel firstLocalTeamPointLabel;
	
	private JLabel firstVisitorTeamName;
	
	private JTextField firstVisitorTeamPointField;
	private JLabel firstVisitorTeamPointLabel;   
	
	private JLabel secondLocalTeamName;
	
	private JTextField secondLocalTeamPointField;
	private JLabel secondLocalTeamPointLabel;
	
	private JLabel secondVisitorTeamName;

	private JTextField secondVisitorTeamPointField;
	private JLabel secondVisitorTeamPointLabel;
	
	private JLabel thirdLocalTeamName;

	private JTextField thirdLocalTeamPointField;
	private JLabel thirdLocalTeamPointLabel;
	
	private JLabel thirdVisitorTeamName;

	private JTextField thirdVisitorTeamPointField;
	private JLabel thirdVisitorTeamPointLabel;
	
	
	public CustomCheckBox firstGameBox;
	public CustomCheckBox secondGameBox;
	public CustomCheckBox thirdGameBox;
	
	public boolean isFirstBoxSelected;
	public boolean isSecondBoxSelected;
	public boolean isThirdBoxSelected;
	private boolean newSeason;
	
	
	 /**
     * Constructor de la clase UpdateDataPanel.
     * 
     * @param teams           Lista de equipos.
     * @param games           Lista de juegos.
     * @param standingsPanel  Panel de clasificación.
     * @param scoresPanel     Panel de puntuaciones.
     */
	public UpdateDataPanel( ArrayList<Team> teams, List<Game> games, StandingsPanel standingsPanel, ScoresPanel scoresPanel) {
 
    	this.games = games;
    	this.teams = teams;
    	this.standingsPanel = standingsPanel;
    	this.scoresPanel = scoresPanel;
    	isFirstBoxSelected = false;
    	isSecondBoxSelected = false;
    	isThirdBoxSelected = false;

		localClubPointsField = new JTextField();
		visitorClubPointsField = new JTextField();
    	
		localClubField = new JTextField();
		visitorClubField = new JTextField();
		newSeason = false;
		
		initializeGraphics();
    	
    }
	
	
	/**
	 * Actualiza los datos del panel.
	 * 
	 * @param teams   Lista de equipos.
	 * @param games   Lista de juegos.
	 * @param season  Temporada actual.
	 */
	public void updateData(ArrayList<Team> teams, ArrayList<Game> games, Season season) {
    	this.games = games;
    	this.teams = teams;
    	this.season = season;
    	changeGames();
    	repaint();
    	newSeason = true;
    }
	

	/**
	 * Inicializa los gráficos del panel.
	 */
	private void initializeGraphics() {
		initializegameOneGraphics();
		initializeGameTwoGraphics();
		initiailizeGameThreeGraphics();
		initializeMainGraphics();
	}
	
	/**
	 * Inicializa los gráficos del primer partido.
	 */
	private void initializegameOneGraphics() {
		firstLocalTeamName = new JLabel(); 	
        firstLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        firstLocalTeamName.setBounds(900, 200, 100, 37);
        this.add(firstLocalTeamName);

        firstLocalTeamPointField = new JTextField();
        firstLocalTeamPointField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        firstLocalTeamPointField.setBounds(1110, 203, 33, 27);
        this.add(firstLocalTeamPointField);
        firstLocalTeamPointField.setVisible(false);
        
        
        
        firstLocalTeamPointLabel = new JLabel();
        firstLocalTeamPointLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        firstLocalTeamPointLabel.setBounds(1110, 203, 33, 27);
        this.add(firstLocalTeamPointLabel);
        
        
        firstVisitorTeamName = new JLabel();
  	    firstVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 20));
  	    firstVisitorTeamName.setBounds(900, 240, 100, 37);
  	    this.add(firstVisitorTeamName);
  	         
  	    firstVisitorTeamPointField = new JTextField();
  	    firstVisitorTeamPointField.setFont(new Font("Tahoma", Font.PLAIN, 20));
  	    firstVisitorTeamPointField.setBounds(1110, 242, 33, 27);
  	    this.add(firstVisitorTeamPointField);
  	    firstVisitorTeamPointField.setVisible(false);
     		
  	    
  	    firstVisitorTeamPointLabel = new JLabel();
  	    firstVisitorTeamPointLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
  	    firstVisitorTeamPointLabel.setBounds(1110, 242, 33, 27);
  	    this.add(firstVisitorTeamPointLabel);
  	    
	}
	
	/**
	 * Inicializa los gráficos del segundo partido.
	 */
	private void initializeGameTwoGraphics() {
		 secondLocalTeamName = new JLabel();
		    secondLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    secondLocalTeamName.setBounds(900, 340, 100, 37);
		    this.add(secondLocalTeamName);
		       
	
		      	       
		    secondLocalTeamPointField = new JTextField();
		    secondLocalTeamPointField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    secondLocalTeamPointField.setBounds(1110, 342, 33, 27);
		    this.add(secondLocalTeamPointField);
		    secondLocalTeamPointField.setVisible(false);
		    
		    
		    secondLocalTeamPointLabel = new JLabel(); 
		    secondLocalTeamPointLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    secondLocalTeamPointLabel.setBounds(1110, 342, 33, 27);
		    this.add(secondLocalTeamPointLabel);
		    
		    
		    
		    
	    
		    secondVisitorTeamName = new JLabel();
		    secondVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    secondVisitorTeamName.setBounds(900, 380, 100, 37);      
		    this.add(secondVisitorTeamName);
		       
	  
	
		       
		       
		    secondVisitorTeamPointField = new JTextField();
		    secondVisitorTeamPointField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    secondVisitorTeamPointField.setBounds(1110, 382, 33, 27);
		    this.add(secondVisitorTeamPointField);
		    secondVisitorTeamPointField.setVisible(false);
		    
		    
		    secondVisitorTeamPointLabel = new JLabel(); 
		    secondVisitorTeamPointLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    secondVisitorTeamPointLabel.setBounds(1110, 382, 33, 27);
		    this.add(secondVisitorTeamPointLabel);
		    
	}
	
	/**
	 * Inicializa los gráficos del tercer partido.
	 */
	private void initiailizeGameThreeGraphics() {
	     
		    thirdLocalTeamName = new JLabel();
		    thirdLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    thirdLocalTeamName.setBounds(900, 480, 100, 37);
		    this.add(thirdLocalTeamName);
		
		       
		    thirdLocalTeamPointField = new JTextField();
		    thirdLocalTeamPointField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    thirdLocalTeamPointField.setBounds(1110, 482, 33, 27);
		    this.add(thirdLocalTeamPointField);
		    thirdLocalTeamPointField.setVisible(false);   

		    
		    thirdLocalTeamPointLabel = new JLabel(); 
		    thirdLocalTeamPointLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    thirdLocalTeamPointLabel.setBounds(1110, 482, 33, 27);
		    this.add(thirdLocalTeamPointLabel);
		    
		    
		    
		    
		    thirdVisitorTeamName = new JLabel();
		    thirdVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    thirdVisitorTeamName.setBounds(900, 520, 100, 37);
		    this.add(thirdVisitorTeamName);
		       
		       
		
		       
		    thirdVisitorTeamPointField = new JTextField();
		    thirdVisitorTeamPointField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    thirdVisitorTeamPointField.setBounds(1110, 522, 33, 27);
		    this.add(thirdVisitorTeamPointField);
		    thirdVisitorTeamPointField.setVisible(false);   

		    
		    thirdVisitorTeamPointLabel = new JLabel(); 
		    thirdVisitorTeamPointLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    thirdVisitorTeamPointLabel.setBounds(1110, 522, 33, 27);
		    this.add(thirdVisitorTeamPointLabel);
		    
		    
	}
	
	/**
	 * Inicializa los gráficos principales de la interfaz de usuario para la actualización de datos.
	 * Esto incluye la creación de casillas de verificación para cada juego, la configuración de campos para los puntos de los equipos locales y visitantes,
	 * la creación de un botón de actualización, la configuración de una lista desplegable para seleccionar la jornada del partido, y la configuración de instrucciones.
	 */
	private void initializeMainGraphics() {
		firstGameBox = new CustomCheckBox();
		firstGameBox.setBounds(1300, 210 ,50 , 45);  
		firstGameBox.addActionListener(this);
		this.add(firstGameBox);	
		allowToModifyField(firstGameBox, firstLocalTeamPointLabel, firstLocalTeamPointField, firstVisitorTeamPointLabel, firstVisitorTeamPointField);

	   
	    
	    
		secondGameBox = new CustomCheckBox();
		secondGameBox.setBounds(1300, 350 ,50 , 45);
		secondGameBox.addActionListener(this);
		this.add(secondGameBox);
	    
		allowToModifyField(secondGameBox, secondVisitorTeamPointLabel, secondVisitorTeamPointField, secondLocalTeamPointLabel, secondLocalTeamPointField);

	       
	    
		thirdGameBox = new CustomCheckBox();
		thirdGameBox.setBounds(1300, 490 ,50 , 45);
		thirdGameBox.addActionListener(this);
		this.add(thirdGameBox);
	    
	       
		allowToModifyField(thirdGameBox,thirdVisitorTeamPointLabel, thirdVisitorTeamPointField, thirdLocalTeamPointLabel, thirdLocalTeamPointField);
		
		
	    
	       
	       
	       


        
     
        
       
        
        updateButton = new JButton("Actualizar");
        updateButton.setBounds(1070, 620, 130, 45);
        updateButton.setFocusable(false);
        updateButton.setBackground(Color.lightGray);
        updateButton.addActionListener(this);
        updateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(updateButton);
        
        createWeekComboBox();
        
        instructionPanel = new JPanel();
        instructionPanel.setBackground(new Color(255, 255, 255));
        instructionPanel.setBounds(0, 60, 627, 756);
        this.add(instructionPanel);
        instructionPanel.setLayout(null);
        
        
        
        
        
        titleInstructionsLabel = new JLabel("Instrucciones para insertar/actualizar los datos");
        titleInstructionsLabel.setIcon(new ImageIcon(SportsDashboardPage.class.getResource("/images/instructionBlue.png")));
        titleInstructionsLabel.setForeground(new Color(0, 0, 0));
        titleInstructionsLabel.setBounds(49, 10, 536, 105);
        instructionPanel.add(titleInstructionsLabel);
        titleInstructionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleInstructionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        instructionsLabel = new JLabel(
                "<html>" +
                "<body style='width: 500px;'>" +
                "<ul>" +
                "<li>Seleccione la jornada del partido desde 'Jornada 1' hasta 'Jornada 10' en el <br> desplegable.</li> <br>" +
                "<li>Haga click en el icono de editar, para poder insertar los puntos o actualizarlos</li> <br> " +
                "<li>Haga click en 'Actualizar' para guardar los resultados del partido  <br> para modificar los puntos</li> <br>"+                     
                "<li>Recuerde guardar su entrada. Gracias por ayudar a mantener los resultados <br> de los partidos</li>" +     
                "</ul>" +
                "</body>" +
                "</html>"
            );
        
 
        instructionsLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        instructionsLabel.setBackground(this.getBackground());     
        instructionPanel.add(instructionsLabel);
        instructionsLabel.setBounds(21, 179, 596, 227);
        
        nflIcon = new ImageIcon(ParentFrame.ResizeIconStatic("/images/worldRugbyLogoBlack.png",120,120));
        JLabel nflIconLabel = new JLabel("");
		nflIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nflIconLabel.setIcon(nflIcon);
		nflIconLabel.setBounds(233, 476, 110, 144);
		instructionPanel.add(nflIconLabel);
        
        
		termsOfUse = new JLabel("<html><p style='text-indent: 10px; white-space: nowrap;'><a href=\"https://nao-f-lll.github.io/terminos.html\">Términos de uso</a></p></html>");
		termsOfUse.setBounds(235, 630, 250, 40);
		termsOfUse.setFont(new Font("Dialog", Font.PLAIN, 13));
		termsOfUse.setCursor(new Cursor(Cursor.HAND_CURSOR));
		instructionPanel.add(termsOfUse);

		
		
		termsOfUse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://nao-f-lll.github.io/paginas/terminos.html"));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });	
	}
       
    
    @Override
	public void actionPerformed(ActionEvent e) {
		userClickLoginLogic(e);
	}
    
    
    /**
     * Lógica para manejar la acción del usuario al hacer clic en el botón de actualización.
     * Verifica qué casilla de verificación está seleccionada y realiza la actualización de los datos del juego seleccionado.
     * Además, realiza validaciones de los datos ingresados antes de actualizar los puntajes y actualiza las tablas de clasificación y puntuaciones.
     * @param e El evento de acción que desencadenó esta función.
     */
    private void userClickLoginLogic(ActionEvent e) {

        if (e.getSource() == updateButton) {

            StandingsDataUtil.checkWhichBoxIsSelected(this);

            if (StandingsDataUtil.checkIfNoBoxIsSelected(this) == 0) {
                handleValidationNumber(NO_CHECK_BOX_IS_SELECTED_UPDATE_CASE);
            } else if (StandingsDataUtil.areMultipleBoxesSelected(this)) {
                handleValidationNumber(MULTIPLE_CHEC_BOXES_ARE_SELECTED_UPDATE_CASE);
            } else {
                if (isFirstBoxSelected) {
                    choseGameToUpdate(isFirstBoxSelected, isSecondBoxSelected, isThirdBoxSelected);
                } else if (isSecondBoxSelected) {
                    choseGameToUpdate(isFirstBoxSelected, isSecondBoxSelected, isThirdBoxSelected);
                } else if (isThirdBoxSelected) {
                    choseGameToUpdate(isFirstBoxSelected, isSecondBoxSelected, isThirdBoxSelected);
                }

                validationNumber = StandingsDataUtil.validateStandingsDataForPoints(localClubPointsField.getText(), visitorClubPointsField.getText());

                if (StandingsDataUtil.validateStandingsDataForEmpties(localClubField.getText(), visitorClubField.getText(), localClubPointsField.getText(), visitorClubPointsField.getText())) {
                    handleValidationNumber(SOME_OR_ALL_FIELDS_ARE_EMPTY);
                } else if (validationNumber == ALL_POINTS_ARE_INVALID || validationNumber == LOCAL_POINTS_ARE_INVALID || validationNumber == VISITOR_POINTS_ARE_INVALID) {
                    handleValidationNumber(validationNumber);
                } else {
                    for (int i = 0; i < games.size(); i++) {
                        if (games.get(i).getLocalTeam().getName().equals(localClubField.getText()) && games.get(i).getVisitorTeam().getName().equals(visitorClubField.getText())) {
                            if (games.get(i).getWeekNumber() == whichWeekIsSelected()) {
                                games.get(i).setOldLocalScore(games.get(i).getLocalScore());
                                games.get(i).setOldVisitorScore(games.get(i).getVisitorScore());
                                games.get(i).setLocalScore(Integer.parseInt(localClubPointsField.getText()));
                                games.get(i).setVisitorScore(Integer.parseInt(visitorClubPointsField.getText()));
                                for (Team team : this.teams) {
                                    if (team.getName().equals(localClubField.getText()) || team.getName().equals(visitorClubField.getText())) {
                                        StandingsCalculation.updateStandings(team, games.get(i), EXISTING_STANDINGS_TYPE);
                                    }
                                }
                            }
                        }
                    }

                    StandingsCalculation.sortStandings(this.teams);
                    if (newSeason) {
                    	standingsPanel.renderUpdatedStandings(this.teams);
                        scoresPanel.renderAllWeeksScores(season);
                    } else {
                        standingsPanel.renderUpdatedStandings();
                        scoresPanel.renderWeeksScores(whichWeekIsSelected());
                    }
               
                    
                    resetFieldsAndWeek();
                    userDialog("Su partido se ha actualizado correctamente", "Actualizar entrada", INFORMATION_MESSAGE_TYPE);
                    initializeTable();            
                    SportsDashboardPage.setHasSeasonDataChanged(true);
                }
            }
        }
    }



    private void initializeTable() {
        Object[][] rows = new Object[][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
        };

        String[] columns = new String[] {
                "Equipo", "Partidos Jugados", "Victorias", "Derrotas", "Empates", "Puntos"
        };
        
        standingsPanel.renderUpdatedStandings(rows, columns);

        JTable table = new JTable(rows, columns);
        table.setEnabled(false);
        table.setFont(new Font("Tahoma", Font.PLAIN, 20));
        table.setBackground(new Color(255, 255, 255));

        table.getTableHeader().setFont(new Font(null, 20, 20));
        table.getTableHeader().setBackground(Color.LIGHT_GRAY);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        table.setRowHeight(60);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
     
        table.setPreferredScrollableViewportSize(new Dimension(650, 360));
        
        JButton customButton = new JButton("OK");
        customButton.setBackground(Color.LIGHT_GRAY);
        customButton.setFocusable(false);
        customButton.addActionListener((ActionEvent e) -> {
            JOptionPane.getRootFrame().dispose();
        });

        Object[] options = {customButton};

       
        JOptionPane.showOptionDialog(
                null,
                new JScrollPane(table),
                "Tabla de clasificacion",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );
    
    }
	

	
    /**
     * Crea un JComboBox para seleccionar la semana de los partidos.
     */
	public void createWeekComboBox() {
	    comboWeekModel = new DefaultComboBoxModel<>();
	    for (int i = 1; i < 11; i++) {
	        comboWeekModel.addElement("Jornada " + i);
	    }
	    
	    selectedWeekNumber = 1;

	    updateButton.setEnabled(true);
	    weekComboBox = new JComboBox<>(comboWeekModel);
	    weekComboBox.setBackground(Color.LIGHT_GRAY);
	    weekComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    weekComboBox.setBounds(1033, 90, 114, 45);
	    this.add(weekComboBox);
	    showGameInfo(0, 1, 2);

    	
	    weekComboBox.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String selectedWeek = (String) weekComboBox.getSelectedItem();
	            String[] parts = selectedWeek.split(" ");
	            if (parts.length == 2) {
	                try {
	                    int weekNumber = Integer.parseInt(parts[1]);
	                    selectedWeekNumber = weekNumber;
	                    changeGames();
	                    firstGameBox.setSelected(false);
	            		secondGameBox.setSelected(false);
	            		thirdGameBox.setSelected(false);
	            		
	            		if (firstLocalTeamPointField.getText().equals("?")) {
	        	    		
	        	    		updateButton.setEnabled(false);	
	        	    	
	        	    	} else {
	        	    		 
	        	    		 updateButton.setEnabled(true);
	        	    	}
	                } catch (NumberFormatException ex) {
	                    System.err.println("Error parsing week number");
	                }
	            }
	        }
	    });
	}
		
	

	/**
	 * Método para seleccionar el partido que se va a actualizar según la semana y la casilla de selección.
	 * 
	 * @param firstBox   Verdadero si la primera casilla está seleccionada, falso de lo contrario.
	 * @param secondBox  Verdadero si la segunda casilla está seleccionada, falso de lo contrario.
	 * @param thirdBox   Verdadero si la tercera casilla está seleccionada, falso de lo contrario.
	 */	
	private void choseGameToUpdate(boolean firstBox, boolean secondBox, boolean thirdBox) {
		if (firstBox) {
			switch (selectedWeekNumber) {
			case 1:
				handleStepGameOne(0);
				break;
			case 2:
				handleStepGameOne(3);
				break;
			case 3:
				handleStepGameOne(6);
				break;
			case 4:
				handleStepGameOne(9);
				break;
			case 5:
				handleStepGameOne(12);
				break;
			case 6:
				handleStepGameOne(15);
				break;
			case 7:
				handleStepGameOne(18);
				break;
			case 8:
				handleStepGameOne(21);
				break;
			case 9:
				handleStepGameOne(24);
				break;
			case 10:  
				handleStepGameOne(27);
				break;
			default :
			}
		}else if (secondBox) {
			switch (selectedWeekNumber) {
			case 1:
				handleStepGameTwo(1);
				break;
			case 2:
				handleStepGameTwo(4);
				break;
			case 3:
				handleStepGameTwo(7);
				break;
			case 4:
				handleStepGameTwo(10);
				break;
			case 5:
				handleStepGameTwo(13);
				break;
			case 6:
				handleStepGameTwo(16);
				break;
			case 7:
				handleStepGameTwo(19);
				break;
			case 8:
				handleStepGameTwo(22);
				break;
			case 9:
				handleStepGameTwo(25);
				break;
			case 10:
				handleStepGameTwo(28);		
				break;
			default :
			}
		}else if (thirdBox) {
			
			switch (selectedWeekNumber) {
			case 1:
				handleStepGameThree(2);
				break;
			case 2:
				handleStepGameThree(5);
				break;
			case 3:
				handleStepGameThree(8);
				break;
			case 4:
				handleStepGameThree(11);
				break;
			case 5:
				handleStepGameThree(14);
				break;
			case 6:
				handleStepGameThree(17);
				break;
			case 7:
				handleStepGameThree(20);
				break;
			case 8:
				handleStepGameThree(23);
				break;
			case 9:
				handleStepGameThree(26);
				break;
			case 10:
				handleStepGameThree(29);
				break;
			default :
			}
		}
	}
	
	
	/**
	 * Método para establecer los campos de puntos del club local y visitante, así como los nombres de los clubes,
	 * cuando se selecciona la primera casilla de juego para actualizar.
	 * 
	 * @param gameNumber El número de juego seleccionado.
	 */
	
	private void handleStepGameOne(int gameNumber){
		
		  	localClubPointsField.setText(firstLocalTeamPointField.getText());
		    visitorClubPointsField.setText(firstVisitorTeamPointField.getText());
		    
		    localClubField.setText(games.get(gameNumber).getLocalTeam().getName());
		    visitorClubField.setText(games.get(gameNumber).getVisitorTeam().getName());
		    
		    isFirstBoxSelected = false;

	}
	
	/**
	 * Maneja la selección del segundo juego en el paso de actualización.
	 * @param gameNumber El número del juego seleccionado.
	 */
	
	private void handleStepGameTwo(int gameNumber){
		
		  	localClubPointsField.setText(secondLocalTeamPointField.getText());
		    visitorClubPointsField.setText(secondVisitorTeamPointField.getText());
		    
		    localClubField.setText(games.get(gameNumber).getLocalTeam().getName());
		    visitorClubField.setText(games.get(gameNumber).getVisitorTeam().getName());
		    
		    isSecondBoxSelected = false;


	}
	

	/**
	 * Maneja la selección del tercer juego en el paso de actualización.
	 * @param gameNumber El número del juego seleccionado.
	 */
	
	private void handleStepGameThree(int gameNumber){
		
		  	localClubPointsField.setText(thirdLocalTeamPointField.getText());
		    visitorClubPointsField.setText(thirdVisitorTeamPointField.getText());
		    
		    localClubField.setText(games.get(gameNumber).getLocalTeam().getName());
		    visitorClubField.setText(games.get(gameNumber).getVisitorTeam().getName());

		    isThirdBoxSelected = false;

	}
	
	
	
	

	/**
	 * Cambia los juegos mostrados en función de la semana seleccionada.
	 */
	
	private void changeGames() {
		
		switch (selectedWeekNumber) {
		case 1:
			showGameInfo(0, 1, 2);
			break;
		case 2:
			showGameInfo(3, 4, 5);
			break;
		case 3:
			showGameInfo(6, 7, 8);
			break;
		case 4:
			showGameInfo(9, 10, 11);
			break;
		case 5:
			showGameInfo(12, 13, 14);
			break;
		case 6:
			showGameInfo(15, 16, 17);
			break;
		case 7:
			showGameInfo(18, 19, 20);
			break;
		case 8:
			showGameInfo(21, 22, 23);
			break;
		case 9:
			showGameInfo(24, 25, 26);
			break;
		case 10:
			showGameInfo(27, 28, 29);
			break;
		default :
					
		}
	}
	
	
	/**
	 * Muestra la información de los juegos en los campos correspondientes.
	 *
	 * @param gameOne   indice del primer juego en la lista de juegos.
	 * @param gameTwo   indice del segundo juego en la lista de juegos.
	 * @param gameThree indice del tercer juego en la lista de juegos.
	 */
	public void showGameInfo(int gameOne, int gameTwo, int gameThree) {
        
		
			firstLocalTeamName.setText(games.get(gameOne).getLocalTeam().getName());
		
			firstLocalTeamPointField.setText(String.valueOf(games.get(gameOne).getLocalScore()));
			firstLocalTeamPointField.setVisible(false);
			firstLocalTeamPointLabel.setText(String.valueOf(games.get(gameOne).getLocalScore()));
			firstLocalTeamPointLabel.setVisible(true);
			
			firstVisitorTeamName.setText(games.get(gameOne).getVisitorTeam().getName());
			
			firstVisitorTeamPointField.setText(String.valueOf(games.get(gameOne).getVisitorScore()));
			firstVisitorTeamPointField.setVisible(false);
			firstVisitorTeamPointLabel.setText(String.valueOf(games.get(gameOne).getVisitorScore()));
			firstVisitorTeamPointLabel.setVisible(true);
       
			secondLocalTeamName.setText(games.get(gameTwo).getLocalTeam().getName());
		
			secondLocalTeamPointField.setText(String.valueOf(games.get(gameTwo).getLocalScore()));
			secondLocalTeamPointField.setVisible(false);
			secondLocalTeamPointLabel.setText(String.valueOf(games.get(gameTwo).getLocalScore()));
			secondLocalTeamPointLabel.setVisible(true);
			
			secondVisitorTeamName.setText(games.get(gameTwo).getVisitorTeam().getName());
		
			secondVisitorTeamPointField.setText(String.valueOf(games.get(gameTwo).getVisitorScore()));
			secondVisitorTeamPointField.setVisible(false);
			secondVisitorTeamPointLabel.setText(String.valueOf(games.get(gameTwo).getVisitorScore()));
			secondVisitorTeamPointLabel.setVisible(true);
    	  
			thirdLocalTeamName.setText(games.get(gameThree).getLocalTeam().getName());
		
			thirdLocalTeamPointField.setText(String.valueOf(games.get(gameThree).getLocalScore()));
			thirdLocalTeamPointField.setVisible(false);
			thirdLocalTeamPointLabel.setText(String.valueOf(games.get(gameThree).getLocalScore()));
			thirdLocalTeamPointLabel.setVisible(true);
    	  
			thirdVisitorTeamName.setText(games.get(gameThree).getVisitorTeam().getName());
			
			thirdVisitorTeamPointField.setText(String.valueOf(games.get(gameThree).getVisitorScore()));
			thirdVisitorTeamPointField.setVisible(false);
			thirdVisitorTeamPointLabel.setText(String.valueOf(games.get(gameThree).getVisitorScore()));
			thirdVisitorTeamPointLabel.setVisible(true);
    }




	/**
	 * Obtiene el número de la semana seleccionada.
	 *
	 * @return Número de la semana seleccionada.
	 */
	private int whichWeekIsSelected() {
		 return selectedWeekNumber;
	}

	
	
	
	
	
	/**
	 * Permite modificar los campos de texto de los equipos locales y visitantes en función del estado del CustomCheckBox.
	 *
	 * @param box           CustomCheckBox que controla el estado de modificación.
	 * @param localLabel    JLabel que muestra el nombre del equipo local.
	 * @param localField    JTextField que permite editar el puntaje del equipo local.
	 * @param visitorLabel  JLabel que muestra el nombre del equipo visitante.
	 * @param visitorField  JTextField que permite editar el puntaje del equipo visitante.
	 */
	private void allowToModifyField(CustomCheckBox box, JLabel localLabel, JTextField localField,  JLabel visitorLabel, JTextField visitorField) {
	
		
		box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box.isSelected()) {
        			localLabel.setVisible(false);
        			localField.setVisible(true);
        			
        			visitorLabel.setVisible(false);
        			visitorField.setVisible(true);
 
                } else {

                	localLabel.setText(localField.getText());
        			localField.setVisible(false);
        	    	localLabel.setVisible(true);
        	    	
        	    	visitorLabel.setText(visitorField.getText());
        	    	visitorField.setVisible(false);
        			visitorLabel.setVisible(true);
                }
            }
        });
		
	}
		
	
	
	
	/**
	 * Deshabilita la modificación de los puntajes y restaura los JLabel con los valores actuales de los puntajes.
	 */
	private void desiablePointsModification() {
		
		
		 firstLocalTeamPointLabel.setText(firstLocalTeamPointField.getText());
		 firstLocalTeamPointField.setVisible(false);
		 firstLocalTeamPointLabel.setVisible(true);
    	
		 
		 firstVisitorTeamPointLabel.setText(firstVisitorTeamPointField.getText());
		 firstVisitorTeamPointField.setVisible(false);
		 firstVisitorTeamPointLabel.setVisible(true);
		 
		 
		 
		 
		 secondLocalTeamPointLabel.setText(secondLocalTeamPointField.getText());
		 secondLocalTeamPointField.setVisible(false);
		 secondLocalTeamPointLabel.setVisible(true);
    	
		 
		 secondVisitorTeamPointLabel.setText(secondVisitorTeamPointField.getText());
		 secondVisitorTeamPointField.setVisible(false);
		 secondVisitorTeamPointLabel.setVisible(true);
		 
		 
		 
		 
		 thirdLocalTeamPointLabel.setText(thirdLocalTeamPointField.getText());
		 thirdLocalTeamPointField.setVisible(false);
		 thirdLocalTeamPointLabel.setVisible(true);
    	
		 
		 thirdVisitorTeamPointLabel.setText(thirdVisitorTeamPointField.getText());
		 thirdVisitorTeamPointField.setVisible(false);
		 thirdVisitorTeamPointLabel.setVisible(true);
		 
		 
		 
		 
		 
	}
		
	

	/**
	 * Maneja el número de validación proporcionado y muestra el mensaje de diálogo correspondiente.
	 * @param validationNumber el número de validación que indica el tipo de error
	 */
	public void handleValidationNumber(int validationNumber) {  
		
		switch (validationNumber) {
		case SOME_OR_ALL_FIELDS_ARE_EMPTY:
			userDialog("Algunos campos están vacíos, le faltan campos por rellenar", "Requisitos de campos", WARRNING_MESSAGE_TYPE);
			
			break;
		case ALL_POINTS_ARE_INVALID:
			userDialog("Puntos incorrectos, los puntos deben ser dentro de este rango (0 a 99)","Requisitos de campos", WARRNING_MESSAGE_TYPE);
			
			break;
		case LOCAL_POINTS_ARE_INVALID:	
			userDialog("Puntos incorrectos, los puntos deben ser dentro de este rango (0 a 99)","Requisitos de campos", WARRNING_MESSAGE_TYPE);
			
			break;
		case VISITOR_POINTS_ARE_INVALID:
			userDialog("Puntos incorrectos, los puntos deben ser dentro de este rango (0 a 99)","Requisitos de campos", WARRNING_MESSAGE_TYPE);
			
			break;	
		case NO_CHECK_BOX_IS_SELECTED_UPDATE_CASE:
			userDialog("Tienes que selecionar un partido para actualizar", "Requisitos de campos", WARRNING_MESSAGE_TYPE);
			break;
		case MULTIPLE_CHEC_BOXES_ARE_SELECTED_UPDATE_CASE:
			userDialog("Se permite actualizar solo un partido", "Requisitos de campos", WARRNING_MESSAGE_TYPE);
			break;
		case WEEK_NUMBER_IS_INCORRECT:
			userDialog("La semana del partido que quieres modifcar es incorrecta", "Requisitos de campos", WARRNING_MESSAGE_TYPE);
			break;
		
		default :
		}
	}	
	

	/**
	 * Muestra un diálogo con el texto y el título especificados.
	 * @param dialogText el texto del diálogo
	 * @param dialogTitle el título del diálogo
	 * @param messageType el tipo de mensaje del diálogo (por ejemplo, JOptionPane.WARNING_MESSAGE)
	 */
	private void userDialog(String dialogText, String dialogTitle, int meesageType) {
		
		 JOptionPane fieldRequirementPane = new JOptionPane(dialogText,JOptionPane.YES_OPTION);

		 fieldRequirementPane.setMessageType(meesageType);

	        JPanel buttonPanel = (JPanel)fieldRequirementPane.getComponent(1);
	        
	        JButton accepetButton = (JButton)buttonPanel.getComponent(0);
	        accepetButton.setText("Aceptar");
	        accepetButton.setFocusable(false);
	        accepetButton.setBackground(Color.LIGHT_GRAY);
	        
	        JDialog passwordRequirementdialog = fieldRequirementPane.createDialog(this, dialogTitle);
	        passwordRequirementdialog.setVisible(true);
	}
	
	
	
	//MODIFIES: this
	//EFFECTS:  set the selection of boxes to false
	
	private void resetFieldsAndWeek() {
		
		resetFields();
		
		firstGameBox.setSelected(false);
		secondGameBox.setSelected(false);
		thirdGameBox.setSelected(false);
		
		desiablePointsModification();
	}
	
	//MODIFIES: this
	//EFFECTS:  set the fields to empty
	private void resetFields() {
		localClubField.setText("");
		visitorClubField.setText("");
		localClubPointsField.setText("");
		visitorClubPointsField.setText("");
	}
}