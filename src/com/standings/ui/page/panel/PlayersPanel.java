package com.standings.ui.page.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.standings.model.Fecha;
import com.standings.model.Jugador;
import com.standings.model.Nationality;
import com.standings.model.Season;
import com.standings.model.Team;
import com.standings.ui.page.SportsDashboardPage;

public class PlayersPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4497166479859458705L;
	private JPanel panelButton;
	private JPanel registerPanel;
	private JLabel fotoPersonalPreviewLable;
	private JLabel playerNameLabel;
	private ImageIcon icon;
	private JTextField nameTextField;
	private JButton creatPlayerButton;
	private JButton updatePlayerButton;
	private JButton deletePlayerButton;
	private JLabel createPlayerTitleLabel;
	private JLabel playerListLabel;
	private JLabel selectTeamLabel;
	private JLabel selectSeasonPanel;
	private JComboBox<Team> selectTeamComboBox;
	private JComboBox<Season> selectSeasonComboBox;
	private DefaultComboBoxModel<Team> teamsComboBoxModel;
	private DefaultComboBoxModel<Team> teamsComboBoxModelForPlayerRegister;
	private DefaultComboBoxModel<Season> seasonsComboBoxModel;
	private JPanel playerTablePanel;
	private ArrayList<Team> allTeams;
	private ArrayList<Season> seasons;
	private JButton fotoPersonalButton;
    private JLabel playerBirthdayLabel;
    private JComboBox<Integer> playerBirthDayComboBox;
    private JLabel playerNationalityLabel;
    private JComboBox<Nationality> nationalityComboBox;
    private JLabel teamLabel;
    private JComboBox<Team> teamComboBox;
    private Vector<String> columnas;
  	private Vector<Vector<Object>> datosTabla;
  	private JTable table;
  	private JTableHeader tableHeader;
  	private Dimension headerSize;
  	private JScrollPane scrollPane;
  	private DefaultTableModel model;
  	private JComboBox<Integer> playerBirthYearComboBox ;
  	private JComboBox<Integer> playerBirthMonthComboBox ;
  	private DefaultComboBoxModel<Integer> yearDefaultComboBox;
  	private DefaultComboBoxModel<Integer> monthDefaultComboBox;
  	private DefaultComboBoxModel<Integer> dayDefaultComboBox;
  	private String imagePath;
    
	
	public PlayersPanel(JPanel panelButton, ArrayList<Team> allTeams, ArrayList<Season> seasons) {
		this.panelButton = panelButton;
		this.allTeams = allTeams;
		this.seasons = seasons;
		initializePlayersPanels(); 	
	}
	
	private void initializePlayersPanels() {
		 initializeCreatNewPlayerPanel();
    	 initializePlayersTablePanel();
	
	}
	
	private void initializeCreatNewPlayerPanel() {
		  registerPanel = new JPanel();
	      registerPanel.setBounds(0, 59, 634, 754);
	      this.add(registerPanel);
	      registerPanel.setLayout(null);
	      registerPanel.setBackground(new Color(255, 255, 255));
	            
	      createPlayerTitleLabel = new JLabel("Crear un nuevo jugador");
	      createPlayerTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	      createPlayerTitleLabel.setBounds(168, 0, 316, 68);
	      registerPanel.add(createPlayerTitleLabel);
	      
	      fotoPersonalPreviewLable = new JLabel();
	      fotoPersonalPreviewLable.setHorizontalAlignment(SwingConstants.CENTER);	      
	      fotoPersonalPreviewLable.setBounds(50, 129, 167, 103);
	      fotoPersonalPreviewLable.setIcon(new ImageIcon(SportsDashboardPage.class.getResource("/images/escudoGenerico.png")));
	      registerPanel.add(fotoPersonalPreviewLable);
	      
	      fotoPersonalButton = new JButton("Selecionar Foto");
	      fotoPersonalButton.setBounds(50, 256, 155, 25);
	      fotoPersonalButton.addActionListener(this);
	      registerPanel.add(fotoPersonalButton);
	      fotoPersonalButton.setFocusable(false);
	      fotoPersonalButton.setBackground(Color.LIGHT_GRAY);
	      fotoPersonalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	      fotoPersonalButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      
	        
	      playerNameLabel = new JLabel("Nombre ");
	      playerNameLabel.setBounds(289, 158, 70, 15);
	      registerPanel.add(playerNameLabel);
	        
	      nameTextField = new JTextField();
	      nameTextField.setBounds(428, 153, 200, 25);
	      registerPanel.add(nameTextField);
	      nameTextField.setColumns(10);
	        
	      playerBirthdayLabel = new JLabel("Fecha de nacemiento");
	      playerBirthdayLabel.setBounds(289, 217, 129, 15);
	      registerPanel.add(playerBirthdayLabel);
	        	        
	      initializeBirthDay();
	                
	      playerNationalityLabel = new JLabel("Nacionalidad");
	      playerNationalityLabel.setBounds(289, 276, 84, 15);
	      registerPanel.add(playerNationalityLabel);
	        
	      initializeNationality();
	        
	      teamLabel = new JLabel("Equipo");
	      teamLabel.setBounds(289, 344, 84, 15);
	      registerPanel.add(teamLabel);
        
	      creatPlayerButton = new JButton("Crear");
	      creatPlayerButton.setBounds(100, 492, 117, 35);
	      registerPanel.add(creatPlayerButton);
	      creatPlayerButton.addActionListener(this); 
	      creatPlayerButton.setFocusable(false);
	      creatPlayerButton.setBackground(Color.LIGHT_GRAY);
	      creatPlayerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	      creatPlayerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
     
	      updatePlayerButton = new JButton("Actualizar");
	      updatePlayerButton.setBounds(316, 492, 117, 35);
	      registerPanel.add(updatePlayerButton);
	      updatePlayerButton.addActionListener(this);  
	      updatePlayerButton.setFocusable(false);
	      updatePlayerButton.setBackground(Color.LIGHT_GRAY);
	      updatePlayerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	      updatePlayerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
   
	      deletePlayerButton = new JButton("Borrar");
	      deletePlayerButton.setBounds(507, 492, 117, 35);
	      registerPanel.add(deletePlayerButton);
	      deletePlayerButton.addActionListener(this);       
	      deletePlayerButton.setFocusable(false);
	      deletePlayerButton.setBackground(Color.LIGHT_GRAY);
	      deletePlayerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	      deletePlayerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	}
	
	private void initializePlayersTablePanel() {
		playerTablePanel = new JPanel();
	    playerTablePanel.setBounds(632, 59, 890, 754);
	    this.add(playerTablePanel);
	    playerTablePanel.setLayout(null);
	    
	    creatEmptyTable();
	    initializeComboBoxes();
	    
	    if (selectTeamComboBox.getSelectedItem() != null) {
	    	//populateTable(selectTeamComboBox.getSelectedIndex());
	    }
	    	     
	     playerListLabel = new JLabel("Lista de jugadores");
	     playerListLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	     playerListLabel.setBounds(350, 10, 316, 68);
	     playerTablePanel.add(playerListLabel);
	     
	     selectTeamLabel = new JLabel("Equipo");
	     selectTeamLabel.setBounds(113, 120, 45, 13);
	     playerTablePanel.add(selectTeamLabel);
	     
	     selectSeasonPanel = new JLabel("Temporada");
	     selectSeasonPanel.setBounds(499, 120, 78, 13);
	     playerTablePanel.add(selectSeasonPanel);      
	}
	
	
	private void creatEmptyTable() {
		columnas = new Vector<String>();
		columnas.add("Nombre");
		columnas.add("Foto");
		columnas.add("Equipo");
		columnas.add("Nacionalidad");
		columnas.add("Nacemiento");
    
		datosTabla = new Vector<Vector<Object>>();
	
       model = new DefaultTableModel(datosTabla, columnas) {
       	private static final long serialVersionUID = -7029166140539557671L;

       	 /**
            * Determina si una celda específica en la tabla es editable.
            * @param row indice de fila de la celda.
            * @param column indice de columna de la celda.
            * @return false para indicar que la celda no es editable.
            */
			@Override
       	public boolean isCellEditable(int row, int column) {
       		return false;
       	}
       };
       
       table = new JTable(model);
       table.setRowSelectionAllowed(true);
       table.setEnabled(true);
       
       

	
       ListSelectionModel selectionModel = table.getSelectionModel();
       selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
       table.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
       tableHeader = table.getTableHeader();
       table.getTableHeader().setFont(new Font(null, 20, 20));
       table.getTableHeader().setBackground(Color.LIGHT_GRAY);
       
       
		headerSize = tableHeader.getPreferredSize();
		headerSize.height = 50; 
		tableHeader.setPreferredSize(headerSize);
		tableHeader.setReorderingAllowed(false);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);
		table.setRowHeight(40);
		table.setFont(new Font(null, 20, 20));
		
		 scrollPane = new JScrollPane(table);
	     scrollPane.setBounds(113, 181, 695, 498);
	     playerTablePanel.add(scrollPane);
	     
	     updateFields();
	}
	
	private void initializeNationality()  {	
        DefaultComboBoxModel<Nationality> nationalityDefaultComboBox = new DefaultComboBoxModel<>();
        Nationality[] playersNationality = Nationality.values();
		
        for (int i = 0; i < playersNationality.length - 1; i++) {
        	nationalityDefaultComboBox.addElement(playersNationality[i]);
        }
        
        nationalityComboBox = new JComboBox<>(nationalityDefaultComboBox);
        nationalityComboBox.setBounds(428, 271, 200, 25);
        nationalityComboBox.setFocusable(false);
        nationalityComboBox.setBackground(Color.LIGHT_GRAY);
        nationalityComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));   
        nationalityComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        registerPanel.add(nationalityComboBox);
	}
	
	private void initializeBirthDay() {
        int lastMonth = 12;
        int lastDay = 31;
        int lastYear = 2024;
        
        yearDefaultComboBox = new DefaultComboBoxModel<>();
        monthDefaultComboBox = new DefaultComboBoxModel<>();
        dayDefaultComboBox = new DefaultComboBoxModel<>();
        

        
        for (int startYear = 1900; startYear <= lastYear; startYear++) {
        	yearDefaultComboBox.addElement(startYear);      	  
        }
        
        for (int startMonth = 1; startMonth <= lastMonth; startMonth++) {
        	monthDefaultComboBox.addElement(startMonth);      	  
        }
        
        for (int startDay = 1; startDay <= lastDay; startDay++) {     
        	dayDefaultComboBox.addElement(startDay);      	  
        }
		
        playerBirthDayComboBox = new JComboBox<>(dayDefaultComboBox);
        playerBirthDayComboBox.setBounds(428, 207, 50, 25);
        registerPanel.add(playerBirthDayComboBox);
        playerBirthDayComboBox.setFocusable(false);
        playerBirthDayComboBox.setBackground(Color.LIGHT_GRAY);
        playerBirthDayComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playerBirthDayComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        playerBirthMonthComboBox = new JComboBox<>(monthDefaultComboBox);
        playerBirthMonthComboBox.setBounds(478, 207, 50, 25);
        registerPanel.add(playerBirthMonthComboBox);
        playerBirthMonthComboBox.setFocusable(false);
        playerBirthMonthComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playerBirthMonthComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      
        playerBirthYearComboBox = new JComboBox<>(yearDefaultComboBox);
        playerBirthYearComboBox.setBounds(528, 207, 100, 25);
        registerPanel.add(playerBirthYearComboBox);
        playerBirthYearComboBox.setFocusable(false);
        playerBirthYearComboBox.setBackground(Color.LIGHT_GRAY);
        playerBirthYearComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playerBirthYearComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
	}
	
	private void initializeComboBoxes() {
		
		refreshTeamsComboBoxModel();
		
		selectTeamComboBox = new JComboBox<>(teamsComboBoxModel);
		selectTeamComboBox.addActionListener(this); 
	    selectTeamComboBox.setBounds(185, 114, 200, 25);
	    selectTeamComboBox.setFocusable(false);
	    selectTeamComboBox.setBackground(Color.LIGHT_GRAY);
	    selectTeamComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    selectTeamComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    playerTablePanel.add(selectTeamComboBox);

        teamComboBox = new JComboBox<>(teamsComboBoxModelForPlayerRegister);
        teamComboBox.addActionListener(this); 
        teamComboBox.setBounds(428, 339, 200, 25);
        teamComboBox.setFocusable(false);
        teamComboBox.setBackground(Color.LIGHT_GRAY);
        teamComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        teamComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        registerPanel.add(teamComboBox);
           
        teamComboBox.setSelectedIndex(teamComboBox.getItemCount() - 1); 
    	selectTeamComboBox.setSelectedIndex(selectTeamComboBox.getItemCount() - 1);
    	
		seasonsComboBoxModel = new DefaultComboBoxModel<>();
		
		
		for (Season season : seasons)  {
			seasonsComboBoxModel.addElement(season);
		}
		
	     selectSeasonComboBox = new JComboBox<>(seasonsComboBoxModel);
	     selectSeasonComboBox.setSelectedIndex(selectSeasonComboBox.getItemCount() - 1);	
	     selectSeasonComboBox.setBounds(608, 116, 200, 25);
	     selectSeasonComboBox.setFocusable(false);
	     selectSeasonComboBox.setBackground(Color.LIGHT_GRAY);
	     selectSeasonComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
	     selectSeasonComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
	     playerTablePanel.add(selectSeasonComboBox);  
	}
	
	public void refreshTeamsComboBoxModel() {		
		teamsComboBoxModel = new DefaultComboBoxModel<>();
		teamsComboBoxModelForPlayerRegister = new DefaultComboBoxModel<>();
		for (Team team : allTeams) {
			teamsComboBoxModel.addElement(team);
			teamsComboBoxModelForPlayerRegister.addElement(team);			
		}
		
	}
	
	private void populateTable(Team team) {
  
	    datosTabla.clear(); // Clear existing data
	    
	    	 ArrayList<Jugador> jugadores = team.getJugadores();
	 	    
	 	    for (Jugador jugador : jugadores) {
	 	        Vector<Object> fila = new Vector<>();
	 	        fila.add(jugador.getNombre());
	 	        fila.add(jugador.getFotoPersonal());
	 	        fila.add(jugador.getEquipo().getName());
	 	        fila.add(jugador.getNationality());
	 	        fila.add(jugador.getFechaDeNacemiento());
	 	        datosTabla.add(fila);
	 	    }
	   
	    // Update the existing model with the new data
	    model.setDataVector(datosTabla, columnas);
	    table.setModel(model);
	    
	       int columnIndex = 1; 

	      	table.getColumnModel().getColumn(columnIndex).setCellRenderer(new DefaultTableCellRenderer() {
	      	    private static final long serialVersionUID = -2661844236545326544L;

	      	    @Override
	      	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	      	        if (value instanceof ImageIcon) {
	      	            ImageIcon logo = (ImageIcon) value;
	      	            JLabel label = new JLabel(logo);
	      	            label.setOpaque(true);
	      	            label.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
	      	            label.setFont(new Font(null, Font.PLAIN, 12)); 
	      	            return label;
	      	        }
	      	        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	      	    }
	      	});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == creatPlayerButton  ) {
			 
			 Team team = (Team) teamComboBox.getSelectedItem();
			 String playerName = nameTextField.getText();
			 
			 if (!playerName.isEmpty()) {
				 
				 if (team != null) {

					 Nationality playerNationality = (Nationality) nationalityComboBox.getSelectedItem();
					 ImageIcon personalImage  = (ImageIcon) fotoPersonalPreviewLable.getIcon();			 			 
					 int day = (int) playerBirthDayComboBox.getSelectedItem();		 
					 int month = (int) playerBirthMonthComboBox.getSelectedItem();
					 int year = (int) playerBirthYearComboBox.getSelectedItem();
			     
					 Fecha fechaDeNacemiento = new Fecha(day, month, year);	 
					 Jugador player = new Jugador(playerName, personalImage, team, fechaDeNacemiento, playerNationality);
					 team.addJugador(player);
				 	selectTeamComboBox.setSelectedItem(team);
				 } else {
					JOptionPane.showMessageDialog(this, "No puedes añadir un jugador sin especificar un equipo; crea un equipo primero",  "Error al insertar un nuevo jugador", JOptionPane.WARNING_MESSAGE);
				 }
			 } else {
					JOptionPane.showMessageDialog(this, "El nombre del jugador no puede estar vacío",  "Error al insertar un nuevo jugador", JOptionPane.WARNING_MESSAGE);
			 }
			 
			 
		 } else if (e.getSource() == selectTeamComboBox) { 
			 
			 if (selectTeamComboBox.getSelectedItem() != null) {
				 populateTable((Team) selectTeamComboBox.getSelectedItem());
			 }
		 } else if (e.getSource() == fotoPersonalButton) {
			 
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(null);
	          
				FileNameExtensionFilter fileNameFilter = new FileNameExtensionFilter("Todas las imagenes", "png", "jpg", "jpeg");
				fileChooser.addChoosableFileFilter(fileNameFilter);
	              
				int fileChooserState = fileChooser.showSaveDialog(null);
				if (fileChooserState == JFileChooser.APPROVE_OPTION){
					imagePath = fileChooser.getSelectedFile().getAbsolutePath();
					fotoPersonalPreviewLable.setIcon(setIcon(imagePath, null));  	
				}
		 } else if (e.getSource() == updatePlayerButton) {
			 int selectedIndex = table.getSelectedRow();
		
				if (selectedIndex == -1) {
					JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para actualizar",  "Error al actualizar", JOptionPane.ERROR_MESSAGE);
			 
				} else {
					Team team = (Team) teamComboBox.getSelectedItem();
					team.getJugadores().get(selectedIndex).setNombre(nameTextField.getText());					
					team.getJugadores().get(selectedIndex).setEquipo(team);				
					team.getJugadores().get(selectedIndex).setNationality(( Nationality )nationalityComboBox.getSelectedItem());;
					team.getJugadores().get(selectedIndex).setFotoPersonal((ImageIcon) fotoPersonalPreviewLable.getIcon());
					
					int day = (int) playerBirthDayComboBox.getSelectedItem();		 
					 int month = (int) playerBirthMonthComboBox.getSelectedItem();
					 int year = (int) playerBirthYearComboBox.getSelectedItem();   
					 Fecha fechaDeNacemiento = new Fecha(day, month, year);	 		
					team.getJugadores().get(selectedIndex).setFechaDeNacemiento(fechaDeNacemiento);;

	
				 	selectTeamComboBox.setSelectedItem(team);
				}
		 } else if (e.getSource() == deletePlayerButton) {
			 int selectedIndex = table.getSelectedRow();
				
				if (selectedIndex == -1) {
					JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para borrar",  "Error al borrar", JOptionPane.ERROR_MESSAGE);
				} else {
					model.removeRow(selectedIndex);
					Team team = (Team) teamComboBox.getSelectedItem();
					team.getJugadores().remove(selectedIndex);
					resetFields();
				}
		 }
	}
	
	
	private void resetFields() {
		nameTextField.setText("");
		yearDefaultComboBox.setSelectedItem(1900);  
		monthDefaultComboBox.setSelectedItem(1) ;
	    dayDefaultComboBox.setSelectedItem(1);
	    nationalityComboBox.setSelectedItem("AFGANISTÁN");
	    teamComboBox.setSelectedItem(null);
	    fotoPersonalPreviewLable.setIcon(new ImageIcon(SportsDashboardPage.class.getResource("/images/escudoGenerico.png")));
	}
	
	
    private ImageIcon setIcon(String myImagePath, byte[] byteImage) {
    	if (myImagePath != null) {
    		icon = new ImageIcon(myImagePath);
    	} else {
    		icon = new ImageIcon(byteImage);
    	}
    	
    	Image tempOneImage = icon.getImage();
    	Image tempTwoImage = tempOneImage.getScaledInstance(fotoPersonalPreviewLable.getWidth(), fotoPersonalPreviewLable.getHeight(), Image.SCALE_SMOOTH);
    	icon = new ImageIcon(tempTwoImage);
    	
		return icon;  	
    }
	
	private void updateFields() {
		
		ListSelectionModel selectionModel = table.getSelectionModel();
		 selectionModel.addListSelectionListener(new ListSelectionListener() {	
				@Override
	         public void valueChanged(ListSelectionEvent e) {
					 if (!e.getValueIsAdjusting() && !selectionModel.isSelectionEmpty()) {
	                	
					int selectedRow = table.getSelectedRow();				
					
					Team team = (Team) selectTeamComboBox.getSelectedItem();
					String playername = team.getJugadores().get(selectedRow).getNombre();
					int playerBirthYear = team.getJugadores().get(selectedRow).getFechaDeNacemiento().getAño();
					int playerBirthMonth = team.getJugadores().get(selectedRow).getFechaDeNacemiento().getMes();
					int playerBirthDay = team.getJugadores().get(selectedRow).getFechaDeNacemiento().getDia();
					Nationality playernationality = team.getJugadores().get(selectedRow).getNationality();
					ImageIcon playerImage = team.getJugadores().get(selectedRow).getFotoPersonal();
					
					nameTextField.setText(playername);
					yearDefaultComboBox.setSelectedItem(playerBirthYear);  
					monthDefaultComboBox.setSelectedItem(playerBirthMonth) ;
				    dayDefaultComboBox.setSelectedItem(playerBirthDay);
				    nationalityComboBox.setSelectedItem(playernationality);
				    teamComboBox.setSelectedItem(team);
				    fotoPersonalPreviewLable.setIcon(playerImage);
				        	
				}
	         }
	     });
	}
}