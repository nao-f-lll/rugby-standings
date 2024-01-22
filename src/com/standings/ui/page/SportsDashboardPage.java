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
        
       //season = new Season(1, 2023, weeks, teams, games);
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
        seasonsManagement.setLayout(null);
      
    
        
        
        
     
        
        
        	
       
        
       mainPanel.add(scoresPanel, BorderLayout.CENTER);
       scoresPanel.add(panelButton);
       
       
       
       
    
        


  
    }
   
    
 
    

    	
    

    
  
    
    

    
    
   
    
   
   
 
    
 

    
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
        goToSeasonsMangement.setBounds(600, 10, 373, 33);
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