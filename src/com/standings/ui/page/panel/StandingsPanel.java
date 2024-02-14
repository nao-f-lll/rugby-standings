package com.standings.ui.page.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.standings.model.RugbyTeamsNames;
import com.standings.model.Season;
import com.standings.model.Team;
import com.standings.util.FileIO;
import com.standings.util.StandingsCalculation;

/**
 * Esta clase representa el panel de clasificaciones.
 * Proporciona una interfaz gráfica para mostrar las clasificaciones de los equipos.
 * 
 * @author SomeOne 
 * @version 1.0
 * @since 2024
 */
public class StandingsPanel extends JPanel implements ActionListener {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = -2913604003111840139L;
	private JTable table;
	private ArrayList<Team> teams;
	private RugbyTeamsNames[] rugbyTeamsNames;
	private Object[][] rows;
	private String[] columns;
	private Season season;
	private ArrayList<Season> seasons;
	private ArrayList<Team> allTeams;
	private JButton printPdfButton;
	private JButton printXmlButton;
	
	private String allblacksLogoPath;
	private String shamrockLogoPath;
	private String sakurasLogoPath;
	private String redRoseLogoPath;
	private String wallabiesLogoPath;
	private String springboksLogoPath;
	private String thistleLogoPath;
	private String feathersLogoPath;
	
	private boolean isNewSeason;
	private String[] newSeasonTeamsNames; 
	private FileIO<Season> fileIO;
	private JScrollPane scrollPane;
	
	
	/**
     * Constructor de la clase StandingsPanel.
     * 
     * @param season La temporada actual
     * @param seasons Lista de temporadas
     * @param allTeams Lista de todos los equipos
     */
		public StandingsPanel( Season season, ArrayList<Season> seasons, ArrayList<Team> allTeams) {
			
			initializeFrameGraphics();
            this.season = season;
            this.seasons = seasons;		
            this.allTeams = allTeams;
			initializeTeams();
			initializeTabel();
	}
		
		
		  /**
	     * Constructor de la clase StandingsPanel.
	     * 
	     * @param season La temporada actual
	     * @param seasons Lista de temporadas
	     * @param allTeams Lista de todos los equipos
	     * @param isNewSeason Indica si es una nueva temporada
	     */		
	public StandingsPanel( Season season, ArrayList<Season> seasons, ArrayList<Team> allTeams, boolean isNewSeason) {
			
			initializeFrameGraphics();
            this.season = season;
            this.seasons = seasons;		
            this.allTeams = allTeams;
            this.isNewSeason = isNewSeason;
			initializeTeams();
			initializeTabel();
	}
		
	
	/**
     * Constructor de la clase StandingsPanel.
     * 
     * @param season La temporada nueva 
     * @param seasons Lista de temporada nueva
     * @param allTeams Lista de todos los equipos buevos
     * @param isNewSeason Indica si es una nueva temporada
     * @param newSeasonTeamsNames Lista de nombres de equipos de la nueva temporada
     */
	public StandingsPanel( Season season, ArrayList<Season> seasons, ArrayList<Team> allTeams, boolean isNewSeason, String[] newSeasonTeamsNames) {
		this.newSeasonTeamsNames = newSeasonTeamsNames;
		initializeFrameGraphics();
        this.season = season;
        this.seasons = seasons;		
        this.allTeams = allTeams;
        this.isNewSeason = isNewSeason;
		initializeAllTeams();
		initializeTabel();
	}

	
	/**
    * Inicializa los elementos gráficos del panel.
    */
		private void initializeFrameGraphics() {
			
            table = new JTable();
            table.setEnabled(false);
            table.setFont(new Font("Tahoma", Font.PLAIN, 20));
            table.setBackground(new Color(255, 255, 255));
            initializeButtons();
            
            
		}
		
		/**
	     * Inicializa los botones del panel.
	     */
		private void initializeButtons() {
			  printPdfButton = new JButton("Exportar PDF");
			  printPdfButton.setBounds(810, 720, 150, 40);
			  printPdfButton.setBackground(Color.lightGray);
			  printPdfButton.setFocusable(false);
			  printPdfButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			  add(printPdfButton);
			  printPdfButton.addActionListener(this);
			  
			  printXmlButton = new JButton("Exportar XML");
			  printXmlButton.setBounds(550, 720, 150, 40);
			  printXmlButton.setBackground(Color.lightGray);
			  printXmlButton.setFocusable(false);
			  printXmlButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			  add(printXmlButton);
			  printXmlButton.addActionListener(this);
		}
		
		
	
		
		 /**
	     * Inicializa los equipos.
	     */
		
		private void initializeTeams() {
			
	
				this.teams = season.getTeams(); 
				
				if (this.isNewSeason) {
					initializeIcons();
					String[] iconsPath = {allblacksLogoPath,springboksLogoPath,sakurasLogoPath,  redRoseLogoPath, shamrockLogoPath, wallabiesLogoPath, thistleLogoPath, feathersLogoPath};	
				
						rugbyTeamsNames = RugbyTeamsNames.values();
						int index = 0;
				
							for (int i = 0; i < rugbyTeamsNames.length - 2; i++) {	
								Team team = new Team(rugbyTeamsNames[i].name(), iconsPath[index]);
								this.teams.add(team);		
								index++;					
					}
				}	
		}
	
		
		 /**
	     * Inicializa todos los equipos para la nueva temporada.
	     * 
	     * @param newSeasonTeamsNames Nombres de los equipos de la nueva temporada
	     */
		private void initializeAllTeams() {
			
				
			this.teams = season.getTeams(); 
		

					initializeIcons();
					String[] iconsPath = {allblacksLogoPath,springboksLogoPath,sakurasLogoPath,  redRoseLogoPath, shamrockLogoPath, wallabiesLogoPath, thistleLogoPath, feathersLogoPath};	
				
					this.allTeams = new ArrayList<>();
						rugbyTeamsNames = RugbyTeamsNames.values();
						int index = 0;
				
							for (int i = 0; i < rugbyTeamsNames.length ; i++) {	
								Team team = new Team(rugbyTeamsNames[i].name(), iconsPath[index]);
								allTeams.add(team);		
								index++;					
					}
							
							
							ArrayList<Team> filteredTeams = new ArrayList<>();
				
								for (Team team : allTeams) {
								    if (Arrays.asList(newSeasonTeamsNames).contains(team.getName())) {
								    	filteredTeams.add(team);
								        if (filteredTeams.size() > 5) {
								            break;
								        }
								    }
								
							}
							
							this.teams.addAll(filteredTeams);		
		}
		
		

		
		

		 /**
	     * Inicializa las rutas de los iconos de los equipos.
	     */
		private void initializeIcons() {
			allblacksLogoPath = "media/Imagenes/logos/all_blacks_badge_white.png";
			shamrockLogoPath = "media/Imagenes/logos/shamrock-logo.png";
			sakurasLogoPath = "media/Imagenes/logos/sakuras-logo.png";
			springboksLogoPath = "media/Imagenes/logos/south_Africa_national_rugby_union_team.png";
			redRoseLogoPath = "media/Imagenes/logos/red_rose_logo.png";
			wallabiesLogoPath = "media/Imagenes/logos/wallabies-logo.png";
			thistleLogoPath = "media/Imagenes/logos/thistle_logo.png";
			feathersLogoPath = "media/Imagenes/logos/feathers_logo.png";
			
			
		

		}
		
		
		





		/**
	     * Inicializa la tabla de clasificación con las filas y columnas predeterminadas.
	     * Si es una nueva temporada, calcula las clasificaciones y las renderiza.
	     */
		private void initializeTabel() {
			rows = new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					};

					columns =	new String[] {
		             		"Equipo", "Partidos Jugados", "Victorias", "Derrotas", "Empates", "Puntos"
		             	};										


					 
					
					if (isNewSeason) {
						new StandingsCalculation(this.season, this.seasons);
					}
					renderUpdatedStandings();


					scrollPane = new JScrollPane(table);
					scrollPane.setEnabled(false);
					scrollPane.setBounds(10, 70, 1502, 643);
 
				    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
				    add(scrollPane);

					JTableHeader tableHeader = table.getTableHeader();
					Dimension headerSize = tableHeader.getPreferredSize();
					headerSize.height = 100; 
					tableHeader.setPreferredSize(headerSize);
					tableHeader.setReorderingAllowed(false);

					table.getTableHeader().setFont(new Font(null, 20, 20));
					table.getTableHeader().setBackground(Color.LIGHT_GRAY);


					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

					centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

					table.setDefaultRenderer(Object.class, centerRenderer);

					table.setRowHeight(90);

					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					this.add(scrollPane, BorderLayout.CENTER);
					
			}
		
		
		 /**
	     * Actualiza la tabla de clasificaciones con los datos actualizados de los equipos.
	     * Recorre la matriz de filas y actualiza cada celda con el nombre del equipo, los partidos jugados,
	     * las victorias, las derrotas, los empates y los puntos obtenidos por cada equipo.
	     * Finalmente, establece el modelo de la tabla con los datos actualizados.
	     */
		public void renderUpdatedStandings() {		
			
			int teamIndex = 0;
			for (int i = 0; i < rows.length; i++) {
	       
	            rows[i][0] = this.teams.get(teamIndex).getName();
	            rows[i][1] = this.teams.get(teamIndex).getGamesPlayed();
	          	rows[i][2] = this.teams.get(teamIndex).getWins();
	          	rows[i][3] = this.teams.get(teamIndex).getLosses();
	          	rows[i][4] = this.teams.get(teamIndex).getTies();
	          	rows[i][5] = this.teams.get(teamIndex).getPoints();	            	 
	           	teamIndex++;
	        }
			
	          table.setModel(new DefaultTableModel(rows, columns));
		}
		
		
		public void renderUpdatedStandings(Object[][] rows, String[] columns) {		
			
			int teamIndex = 0;
			for (int i = 0; i < rows.length; i++) {
	       
	            rows[i][0] = this.teams.get(teamIndex).getName();
	            rows[i][1] = this.teams.get(teamIndex).getGamesPlayed();
	          	rows[i][2] = this.teams.get(teamIndex).getWins();
	          	rows[i][3] = this.teams.get(teamIndex).getLosses();
	          	rows[i][4] = this.teams.get(teamIndex).getTies();
	          	rows[i][5] = this.teams.get(teamIndex).getPoints();	             	 
	           	teamIndex++;
	        }
			
	          table.setModel(new DefaultTableModel(rows, columns));
		}
		
		
		/**
		 * Actualiza la tabla de clasificaciones con los datos actualizados de los equipos y la temporada.
		 * Asigna la temporada proporcionada como la temporada actual y actualiza los datos de cada equipo en la tabla.
		 *
		 * @param teams  La lista de equipos actualizada.
		 * @param season La temporada actualizada.
		 */
		public void renderUpdatedStandings(ArrayList<Team> teams, Season season) {		
			this.season = season;
			int teamIndex = 0;
			for (int i = 0; i < rows.length; i++) {
	       
	            rows[i][0] = teams.get(teamIndex).getName();
	            rows[i][1] = teams.get(teamIndex).getGamesPlayed();
	          	rows[i][2] = teams.get(teamIndex).getWins();
	          	rows[i][3] = teams.get(teamIndex).getLosses();
	          	rows[i][4] = teams.get(teamIndex).getTies();
	          	rows[i][5] = teams.get(teamIndex).getPoints();	            	 
	           	teamIndex++;
	     
	        }
			
	          table.setModel(new DefaultTableModel(rows, columns));

		
	  
		}
		
		/**
		 * Actualiza la tabla de clasificaciones con los datos actualizados de los equipos.
		 * Actualiza los datos de cada equipo en la tabla.
		 *
		 * @param teams La lista de equipos actualizada.
		 */
		public void renderUpdatedStandings(ArrayList<Team> teams) {		
			
			int teamIndex = 0;
			for (int i = 0; i < rows.length; i++) {
	       
	            rows[i][0] = teams.get(teamIndex).getName();
	            rows[i][1] = teams.get(teamIndex).getGamesPlayed();
	          	rows[i][2] = teams.get(teamIndex).getWins();
	          	rows[i][3] = teams.get(teamIndex).getLosses();
	          	rows[i][4] = teams.get(teamIndex).getTies();
	          	rows[i][5] = teams.get(teamIndex).getPoints();	            	 
	           	teamIndex++;
	     
	        }
			
	          table.setModel(new DefaultTableModel(rows, columns));

		
	  
		}
		
		/**
		 * Realiza una acción en respuesta a un evento de acción.
		 * Si el origen del evento es el botón de impresión PDF, imprime la tabla como un archivo PDF.
		 * Si el origen del evento es el botón de impresión XML, crea un archivo XML.
		 *
		 * @param e El evento de acción que desencadena este método.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == printPdfButton) {
				printTabelAsPDF();
			} else if (e.getSource() == printXmlButton) {
				CreatXML();
			}
			
			
		}
		
		/**
		 * Imprime la tabla como un archivo PDF.
		 * El encabezado del documento PDF muestra la clasificación de la temporada actual.
		 * El pie de página muestra la afiliación a la Federación de World Rugby.
		 * Muestra un mensaje de éxito al usuario después de exportar el archivo PDF.
		 * En caso de error al imprimir, muestra un mensaje de error.
		 */
		private void printTabelAsPDF() {
			
		
			MessageFormat header = new MessageFormat("Clasificaión de la temporada " + season.getYear());
			MessageFormat footer = new MessageFormat("Federación de World Rugby");
	
		
			try {
	 
				table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				userDialog("Se ha exportado el archivo PDF", "Exportar PDF", JOptionPane.INFORMATION_MESSAGE);
				
			} catch(java.awt.print.PrinterException e) {
				System.err.format("error al imprimir", e.getMessage());
			}

		}
		
		private void CreatXML() {
			season.convertToXML();
			fileIO = new FileIO<Season>();
			fileIO.writeMetaData(seasons);
			userDialog("Se ha exportado el archivo XML", "Exportar XML", JOptionPane.INFORMATION_MESSAGE);
		}
		

		/**
		 * Este metodo muestra un ventana que contiene un mensaje de error
		 * 
		 * @param warrningText  la descripcion del error
		 * @param warrningTitle el titulo mensaje de error
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
		
		
}