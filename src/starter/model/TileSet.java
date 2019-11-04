package starter.model;
import java.lang.*;

public class TileSet {

	NumberedTile pieces[];
	EmptyTile space;
	
	public TileSet(NumberedTile pieces[], EmptyTile space)
	{
		pieces[0] = new NumberedTile(1, 4, false);
		pieces[1] = new NumberedTile(4, 1, false);
		pieces[2] = new NumberedTile(2, 3, true);
		pieces[3] = new NumberedTile(2, 3, false);
		pieces[4] = new NumberedTile(1, 4, false);
		pieces[5] = new NumberedTile(3, 2, true);
		pieces[6] = new NumberedTile(3, 2, false);
		pieces[7] = new NumberedTile(4, 1, false);
		space = new EmptyTile(new Cell(2,2));
		
		pieces[0].setLocation(new Cell(0,0));
		pieces[1].setLocation(new Cell(0,1));
		pieces[2].setLocation(new Cell(0,2));
		pieces[3].setLocation(new Cell(1,0));
		pieces[4].setLocation(new Cell(1,1));
		pieces[5].setLocation(new Cell(1,2));
		pieces[6].setLocation(new Cell(2,0));
		pieces[7].setLocation(new Cell(2,1));
		
		this.pieces = pieces;
		this.space = space;
	}
	
	public NumberedTile getTileFromCell(Cell location) 
	{
		for(NumberedTile t : this.pieces) {
			if(t.getLocation().row == location.row && t.getLocation().col == location.col) {
				return t;
			}
		}
		//TODO fix this later
		return null;
	}
	
	public NumberedTile[] getPieces() {return pieces;}
	public EmptyTile getEmptyTile() {return space;}
	
	
	public EmptyTile hasEmptyNeighbor(NumberedTile aTile) 
	{
		int col_diff = 0;
		int row_diff = 0;
		
		
			col_diff = Math.abs(aTile.getLocation().col - this.space.getLocation().col);
			row_diff = Math.abs(aTile.getLocation().row - this.space.getLocation().row);
			if((col_diff + row_diff) > 1)
			{
				//Empty Tile is not a neighbor
			}
			else 
			{
				//Empty Tile is a neighbor
				return this.space;
			}
		
		return null;
	}
	
	public void switchTileAndSpace(NumberedTile aTile) 
	{
		Cell old_loc = aTile.getLocation();
		aTile.setLocation(this.space.location);
		this.space.setLocation(old_loc);
		aTile.flipped = !(aTile.flipped); // change Flipped Status
	}
	
}
