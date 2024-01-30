package com.standings.ui.page.panel.teams;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SakurasPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7031165578209572937L;
	
	   private JLabel iconLabel; 
	    private ImageIcon icon;
	    private  JLabel stadiumLabel;
	    private JLabel stadiumNameLabel;
	    private JLabel fundiationYearLabel;
	    private JLabel cityNameLabel;
	    private JLabel fundiationLabel;
	    private JLabel cityLabel;
	    private JLabel descriptionLabel;
	    
	    
	
	
	public SakurasPanel () {
		
		this.setBounds(0, 115, 1525, 845);
	   	this.setLayout(null);
	   	
	   	icon = new ImageIcon(SakurasPanel.class.getResource("/images/sakuras_logo.png"));
		
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
	           
	    
	    stadiumNameLabel = new JLabel("Chichibunomiya"); 
	    stadiumNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    stadiumNameLabel.setBounds(161, 542, 300, 54);
	    this.add(stadiumNameLabel);
	           
	    
	    cityNameLabel = new JLabel("Tokyo");
	    cityNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    cityNameLabel.setBounds(706, 542, 148, 54);
	    this.add(cityNameLabel);
	          
	    fundiationYearLabel = new JLabel("1932");
	    fundiationYearLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    fundiationYearLabel.setBounds(1223, 542, 148, 54);
	    this.add(fundiationYearLabel);  

	       
	    descriptionLabel = new JLabel("<html>El equipo nacional de rugby de Japón a menudo \"Sakura\", es tradicionalmente la unión de rugby más fuerte de Asia y"
	    		+ " ha disfrutado y soportado resultados mixtos contra equipos no asiáticos a lo largo de los años."
	    		+ " Rugby unión en Japón fue fundada en 1932. También han participado en cada Copa del Mundo de Rugby desde que el torneo comenzó en 1987. </html>");
	    
	    descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    descriptionLabel.setBounds(433, 284, 699, 205);
	   this.add(descriptionLabel);
	}
}
