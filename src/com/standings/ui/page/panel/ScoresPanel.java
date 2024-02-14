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

import com.standings.model.Season;

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

/**
 * Panel para mostrar los resultados de los partidos por semana.
 * @author SomeOne
 * @version 1.0
 * @since 2024-02-02
 */
public class ScoresPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 2653188263518760831L;

	// Paneles de cada semana
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
	
	// Botones para seleccionar la semana
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

	
	  /**
     * Constructor de ScoresPanel.
     * @param panelButton Panel de botones.
     * @param season Temporada actual.
     */
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
		
		 weekOnePanel    = new WeekOnePanel(this.season);	 
		 weekTwoPanel    = new WeekTwoPanel(this.season);	 
		 weekThreePanel  = new WeekThreePanel(this.season);
		 weekFourPanel   = new WeekFourPanel(this.season);
		 weekFivePanel   = new WeekFivePanel(this.season);
		 weekSixPanel    = new WeekSixPanel(this.season);
		 weekSevenPanel  = new WeekSevenPanel(this.season);
		 weekEighthPanel = new WeekEighthPanel(this.season);
		 weekNinePanel   = new WeekNinePanel(this.season);
		 weekTenPanel   = new WeekTenPanel(this.season);

		
		 this.add(weekOnePanel);
	}
	
	
	/**
	 * Renderiza los resultados de todos los partidos para cada semana de la temporada.
	 * 
	 * @param season La temporada para la cual se renderizan los resultados.
	 */
	public void renderAllWeeksScores(Season season) {
		weekOnePanel.addGameInfo(season);
		weekTwoPanel.addGameInfo(season);
		weekThreePanel.addGameInfo(season);
		weekFourPanel.addGameInfo(season);
		weekFivePanel.addGameInfo(season);
		weekSixPanel.addGameInfo(season);
		weekSevenPanel.addGameInfo(season);
		weekEighthPanel.addGameInfo(season);
		weekNinePanel.addGameInfo(season);
		weekTenPanel.addGameInfo(season);
	}
	
	
	
	
	/**
	 * Renderiza los resultados de los partidos para la semana seleccionada.
	 * 
	 * @param selectedWeek El número de la semana para la cual se renderizan los resultados.
	 */
	
	public void renderWeeksScores(int selectedWeek) {
		
	
		
		switch (selectedWeek) {
		case 1:
			weekOnePanel.addGameInfo(this.season);
			break;
			
		case 2:
			weekTwoPanel.addGameInfo(this.season);
			break;	
		case 3:
			weekThreePanel.addGameInfo(this.season);
			break;
		case 4:
			weekFourPanel.addGameInfo(this.season);
			break;
		case 5:
			weekFivePanel.addGameInfo(this.season);
			break;	
		case 6:
			weekSixPanel.addGameInfo(this.season);
			break;
		case 7:
			weekSevenPanel.addGameInfo(this.season);
			break;
		case 8:
			weekEighthPanel.addGameInfo(this.season);
			break;
		case 9:
			weekNinePanel.addGameInfo(this.season);
			break;
		case 10:	
			weekTenPanel.addGameInfo(this.season);

			break;
			
		default:
			
		}
	}
	
	
    
	/**
	 * Muestra el panel especificado, reemplazando el contenido actual del panel principal.
	 * 
	 * @param panelToShow El panel que se mostrará en el panel principal.
	 */
	private void showPanel(JPanel panelToShow) {
        this.removeAll();
        this.add(panelButton);
        this.add(weeksPanelButton);
        this.add(panelToShow, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

	
	
	  
	/**
	 * Realiza las acciones correspondientes cuando se produce un evento de acción, como hacer clic en un botón.
	 * 
	 * @param e El evento de acción que se ha producido.
	 */
	
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
