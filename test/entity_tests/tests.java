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

}
