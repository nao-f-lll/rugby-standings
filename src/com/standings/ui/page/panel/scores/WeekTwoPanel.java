package com.standings.ui.page.panel.scores;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.standings.model.Game;
import com.standings.model.Season;
import com.standings.model.Week;
import com.standings.model.design.CustomBorder;
import com.standings.util.FileIO;
import com.standings.util.UserDialogUtil;

public class WeekTwoPanel extends JPanel implements ActionListener{



	/**
	 * 
	 */
	private static final long serialVersionUID = -304933483533019200L;
	private JLabel firstLocalTeamName;
	private JLabel firstLocalTeamPoint;
	
	private JLabel firstVisitorTeamName;
	private JLabel firstVisitorTeamPoint;
	
	private JLabel secondLocalTeamName;
	private JLabel secondLocalTeamPoint;
	
	private JLabel secondVisitorTeamName;
	private JLabel secondVisitorTeamPoint;
	
	private JLabel thirdLocalTeamName;
	private JLabel thirdLocalTeamPoint;
	
	private JLabel thirdVisitorTeamName;
	private JLabel thirdVisitorTeamPoint;
	
	private Season season;
	private ArrayList<Game> games;
	private ArrayList<Week> weeks;
	private FileIO<Season> fileIO;
	


	
	
	final int  GAME_ONE = 3;
	final int  GAME_TWO = 4;
	final int  GAME_THREE = 5;
	private JPanel gameThreePanel;
	private JPanel gameTwoPanel;
	private JPanel gameOnePanel;
	private JButton exoportXMLButton;
	

	public WeekTwoPanel(Season season) {
		
		   	this.setBounds(0, 115, 1525, 845);
		   	this.setLayout(null);
			this.season = season;
		   	this.games  = season.getGames();
		   	this.weeks = season.getWeeks();
		       
		    gameOnePanel = new JPanel();
		       gameOnePanel.setBackground(Color.LIGHT_GRAY);
		       gameOnePanel.setBounds(101, 44, 437, 266);
		       add(gameOnePanel);
		       gameOnePanel.setBorder(new CustomBorder(20));
		       gameOnePanel.setLayout(null);
		       
		              
		              
		       		
		       	       firstLocalTeamName = new JLabel("");
		       	       firstLocalTeamName.setBounds(53, 26, 159, 95);
		       	       gameOnePanel.add(firstLocalTeamName);
		       	       firstLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       	       
		       	             
		       	       
		       	       firstVisitorTeamName = new JLabel("");
		       	       firstVisitorTeamName.setBounds(53, 131, 159, 95);
		       	       gameOnePanel.add(firstVisitorTeamName);
		       	       firstVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       	       
		       	        
		       	        firstLocalTeamPoint = new JLabel("");
		       	        firstLocalTeamPoint.setBounds(281, 26, 58, 95);
		       	        gameOnePanel.add(firstLocalTeamPoint);
		       	        firstLocalTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       	        
		       
		       firstVisitorTeamPoint = new JLabel("");
		       firstVisitorTeamPoint.setBounds(281, 131, 58, 95);
		       gameOnePanel.add(firstVisitorTeamPoint);
		       firstVisitorTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       
		       gameThreePanel = new JPanel();
		       gameThreePanel.setBackground(Color.LIGHT_GRAY);
		       gameThreePanel.setBounds(758, 191, 443, 277);
		       gameThreePanel.setBorder(new CustomBorder(20));
		       add(gameThreePanel);
		       gameThreePanel.setLayout(null);
		       
		       
		       thirdLocalTeamName = new JLabel("");
		       thirdLocalTeamName.setBounds(64, 21, 159, 95);
		       gameThreePanel.add(thirdLocalTeamName);
		       thirdLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       
		       
		       thirdVisitorTeamName = new JLabel("");
		       thirdVisitorTeamName.setBounds(64, 141, 159, 95);
		       gameThreePanel.add(thirdVisitorTeamName);
		       thirdVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       
		 
		       
		       thirdLocalTeamPoint = new JLabel("");
		       thirdLocalTeamPoint.setBounds(310, 21, 58, 95);
		       gameThreePanel.add(thirdLocalTeamPoint);
		       thirdLocalTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       
		       
		  
		       
		       thirdVisitorTeamPoint = new JLabel("");
		       thirdVisitorTeamPoint.setBounds(310, 141, 58, 95);
		       gameThreePanel.add(thirdVisitorTeamPoint);
		       thirdVisitorTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       
		       gameTwoPanel = new JPanel();
		       gameTwoPanel.setBackground(Color.LIGHT_GRAY);
		       gameTwoPanel.setBounds(101, 379, 437, 267);
		       gameTwoPanel.setBorder(new CustomBorder(20));
		       add(gameTwoPanel);
		       gameTwoPanel.setLayout(null);
		       
		       
		       secondLocalTeamName = new JLabel("");
		       secondLocalTeamName.setBounds(45, 21, 172, 95);
		       gameTwoPanel.add(secondLocalTeamName);
		       secondLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       
		       
		       secondVisitorTeamName = new JLabel("");
		       secondVisitorTeamName.setBounds(45, 126, 178, 95);
		       gameTwoPanel.add(secondVisitorTeamName);
		       secondVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       
		          	       
		           secondLocalTeamPoint = new JLabel("");
		           secondLocalTeamPoint.setBounds(275, 21, 58, 95);
		           gameTwoPanel.add(secondLocalTeamPoint);
		           secondLocalTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
		           
		           
		           secondVisitorTeamPoint = new JLabel("");
		           secondVisitorTeamPoint.setBounds(275, 126, 58, 95);
		           gameTwoPanel.add(secondVisitorTeamPoint);
		           secondVisitorTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
		           
		           exoportXMLButton = new JButton("Exportar XML");
		           exoportXMLButton.setBounds(1338, 296, 150, 40);
		           exoportXMLButton.setBackground(Color.lightGray);
		           exoportXMLButton.setFocusable(false);
		           exoportXMLButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				   add(exoportXMLButton);
				   exoportXMLButton.addActionListener(this);

				    addGameInfo(this.season);
	       
	}
	
	


	//REQUIRES: objects mustn't be a null value.
	//MODIFIES: this
	//EFFECTS: set the team information each in its appropriate game.
	
	public void addGameInfo(Season season) {
        
		
	 	this.games  = season.getGames();
	   	this.weeks =  season.getWeeks();
	   	this.season = season;
		
	   	firstLocalTeamName.setText(games.get(GAME_ONE).getLocalTeam().getName());
		firstVisitorTeamName.setText(games.get(GAME_ONE).getVisitorTeam().getName());
		
		if (games.get(GAME_ONE).isActive()) {
			firstLocalTeamPoint.setText(String.valueOf(games.get(GAME_ONE).getLocalScore()));  
	        firstVisitorTeamPoint.setText(String.valueOf(games.get(GAME_ONE).getVisitorScore()));
		} else {
			firstLocalTeamPoint.setText("?");  
	        firstVisitorTeamPoint.setText("?");
		}
		
 
          secondLocalTeamName.setText(games.get(GAME_TWO).getLocalTeam().getName());
    	  secondVisitorTeamName.setText(games.get(GAME_TWO).getVisitorTeam().getName());

    	  if (games.get(GAME_TWO).isActive()) {
    		  secondLocalTeamPoint.setText(String.valueOf(games.get(GAME_TWO).getLocalScore()));
        	  secondVisitorTeamPoint.setText(String.valueOf(games.get(GAME_TWO).getVisitorScore()));
  		} else {
  			secondLocalTeamPoint.setText("?");  
  			secondVisitorTeamPoint.setText("?");
  		}

    	  
    	  thirdLocalTeamName.setText(games.get(GAME_THREE).getLocalTeam().getName());
    	  thirdVisitorTeamName.setText(games.get(GAME_THREE).getVisitorTeam().getName());
    	     	 
    	  if (games.get(GAME_THREE).isActive()) {  
        	  thirdLocalTeamPoint.setText(String.valueOf(games.get(GAME_THREE).getLocalScore()));
        	  thirdVisitorTeamPoint.setText(String.valueOf(games.get(GAME_THREE).getVisitorScore()));
  		} else {
  			thirdLocalTeamPoint.setText("?");  
  			thirdVisitorTeamPoint.setText("?");
  		}
    }




	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exoportXMLButton) {
			fileIO = new FileIO<>();
			fileIO.convertToXML(weeks, season);	
			UserDialogUtil.userDialog("Se ha exportado el archivo XML", "Exportar XML", JOptionPane.INFORMATION_MESSAGE);
		} else {
			UserDialogUtil.userDialog("Se ha producido un error, comprueba los archivos de logs", "Exportar XML", JOptionPane.ERROR_MESSAGE);

		}
		
	}
}
