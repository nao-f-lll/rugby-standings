package com.standings.ui.page.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.standings.model.Fecha;
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
	private JTextField textField;
	private JButton creatTeamButton;
	private JButton updateTeamButton;
	private JButton deleteTeamButton;
	private JLabel lblNewLabel;
	private  JLabel playerListLabel;
	private JLabel selectTeamLabel;
	private JLabel selectSeasonPanel;
	private JComboBox<Fecha> selectTeamComboBox;
	private JComboBox<Fecha> selectSeasonComboBox;
	private JPanel playerTablePanel;
    
    
	
	public PlayersPanel(JPanel panelButton, ArrayList<Team> allTeams) {
		this.panelButton = panelButton;
		
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
	      
	      
	      lblNewLabel = new JLabel("Crear un nuevo jugador");
	      lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	      lblNewLabel.setBounds(168, 0, 316, 68);
	      registerPanel.add(lblNewLabel);
	      
	      fotoPersonalPreviewLable = new JLabel();
	      fotoPersonalPreviewLable.setHorizontalAlignment(SwingConstants.CENTER);
	      fotoPersonalPreviewLable.setBounds(70, 137, 45, 13);
	      registerPanel.add(fotoPersonalPreviewLable);
	      fotoPersonalPreviewLable.setBounds(50, 129, 167, 103);
	      fotoPersonalPreviewLable.setIcon(new ImageIcon(SportsDashboardPage.class.getResource("/images/escudoGenerico.png")));
	      
	      JButton fotoPersonalButton = new JButton("Selecionar Foto");
	        fotoPersonalButton.setBounds(50, 256, 155, 25);
	        registerPanel.add(fotoPersonalButton);
	        
	        playerNameLabel = new JLabel("Nombre ");
	        playerNameLabel.setBounds(289, 158, 70, 15);
	        registerPanel.add(playerNameLabel);
	        
	        textField = new JTextField();
	        textField.setBounds(428, 153, 200, 25);
	        registerPanel.add(textField);
	        textField.setColumns(10);
	        
	        JLabel playerBirthdayLabel = new JLabel("Fecha de nacemiento");
	        playerBirthdayLabel.setBounds(289, 217, 129, 15);
	        registerPanel.add(playerBirthdayLabel);
	        
	        JComboBox<Fecha> playerBirthDayComboBox = new JComboBox<>();
	        playerBirthDayComboBox.setBounds(428, 207, 200, 25);
	        registerPanel.add(playerBirthDayComboBox);
	        
	        JLabel playerNationalityLabel = new JLabel("Nacionalidad");
	        playerNationalityLabel.setBounds(289, 276, 84, 15);
	        registerPanel.add(playerNationalityLabel);
	        
	        JComboBox<?> NationalityComboBox = new JComboBox<Object>();
	        NationalityComboBox.setBounds(428, 271, 200, 25);
	        registerPanel.add(NationalityComboBox);
	        
	        JLabel teamLabel = new JLabel("Equipo");
	        teamLabel.setBounds(289, 344, 84, 15);
	        registerPanel.add(teamLabel);
	        
	        JComboBox<Team> teamComboBox = new JComboBox<>();
	        teamComboBox.setBounds(428, 339, 200, 25);
	        registerPanel.add(teamComboBox);
	        
	        creatTeamButton = new JButton("Crear");
	        creatTeamButton.setBounds(100, 492, 117, 35);
	        registerPanel.add(creatTeamButton);
	        creatTeamButton.addActionListener(this); 
	        creatTeamButton.setFocusable(false);
	        creatTeamButton.setBackground(Color.LIGHT_GRAY);
	        creatTeamButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        creatTeamButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

	        
	        
	        updateTeamButton = new JButton("Actualizar");
	        updateTeamButton.setBounds(316, 492, 117, 35);
	        registerPanel.add(updateTeamButton);
	        updateTeamButton.addActionListener(this);  
	        updateTeamButton.setFocusable(false);
	        updateTeamButton.setBackground(Color.LIGHT_GRAY);
	        updateTeamButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        updateTeamButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
   
	        deleteTeamButton = new JButton("Borrar");
	        deleteTeamButton.setBounds(507, 492, 117, 35);
	        registerPanel.add(deleteTeamButton);
	        deleteTeamButton.addActionListener(this);       
	        deleteTeamButton.setFocusable(false);
	        deleteTeamButton.setBackground(Color.LIGHT_GRAY);
	        deleteTeamButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        deleteTeamButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	}
	
	private void initializePlayersTablePanel() {
		playerTablePanel = new JPanel();
	    playerTablePanel.setBounds(632, 59, 890, 754);
	    this.add(playerTablePanel);
	    playerTablePanel.setLayout(null);
	    
		createTable();
	     
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
	     
	     selectTeamComboBox = new JComboBox<>();
	     selectTeamComboBox.setBounds(185, 114, 200, 25);
	     playerTablePanel.add(selectTeamComboBox);
	     
	     selectSeasonComboBox = new JComboBox<>();
	     selectSeasonComboBox.setBounds(608, 116, 200, 25);
	     playerTablePanel.add(selectSeasonComboBox);
	     
	}
	
	private void createTable() {

   	 Vector<String> columnas;
   	 Vector<Vector<Object>> datosTabla;
   	 JTable table;
   	 JTableHeader tableHeader;
   	 Dimension headerSize;
   	 JScrollPane scrollPane;;
   	 DefaultTableModel model;
       

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
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
