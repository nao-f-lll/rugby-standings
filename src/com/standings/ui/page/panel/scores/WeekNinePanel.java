package com.standings.ui.page.panel.scores;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.standings.model.Game;
import com.standings.model.Team;
import com.standings.model.design.CustomBorder;

import java.awt.Color;
import java.awt.Cursor;

public class WeekNinePanel extends JPanel implements ActionListener{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6846719985207778364L;
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
	
	private ArrayList<Team> teams;
	private ArrayList<Game> games;
	
	final int  GAME_ONE = 24;
	final int  GAME_TWO = 25;
	final int  GAME_THREE = 26;
	private JPanel gameThreePanel;
	private JPanel gameTwoPanel;
	private JPanel gameOnePanel;
	

	public WeekNinePanel(ArrayList<Team> teams, ArrayList<Game> games) {
		
		   	this.setBounds(0, 115, 1525, 845);
		   	this.setLayout(null);
		   	this.games = games;
		   	this.teams = teams;
		       
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
		           
		           JButton exoportXMLButton = new JButton("Export XML");
		           exoportXMLButton.setBounds(1338, 296, 150, 40);
		           exoportXMLButton.setBackground(Color.lightGray);
		           exoportXMLButton.setFocusable(false);
		           exoportXMLButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				   add(exoportXMLButton);
				   exoportXMLButton.addActionListener(this);
		       addGameInfo(this.teams, this.games);
	       
	}
	
	


	//REQUIRES: objects mustn't be a null value.
	//MODIFIES: this
	//EFFECTS: set the team information each in its appropriate game.
	
	public void addGameInfo(ArrayList<Team> teams,  ArrayList<Game> games) {
        
		
		firstLocalTeamName.setText(games.get(GAME_ONE).getLocalTeam().getName());
        firstLocalTeamPoint.setText(String.valueOf(games.get(GAME_ONE).getLocalScore()));
        
        
        firstVisitorTeamName.setText(games.get(GAME_ONE).getVisitorTeam().getName());
        firstVisitorTeamPoint.setText(String.valueOf(games.get(GAME_ONE).getVisitorScore()));
	
     
          secondLocalTeamName.setText(games.get(GAME_TWO).getLocalTeam().getName());
    	  secondLocalTeamPoint.setText(String.valueOf(games.get(GAME_TWO).getLocalScore()));
    	  
    	
    	  secondVisitorTeamName.setText(games.get(GAME_TWO).getVisitorTeam().getName());
    	
    	  secondVisitorTeamPoint.setText(String.valueOf(games.get(GAME_TWO).getVisitorScore()));
    	
    	  
    	  
    	  thirdLocalTeamName.setText(games.get(GAME_THREE).getLocalTeam().getName());
    
    	  thirdLocalTeamPoint.setText(String.valueOf(games.get(GAME_THREE).getLocalScore()));
    	  
    	  
    	  thirdVisitorTeamName.setText(games.get(GAME_THREE).getVisitorTeam().getName());
    	  
    	  thirdVisitorTeamPoint.setText(String.valueOf(games.get(GAME_THREE).getVisitorScore()));
    }




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
