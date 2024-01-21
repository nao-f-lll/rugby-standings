package com.standings.ui.page;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import com.standings.model.design.CustomBorder;
import com.standings.model.design.CustomButton;
import com.standings.ui.page.panel.ScoresPanel;
import com.standings.ui.page.panel.SeasonsManagement;
import com.standings.ui.page.panel.StandingsPanel;
import com.standings.ui.page.panel.TeamsPanel;
import com.standings.ui.page.panel.UpdateDataPanel;
import com.standings.util.FileIO;
import com.standings.model.ParentFrame;
import com.standings.model.Season;
import com.standings.model.Team;
import com.standings.model.Week;
import com.standings.model.Game;


public class SportsDashboardPage extends ParentFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final   String FILE_PATH = "data/objects/seasons.ser";
    
    private JPanel mainPanel;
    private JPanel panelButton;
    
    private ScoresPanel scoresPanel;
    private StandingsPanel standingsPanel;
    private TeamsPanel teamsPanel; 
    private UpdateDataPanel updateDataPanel;
    private SeasonsManagement seasonsManagement;
    
    private JButton goToScoresButton;
    private JButton goToStandingButton;
    private JButton goToTeamsButton;
    private JButton goToUpdateDataButton;
    private JButton goToSeasonsMangement;
    private ArrayList<Team> teams;
	private ArrayList<Game> games;
	private ArrayList<Week> weeks;
	private Season season;
	private ArrayList<Season> seasons;
	private FileIO<Season> fileIo;
	
	/////

    /* 
    
    private JLabel allBalckIconLabel; 
    private ImageIcon allbalcksIcon;
    private  JLabel allbalcksStadiumLabel;
    private JLabel allbalcksStadiumNameLabel;
    private JLabel allbalcksFundiationYearLabel;
    private JLabel allbalcksCityNameLabel;
    private JLabel allbalcksFundiationLabel;
    private JLabel allbalcksCityLabel;
    private JLabel allbalcksDescriptionLabel;
    
    
        */

     
	
	
	
	/////

	
	
	   public SportsDashboardPage() {
		   initializeFrameGraphics();	
	    	initializeStandingsData();
			initializePanelGraphics();	
	   }

    public SportsDashboardPage(String selectedSeason, ArrayList<Season>seasons) {
    	
    	
    	initializeFrameGraphics();	
    	initializeStandingsData();
		initializePanelGraphics();	
    }
     
    
    private void initializeFrameGraphics() {
    	setTitle("Panel administrativo");
        setResizable(false);
        setSizeAndCenter();
    }

    private void setSizeAndCenter() {
        setSize(1538, 850);
        setLocationRelativeTo(null);
    }
  
    
    private void initializeStandingsData() {
    	
    	seasons = new ArrayList<>();
    	fileIo = new FileIO<>();
    	seasons = fileIo.readObject(FILE_PATH, seasons);
    	season = seasons.get(seasons.size() - 1);
    	
    	
        teams = new ArrayList<>();
        games = new ArrayList<>();
        weeks = new ArrayList<>();
        
      // season = new Season(1, 2023, weeks, teams, games);
       //seasons.add(season);
    }
    
    private void initializePanelGraphics() {
    	initializeMainPanel();
    	initializePanelButton();
    	initializeButtons();
    	initializeButtonPanels();
    	lastPaint();
    }
    
    private void initializeMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); 	
    }
   
    
    private void initializePanelButton() {
        panelButton = new JPanel();
        panelButton.setBounds(0, 0, 1522, 60);
        panelButton.setBackground(Color.WHITE);
        panelButton.setLayout(null);
    }
    
    private void initializeButtonPanels() {
       // standingsPanel = new StandingsPanel(teams, games, weeks);   
       // teamsPanel = new TeamsPanel();          
       // updateDataPanel = new UpdateDataPanel(teams, games,standingsPanel, scoresPanel);
        
    	standingsPanel = new StandingsPanel(season, seasons);
    	scoresPanel = new ScoresPanel(panelButton, season);
    	teamsPanel = new TeamsPanel(panelButton);          
        updateDataPanel = new UpdateDataPanel(season.getTeams(), season.getGames(),standingsPanel, scoresPanel);
        seasonsManagement = new SeasonsManagement();
        
        
        

        
   
        scoresPanel.setLayout(null);
        standingsPanel.setLayout(null);
        teamsPanel.setLayout(null);
        updateDataPanel.setLayout(null);
      
    
        
        
        
     
        
        
        	
        
        
        	//	allbalcksIcon = new ImageIcon(SportsDashboardPage.class.getResource("/images/all_blacks_logo.png"));

        
               
             
    	
        
       mainPanel.add(scoresPanel, BorderLayout.CENTER);
       scoresPanel.add(panelButton);
       
       
       /*
       
       allBalckIconLabel = new JLabel("");
       
       allBalckIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
       allBalckIconLabel.setIcon(allbalcksIcon);
       allBalckIconLabel.setBounds(520, 132, 423, 220);
       scoresPanel.add(allBalckIconLabel);
       
       
       allbalcksCityLabel = new JLabel("Ciudad");
       scoresPanel.add(allbalcksCityLabel);
       allbalcksCityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
       allbalcksCityLabel.setBounds(470, 632, 148, 54);
       
       allbalcksFundiationLabel = new JLabel("Fundación");
       scoresPanel.add(allbalcksFundiationLabel);
       allbalcksFundiationLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
       allbalcksFundiationLabel.setBounds(753, 566, 148, 54);
       
        
        allbalcksStadiumLabel = new JLabel("Estadio");
        scoresPanel.add(allbalcksStadiumLabel);
        allbalcksStadiumLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        allbalcksStadiumLabel.setBounds(113, 632, 109, 54);
        
           
           allbalcksStadiumNameLabel = new JLabel("Eden Park");
           scoresPanel.add(allbalcksStadiumNameLabel);
           allbalcksStadiumNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
           allbalcksStadiumNameLabel.setBounds(108, 688, 300, 54);
           
           
           allbalcksCityNameLabel = new JLabel("Auckland");
           scoresPanel.add(allbalcksCityNameLabel);
           allbalcksCityNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
           allbalcksCityNameLabel.setBounds(454, 698, 148, 54);
           
           allbalcksFundiationYearLabel = new JLabel("1960");
           scoresPanel.add(allbalcksFundiationYearLabel);
           allbalcksFundiationYearLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
           allbalcksFundiationYearLabel.setBounds(753, 632, 148, 54);
           

       
       
    
           allbalcksDescriptionLabel = new JLabel("<html>El equipo nacional de rugby de Nueva Zelanda, comúnmente conocido como All Blacks.<br>"
           		                                   + "Famosos por su éxito internacional, los All Blacks han sido considerados a menudo <br>"
                                                   + "como uno de los equipos deportivos más exitosos de la historia.</html>");
           scoresPanel.add(allbalcksDescriptionLabel);
           allbalcksDescriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
           allbalcksDescriptionLabel.setBounds(208, 364, 628, 205);
        */


  
    }
   
    
    
    /////////
    
    
    

    	
    

    
  
    
    

    
    
   
    
   
   
 
    
 
    
    
   
    
    
    
    
    ///
    
    private void initializeButtons() {
        goToScoresButton = new JButton("Partidos");
        goToScoresButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        goToScoresButton.setBounds(10, 10, 163, 33);
        goToScoresButton.setFocusable(false);
        goToScoresButton.setBackground(Color.WHITE);
        goToScoresButton.setBorder(new CustomBorder(20));
        goToScoresButton.setUI(new CustomButton());
        goToScoresButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                 
        goToStandingButton = new JButton("Clasificación");
        goToStandingButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        goToStandingButton.setBounds(205, 10, 212, 33);
        goToStandingButton.setFocusable(false);
        goToStandingButton.setBackground(Color.WHITE);
        goToStandingButton.setUI(new CustomButton());
        goToStandingButton.setBorder(null);
        goToStandingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        goToTeamsButton = new JButton("Equipos");
        goToTeamsButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        goToTeamsButton.setBounds(427, 10, 152, 33);
        goToTeamsButton.setFocusable(false);
        goToTeamsButton.setBackground(Color.WHITE);
        goToTeamsButton.setUI(new CustomButton()); 
        goToTeamsButton.setBorder(null);
        goToTeamsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        goToUpdateDataButton = new JButton("Actualizar datos");
        goToUpdateDataButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        goToUpdateDataButton.setBounds(1253, 10, 259, 33);
        goToUpdateDataButton.setFocusable(false);
        goToUpdateDataButton.setBackground(Color.WHITE);
        goToUpdateDataButton.setUI(new CustomButton()); 
        goToUpdateDataButton.setBorder(null);
        goToUpdateDataButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
        
        goToSeasonsMangement  = new JButton("Gestión de Temporadas");
        goToSeasonsMangement.setFont(new Font("Tahoma", Font.BOLD, 25));
        goToSeasonsMangement.setBounds(600, 10, 200, 33);
        goToSeasonsMangement.setFocusable(false);
        goToSeasonsMangement.setBackground(Color.WHITE);
        goToSeasonsMangement.setUI(new CustomButton()); 
        goToSeasonsMangement.setBorder(null);
        goToSeasonsMangement.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        goToScoresButton.addActionListener(this);
        goToStandingButton.addActionListener(this);
        goToTeamsButton.addActionListener(this);
        goToUpdateDataButton.addActionListener(this);
        goToSeasonsMangement.addActionListener(this);
        
        panelButton.add(goToScoresButton);
        panelButton.add(goToStandingButton);
        panelButton.add(goToTeamsButton);
        panelButton.add(goToUpdateDataButton);  
        panelButton.add(goToSeasonsMangement);
    }
    
    private void lastPaint() {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }
   
    private void showPanel(JPanel panelToShow) {
        mainPanel.removeAll();
        mainPanel.add(panelButton);
        mainPanel.add(panelToShow, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    
	//MODIFIES: this
    //EFFECTS:  displays the appropriate panel based on the clicked button by the user
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Map<JButton, JPanel> buttonPanelMap = new HashMap<>();
        buttonPanelMap.put(goToScoresButton, scoresPanel);
        buttonPanelMap.put(goToStandingButton, standingsPanel);
       buttonPanelMap.put(goToTeamsButton, teamsPanel);
       buttonPanelMap.put(goToUpdateDataButton, updateDataPanel);
       buttonPanelMap.put(goToSeasonsMangement, seasonsManagement);

        for (JButton button : buttonPanelMap.keySet()) {
            button.setBorder(null);
        }

        JButton clickedButton = (JButton) e.getSource();
        JPanel panelToShow = buttonPanelMap.get(clickedButton);

        if (panelToShow != null) {
            clickedButton.setBorder(new CustomBorder(25));
            showPanel(panelToShow);
        }
    }
    
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
			        new SportsDashboardPage();			    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}