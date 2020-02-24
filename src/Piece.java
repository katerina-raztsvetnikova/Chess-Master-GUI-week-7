
import java.util.Vector;
public abstract class Piece {
	public Positions positions;
	public boolean isMoved;
	public boolean selected;


	public Piece() {	
		isMoved = false;
		selected = false;
		positions = new Positions(0,0);
	}
	
	public abstract void move(int x, int y);

	
	public abstract boolean canMove(int x, int y, int player, Board [][] g);

    public abstract void skiplMove(String c);

    public abstract Vector<Positions> addMoves(int player, Board[][] g);



}
