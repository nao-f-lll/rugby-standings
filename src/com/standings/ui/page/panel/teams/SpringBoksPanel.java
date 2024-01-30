package com.standings.ui.page.panel.teams;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SpringBoksPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1388571788911667057L;
	
	   private JLabel iconLabel; 
	    private ImageIcon icon;
	    private  JLabel stadiumLabel;
	    private JLabel stadiumNameLabel;
	    private JLabel fundiationYearLabel;
	    private JLabel cityNameLabel;
	    private JLabel fundiationLabel;
	    private JLabel cityLabel;
	    private JLabel descriptionLabel;
	    
	    
	
	
	public SpringBoksPanel () {
		
		this.setBounds(0, 115, 1525, 845);
	   	this.setLayout(null);
	   	
	   	icon = new ImageIcon(AllblacksPanel.class.getResource("/images/springbok_logo.png"));
		
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
	           
	    
	    stadiumNameLabel = new JLabel("Ellis Park"); 
	    stadiumNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    stadiumNameLabel.setBounds(161, 542, 300, 54);
	    this.add(stadiumNameLabel);
	           
	    
	    cityNameLabel = new JLabel("Johannesburg");
	    cityNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    cityNameLabel.setBounds(706, 542, 148, 54);
	    this.add(cityNameLabel);
	          
	    fundiationYearLabel = new JLabel("1891");
	    fundiationYearLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    fundiationYearLabel.setBounds(1223, 542, 148, 54);
	    this.add(fundiationYearLabel);  

	       
	    descriptionLabel = new JLabel("<html>Los Springboks (coloquialmente los Boks, Bokke o Amabhokobhoko),"
	    		+ " es la selección sudafricana. Los Springboks juegan en camisetas verdes y doradas con pantalones blancos."
	    		+ " Su emblema es un antílope nativo, el Springbok, que es el animal nacional de Sudáfrica</html>");
	    
	    descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    descriptionLabel.setBounds(433, 284, 699, 205);
	   this.add(descriptionLabel);
	}
}
