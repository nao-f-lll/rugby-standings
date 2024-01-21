package com.standings.model.design;

import static com.standings.model.ParentFrame.ResizeIconStatic;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class CustomCheckBox extends JCheckBox {

	private static final long serialVersionUID = -7104751621123160976L;
	
	private ImageIcon clickToEditIcon;
	private ImageIcon editorIcon;
	
	public CustomCheckBox() {
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setOpaque(false);
		setBackground(new Color(69, 124, 235));
		setFocusable(false);

		clickToEditIcon  = new ImageIcon(ResizeIconStatic("/images/Editando.png", 30, 30));
		editorIcon = new ImageIcon(ResizeIconStatic("/images/Editar.png", 30, 30));
		
	}
	
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (isSelected()) {
			if (isEnabled()) {
			
				
				this.setIcon(clickToEditIcon);		
				setToolTipText("Haga click para dejar de editar");
			} else {
				
			}
		
		} else {
			
			this.setIcon(editorIcon);
			setToolTipText("Haga click para editar");
			
		}
	}
}