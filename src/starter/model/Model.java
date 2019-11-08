package starter.model;

public class Model {

	public TileSet puzzlePieces;
	int totalNumMoves;
	
	public Model(TileSet puzzlePieces, int totalNumMoves) 
	{	
		this.puzzlePieces = puzzlePieces;
		this.totalNumMoves = totalNumMoves ;
	}
	
	/** 
	 * 
	 */
	public int getTotalNumMoves() {return totalNumMoves;}
	public void setTotalNumMoves(int newTotal) {this.totalNumMoves = newTotal;}
}
