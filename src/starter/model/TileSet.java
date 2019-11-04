package starter.model;

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
	
}
