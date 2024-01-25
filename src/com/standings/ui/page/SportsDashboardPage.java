package com.standings.ui.page;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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


public class SportsDashboardPage extends ParentFrame implements ActionListener, WindowListener, ListSelectionListener {

    private static final long serialVersionUID = 1L;
    private final String FILE_PATH = "data/objects/seasons.ser";
    
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
    private ArrayList<Team> allTeams;
	private ArrayList<Game> games;
	private ArrayList<Week> weeks;
	private Season season;
	private ArrayList<Season> seasons;
	private FileIO<Season> fileIo;
	private static boolean hasSeasondataCHanged;
	private boolean isNewSeason;
	
	/////
	
	/*
	private JTextField textField;
	private JLabel teamsLabel;	
	private DefaultListModel<Team> listModel;
	
    private JList<Team> teamList;
    private JLabel sectionTitle;
    private JLabel yearLabel;
    private JButton creatSeasonButton;
	*/
	
	
	

	
	////
	
	   public SportsDashboardPage() {
		   initializeFrameGraphics();	
	    	
	        allTeams = new ArrayList<>();
	        isNewSeason = true;
	        if (isNewSeason) {
	        	initializeStandingsNewSeason();
	        } else {
	        	initializeStandingsData();
	        }
			initializePanelGraphics();	
		   
	  }
/*
    public SportsDashboardPage(String selectedSeason, ArrayList<Season>seasons) {
    	
    	
    	initializeFrameGraphics();	
    	//initializeStandingsData();
    	initializeStandingsNewSeason();
		initializePanelGraphics();	
    }
     */
    
    private void initializeFrameGraphics() {
    	setTitle("Panel administrativo");
    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	this.addWindowListener(this);
        setResizable(false);
        setSizeAndCenter();
    }

    private void setSizeAndCenter() {
        setSize(1538, 850);
        setLocationRelativeTo(null);
    }
  
    
    private void initializeStandingsData() {
    	hasSeasondataCHanged = false;
    	fileIo = new FileIO<>();
    	seasons = new ArrayList<>();
    	seasons = fileIo.readObject(FILE_PATH, seasons);
    	season = seasons.get(seasons.size() - 1);
    	
    	

    }
    
    private void initializeStandingsNewSeason() {
    	   fileIo = new FileIO<>();
    	   teams = new ArrayList<>();
           games = new ArrayList<>();
           weeks = new ArrayList<>();
           seasons = new ArrayList<>();
          season = new Season(2023, weeks, teams, games);
          seasons.add(season);
          hasSeasondataCHanged = true;
      
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
    	
    	if (isNewSeason) {
    		standingsPanel = new StandingsPanel(season, seasons, allTeams, isNewSeason);
    	} else {
    		standingsPanel = new StandingsPanel(season, seasons, allTeams);
    	}
    	
    	scoresPanel = new ScoresPanel(panelButton, season);
    	teamsPanel = new TeamsPanel(panelButton);          
        updateDataPanel = new UpdateDataPanel(season.getTeams(), season.getGames(),standingsPanel, scoresPanel);
        seasonsManagement = new SeasonsManagement(allTeams);
        

        scoresPanel.setLayout(null);
        standingsPanel.setLayout(null);
        teamsPanel.setLayout(null);
        updateDataPanel.setLayout(null);
        seasonsManagement.setLayout(null);
      
    
       mainPanel.add(scoresPanel, BorderLayout.CENTER);
       scoresPanel.add(panelButton);
          
    	
		///////////////////////////////////7
		/*
		 * 
		 *      
        mainPanel.add(seasonsManagement, BorderLayout.CENTER);
        seasonsManagement.add(panelButton); 
        
        sectionTitle = new JLabel("Crear una temporada");
        sectionTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        sectionTitle.setBounds(232, 80, 264, 68);
        getContentPane().add(sectionTitle);
        
        textField = new JTextField();
        textField.setBounds(422, 190, 115, 45);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        yearLabel = new JLabel("Año");
        yearLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        yearLabel.setBounds(192, 174, 75, 68);
        getContentPane().add(yearLabel);
        
        teamsLabel = new JLabel("Equipos");
        teamsLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        teamsLabel.setBounds(192, 287, 75, 68);
        getContentPane().add(teamsLabel);
        
        
        
        listModel = new DefaultListModel<Team>();
        
        teamList = new JList<Team>();
        teamList.setBounds(422, 287, 115, 169);
        teamList.setModel(listModel);
        teamList.addListSelectionListener(this);
        getContentPane().add(teamList);
        
        creatSeasonButton = new JButton("Crear Temporada");
        creatSeasonButton.setBounds(301, 545, 139, 28);
        getContentPane().add(creatSeasonButton);

        
        
        addTeamsToList();
 */
  
    }
   /*
	
	private void addTeamsToList() {
		for (Team team : allTeams) {
			listModel.addElement(team);
		}
		
	}*/
	
	///////////////////////////////
    


    
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
    

	public boolean hasSeasondataCHanged() {
		return hasSeasondataCHanged;
	}

	public static  void setHasSeasonDataChanged(boolean hasSeasondataCHanged) {
		SportsDashboardPage.hasSeasondataCHanged = hasSeasondataCHanged;
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
	
	

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		if (hasSeasondataCHanged) {
		
			fileIo.writeObject(FILE_PATH, seasons);
			
			userDialog("Guardando...", "Datos Modificados", JOptionPane.INFORMATION_MESSAGE);
			
			
			
			
			
			
			
		}
		
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}