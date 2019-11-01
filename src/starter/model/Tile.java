package starter.model;

public abstract class Tile 
{

	Cell location;
	
	public void setLocation(Cell acell) { location = acell; }
	public Cell getLocation() {return location;}
}
