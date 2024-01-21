package com.standings.model.design;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.AbstractBorder;

public class CustomBorder extends AbstractBorder {

	private static final long serialVersionUID = -1182472549866573751L;
	private int cornerRadius;

     public CustomBorder(int cornerRadius) {
         this.cornerRadius = cornerRadius;
     }

     @Override
     public void paintBorder(Component component, Graphics graphics, int x, int y, int width, int height) {
         super.paintBorder(component, graphics, x, y, width, height);

         Graphics2D g2d = (Graphics2D) graphics;
         g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         g2d.setColor(Color.BLACK); 

       
         RoundRectangle2D roundedRect = new RoundRectangle2D.Float(x, y, width - 1, height - 1, cornerRadius, cornerRadius);

       
         g2d.draw(roundedRect);
     }

     @Override
     public Insets getBorderInsets(Component c) {
         return new Insets(cornerRadius, cornerRadius, cornerRadius, cornerRadius);
     }

     @Override
     public Insets getBorderInsets(Component c, Insets insets) {
         insets.left = insets.top = insets.right = insets.bottom = cornerRadius;
         return insets;
     }
 }
