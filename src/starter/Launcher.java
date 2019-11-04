package starter;

import starter.boundary.App;
import starter.model.Cell;
import starter.model.EmptyTile;
import starter.model.Model;
import starter.model.NumberedTile;
import starter.model.TileSet;

public class Launcher {

	public static void main(String[] args) 
	{
		Model model = new Model(new TileSet(new NumberedTile[8], new EmptyTile(null)));
		App dsa = new App(model);
		
		dsa.setVisible(true);
	}
}
