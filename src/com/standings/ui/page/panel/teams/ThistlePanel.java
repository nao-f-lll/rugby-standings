package com.standings.ui.page.panel.teams;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ThistlePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9167439328393463054L;
	
	   private JLabel iconLabel; 
	    private ImageIcon icon;
	    private  JLabel stadiumLabel;
	    private JLabel stadiumNameLabel;
	    private JLabel fundiationYearLabel;
	    private JLabel cityNameLabel;
	    private JLabel fundiationLabel;
	    private JLabel cityLabel;
	    private JLabel descriptionLabel;
	    
	    
	
	
	public ThistlePanel () {
		
		this.setBounds(0, 115, 1525, 845);
	   	this.setLayout(null);
	   	
	   	icon = new ImageIcon(AllblacksPanel.class.getResource("/images/thistle_logo.png"));
		
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
	           
	    
	    stadiumNameLabel = new JLabel("Murrayfield Stadium"); 
	    stadiumNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    stadiumNameLabel.setBounds(161, 542, 300, 54);
	    this.add(stadiumNameLabel);
	           
	    
	    cityNameLabel = new JLabel("Edinburgh");
	    cityNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    cityNameLabel.setBounds(706, 542, 148, 54);
	    this.add(cityNameLabel);
	          
	    fundiationYearLabel = new JLabel("1871");
	    fundiationYearLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    fundiationYearLabel.setBounds(1223, 542, 148, 54);
	    this.add(fundiationYearLabel);  

	       
	    descriptionLabel = new JLabel("<html>En 1882 se fundó el Campeonato de las Naciones Locales, el precursor del moderno Campeonato de las Seis Naciones, con la participación de Escocia, Inglaterra, Gales e Irlanda."
	    		+ "  Los escoceses disfrutaron de un éxito ocasional en los primeros años,"
	    		+ " ganando su primera Triple Corona en 1891 y repitiendo la hazaña en 1895, Sin embargo, el triunfo de Escocia en 1907 sería el último en dieciocho años, ya que la Primera Guerra Mundial (1914-1918) y"
	    		+ " el dominio de Inglaterra después les negarían la gloria.</html>");
	    
	    descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    descriptionLabel.setBounds(433, 284, 699, 205);
		this.add(descriptionLabel);
	}
}
