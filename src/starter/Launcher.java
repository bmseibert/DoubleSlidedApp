package starter;

import starter.boundary.App;
import starter.model.Cell;
import starter.model.EmptyTile;
import starter.model.Model;
import starter.model.NumberedTile;

public class Launcher {

	public static void main(String[] args) 
	{
		NumberedTile[] pieces = new NumberedTile[8];
		EmptyTile space = new EmptyTile(new Cell(2,2));
		Model m = new Model(pieces, space);
		App dsa = new App();
		
		dsa.setVisible(true);
	}
}
