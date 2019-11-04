package starter.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import starter.boundary.App;
import starter.model.Cell;
import starter.model.EmptyTile;
import starter.model.Model;
import starter.model.NumberedTile;

public class FlipController extends MouseAdapter{
	
	Model model;
	App dsa;
	
	public FlipController(Model model, App dsa) {
		this.model = model;
		this.dsa = dsa;
	}
	

	public void mousePressed(MouseEvent me) {
		System.out.println(me.getPoint());
		// Get the mouse's cell location
		Cell mouseLoc = mouseLocation(me);
		
		if(mouseLoc.getCol() > -1 && mouseLoc.getRow() > -1) 
		{
			//Location is valid
			NumberedTile mouseTile = model.puzzlePieces.getTileFromCell(mouseLoc);
			EmptyTile space = model.puzzlePieces.hasEmptyNeighbor(mouseTile);
			if(space != null) // Checks if there is an empty tile neighboring the mouse tile
			{
				System.out.println("Valid Flip!");
//				//Switch the locations of the cells
//				model.puzzlePieces.getTileFromCell(mouseLoc).setLocation(space.getLocation());
//				System.out.println("new tile Loc:" + space.getLocation().getRow() + " , " + space.getLocation().getCol());
//				model.puzzlePieces.getEmptyTile().setLocation(mouseTile.getLocation());
//				System.out.println("new space Loc:" + model.puzzlePieces.getEmptyTile().getLocation().getRow() + " , " + model.puzzlePieces.getEmptyTile().getLocation().getCol());
				System.out.println("old space Loc:" + model.puzzlePieces.getEmptyTile().getLocation().getRow() + " , " + model.puzzlePieces.getEmptyTile().getLocation().getCol());
				model.puzzlePieces.switchTileAndSpace(mouseTile);
				System.out.println("new space Loc:" + model.puzzlePieces.getEmptyTile().getLocation().getRow() + " , " + model.puzzlePieces.getEmptyTile().getLocation().getCol());
				//UPDATES THE APP
				dsa.repaint();
				model.totalNumMoves++;
			}
			
		}
		else 
		{
			System.out.println("Invalid Tile, Try Again");
		}
		
	}
	
	// Helper Function
	public Cell mouseLocation(MouseEvent me) 
	{
		int mouseCol = (int) Math.floor(me.getPoint().x / 110);
		int mouseRow = (int) Math.floor(me.getPoint().y / 110);
		Cell result = new Cell(-1, -1);
		
		//Check if location is within bounds set the result to the mouses location
		if(mouseCol < 3) 
		{
			result.setCol(mouseCol);
		}
		if(mouseRow < 3) 
		{
			result.setRow(mouseRow);
		}
		
		return result;
	}
	
}
