package com.standings.ui.page.panel;


import java.awt.Color;
import java.awt.Desktop;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.standings.model.design.CustomCheckBox;
import com.standings.model.Game;
import com.standings.model.ParentFrame;
import com.standings.model.Team;
import com.standings.ui.page.SportsDashboardPage;
//import com.standings.util.AddGameUtil;
import com.standings.util.StandingsCalculation;
//import com.standings.util.StandingsDataUtil;
import com.standings.util.StandingsDataUtil;

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
					
		
		initializeGraphics();
    	
    }
	
	
	
	
	private void initializeGraphics() {
		initializegameOneGraphics();
		initializeGameTwoGraphics();
		initiailizeGameThreeGraphics();
		initializeMainGraphics();
	}
	
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
                "<li>Ingrese los puntos del club local y visitante.</li> <br>" +
                "<li> Haga click en 'Guardar' para guardar los resultados del partido o 'Actualizar' <br> para  actualizar los puntos</li> <br>"+             
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
                    standingsPanel.renderUpdatedStandings();
                    scoresPanel.renderWeeksScores(whichWeekIsSelected());
                    resetFieldsAndWeek();
                    userDialog("Su partido se ha actualizado correctamente", "Actualizar entrada", INFORMATION_MESSAGE_TYPE);
                    SportsDashboardPage.setHasSeasondataCHanged(true);
                }
            }
        }
    }



	

	
	//MODIFIES: this
	//EFFECTS: create a comboBox and store the selectedWeekNumber
	//		   the action listener turns the selected boxes to false when every change happens.	 
	
	public void createWeekComboBox() {
	    comboWeekModel = new DefaultComboBoxModel<>();
	    for (int i = 1; i < 11; i++) {
	        comboWeekModel.addElement("Jornada " + i);
	    }
	    
	    selectedWeekNumber = 1;
	    
	    
	    

	    updateButton.setEnabled(true);
	    	   	
	   

	    weekComboBox = new JComboBox<>(comboWeekModel);
	    weekComboBox.setBackground(Color.LIGHT_GRAY);
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
	        	    	
	        	    		
	        	    	} else if (secondLocalTeamPointField.getText().equals("?")) {
	        	    		
	        	    		
	        	    	
	        	    	
	        	    	} else if (thirdLocalTeamPointField.getText().equals("?")) {
	        	    		
	        	    		
	        	    	
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
		
	

	//EFFECTS: retrieve game data before updating it based on the selected checkBox.
	
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
	
	
	//REQUIRES: argument must be between the bound of the games array.
	//MODIFIES: this
	//EFFECTS: retrieve game data from games array based on the game index.
	
	private void handleStepGameOne(int gameNumber){
		
		  	localClubPointsField.setText(firstLocalTeamPointField.getText());
		    visitorClubPointsField.setText(firstVisitorTeamPointField.getText());
		    
		    localClubField.setText(games.get(gameNumber).getLocalTeam().getName());
		    visitorClubField.setText(games.get(gameNumber).getVisitorTeam().getName());
		    
		    isFirstBoxSelected = false;

	}
	
	//REQUIRES: argument must be between the bound of the games array.
	//MODIFIES: this
	//EFFECTS: retrieve game data from games array based on the game index.
	
	private void handleStepGameTwo(int gameNumber){
		
		  	localClubPointsField.setText(secondLocalTeamPointField.getText());
		    visitorClubPointsField.setText(secondVisitorTeamPointField.getText());
		    
		    localClubField.setText(games.get(gameNumber).getLocalTeam().getName());
		    visitorClubField.setText(games.get(gameNumber).getVisitorTeam().getName());
		    
		    isSecondBoxSelected = false;


	}
	

	//REQUIRES: argument must be between the bound of the games array.
	//MODIFIES: this
	//EFFECTS: retrieve game data from games array based on the game index.
	
	private void handleStepGameThree(int gameNumber){
		
		  	localClubPointsField.setText(thirdLocalTeamPointField.getText());
		    visitorClubPointsField.setText(thirdVisitorTeamPointField.getText());
		    
		    localClubField.setText(games.get(gameNumber).getLocalTeam().getName());
		    visitorClubField.setText(games.get(gameNumber).getVisitorTeam().getName());

		    isThirdBoxSelected = false;

	}
	

	//EFFECTS: pass the arguments based on the week. 
	
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
	
	
	//REQUIRES: argument must be between the bound of the games array.
	//MODIFIES: this
	//EFFECTS: set the appropriate data for a team fields and label based on the game index.
	
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
		;
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




	
	private int whichWeekIsSelected() {
		 return selectedWeekNumber;
	}

	
	
	
	
	
	//MODIFIES: this
	//EFFECTS:  change the visibility of the given label and field based on the mouse actions
	
	
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
		
	

	//EFFECTS:  based on the validationNumber it calls the userDialog passing to it the 
	//			appropriate arguments.
	
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
	


	//EFFECTS:  prompt the user with a message that has the given text and title.
	
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