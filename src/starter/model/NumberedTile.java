package starter.model;

public class NumberedTile extends Tile{

	final int topNum;
	final int bottomNum;
	boolean flipped; //True if bottom Number is visible
	
	NumberedTile(int topNum, int bottomNum, boolean flipped){
		this.bottomNum = bottomNum;
		this.topNum = topNum;
		this.flipped = flipped;
	}
	
	public int getVisibleNum() 
	{
		if(flipped) 
		{
			return bottomNum;
		}
		else 
		{
			return topNum;
		}
	}
	
	public boolean getFlipStatus() {return flipped;}
}
