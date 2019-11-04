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
		
		NumberedTile[] pieces =  model.puzzlePieces.getPieces();
		EmptyTile space = model.puzzlePieces.getEmptyTile();
		
		Font numberFont = new Font("trebuchet", Font.BOLD, 24);
		g.setFont(numberFont);
		
		for (NumberedTile t : pieces)
		{
			// Draw Tiles
			g.drawRect(t.getLocation().getCol() * 110, t.getLocation().getRow() * 110, 100, 100);
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
			g.fillRect(t.getLocation().getCol() * 110, t.getLocation().getRow() * 110, 100, 100);
			// Draw Numbers on the Tiles
			g.setColor(Color.white);
			g.drawString("" + t.getVisibleNum(), (t.getLocation().getCol() * 110) + 45, (t.getLocation().getRow() * 110) + 60);
		}
		
		g.drawRect(space.getLocation().getCol() * 110, space.getLocation().getRow() * 110, 100, 100);
		g.setColor(Color.orange);
		g.fillRect(space.getLocation().getCol() * 110, space.getLocation().getRow() * 110, 100, 100);
		
	}
	
}
