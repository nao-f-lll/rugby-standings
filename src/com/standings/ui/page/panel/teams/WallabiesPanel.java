package com.standings.ui.page.panel.teams;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WallabiesPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3885178914460674202L;
	
	   private JLabel iconLabel; 
	    private ImageIcon icon;
	    private  JLabel stadiumLabel;
	    private JLabel stadiumNameLabel;
	    private JLabel fundiationYearLabel;
	    private JLabel cityNameLabel;
	    private JLabel fundiationLabel;
	    private JLabel cityLabel;
	    private JLabel descriptionLabel;
	    
	    
	
	
	public WallabiesPanel () {
		
		this.setBounds(0, 115, 1525, 845);
	   	this.setLayout(null);
	   	
	   	icon = new ImageIcon(AllblacksPanel.class.getResource("/images/wallabies_logo.png"));
		
	   	iconLabel = new JLabel("");      
	   	iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
	   	iconLabel.setIcon(icon);
	   	iconLabel.setBounds(587, 70, 358, 229);
	    this.add(iconLabel);
	       
	       
	    cityLabel = new JLabel("Ciudad"); 
	    cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    cityLabel.setBounds(706, 490, 148, 54);
	    this.add(cityLabel);
	       
	    fundiationLabel = new JLabel("Fundación"); 
	    fundiationLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    fundiationLabel.setBounds(1223, 490, 148, 54);
	    this.add(fundiationLabel);
	        
	    stadiumLabel = new JLabel("Estadio");
	    stadiumLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    stadiumLabel.setBounds(161, 490, 109, 54);
	    this.add(stadiumLabel);
	           
	    
	    stadiumNameLabel = new JLabel("ANZ Stadium"); 
	    stadiumNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    stadiumNameLabel.setBounds(161, 542, 300, 54);
	    this.add(stadiumNameLabel);
	           
	    
	    cityNameLabel = new JLabel("Sydney");
	    cityNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    cityNameLabel.setBounds(706, 542, 148, 54);
	    this.add(cityNameLabel);
	          
	    fundiationYearLabel = new JLabel("1899");
	    fundiationYearLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    fundiationYearLabel.setBounds(1223, 542, 148, 54);
	    this.add(fundiationYearLabel);  

	       
	    descriptionLabel = new JLabel("<html>El equipo nacional de rugby de Nueva Zelanda, comúnmente conocido como All Blacks."
	           		                                   + "Famosos por su éxito internacional, los All Blacks han sido considerados a menudo <br>"
	                                                   + "como uno de los equipos deportivos más exitosos de la historiaAustralia ha"
	                                                   + "competido en las nueve Copas del Mundo de Rugby, ganando la final en dos ocasiones y"
	                                                   + "también terminando como subcampeón dos veces. Australia venció a Inglaterra en Twickenham en "
	                                                   + "la final de la Copa Mundial de Rugby de 1991 y ganó de nuevo en 1999 en el Millennium Stadium de Cardiff"
	                                                   + "cuando sus oponentes en la final fueron Francia.</html>");
	    
	    descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    descriptionLabel.setBounds(433, 284, 699, 205);
	   this.add(descriptionLabel);
	}
}
