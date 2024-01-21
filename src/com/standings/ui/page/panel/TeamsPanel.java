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
import com.standings.model.design.CustomBorder;
import com.standings.model.design.CustomButton;
import com.standings.ui.page.panel.teams.AllblacksPanel;
import com.standings.ui.page.panel.teams.FeathersPanel;
import com.standings.ui.page.panel.teams.RedRosePanel;
import com.standings.ui.page.panel.teams.SakurasPanel;
import com.standings.ui.page.panel.teams.ShamrockPanel;
import com.standings.ui.page.panel.teams.SpringBoksPanel;
import com.standings.ui.page.panel.teams.ThistlePanel;
import com.standings.ui.page.panel.teams.WallabiesPanel;

public class TeamsPanel extends JPanel implements ActionListener {
	
	
    private static final long serialVersionUID = -538081400942327500L;
	
 
    
    
    
	private AllblacksPanel allblacksPanel;
	private SpringBoksPanel springBoksPanel;
	private SakurasPanel sakurasPanel;
	private WallabiesPanel wallabiesPanel;
	private ShamrockPanel shamrockPanel;	
	private RedRosePanel redRosePanel;
	private FeathersPanel feathersPanel;
	private ThistlePanel thistlePanel;
    
    
	private JButton allBlacksButton;
	private JButton springBoksButton;	
	private JButton sakurasButton;
	private JButton shamrockButton;
	private JButton wallabiesButton;
	private JButton feathersButton;
	private JButton thistleButton;
	private JButton redRoseButton;

	private JPanel teamsPanelButton;
	private JPanel panelButton;
    
    public TeamsPanel(JPanel panelButton) {
    	this.panelButton = panelButton;
    	initializeTeamsPanels();
    	initializeButtons();

    }
    
    
    private void initializeTeamsPanels() {
    	

  


    	allblacksPanel    = new AllblacksPanel();
    	springBoksPanel    = new SpringBoksPanel();
    	sakurasPanel  = new SakurasPanel();
    	wallabiesPanel   = new WallabiesPanel();
    	shamrockPanel   = new ShamrockPanel();
    	redRosePanel    = new RedRosePanel();
    	feathersPanel  = new FeathersPanel();
    	thistlePanel = new ThistlePanel();
	

		
		 this.add(allblacksPanel);
    }
    
    private void initializeButtons() {
    		   
    	
	       teamsPanelButton = new JPanel();
	       teamsPanelButton.setLayout(null);
	       teamsPanelButton.setBackground(Color.WHITE);
	       teamsPanelButton.setBounds(0, 62, 1522, 60);
	       this.add(teamsPanelButton);

	       int buttonWidth = 190;
	       int horizontalGap = 3; 
	       int initialX = 10;

	       allBlacksButton = new JButton("All Blacks");
	       allBlacksButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       allBlacksButton.setFocusable(false);
	       allBlacksButton.setBorder(new CustomBorder(20));
	       allBlacksButton.setBackground(Color.WHITE);
	       allBlacksButton.setBounds(initialX, 10, buttonWidth, 33);
	       allBlacksButton.setUI(new CustomButton()); 
	       allBlacksButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       teamsPanelButton.add(allBlacksButton);
	       


	       springBoksButton = new JButton("Springboks");
	       springBoksButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       springBoksButton.setFocusable(false);
	       springBoksButton.setUI(new CustomButton());
	       springBoksButton.setBorder(null);
	       springBoksButton.setBackground(Color.WHITE);
	       springBoksButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);  
	       springBoksButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       teamsPanelButton.add(springBoksButton);
	       
	       
	       sakurasButton = new JButton("Sakuras");
	       sakurasButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       sakurasButton.setFocusable(false);
	       sakurasButton.setUI(new CustomButton());
	       sakurasButton.setBorder(null);
	       sakurasButton.setBackground(Color.WHITE);
	       sakurasButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       sakurasButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       teamsPanelButton.add(sakurasButton);
	       
	       

	       
	       shamrockButton  = new JButton("Shamrock");
	       shamrockButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       shamrockButton.setFocusable(false);
	       shamrockButton.setUI(new CustomButton());
	       shamrockButton.setBorder(null);
	       shamrockButton.setBackground(Color.WHITE);
	       shamrockButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       shamrockButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       teamsPanelButton.add(shamrockButton);
	       
	  
	       
	       wallabiesButton = new JButton("Wallabies");
	       wallabiesButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       wallabiesButton.setFocusable(false);
	       wallabiesButton.setUI(new CustomButton());
	       wallabiesButton.setBorder(null);
	       wallabiesButton.setBackground(Color.WHITE);  
	       wallabiesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       wallabiesButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       teamsPanelButton.add(wallabiesButton);
	       
	       
	      
	       
	       redRoseButton  = new JButton("Red Rose");
	       redRoseButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       redRoseButton.setFocusable(false);
	       redRoseButton.setUI(new CustomButton());
	       redRoseButton.setBorder(null);
	       redRoseButton.setBackground(Color.WHITE); 
	       redRoseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       redRoseButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       teamsPanelButton.add(redRoseButton);
	       
	       
	       feathersButton  = new JButton("Feathers");
	       feathersButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       feathersButton.setFocusable(false);
	       feathersButton.setUI(new CustomButton());
	       feathersButton.setBorder(null);
	       feathersButton.setBackground(Color.WHITE); 
	       feathersButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       feathersButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       teamsPanelButton.add(feathersButton);
	       
	       
	       thistleButton  = new JButton("Thistle");
	       thistleButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	       thistleButton.setFocusable(false);
	       thistleButton.setUI(new CustomButton());
	       thistleButton.setBorder(null);
	       thistleButton.setBackground(Color.WHITE); 
	       thistleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	       thistleButton.setBounds(initialX += buttonWidth + horizontalGap, 10, buttonWidth, 33);
	       teamsPanelButton.add(thistleButton);
	       
	       
	       
	       allBlacksButton.addActionListener(this);
	       springBoksButton.addActionListener(this);
	       sakurasButton.addActionListener(this);
	       shamrockButton.addActionListener(this);       
	       wallabiesButton.addActionListener(this);       
	       redRoseButton.addActionListener(this);
	       feathersButton.addActionListener(this);
	       thistleButton.addActionListener(this);
	       
	       
	      
    }
  

	private void showPanel(JPanel panelToShow) {
        this.removeAll();
        this.add(panelButton);
        this.add(teamsPanelButton);
        this.add(panelToShow, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

	
	  
	//MODIFIES: this
	//EFFECTS:  displays the appropriate panel based on the clicked button by the user
	
    @Override
    public void actionPerformed(ActionEvent e) {
      
    	Map<JButton, JPanel> buttonPanelMap = new HashMap<>();
        buttonPanelMap.put(allBlacksButton, allblacksPanel);
        buttonPanelMap.put(springBoksButton, springBoksPanel);
        buttonPanelMap.put(sakurasButton, sakurasPanel);
        buttonPanelMap.put(wallabiesButton, wallabiesPanel);
        buttonPanelMap.put(shamrockButton, shamrockPanel);
        buttonPanelMap.put(redRoseButton, redRosePanel);
        buttonPanelMap.put(feathersButton, feathersPanel);
        buttonPanelMap.put(thistleButton, thistlePanel);
 

        
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
