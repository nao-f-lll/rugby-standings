package com.standings.ui.page.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.standings.model.Season;
import com.standings.model.Team;

public class SeasonsManagement extends JPanel implements ActionListener{
 
	private JLabel desendentTeamsLabel;	
    private JLabel AddSeasonTitle;
    private JLabel seasonLabel;
    private JButton creatSeasonButton;
    private String[] columns;
    private JPanel addSeasonPanel;
    private JComboBox<Integer> seasonYearsComboBox;
    private JLabel firstDescendentTeam;
    private JLabel secondDescendentTeam;
    private JLabel ascendentTeamsLabel;
    private JLabel firstAscendentTeam;
    private JLabel secondAescendentTeam;
    private DefaultTableModel model;
    private JTable table;
    private JTableHeader tableHeader;
    private Dimension headerSize;
    private JButton addRowButton;
    private JPanel modifySeasonPanel;
    private JScrollPane scrollPane;
    private JLabel modifySeasonTitle;
    private ArrayList<Season> seasons;
    private ArrayList<Team> allTeams;
    
    private static final long serialVersionUID = 413951360879373732L;

	public SeasonsManagement(ArrayList<Team> allTeams, ArrayList<Season> seasons) {
    	
		
			this.seasons = seasons;
			this.allTeams = allTeams;
		
		    addSeasonPanel = new JPanel();
		    addSeasonPanel.setBackground(new Color(255, 255, 255));
		    addSeasonPanel.setBounds(0, 59, 634, 754);
	        this.add(addSeasonPanel);
	        addSeasonPanel.setLayout(null);
	        
	        AddSeasonTitle = new JLabel("Crear una temporada nueva");
	        AddSeasonTitle.setBounds(163, 0, 316, 68);
	        addSeasonPanel.add(AddSeasonTitle);
	        AddSeasonTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
	        
	        seasonLabel = new JLabel("Temporada");
	        seasonLabel.setBounds(125, 78, 115, 68);
	        addSeasonPanel.add(seasonLabel);
	        seasonLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        
	        seasonYearsComboBox = new JComboBox<Integer>();
	        seasonYearsComboBox.setBounds(412, 96, 115, 29);
	        addSeasonPanel.add(seasonYearsComboBox);
	        seasonYearsComboBox.setBackground(Color.LIGHT_GRAY);
	        seasonYearsComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        
	        
	        addSeasonYearsToComboBox();
	        
	        desendentTeamsLabel = new JLabel("Equipos que descienden:");
	        desendentTeamsLabel.setBounds(125, 141, 233, 68);
	        addSeasonPanel.add(desendentTeamsLabel);
	        desendentTeamsLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        
	        firstDescendentTeam = new JLabel("All blacks");
	        firstDescendentTeam.setBounds(125, 214, 115, 68);
	        addSeasonPanel.add(firstDescendentTeam);
	        firstDescendentTeam.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        
	        secondDescendentTeam = new JLabel("Shamrock");
	        secondDescendentTeam.setBounds(125, 280, 115, 68);
	        addSeasonPanel.add(secondDescendentTeam);
	        secondDescendentTeam.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        
	        ascendentTeamsLabel = new JLabel("Equipos que ascienden:");
	        ascendentTeamsLabel.setBounds(125, 358, 219, 68);
	        addSeasonPanel.add(ascendentTeamsLabel);
	        ascendentTeamsLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        
	        firstAscendentTeam = new JLabel("Shamrock");
	        firstAscendentTeam.setBounds(125, 436, 115, 68);
	        addSeasonPanel.add(firstAscendentTeam);
	        firstAscendentTeam.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        
	        secondAescendentTeam = new JLabel("All blacks");
	        secondAescendentTeam.setBounds(125, 502, 115, 68);
	        addSeasonPanel.add(secondAescendentTeam);
	        secondAescendentTeam.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        
	        creatSeasonButton = new JButton("Crear Temporada");
	        creatSeasonButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        creatSeasonButton.setBounds(245, 595, 168, 49);
	        addSeasonPanel.add(creatSeasonButton);
	        creatSeasonButton.setFocusable(false);
	        creatSeasonButton.setBackground(Color.LIGHT_GRAY);
	        creatSeasonButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        
	        model = new DefaultTableModel();
	        table = new JTable(model);
	        
	        
	        
	        tableHeader = table.getTableHeader();
	        table.getTableHeader().setFont(new Font(null, 20, 20));
	        table.getTableHeader().setBackground(Color.LIGHT_GRAY);
	        
	        
			headerSize = tableHeader.getPreferredSize();
			headerSize.height = 50; 
			tableHeader.setPreferredSize(headerSize);
			tableHeader.setReorderingAllowed(false);

	       
	       
	        
	        modifySeasonPanel = new JPanel();
	        modifySeasonPanel.setBounds(632, 59, 890, 754);
	        this.add(modifySeasonPanel);
	        modifySeasonPanel.setLayout(null);
	        
	             
	            
	                        
	        scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(113, 125, 695, 498);
	        modifySeasonPanel.add(scrollPane);
	        
	        modifySeasonTitle = new JLabel("Modifica una temporada ");
	        modifySeasonTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
	        modifySeasonTitle.setBounds(300, 10, 316, 68);
	        modifySeasonPanel.add(modifySeasonTitle);
	        
	    	columns =	new String[] {
	         		"Temporada", "ID", "Año"};	
	    	for (String column : columns) {
	    	    model.addColumn(column);
	    	}
	    	
	    	addRowToTable( model);
	
	
	}
	
	private void addSeasonYearsToComboBox() {
		for (int i = 0; i < seasons.size(); i++) {
			seasonYearsComboBox.addItem(seasons.get(i).getYear());
		
			System.out.println("year is: " + seasons.get(i).getYear());
		}
		System.out.println("my size is: " + seasons.size());
		
		seasonYearsComboBox.addItem(seasonYearsComboBox.getItemAt(seasons.size() - 1) + 1);
		
	}
	
	private void addRowToTable(DefaultTableModel model) {
	    String[] newRowData = new String[columns.length]; // Assuming 'columns' is an array of column names

	    for (int i = 0; i < seasons.size(); i++) {
	        Season season = seasons.get(i);
	        for (int j = 0; j < columns.length; i++) {
	            // Set specific values for each column
	            if (i == 0) {
	                newRowData[j] = "1";
	            } else if (i == 1) {
	                newRowData[j] = "3";
	            } else {
	                // Handle additional columns if needed
	                newRowData[j] = String.valueOf(season.getYear()) ;
	            }
	        }
	    }

	    model.addRow(newRowData);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
