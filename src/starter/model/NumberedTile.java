package starter.model;

public class NumberedTile extends Tile{

	final int topNum;
	final int bottomNum;
	boolean flipped; //True if bottom Number is visible
	
	/** NumberedTile() is the constructor for the NumberedTile class
	 */
	public NumberedTile(int topNum, int bottomNum, boolean flipped){
		this.bottomNum = bottomNum;
		this.topNum = topNum;
		this.flipped = flipped;
	}
	
	/** getVisibleNum() determines the number the the tile 
	 * is currently displayed to the player based on the flip state
	 * @param none
	 * @return int result, the number shown to the player
	 */
	public int getVisibleNum() 
	{
		int result;
		if(flipped) 
		{
			result = bottomNum;
		}
		else 
		{
			result = topNum;
		}
		return result;
	}
	
	/** getFlipStatus is a getter for the flipped attribute which determines which side
	 * of the tile is shown to the player
	 * @param none
	 * @return boolean flipped, the flipped attribute of the tile
	 */
	public boolean getFlipStatus() {return flipped;}
	
	public void setFlipStatus(boolean newStatus) {this.flipped = newStatus;}
}
