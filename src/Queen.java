
import java.util.Vector;


public class Queen extends Piece {

	@Override
	public void move(int x, int y) {
		
		positions.setCoords(x, y);
		
	}

	@Override
	public boolean canMove(int x, int y, int player, Board[][] g) {
		 Bishop bis = new Bishop();
	        bis.positions.setCoords(positions.getX(), positions.getY());
	        boolean b = bis.canMove(x, y, player, g);
	        if(!b)
	        {
	            Rook cas = new Rook();
	            cas.positions.setCoords(positions.getX(), positions.getY());
	            boolean c = cas.canMove(x, y ,player, g);
	            return c;
	        }
	        else
	            return true;

	}

	@Override
	public void skiplMove(String c) {
		
	}

	@Override
	public Vector<Positions> addMoves(int player, Board[][] g) {
		 Vector<Positions> values = new Vector<Positions>();

	        for(int i = 0; i < 8;i++ )
	        {
	            for(int j = 0; j < 8;j++)
	            {
	                if( canMove(i, j, player, g) )
	                    values.add(new Positions(i, j) );
	            }
	        }

	        return values;
		
	}

}
