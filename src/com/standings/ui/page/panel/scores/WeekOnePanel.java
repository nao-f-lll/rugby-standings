package com.standings.ui.page.panel.scores;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.standings.model.Game;
import com.standings.model.Team;

public class WeekOnePanel extends JPanel{

	private static final long serialVersionUID = 2821219558128276869L;

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
	
	final int  GAME_ONE = 0;
	final int  GAME_TWO = 1;
	final int  GAME_THREE = 2;
	

	public WeekOnePanel(ArrayList<Team> teams, ArrayList<Game> games) {
		
		   	this.setBounds(0, 115, 1525, 845);
		   	this.setLayout(null);
		   	this.games = games;
		   	this.teams = teams;
	
	       
	       
			
		       firstLocalTeamName = new JLabel("");
		       firstLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       firstLocalTeamName.setBounds(365, 80, 159, 95);
		       this.add(firstLocalTeamName);
		      
		       
		       firstLocalTeamPoint = new JLabel("");
		       firstLocalTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       firstLocalTeamPoint.setBounds(571, 80, 58, 95);
		       this.add(firstLocalTeamPoint);
		       
		             
		       
		       firstVisitorTeamName = new JLabel("");
		       firstVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       firstVisitorTeamName.setBounds(365, 210, 159, 95);
		       this.add(firstVisitorTeamName);
		       	     
		       
		       firstVisitorTeamPoint = new JLabel("");
		       firstVisitorTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       firstVisitorTeamPoint.setBounds(571, 210, 58, 95);
		       this.add(firstVisitorTeamPoint);
		       		       
		       
		       secondLocalTeamName = new JLabel("");
		       secondLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       secondLocalTeamName.setBounds(365, 404, 116, 95);
		       this.add(secondLocalTeamName);
		   
		      	       
		       secondLocalTeamPoint = new JLabel("");
		       secondLocalTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       secondLocalTeamPoint.setBounds(571, 404, 58, 95);
		       this.add(secondLocalTeamPoint);
		       
		       
		       secondVisitorTeamName = new JLabel("");
		       secondVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       secondVisitorTeamName.setBounds(355, 529, 126, 95);      
		       this.add(secondVisitorTeamName);
		       
		       
		       secondVisitorTeamPoint = new JLabel("");
		       secondVisitorTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       secondVisitorTeamPoint.setBounds(571, 529, 58, 95);
		       this.add(secondVisitorTeamPoint);
		       	       
		       
		       thirdLocalTeamName = new JLabel("");
		       thirdLocalTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       thirdLocalTeamName.setBounds(1102, 80, 159, 95);
		       this.add(thirdLocalTeamName);
		       
		 
		       
		       thirdLocalTeamPoint = new JLabel("");
		       thirdLocalTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       thirdLocalTeamPoint.setBounds(1305, 80, 58, 95);
		       this.add(thirdLocalTeamPoint);
		       
		       
		       thirdVisitorTeamName = new JLabel("");
		       thirdVisitorTeamName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       thirdVisitorTeamName.setBounds(1102, 221, 159, 95);
		       this.add(thirdVisitorTeamName);
		       
		       
		  
		       
		       thirdVisitorTeamPoint = new JLabel("");
		       thirdVisitorTeamPoint.setFont(new Font("Tahoma", Font.PLAIN, 27));
		       thirdVisitorTeamPoint.setBounds(1305, 221, 58, 95);
		       this.add(thirdVisitorTeamPoint);
		       

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
	
	


	
}
