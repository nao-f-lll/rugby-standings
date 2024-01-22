package com.standings.ui.page.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.standings.model.RugbyTeamsNames;
import com.standings.model.Season;
import com.standings.model.Team;
import com.standings.util.StandingsCalculation;

public class StandingsPanel extends JPanel  {
   

	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private ArrayList<Team> teams;
	private RugbyTeamsNames[] rugbyTeamsNames;
	private Object[][] rows;
	private String[] columns;
	private Season season;
	private ArrayList<Season> seasons;
	private JButton printPdfButton;
	private JButton printXmlButton;


		public StandingsPanel( Season season, ArrayList<Season> seasons) {
	    	
			initializeFrameGraphics();
            this.season = season;
            this.seasons = seasons;		
			initializeTeams();
			initializeTabel();
	
	}	
		private void initializeFrameGraphics() {
			
            table = new JTable();
            table.setEnabled(false);
            table.setFont(new Font("Tahoma", Font.PLAIN, 20));
            table.setBackground(new Color(255, 255, 255));
            initializeButtons();
            
            
		}
		
		private void initializeButtons() {
			  printPdfButton = new JButton("Exportar PDF");
			  printPdfButton.setBounds(810, 720, 150, 40);
			  printPdfButton.setBackground(Color.lightGray);
			  printPdfButton.setFocusable(false);
			  printPdfButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			  add(printPdfButton);
			  
			  printXmlButton = new JButton("Exportar XML");
			  printXmlButton.setBounds(550, 720, 150, 40);
			  printXmlButton.setBackground(Color.lightGray);
			  printXmlButton.setFocusable(false);
			  printXmlButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			  add(printXmlButton);
		}
		
		//REQUIRES: icons must have six objects
		//MODIFIES: Team
		//EFFECTS:  assign to every team, it's icon
		
		private void initializeTeams( ) {
			
			this.teams = season.getTeams();
			
			rugbyTeamsNames = RugbyTeamsNames.values();
			int logoIndex = 0;
			
			for (RugbyTeamsNames rugbyTeam : rugbyTeamsNames) {
				Team team = new Team(rugbyTeam.name());
				this.teams.add(team);
			   logoIndex++;
	    	}
		}
		
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


					 
					/// use this only when creating anew season ////
					//new StandingsCalculation(this.season, this.seasons);
					renderUpdatedStandings();


					JScrollPane scrollPane = new JScrollPane(table);
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
		
		
		//MODIFIES: this
		//EFFECTS:  render the standings table, based on the updated data.
		
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
}