package test_suite;

import org.junit.*;
import static org.junit.Assert.*;

import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.JMenuBar;

import starter.boundary.App;
import starter.controller.FlipController;
import starter.controller.QuitController;
import starter.model.*;

public class tests {

	@Test
	public void visibleNumTest() 
	{
		NumberedTile tile = new NumberedTile(2,3,false);
		int visible_top_number = tile.getVisibleNum();
		tile.setFlipStatus(true);
		int visible_bottom_number = tile.getVisibleNum();
		assertEquals(visible_top_number, 2);
		assertEquals(visible_bottom_number, 3);
	}
	
	@Test
	public void tileFromLocationTest()
	{
		TileSet pieces = new TileSet(new NumberedTile[8], new EmptyTile(null));
		NumberedTile tile1 = pieces.getTileFromCell(new Cell(0,0));
		assertEquals(tile1.getLocation().getRow(), 0);
		assertEquals(tile1.getLocation().getCol(), 0);
		assertEquals(tile1.getVisibleNum(), 1);
		assertEquals(tile1.getFlipStatus(), false);
	}
	
	@Test
	public void hasEmptyNeighborTest()
	{
		TileSet pieces = new TileSet(new NumberedTile[8], new EmptyTile(null));
		NumberedTile tile1 = pieces.getTileFromCell(new Cell(0,0)); //Tile away from the empty tile
		NumberedTile tile6 = pieces.getTileFromCell(new Cell(1,2)); //Tile neighboring the empty tile
		EmptyTile noNeighborTile = pieces.hasEmptyNeighbor(tile1);
		EmptyTile neighborTile = pieces.hasEmptyNeighbor(tile6);
		
		//Checks that the function returns null when there is no neighboring empty tile
		assertEquals(noNeighborTile, null);
		//Checks that the function returns the correct empty cell when it is a neighbor of the tile entered in the function
		assertEquals(neighborTile.getLocation().getCol(), pieces.getEmptyTile().getLocation().getCol());
		assertEquals(neighborTile.getLocation().getRow(), pieces.getEmptyTile().getLocation().getRow());
	}
	
	@Test 
	public void flipTileTest()
	{
		TileSet pieces = new TileSet(new NumberedTile[8], new EmptyTile(null));
		NumberedTile greyTileToFlip = pieces.getTileFromCell(new Cell(1,2));
		pieces.switchTileAndSpace(greyTileToFlip);
		
		// Check that the empty tile has changed locations with the selected numbered tile
		assertEquals(pieces.getEmptyTile().getLocation().getCol(), 2);
		assertEquals(pieces.getEmptyTile().getLocation().getRow(), 1);
		
		TileSet pieces2 = new TileSet(new NumberedTile[8], new EmptyTile(null));
		NumberedTile blackTileToFlip = pieces2.getTileFromCell(new Cell(2,1));
		pieces2.switchTileAndSpace(blackTileToFlip);
		
		assertEquals(blackTileToFlip.getLocation().getCol(), 2);
		assertEquals(blackTileToFlip.getLocation().getRow(), 2);
	}
	
	
	@Test
	public void flipControllerTest()
	{
		Model model = new Model(new TileSet(new NumberedTile[8], new EmptyTile(null)), 0);
		App dsa = new App(model);
		dsa.setVisible(true);
		
		MouseEvent me = new MouseEvent(dsa, 100, 100, 100, 169, 276, 1, false);
		FlipController cont = new FlipController(model, dsa);
		cont.mousePressed(me);
		assertEquals(model.puzzlePieces.getEmptyTile().getLocation().getRow(), 2);
		assertEquals(model.puzzlePieces.getEmptyTile().getLocation().getCol(), 1);
	}
	
	@Test
	public void invalidMoveTest()
	{
		Model model = new Model(new TileSet(new NumberedTile[8], new EmptyTile(null)), 0);
		App dsa = new App(model);
		dsa.setVisible(true);
		
		MouseEvent clickOnEmpty = new MouseEvent(dsa, 100, 100, 100, 300, 300, 1, false);
		MouseEvent clickOutsideOfGame = new MouseEvent(dsa, 100, 100, 100, 400, 400, 1, false);
		FlipController cont = new FlipController(model, dsa);
		cont.mousePressed(clickOnEmpty);
		cont.mousePressed(clickOutsideOfGame);
		// Empty Space will not move if the moves are invalid
		assertEquals(model.puzzlePieces.getEmptyTile().getLocation().getRow(), 2);
		assertEquals(model.puzzlePieces.getEmptyTile().getLocation().getCol(), 2);
		
	}
	
	@Test
	public void resetApptest() 
	{
		Model model = new Model(new TileSet(new NumberedTile[8], new EmptyTile(null)), 0);
		App dsa = new App(model);
		dsa.setVisible(true);
		// Flip a tile and confirm that the tile has been flipped
		MouseEvent me = new MouseEvent(dsa, 100, 100, 100, 169, 276, 1, false);
		FlipController cont = new FlipController(model, dsa);
		cont.mousePressed(me);
		assertEquals(model.puzzlePieces.getEmptyTile().getLocation().getRow(), 2);
		assertEquals(model.puzzlePieces.getEmptyTile().getLocation().getCol(), 1);
		// Reset the game and confirm the tile return to its correct location
		dsa.btnReset.doClick();
		assertEquals(model.puzzlePieces.getEmptyTile().getLocation().getRow(), 2);
		assertEquals(model.puzzlePieces.getEmptyTile().getLocation().getCol(), 2);
	}
	
	@Test
	public void winTest()
	{
		Model model = new Model(new TileSet(new NumberedTile[8], new EmptyTile(null)), 0);
		App dsa = new App(model);
		dsa.setVisible(true);
		
		FlipController cont = new FlipController(model, dsa);
		MouseEvent move1 = new MouseEvent(dsa, 100, 100, 100, 169, 276, 1, false);
		MouseEvent move2 = new MouseEvent(dsa, 100, 100, 100, 69, 269, 1, false);
		MouseEvent move3 = new MouseEvent(dsa, 100, 100, 100, 52, 179, 1, false);
		MouseEvent move4 = new MouseEvent(dsa, 100, 100, 100, 176, 144, 1, false);
		MouseEvent move5 = new MouseEvent(dsa, 100, 100, 100, 280, 165, 1, false);
		MouseEvent move6 = new MouseEvent(dsa, 100, 100, 100, 264, 54, 1, false);
		MouseEvent move7 = new MouseEvent(dsa, 100, 100, 100, 185, 62, 1, false);
		MouseEvent move8 = new MouseEvent(dsa, 100, 100, 100, 179, 201, 1, false);
		MouseEvent move9 = new MouseEvent(dsa, 100, 100, 100, 299, 151, 1, false);
		MouseEvent move10 = new MouseEvent(dsa, 100, 100, 100, 266, 66, 1, false);
		MouseEvent move11 = new MouseEvent(dsa, 100, 100, 100, 184, 66, 1, false);
		MouseEvent move12 = new MouseEvent(dsa, 100, 100, 100, 176, 180, 1, false);
		cont.mousePressed(move1);
		cont.mousePressed(move2);
		cont.mousePressed(move3);
		cont.mousePressed(move4);
		cont.mousePressed(move5);
		cont.mousePressed(move6);
		cont.mousePressed(move7);
		cont.mousePressed(move8);
		cont.mousePressed(move9);
		cont.mousePressed(move10);
		cont.mousePressed(move11);
		// cont.mousePressed(move12);
		
			
	}

}
