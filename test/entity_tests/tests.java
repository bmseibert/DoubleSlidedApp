package entity_tests;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
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
		NumberedTile blackTileToFlip = pieces.getTileFromCell(new Cell(2,1));
		pieces.switchTileAndSpace(greyTileToFlip);
		
		// Check that the empty tile has changed locations with the selected numbered tile
		assertEquals(pieces.getEmptyTile().getLocation().getCol(), 2);
		assertEquals(pieces.getEmptyTile().getLocation().getRow(), 1);
		
		
		
		assertEquals(blackTileToFlip.getLocation().getCol(), 2);
		assertEquals(blackTileToFlip.getLocation().getRow(), 2);
	}

}
