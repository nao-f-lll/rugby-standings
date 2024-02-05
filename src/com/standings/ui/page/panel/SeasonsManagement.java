package com.standings.ui.page.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.standings.model.Game;
import com.standings.model.Season;
import com.standings.model.Team;
import com.standings.model.Week;
import com.standings.ui.page.SportsDashboardPage;
import com.standings.util.UserDialogUtil;

public class SeasonsManagement extends JPanel implements ActionListener{
 
    private DefaultTableModel model;
    private JTable table;
    private JTableHeader tableHeader;
    private Dimension headerSize;
    private JPanel modifySeasonPanel;
    private JScrollPane scrollPane;
    private JLabel modifySeasonTitle;
    private ArrayList<Season> seasons;
    private ArrayList<Team> allTeams;
	private JLabel allTeamsLabel;	
    private JLabel AddSeasonTitle;
    private JLabel seasonLabel;
    private JButton creatSeasonButton;
    private String[] columns;
    private JPanel addSeasonPanel;
    private JLabel seasonYearsLabel;
    private JList<String> listOne;
    private JList<String> listTwo;
    private DefaultListModel<String> listOneModel;
    private static final long serialVersionUID = 413951360879373732L;
    private DefaultListModel<String> listTwoModel;
    private JButton addOneTeamButton;
    private  JButton removeOneTeamButton;
    private JButton endSeasonButton;
    private JLabel newSeasonteams;
    private String[] newSeasonTeamsNames;
    private UpdateDataPanel updateDataPanel;
    private StandingsPanel standingsPanel;
    private ScoresPanel scoresPanel;
    private ListSelectionModel selectionModel;
    private JButton goToUpdateDataButton;
    private JButton goToScoresButton;
    private JButton goToStandingButton;
    private final String[] allTeamsNames = {"AllBlacks", "Shamrock", "Wallabies", "RedRose", "Feathers", "Thistle", "Springboks", "Sakuras"};       
;
    
    
	public SeasonsManagement(UpdateDataPanel updateDataPanel, JButton goToUpdateDataButton,JButton goToScoresButton  ,JButton goToStandingButton, ArrayList<Team> allTeams, ArrayList<Season> seasons, StandingsPanel standingsPanel, ScoresPanel scoresPanel) {
    	
		
			this.updateDataPanel = updateDataPanel;
			this.seasons = seasons;
			this.allTeams = allTeams;
			this.standingsPanel = standingsPanel;
			this.scoresPanel = scoresPanel;
			this.goToUpdateDataButton = goToUpdateDataButton;
			this.goToScoresButton = goToScoresButton;
			this.goToStandingButton = goToStandingButton;

			
		    addSeasonPanel = new JPanel();
		    addSeasonPanel.setBackground(new Color(255, 255, 255));
		    addSeasonPanel.setBounds(0, 59, 634, 754);
	        this.add(addSeasonPanel);
	        addSeasonPanel.setLayout(null);
	        
	        
	        

		       allTeamsLabel = new JLabel("Equipos no selecionados");
		       allTeamsLabel.setBounds(82, 142, 233, 68);
		       addSeasonPanel.add(allTeamsLabel);
		       allTeamsLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		       
		      
		       
		       listOneModel = new DefaultListModel<>();
		       listOne = new JList<String>();
		       listOne.setValueIsAdjusting(true);
		       listOne.setFont(new Font("Dialog", Font.BOLD, 15));
		       listOne.setBorder(new LineBorder(new Color(0, 0, 0)));
		       listOne.setBounds(67, 218, 187, 220);
		       addSeasonPanel.add(listOne);
		       listOne.setCursor(new Cursor(Cursor.HAND_CURSOR));
		       listOne.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		       
		       listTwoModel = new DefaultListModel<>();
		       listTwo = new JList<String>();
		       listTwo.setFont(new Font("Dialog", Font.BOLD, 15));
		       listTwo.setBorder(new LineBorder(new Color(0, 0, 0)));
		       listTwo.setBounds(417, 218, 187, 220);
		       addSeasonPanel.add(listTwo);
		       listTwo.setModel(listTwoModel);
		       listTwo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		       listTwo.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		       
		       fillListOne();		       
		       
		       listOne.setModel(listOneModel);
		       
		       addOneTeamButton = new JButton(">");
		       addOneTeamButton.setFont(new Font("Dialog", Font.BOLD, 20));
		       addOneTeamButton.setBounds(276, 270, 117, 30);
		       addOneTeamButton.setBackground(Color.LIGHT_GRAY);
		       addSeasonPanel.add(addOneTeamButton);
		       addOneTeamButton.addActionListener(this);
		       addOneTeamButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		       

		       
		       removeOneTeamButton = new JButton("<");
		       removeOneTeamButton.setFont(new Font("Dialog", Font.BOLD, 20));
		       removeOneTeamButton.setBounds(276, 346, 117, 30);
		       addSeasonPanel.add(removeOneTeamButton);
		       removeOneTeamButton.setBackground(Color.LIGHT_GRAY);
		       removeOneTeamButton.addActionListener(this);
		       removeOneTeamButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		       

		       
		       newSeasonteams = new JLabel("Equipos selecionados");
		       newSeasonteams.setFont(new Font("Dialog", Font.PLAIN, 17));
		       newSeasonteams.setBounds(425, 142, 233, 68);
		       addSeasonPanel.add(newSeasonteams);
	        
	        AddSeasonTitle = new JLabel("Crear una temporada nueva");
	        AddSeasonTitle.setBounds(163, 0, 316, 68);
	        addSeasonPanel.add(AddSeasonTitle);
	        AddSeasonTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
	        
	        seasonLabel = new JLabel("Temporada");
	        seasonLabel.setBounds(125, 78, 115, 68);
	        addSeasonPanel.add(seasonLabel);
	        seasonLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        
	        seasonYearsLabel = new JLabel();
	        seasonYearsLabel.setBounds(450, 96, 115, 29);
	        addSeasonPanel.add(seasonYearsLabel);
	        seasonYearsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

	        	        
	        addSeasonYearsToComboBox();
	        

	        creatSeasonButton = new JButton("Crear Temporada");
	        creatSeasonButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        creatSeasonButton.setBounds(245, 470, 168, 49);
	        addSeasonPanel.add(creatSeasonButton);
	        creatSeasonButton.setFocusable(false);
	        creatSeasonButton.setBackground(Color.LIGHT_GRAY);
	        creatSeasonButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        creatSeasonButton.addActionListener(this);
	        
	        
	        
	        
	        columns =	new String[] {
	         		"ID", "Año", "Estado"};	
	        model = new DefaultTableModel(columns, 0) {
	        	private static final long serialVersionUID = -7029166140539557670L;

				@Override
	        	public boolean isCellEditable(int row, int column) {
	        		return false;
	        	}
	        };
	        
	        table = new JTable(model);
	        table.setRowSelectionAllowed(true);
	        table.setEnabled(true);
	        
	        selectionModel = table.getSelectionModel();
	        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	        table.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        
	        
	        handleTableSelection();
	   

	           
	        
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
	       
	       
	        
	        modifySeasonPanel = new JPanel();
	        modifySeasonPanel.setBounds(632, 59, 890, 754);
	        this.add(modifySeasonPanel);
	        modifySeasonPanel.setLayout(null);
	        
	             
	            
	                        
	        scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(113, 125, 695, 498);
	        modifySeasonPanel.add(scrollPane);
	        
	        modifySeasonTitle = new JLabel("Lista de temporadas");
	        modifySeasonTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
	        modifySeasonTitle.setBounds(350, 10, 316, 68);
	        modifySeasonPanel.add(modifySeasonTitle);
	        
	        
	        endSeasonButton = new JButton("Finalizar Temporada");
	        endSeasonButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        endSeasonButton.setBounds(380, 650, 180, 49);
	        endSeasonButton.setFocusable(false);
	        endSeasonButton.setBackground(Color.LIGHT_GRAY);
	        endSeasonButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        endSeasonButton.addActionListener(this);
	        modifySeasonPanel.add(endSeasonButton);
	        
	    	
	    	addRowToTable(true);
	
	
	}
	
	private void handleTableSelection() {
	     selectionModel.addListSelectionListener(new ListSelectionListener() {
	            
				
					@Override
		            public void valueChanged(ListSelectionEvent e) {
		                if (!e.getValueIsAdjusting() && !selectionModel.isSelectionEmpty()) {
		                	 int selectedRow = table.getSelectedRow();
			                    Season season = seasons.get(selectedRow);
		                	if (!season.getState().equals("proximamente")) {
		                		 standingsPanel.renderUpdatedStandings(season.getTeams(), season);
		 	                    scoresPanel.renderAllWeeksScores(season);
		 	        	        updateDataPanel.updateData(season.getTeams(), season.getGames(), season);
		 	        	        listTwoModel.clear();
		 	        	       listOneModel.clear();
		 	        	        for (int i = 0; i < season.getTeams().size(); i++) {	
		 	        	        	listTwoModel.addElement(season.getTeams().get(i).getName());
		 	        	        }
		 	        	        
		 	        	       String[] tempTeamsNames = new String[6];
		 	        	        for (int i = 0; i < season.getTeams().size(); i++) {
		 	        	        	tempTeamsNames[i] = season.getTeams().get(i).getName();
		 	        	        }
		 	        	        
		 	        	       
		 	        	       for (int i = 0; i < allTeamsNames.length; i++) {
		 	        	    	    if (!Arrays.asList(tempTeamsNames).contains(allTeamsNames[i])) {
		 	        	    	        listOneModel.addElement(allTeamsNames[i]);
		 	        	    	    }
		 	        	    	}

		 	        	        
		 	        	       if (season.getState().equals("finalizada")) {
			                        goToUpdateDataButton.setEnabled(false);
			                    	goToScoresButton.setEnabled(true);
			                    	goToStandingButton.setEnabled(true);
			                    	creatSeasonButton.setEnabled(false);
			                    	endSeasonButton.setEnabled(false);
			                    	listOne.setEnabled(false);
			                    	listTwo.setEnabled(false);
			                    	
			                    	addOneTeamButton.setEnabled(false);
			                    	removeOneTeamButton.setEnabled(false);
			                    	newSeasonTeamsNames = new String[6];
			 	        	        for (int i = 0; i < season.getTeams().size(); i++) {
			 	        	        	newSeasonTeamsNames[i] = seasons.get(seasons.size() - 2).getTeams().get(i).getName();
			 	        	        }
			                    }
			        	        
			        	        if (season.getState().equals("actual")){
			                        goToUpdateDataButton.setEnabled(true);
			                    	goToScoresButton.setEnabled(true);
			                    	goToStandingButton.setEnabled(true);
			                    	creatSeasonButton.setEnabled(false);
			                    	endSeasonButton.setEnabled(true);
			                    	listOne.setEnabled(false);
			                    	listTwo.setEnabled(false);

			                    	addOneTeamButton.setEnabled(false);
			                    	removeOneTeamButton.setEnabled(false);
			                    	
				 	        	       newSeasonTeamsNames = new String[6];
				 	        	        for (int i = 0; i < season.getTeams().size(); i++) {
				 	        	        	newSeasonTeamsNames[i] = season.getTeams().get(i).getName();
				 	        	        }
			                    	
			                    }
		                	} else {
		                		goToScoresButton.setEnabled(false);
		                    	goToStandingButton.setEnabled(false);
		                    	 goToUpdateDataButton.setEnabled(false);
		                    	 
		                    	 creatSeasonButton.setEnabled(true);
			                    	endSeasonButton.setEnabled(false);

			                    	addOneTeamButton.setEnabled(true);
			                    	removeOneTeamButton.setEnabled(true);
			                    	listOne.setEnabled(true);
			                    	listTwo.setEnabled(true);
		                    	
		                    	 listTwoModel.clear();
		                    	 listOneModel.clear();
			 	        	     for (int i = 0; i < allTeamsNames.length; i++) {
			 	        	    	 if (!Arrays.asList(newSeasonTeamsNames).contains(allTeamsNames[i])) {
			 	        	    	        listTwoModel.addElement(allTeamsNames[i]);
			 	        	    	    } else {
			 	        	    	    	listOneModel.addElement(allTeamsNames[i]);
			 	        	    	    }
			 	        	     }
		                	}
		               
		                }
		            }
		        });
	}
	
	private void addSeasonYearsToComboBox() {	
		seasonYearsLabel.setText(String.valueOf(seasons.get((seasons.size() - 1)).getYear() + 1 ));
	}
	
	
	
	
	private void addRowToTable(boolean isLastOneSelected) {
		int selectedRow = table.getSelectedRow();
		model.setRowCount(0);
		for (int i = 0; i < seasons.size(); i++) {
			Season season = seasons.get(i);
			this.model.addRow(
	                new Object[]{
	                	season.getId(),
	                	season.getYear(),
	                	season.getState()
	                }
	           );
		}
		if (isLastOneSelected) {
			int lastRowIndex = table.getRowCount() - 2;
			table.changeSelection(lastRowIndex, 0, false, false);
		} else {	
			table.changeSelection(selectedRow, 0, false, false);
		}
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == creatSeasonButton) {
			 creatNewSeason();
		} else if (e.getSource() == addOneTeamButton) {
			addTeam(listOne, listOneModel, listTwoModel);
		} else if (e.getSource() == removeOneTeamButton) {
			addTeam(listTwo, listTwoModel, listOneModel);
		} else if (e.getSource() == endSeasonButton) {
			endSeason();
		}
	}
		
	private void endSeason() {

	    int selectedRow = table.getSelectedRow();
	    Season season = seasons.get(selectedRow);

	    if (season.getState().equals("actual")) {

	        int result = userDialogOkCancel("¿Estas seguro de que quieres finalizar la temporada?", "Finalizar temporada", JOptionPane.WARNING_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {
	            season.setState("finalizada");
	            addRowToTable(false);
	            SportsDashboardPage.setHasSeasonDataChanged(true);
	        }
	    }
	}

	
	private int userDialogOkCancel(String dialogText, String dialogTitle, int messageType) {
	    JOptionPane optionPane = new JOptionPane(dialogText, JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
	    Object[] options = {"Aceptar", "Cancelar"};
	    optionPane.setOptions(options);
	    JDialog dialog = optionPane.createDialog(this, dialogTitle);
	    dialog.setVisible(true);
	    Object selectedValue = optionPane.getValue();
	    return (selectedValue.equals("Aceptar")) ? JOptionPane.OK_OPTION : JOptionPane.CANCEL_OPTION;
	}

	private void addTeam(JList<String> moveFromThisList, DefaultListModel<String> moveFromThisListModel, DefaultListModel<String> moveToThisListModel) {
		
		List<String> selectedvalues = moveFromThisList.getSelectedValuesList();
		
		if (moveFromThisList.getSelectedIndex() == -1) {
			UserDialogUtil.userDialog("Ningun Equipo esta selecionado, seleciona uno", "Error Al añadir equipo", JOptionPane.WARNING_MESSAGE);
		} else if ((listTwoModel.size() > 5 || selectedvalues.size() > 4) && moveToThisListModel == listTwoModel) {
			UserDialogUtil.userDialog("No se puede añadir mas que seis equipos", "Error Al añadir equipo", JOptionPane.WARNING_MESSAGE);

		} else {
			
			String[] selectedValuesArray = selectedvalues.toArray(new String[0]);

			for (int i = 0; i < selectedValuesArray.length; i++) {
				moveToThisListModel.addElement(selectedValuesArray[i]);
				
				if (moveFromThisListModel.getSize() != 0) {
					moveFromThisListModel.removeElement(selectedValuesArray[i]);				}
			}

		}
	}

	private void fillListOne() {
		listOneModel.removeAllElements(); 
		 for (int i = 0; i < allTeamsNames.length; i++) {
	    	   listOneModel.addElement(allTeamsNames[i]);
	       }
	}
	
	
	private void creatNewSeason() {
	
		if (listTwoModel.size() == 6) {
	
			seasons.remove(seasons.size() -1);
			
			for (int i = 0; i < seasons.size() - 1; i++) {
	    		if (seasons.get(i).getState().equals("actual")) {
	    			seasons.get(i).setState("finalizada");
	        		break;
	    		} else {
	    			
	    		}
	    	}
			
			newSeasonTeamsNames = new String[6];
			for (int i = 0; i < listTwoModel.size(); i++) {
				newSeasonTeamsNames[i] = listTwoModel.get(i);
			}
			ListSelectionModel selectionModel = table.getSelectionModel();
			selectionModel.clearSelection();
			ArrayList<Team> teams = new ArrayList<>();
			ArrayList<Game>  games = new ArrayList<>();
			ArrayList<Week>  weeks = new ArrayList<>();
			Season lastSeason = seasons.get(seasons.size() - 1);
	  	    lastSeason.setState("finalizada");
	        Season  newSeason = new Season(lastSeason.getId() + 1, lastSeason.getYear() + 1, "actual", weeks, teams, games);
	        seasons.add(newSeason);
	        boolean isNewSeason = true;
	        standingsPanel = new StandingsPanel(newSeason, seasons, allTeams, isNewSeason, newSeasonTeamsNames);
	        SportsDashboardPage.setHasSeasonDataChanged(true);
	        addRowToTable(true);  
	        addSeasonYearsToComboBox();
	        fillListOne();
	        listTwoModel.removeAllElements();

	        
			ArrayList<Team> futureTeams = new ArrayList<>();
			ArrayList<Game>  futureGames = new ArrayList<>();
			ArrayList<Week>  futureweeks = new ArrayList<>();
	        
	        Season futureSeason = new Season(newSeason.getId() + 1, newSeason.getYear() + 1, "proximamente", futureweeks,futureTeams,futureGames);
	        seasons.add(futureSeason);
	        addRowToTable(true); 
		} else {
			UserDialogUtil.userDialog("Tienes que selecionar seis equipos para crear una nueva temporada", "Creacion de temporada", JOptionPane.WARNING_MESSAGE);
		}  
	}
}