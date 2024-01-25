package com.standings.ui.page.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

//import com.standings.ui.page.panel.subpanel.*;

import com.standings.model.design.CustomBorder;
import com.standings.model.design.CustomButton;
import com.standings.ui.page.panel.scores.WeekEighthPanel;
import com.standings.ui.page.panel.scores.WeekFivePanel;
import com.standings.ui.page.panel.scores.WeekFourPanel;
import com.standings.ui.page.panel.scores.WeekNinePanel;
import com.standings.ui.page.panel.scores.WeekOnePanel;
import com.standings.ui.page.panel.scores.WeekSevenPanel;
import com.standings.ui.page.panel.scores.WeekSixPanel;
import com.standings.ui.page.panel.scores.WeekTenPanel;
import com.standings.ui.page.panel.scores.WeekThreePanel;
import com.standings.ui.page.panel.scores.WeekTwoPanel;
import com.standings.model.Season;

public class ScoresPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 2653188263518760831L;

	
	private WeekOnePanel weekOnePanel;
	private WeekTwoPanel weekTwoPanel;
	private WeekThreePanel weekThreePanel;
	private WeekFourPanel weekFourPanel;
	private WeekFivePanel weekFivePanel;	
	private WeekSixPanel weekSixPanel;
	private WeekSevenPanel weekSevenPanel;
	private WeekEighthPanel weekEighthPanel;
	private WeekNinePanel weekNinePanel;
	private WeekTenPanel weekTenPanel;
	
	private JPanel weeksPanelButton;
	private JPanel panelButton;
	
	private JButton weekOneButton;
	private JButton weekTwoButton;
	private JButton weekThreeButton;
	private JButton weekFourButton;
	private JButton weekFiveButton;
	private JButton weekSixButton;
	private JButton weekSevenButton;
	private JButton weekEighthButton;
	private JButton weekNineButton;
	private JButton weekTenButton;
	
	private Season season;

	
	public ScoresPanel(JPanel panelButton, Season season) {
	       
		
		this.panelButton = panelButton;
		this.season = season;

		
		
		initializeWeekPanels();
				
	       weeksPanelButton = new JPanel();
	       weeksPanelButton.setLayout(null);
	       weeksPanelButton.setBackground(Color.WHITE);
	       weeksPanelButton.setBounds(0, 62, 1522, 60);
	       this.add(weeksPanelButton);

	       int buttonWidth = 120;
	       int horizontalGap = 33; 
	       int initialX = 10;

	       weekOneButton = new JButton("J-1");
	       weekOneButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekOneButton.setFocusable(false);
	       weekOneButton.setBorder(new CustomBorder(20));
	       weekOneButton.setBackground(Color.WHITE);
	       weekOneButton.setBounds(initialX, 10, buttonWidth, 33);
	       weekOneButton.setUI(new CustomButton()); 
	       weekOneButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weeksPanelButton.add(weekOneButton);
	       


	       weekTwoButton = new JButton("J-2");
	       weekTwoButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekTwoButton.setFocusable(false);
	       weekTwoButton.setUI(new CustomButton());
	       weekTwoButton.setBorder(null);
	       weekTwoButton.setBackground(Color.WHITE);
	       weekTwoButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);  
	       weekTwoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weeksPanelButton.add(weekTwoButton);
	       
	       
	       weekThreeButton = new JButton("J-3");
	       weekThreeButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekThreeButton.setFocusable(false);
	       weekThreeButton.setUI(new CustomButton());
	       weekThreeButton.setBorder(null);
	       weekThreeButton.setBackground(Color.WHITE);
	       weekThreeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekThreeButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekThreeButton);
	       
	       

	       
	       weekFourButton  = new JButton("J-4");
	       weekFourButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekFourButton.setFocusable(false);
	       weekFourButton.setUI(new CustomButton());
	       weekFourButton.setBorder(null);
	       weekFourButton.setBackground(Color.WHITE);
	       weekFourButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekFourButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekFourButton);
	       
	  
	       
	       weekFiveButton = new JButton("J-5");
	       weekFiveButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekFiveButton.setFocusable(false);
	       weekFiveButton.setUI(new CustomButton());
	       weekFiveButton.setBorder(null);
	       weekFiveButton.setBackground(Color.WHITE);  
	       weekFiveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekFiveButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekFiveButton);
	       
	       
	      
	       
	       weekSixButton  = new JButton("J-6");
	       weekSixButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekSixButton.setFocusable(false);
	       weekSixButton.setUI(new CustomButton());
	       weekSixButton.setBorder(null);
	       weekSixButton.setBackground(Color.WHITE); 
	       weekSixButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekSixButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekSixButton);
	       
	       
	       
	       
	       
	       weekSevenButton = new JButton("J-7");
	       weekSevenButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekSevenButton.setFocusable(false);
	       weekSevenButton.setUI(new CustomButton());
	       weekSevenButton.setBorder(null);
	       weekSevenButton.setBackground(Color.WHITE); 
	       weekSevenButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekSevenButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekSevenButton);


	       
	       weekEighthButton = new JButton("J-8");
	       weekEighthButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekEighthButton.setFocusable(false);
	       weekEighthButton.setUI(new CustomButton());
	       weekEighthButton.setBorder(null);
	       weekEighthButton.setBackground(Color.WHITE); 
	       weeksPanelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekEighthButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekEighthButton);
	       
	       
	       
	       
	       weekNineButton = new JButton("J-9");
	       weekNineButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekNineButton.setFocusable(false);
	       weekNineButton.setUI(new CustomButton());
	       weekNineButton.setBorder(null);
	       weekNineButton.setBackground(Color.WHITE);
	       weekNineButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekNineButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekNineButton);
	       
	       
	  
	       
	       weekTenButton = new JButton("J-10");
	       weekTenButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       weekTenButton.setFocusable(false);
	       weekTenButton.setUI(new CustomButton());
	       weekTenButton.setBorder(null);
	       weekTenButton.setBackground(Color.WHITE); 
	       weekTenButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       weekTenButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       weeksPanelButton.add(weekTenButton);
	       
	       
	       weekOneButton.addActionListener(this);
	       weekTwoButton.addActionListener(this);
	       weekThreeButton.addActionListener(this);
	       weekFourButton.addActionListener(this);       
	       weekFiveButton.addActionListener(this);       
	       weekSixButton.addActionListener(this);
	       weekSevenButton.addActionListener(this);
	       weekEighthButton.addActionListener(this);
	       weekNineButton.addActionListener(this);
	       weekTenButton.addActionListener(this);
	          
	}
	
	public void initializeWeekPanels() {
		
		 weekOnePanel    = new WeekOnePanel(this.season.getTeams(),this.season.getGames(), this.season.getWeeks());	 
		 weekTwoPanel    = new WeekTwoPanel(this.season.getTeams(),this.season.getGames(), this.season.getWeeks());	 
		 weekThreePanel  = new WeekThreePanel(this.season.getTeams(),this.season.getGames(), this.season.getWeeks());
		 weekFourPanel   = new WeekFourPanel(this.season.getTeams(),this.season.getGames(), this.season.getWeeks());
		 weekFivePanel   = new WeekFivePanel(this.season.getTeams(),this.season.getGames(), this.season.getWeeks());
		 weekSixPanel    = new WeekSixPanel(this.season.getTeams(),this.season.getGames(), this.season.getWeeks());
		 weekSevenPanel  = new WeekSevenPanel(this.season.getTeams(),this.season.getGames(), this.season.getWeeks());
		 weekEighthPanel = new WeekEighthPanel(this.season.getTeams(),this.season.getGames(), this.season.getWeeks());
		 weekNinePanel   = new WeekNinePanel(this.season.getTeams(),this.season.getGames(), this.season.getWeeks());
		 weekTenPanel   = new WeekTenPanel(this.season.getTeams(),this.season.getGames(), this.season.getWeeks());

		
		 this.add(weekOnePanel);
	}
	
	
	//MODIFIES: week [One...Ten] Panel
	//EFFECTS:  based on the selected week passed call the appropriate week's panel
	
	public void renderWeeksScores(int selectedWeek) {
		
	
		
		switch (selectedWeek) {
		case 1:
			weekOnePanel.addGameInfo(this.season.getTeams(), this.season.getGames());
			break;
			
		case 2:
			weekTwoPanel.addGameInfo(this.season.getTeams(), this.season.getGames());
			break;
			
		case 3:
			weekThreePanel.addGameInfo(this.season.getTeams(), this.season.getGames());
			break;
		case 4:
			weekFourPanel.addGameInfo(this.season.getTeams(), this.season.getGames());
			break;
		case 5:
			weekFivePanel.addGameInfo(this.season.getTeams(), this.season.getGames());
			break;	
		case 6:
			weekSixPanel.addGameInfo(this.season.getTeams(), this.season.getGames());
			break;
		case 7:
			weekSevenPanel.addGameInfo(this.season.getTeams(), this.season.getGames());
			break;
		case 8:
			weekEighthPanel.addGameInfo(this.season.getTeams(), this.season.getGames());
			break;
		case 9:
			weekNinePanel.addGameInfo(this.season.getTeams(), this.season.getGames());
			break;
		case 10:	
			
		weekTenPanel.addGameInfo(this.season.getTeams(), this.season.getGames());

			break;
			
		default:
			
		}
	}
	
	
    

	private void showPanel(JPanel panelToShow) {
        this.removeAll();
        this.add(panelButton);
        this.add(weeksPanelButton);
        this.add(panelToShow, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

	
	
	  
	//MODIFIES: this
	//EFFECTS:  displays the appropriate panel based on the clicked button by the user
	
    @Override
    public void actionPerformed(ActionEvent e) {
      
    	Map<JButton, JPanel> buttonPanelMap = new HashMap<>();
        buttonPanelMap.put(weekOneButton, weekOnePanel);
       
        buttonPanelMap.put(weekTwoButton, weekTwoPanel);
       
        buttonPanelMap.put(weekThreeButton, weekThreePanel);
        buttonPanelMap.put(weekFourButton, weekFourPanel);
        buttonPanelMap.put(weekFiveButton, weekFivePanel);
        buttonPanelMap.put(weekSixButton, weekSixPanel);
        buttonPanelMap.put(weekSevenButton, weekSevenPanel);
        buttonPanelMap.put(weekEighthButton, weekEighthPanel);
        buttonPanelMap.put(weekNineButton, weekNinePanel);
        buttonPanelMap.put(weekTenButton, weekTenPanel);
   
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
  
}
