package com.standings.ui.page.panel.teams;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ShamrockPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6492254016786148458L;

	   private JLabel iconLabel; 
	    private ImageIcon icon;
	    private  JLabel stadiumLabel;
	    private JLabel stadiumNameLabel;
	    private JLabel fundiationYearLabel;
	    private JLabel cityNameLabel;
	    private JLabel fundiationLabel;
	    private JLabel cityLabel;
	    private JLabel descriptionLabel;
	    
	    
	
	
	public ShamrockPanel () {
		
		this.setBounds(0, 115, 1525, 845);
	   	this.setLayout(null);
	   	
	   	icon = new ImageIcon(ShamrockPanel.class.getResource("/images/shamrock_logo.png"));
		
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
	           
	    
	    stadiumNameLabel = new JLabel("Croke Park"); 
	    stadiumNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    stadiumNameLabel.setBounds(161, 542, 300, 54);
	    this.add(stadiumNameLabel);
	           
	    
	    cityNameLabel = new JLabel("Dublin");
	    cityNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    cityNameLabel.setBounds(706, 542, 148, 54);
	    this.add(cityNameLabel);
	          
	    fundiationYearLabel = new JLabel("1875");
	    fundiationYearLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    fundiationYearLabel.setBounds(1223, 542, 148, 54);
	    this.add(fundiationYearLabel);  

	       
	    descriptionLabel = new JLabel("<html>El equipo nacional de rugby de Irlanda es el equipo nacional representativo masculino"
	    		+ " de la isla de Irlanda en la unión de rugby. El equipo representa tanto a la República de Irlanda como a Irlanda del Norte."
	    		+ " Irlanda compite en el Campeonato Anual de las Seis Naciones y en la Copa Mundial de Rugby."
	    		+ " shamrock es uno de los cuatro equipos que forman los Leones Británico e "
	    		+ "Irlandés - los jugadores elegibles para jugar en shamrock también son elegibles para los Leones. </html>");
	    
	    descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    descriptionLabel.setBounds(433, 284, 699, 205);
	   this.add(descriptionLabel);
	}
}
