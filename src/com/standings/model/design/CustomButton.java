package com.standings.model.design;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class CustomButton extends BasicButtonUI{
	  @Override
      public void installUI(JComponent c) {
   	   super.installUI(c);
   	   AbstractButton b = (AbstractButton) c;
   	   b.setOpaque(true);
      }
      @Override
      protected void paintButtonPressed(Graphics g, AbstractButton b) {
   	   if (b.isContentAreaFilled()) {
   		   g.setColor(Color.WHITE);
   		   g.fillRect(0, 0, b.getWidth(), b.getHeight());
   	   }  	   
      }
}