package com.standings.util;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UserDialogUtil {

	
	public static void userDialog(String dialogText, String dialogTitle, int meesageType) {
		
		 JOptionPane requirementPane = new JOptionPane(dialogText,JOptionPane.YES_OPTION);

		 requirementPane.setMessageType(meesageType);

	        JPanel buttonPanel = (JPanel)requirementPane.getComponent(1);
	        
	        JButton accepetButton = (JButton)buttonPanel.getComponent(0);
	        accepetButton.setText("Aceptar");
	        accepetButton.setFocusable(false);
	        accepetButton.setBackground(Color.LIGHT_GRAY);
	        
	        JDialog requirementdialog = requirementPane.createDialog(null, dialogTitle);
	        requirementdialog.setVisible(true);
	}
}
