package starter.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import starter.boundary.App;
import starter.boundary.PopUp;
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
		// Get the mouse's cell location
		Cell mouseLoc = mouseLocation(me);
		
		if(mouseLoc.getCol() > -1 && mouseLoc.getRow() > -1) 
		{
			//Location is valid
			NumberedTile mouseTile = model.puzzlePieces.getTileFromCell(mouseLoc);
			if(mouseTile != null) 
			{
				EmptyTile space = model.puzzlePieces.hasEmptyNeighbor(mouseTile);
				if(space != null) // Checks if there is an empty tile neighboring the mouse tile
				{
					System.out.println("Valid Flip!");
					//Switch the locations of the cells
					model.puzzlePieces.switchTileAndSpace(mouseTile);
					//UPDATES THE APP
					model.totalNumMoves++;
					dsa.repaint();
					
					if(loseCheck()) 
					{
						System.out.println("YOU LOSE :(");
						PopUp.infoBox("You Lost! ", "Game Over", dsa);
					}
					if(winCheck()) 
					{
						System.out.println("YOU WIN :)");
					}
				}
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
	
	public boolean loseCheck() 
	{
		int topnum = 0;
		int oneCount = 0;
		int twoCount = 0;
		int threeCount = 0;
		int fourCount = 0;
		boolean result = false;
		for(NumberedTile t : model.puzzlePieces.getPieces()) 
		{
			topnum = t.getVisibleNum();
			if(topnum == 1) 
			{
				oneCount++;
			}
			else if(topnum == 2) 
			{
				twoCount++;
			}
			else if(topnum == 3) 
			{
				threeCount++;
			}
			else 
			{
				fourCount++;
			}
			
		}
		if(oneCount == 4 || twoCount == 4 || threeCount == 4 || fourCount == 4) 
		{
			result = true;
		}
		
		return result;
	}
	
	public boolean winCheck() 
	{
		boolean result = false;
		boolean numResult = false;
		boolean colorResult = false;
		EmptyTile space = model.puzzlePieces.getEmptyTile();
		// Check that the space is in the center of the tiles
		if(space.getLocation().getCol() == 1 && space.getLocation().getRow() == 1) 
		{
			int tile1num = model.puzzlePieces.getTileFromCell(new Cell(0,0)).getVisibleNum();
			int tile2num = model.puzzlePieces.getTileFromCell(new Cell(0,1)).getVisibleNum();
			int tile3num = model.puzzlePieces.getTileFromCell(new Cell(0,2)).getVisibleNum();
			int tile4num = model.puzzlePieces.getTileFromCell(new Cell(1,0)).getVisibleNum();
			int tile6num = model.puzzlePieces.getTileFromCell(new Cell(1,2)).getVisibleNum();
			int tile7num = model.puzzlePieces.getTileFromCell(new Cell(2,0)).getVisibleNum();
			int tile8num = model.puzzlePieces.getTileFromCell(new Cell(2,1)).getVisibleNum();
			int tile9num = model.puzzlePieces.getTileFromCell(new Cell(2,2)).getVisibleNum();
			numResult = (tile1num == 1 && tile2num == 2 && tile3num == 3 && tile4num == 4 && tile6num == 4
					  && tile7num == 3 && tile8num == 2 && tile9num == 1);
			
			boolean tile1flipped = model.puzzlePieces.getTileFromCell(new Cell(0,0)).getFlipStatus();
			boolean tile2flipped = model.puzzlePieces.getTileFromCell(new Cell(0,1)).getFlipStatus();
			boolean tile3flipped = model.puzzlePieces.getTileFromCell(new Cell(0,2)).getFlipStatus();
			boolean tile4flipped = model.puzzlePieces.getTileFromCell(new Cell(1,0)).getFlipStatus();
			boolean tile6flipped = model.puzzlePieces.getTileFromCell(new Cell(1,2)).getFlipStatus();
			boolean tile7flipped = model.puzzlePieces.getTileFromCell(new Cell(2,0)).getFlipStatus();
			boolean tile8flipped = model.puzzlePieces.getTileFromCell(new Cell(2,1)).getFlipStatus();
			boolean tile9flipped = model.puzzlePieces.getTileFromCell(new Cell(2,2)).getFlipStatus();
			colorResult = (!tile1flipped && !tile2flipped && !tile3flipped && tile4flipped && 
					       !tile6flipped && tile7flipped && tile8flipped && tile9flipped);
			result = numResult && colorResult;
		}
		
		return result;
	}
	
}
