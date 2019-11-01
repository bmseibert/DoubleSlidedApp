package starter.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.color.*;
import java.awt.font.*;

import javax.swing.JPanel;

import starter.model.Cell;
import starter.model.EmptyTile;
import starter.model.Model;
import starter.model.NumberedTile;

public class PuzzlePanel extends JPanel {

	Model model;

	/**
	 * Create the panel.
	 */
	public PuzzlePanel(Model model) {
		this.model = model;
	}

	@Override
	public void paintComponent(Graphics g) {
		
		NumberedTile[] pieces =  model.pieces;
		EmptyTile space = model.space;
		
		Font numberFont = new Font("trebuchet", Font.BOLD, 24);
		g.setFont(numberFont);
		
		for (NumberedTile t : pieces)
		{
			// Draw Tiles
			g.drawRect(t.getLocation().col * 110, t.getLocation().row * 110, 100, 100);
			// Fill Tiles
			if(t.getFlipStatus()) 
			{
				// If true color cell black
				g.setColor(Color.black);
			}
			else
			{
				// Color cell grey
				g.setColor(Color.gray);
			}
			g.fillRect(t.getLocation().col * 110, t.getLocation().row * 110, 100, 100);
			// Draw Numbers on the Tiles
			g.setColor(Color.white);
			g.drawString("" + t.getVisibleNum(), (t.getLocation().col * 110) + 45, (t.getLocation().row * 110) + 60);
		}
		
		g.drawRect(space.getLocation().col * 110, space.getLocation().row * 110, 100, 100);
		g.setColor(Color.orange);
		g.fillRect(space.getLocation().col * 110, space.getLocation().row * 110, 100, 100);
		
	}
	
}
