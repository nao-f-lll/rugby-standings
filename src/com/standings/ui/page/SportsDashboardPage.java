package com.standings.ui.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.standings.model.Game;
import com.standings.model.ParentFrame;
import com.standings.model.Season;
import com.standings.model.Team;
import com.standings.model.Week;
import com.standings.model.design.CustomBorder;
import com.standings.model.design.CustomButton;
import com.standings.ui.page.panel.PlayersPanel;
import com.standings.ui.page.panel.ScoresPanel;
import com.standings.ui.page.panel.SeasonsManagement;
import com.standings.ui.page.panel.StandingsPanel;
import com.standings.ui.page.panel.TeamsPanel;
import com.standings.ui.page.panel.UpdateDataPanel;
import com.standings.util.FileIO;

/**
 * La clase SportsDashboardPage representa la página principal del panel de control de la aplicación,
 * que permite a los usuarios gestionar datos deportivos, incluyendo equipos, partidos, clasificaciones y temporadas.
 */
public class SportsDashboardPage extends ParentFrame implements ActionListener, WindowListener, ListSelectionListener {
	
	// Variables de clase y constantes
    private static final long serialVersionUID = 1L;
    private final String FILE_PATH = "data/objects/seasons.ser";
    
    private JPanel mainPanel;
    private JPanel panelButton;
    
    private ScoresPanel scoresPanel;
    private StandingsPanel standingsPanel;
    private TeamsPanel teamsPanel; 
    private UpdateDataPanel updateDataPanel;
    private SeasonsManagement seasonsManagementPanel;
    private PlayersPanel playersManagementPanel;
    
    private JButton goToScoresButton;
    private JButton goToStandingButton;
    private JButton goToTeamsManagementButton;
    private JButton goToUpdateDataButton;
    private JButton goToSeasonsMangementButton;
    private JButton goToPlayersMangementButton;
    private ArrayList<Team> teams;
    private ArrayList<Team> allTeams;
	private ArrayList<Game> games;
	private ArrayList<Week> weeks;
	private Season season;
	private ArrayList<Season> seasons;
	private FileIO<Season> fileIo;
	private static boolean hasSeasondataCHanged;
	private boolean isNewSeason;
	private  Season futureSeason;
	
	
	/////////////////////////////////////////

	

	/////////////////////////////////////
	
	/**
	 * Constructor de la página del tablero deportivo.
	 * Inicializa los gráficos del marco, los datos de todos los equipos y verifica si es una nueva temporada.
	 * Si es una nueva temporada, inicializa los datos de la nueva temporada; de lo contrario, carga los datos de la temporada existente.
	 * Inicializa los gráficos del panel.
	 */
	   public SportsDashboardPage() {
		   initializeFrameGraphics();	
	    	
	        allTeams = new ArrayList<>();
	        checkIfFileExists();
	        
	        
	        if (isNewSeason) {
	        	initializeStandingsNewSeason();
	        } else {
	        	initializeStandingsData();
	        }
			initializePanelGraphics();	
		   
	  }

	   private void checkIfFileExists() {
			  File file = new File(FILE_PATH);
		        if (!file.exists() || file.length() == 0) {
		        	 isNewSeason = true;
		        } else {
		        	  isNewSeason = false;
		        } 
		}
    
	   /**
	    * Inicializa los gráficos del panel.
	    * Establece el título, la operación de cierre, el tamaño y la ubicación del panel
	    */
    private void initializeFrameGraphics() {
    	setTitle("Panel administrativo");
    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	this.addWindowListener(this);
        setResizable(false);
        setSizeAndCenter();
    }

    /**
     * Establece el tamaño del marco y lo centra en la pantalla.
     */
    private void setSizeAndCenter() {
        setSize(1538, 850);
        setLocationRelativeTo(null);
    }
  
    
    /**
     * Inicializa los datos de la clasificación para una temporada existente.
     * Lee los datos de la temporada desde el archivo y establece la última temporada como la actual.
     */
    private void initializeStandingsData() {
    	hasSeasondataCHanged = false;
    	fileIo = new FileIO<>();
    	seasons = new ArrayList<>();
    	seasons = fileIo.readObject(FILE_PATH, seasons);
    	season = seasons.get(seasons.size() - 2);
    }
    
    /**
     * Inicializa los datos de la clasificación para una nueva temporada.
     * Lee los datos de las temporadas anteriores desde el archivo, crea una nueva temporada y la establece como la actual.
     */
    public void initializeStandingsNewSeason() {
    	   fileIo = new FileIO<>();
    	   seasons = new ArrayList<>();
    	   seasons = fileIo.readObject(FILE_PATH, seasons);
    	   teams = new ArrayList<>();
           games = new ArrayList<>();
           weeks = new ArrayList<>();
           if (seasons.size() > 0) {
        	   Season lastSeason = seasons.get(seasons.size() - 2);
        	   lastSeason.setState("finalizada");
               season = new Season(lastSeason.getId() + 1,lastSeason.getYear() + 1, "actual", weeks, teams, games);
           } else {
        	   // user should select the year//////
        	   /////
        	   /////
        	   /////
        	   ///
               season = new Season(1, 2023, "actual", weeks, teams, games);
              
       		ArrayList<Team> futureTeams = new ArrayList<>();
			ArrayList<Game>  futureGames = new ArrayList<>();
			ArrayList<Week>  futureweeks = new ArrayList<>();
               
            futureSeason = new Season(season.getId() + 1, season.getYear()+ 1,  "proximamente", futureweeks, futureTeams, futureGames);
           }
        
          seasons.add(season);
          seasons.add(futureSeason);
          hasSeasondataCHanged = true;

    }
    
    /**
     * Inicializa los gráficos de los paneles.
     * Inicializa el panel principal, los botones del panel y otros componentes necesarios.
     */
    private void initializePanelGraphics() {
    	initializeMainPanel();
    	initializePanelButton();
    	initializeButtons();
    	initializeButtonPanels();
    	lastPaint();
    }
    
    /**
     * Inicializa el panel principal con un diseño de borde.
     */
    private void initializeMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); 	
    }
   
    
    /**
     * Inicializa el panel de botones con un diseño nulo y un fondo blanco.
     */
    private void initializePanelButton() {
        panelButton = new JPanel();
        panelButton.setBounds(0, 0, 1522, 60);
        panelButton.setBackground(Color.WHITE);
        panelButton.setLayout(null);
    }
    
    /**
     * Inicializa los paneles de botones en función de si es una nueva temporada o no.
     * Si es una nueva temporada, inicializa el panel de clasificación con la temporada actual y los equipos disponibles.
     * Si no es una nueva temporada, inicializa el panel de clasificación con la temporada anterior y los equipos disponibles.
     * Además, inicializa los paneles de puntuaciones, equipos, actualización de datos y gestión de temporadas.
     */
    private void initializeButtonPanels() {    		
    	teamsPanel = new TeamsPanel(panelButton, allTeams);
    	standingsPanel = new StandingsPanel(season, isNewSeason);   	
        scoresPanel = new ScoresPanel(panelButton, season);
        updateDataPanel = new UpdateDataPanel(season.getTeams(), season.getGames(),standingsPanel, scoresPanel);      
        seasonsManagementPanel = new SeasonsManagement(updateDataPanel, goToUpdateDataButton, goToScoresButton, goToStandingButton, allTeams, seasons, standingsPanel, scoresPanel);
        playersManagementPanel = new PlayersPanel(panelButton, allTeams);
        
        scoresPanel.setLayout(null);
        standingsPanel.setLayout(null);
        teamsPanel.setLayout(null);
        updateDataPanel.setLayout(null);
        seasonsManagementPanel.setLayout(null);
        playersManagementPanel.setLayout(null);
        ///////////////////////////////////////////

    
      
        

     

        ////////////////////////////////////   
        
        
        
       mainPanel.add(scoresPanel, BorderLayout.CENTER);
       scoresPanel.add(panelButton);

>>>>>>> 9118f63f551296d176d8736d2550b898c54753a3

        
        mainPanel.add(scoresPanel, BorderLayout.CENTER);
        scoresPanel.add(panelButton);
    }
    /**
     * Inicializa los botones de la interfaz de usuario.
     * Los botones incluyen opciones para acceder a los partidos, la clasificación, los equipos,
     * la actualización de datos y la gestión de temporadas.
     * Configura las propiedades de estilo y comportamiento de los botones.
     */
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
        goToStandingButton.setBounds(197, 11, 212, 33);
        goToStandingButton.setFocusable(false);
        goToStandingButton.setBackground(Color.WHITE);
        goToStandingButton.setUI(new CustomButton());
        goToStandingButton.setBorder(null);
        goToStandingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        goToTeamsManagementButton = new JButton("Equipos");
        goToTeamsManagementButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        goToTeamsManagementButton.setBounds(426, 11, 204, 33);
        goToTeamsManagementButton.setFocusable(false);
        goToTeamsManagementButton.setBackground(Color.WHITE);
        goToTeamsManagementButton.setUI(new CustomButton()); 
        goToTeamsManagementButton.setBorder(null);
        goToTeamsManagementButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        goToUpdateDataButton = new JButton("Actualizar datos");
        goToUpdateDataButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        goToUpdateDataButton.setBounds(1253, 10, 259, 33);
        goToUpdateDataButton.setFocusable(false);
        goToUpdateDataButton.setBackground(Color.WHITE);
        goToUpdateDataButton.setUI(new CustomButton()); 
        goToUpdateDataButton.setBorder(null);
        goToUpdateDataButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
        
        goToSeasonsMangementButton  = new JButton("Temporadas");
        goToSeasonsMangementButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        goToSeasonsMangementButton.setBounds(869, 11, 204, 33);
        goToSeasonsMangementButton.setFocusable(false);
        goToSeasonsMangementButton.setBackground(Color.WHITE);
        goToSeasonsMangementButton.setUI(new CustomButton()); 
        goToSeasonsMangementButton.setBorder(null);
        goToSeasonsMangementButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        goToPlayersMangementButton  = new JButton("Jugadores");
        goToPlayersMangementButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        goToPlayersMangementButton.setBounds(642, 11, 204, 33);
        goToPlayersMangementButton.setFocusable(false);
        goToPlayersMangementButton.setBackground(Color.WHITE);
        goToPlayersMangementButton.setUI(new CustomButton()); 
        goToPlayersMangementButton.setBorder(null);
        goToPlayersMangementButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        goToScoresButton.addActionListener(this);
        goToPlayersMangementButton.addActionListener(this);
        goToStandingButton.addActionListener(this);
        goToTeamsManagementButton.addActionListener(this);
        goToUpdateDataButton.addActionListener(this);
        goToSeasonsMangementButton.addActionListener(this);
        
        panelButton.add(goToScoresButton);
        panelButton.add(goToStandingButton);
        panelButton.add(goToTeamsManagementButton);
        panelButton.add(goToUpdateDataButton);  
        panelButton.add(goToSeasonsMangementButton);
        panelButton.add(goToPlayersMangementButton);
    }
    
    /**
     * Configura el diseño final de la ventana principal.
     * Añade el panel principal al centro de la ventana y el panel de botones en la parte superior.
     */
    
    private void lastPaint() {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }
   
    /**
     * Muestra el panel especificado en la ventana principal.
     * Limpia el contenido anterior del panel principal y agrega el panel de botones en la parte superior.
     * Luego, agrega el panel especificado en el centro del panel principal.
     * Finalmente, refresca y actualiza el panel principal.
     * @param panelToShow El panel que se va a mostrar en la ventana principal.
     */
    private void showPanel(JPanel panelToShow) {
        mainPanel.removeAll();
        mainPanel.add(panelButton);
        mainPanel.add(panelToShow, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    
 
    
    
    /**
     * Maneja las acciones realizadas por el usuario en la interfaz de usuario.
     * Asocia cada botón con el panel correspondiente y muestra el panel asociado cuando se hace clic en el botón.
     * Además, actualiza el borde de los botones para resaltar el botón seleccionado.
     * @param e El evento de acción generado por el usuario.
     */
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
    	
    	
    	Map<JButton, JPanel> buttonPanelMap = new HashMap<>();
        buttonPanelMap.put(goToScoresButton, scoresPanel);
        buttonPanelMap.put(goToStandingButton, standingsPanel);
       buttonPanelMap.put(goToTeamsManagementButton, teamsPanel);
       buttonPanelMap.put(goToUpdateDataButton, updateDataPanel);
       buttonPanelMap.put(goToSeasonsMangementButton, seasonsManagementPanel);
       buttonPanelMap.put(goToPlayersMangementButton, playersManagementPanel);
       
       

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
    

    /**
     * Devuelve un valor booleano que indica si los datos de la temporada han cambiado.
     * @return true si los datos de la temporada han cambiado, false de lo contrario.
     */
	public boolean hasSeasondataCHanged() {
		return hasSeasondataCHanged;
	}
	

	/**
	 * Establece el estado de cambio de los datos de la temporada.
	 * @param hasSeasondataCHanged true si los datos de la temporada han cambiado, false de lo contrario.
	 */
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


    /** Verifica si los datos de la temporada han cambiado
     * Si han cambiado, guarda los datos en el archivo
     * Muestra un mensaje al usuario indicando que los datos se están guardando
     */
	@Override
	public void windowClosing(WindowEvent e) {
		
		  if (hasSeasondataCHanged) {
		       int result = userDialogOkCancel("Desea guardar?", "Cambios detectados", JOptionPane.INFORMATION_MESSAGE);
		        if (result == 0) {
		            fileIo.writeObject(FILE_PATH, seasons);
		        } 
		    }
		    System.exit(0);
		
	}
	
	/**
	 * Muestra un diálogo de mensaje con un botón "Aceptar".
	 *
	 * @param dialogText   El texto que se mostrará en el diálogo.
	 * @param dialogTitle  El título del diálogo.
	 * @param messageType  El tipo de mensaje (por ejemplo, JOptionPane.INFORMATION_MESSAGE).
	 */
	private int userDialogOkCancel(String dialogText, String dialogTitle, int messageType) {

		  JDialog dialog = new JDialog(this, dialogTitle, true);
	        dialog.getContentPane().setLayout(new BorderLayout());
	        dialog.setSize(300, 150);

	        JLabel label = new JLabel(dialogText);
	        label.setHorizontalAlignment(JLabel.CENTER);
	        dialog.getContentPane().add(label, BorderLayout.CENTER);

	        JButton acceptButton = new JButton("Guardar y salir");
	        JButton cancelButton = new JButton("Salir sin guardar");

	        acceptButton.setFocusable(false);
	        acceptButton.setBackground(Color.LIGHT_GRAY);
	        cancelButton.setFocusable(false);
	        cancelButton.setBackground(Color.LIGHT_GRAY);

	        final int[] result = {-2};

	        acceptButton.addActionListener(e -> {
	            dialog.dispose();
	            result[0] = 0;
	        });

	        cancelButton.addActionListener(e -> {
	            dialog.dispose();
	            result[0] = -1;

	        });

	        JPanel buttonPanel = new JPanel(new FlowLayout());
	        buttonPanel.add(acceptButton);
	        buttonPanel.add(cancelButton);
	        dialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        dialog.setLocationRelativeTo(this);
	        dialog.setVisible(true);

	        return result[0];
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
	
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
