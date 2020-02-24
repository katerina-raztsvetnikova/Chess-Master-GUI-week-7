
import java.util.Vector;



public class Knight extends Piece {

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		positions.setCoords(x, y);
		
	}

	@Override
	public boolean canMove(int x, int y, int player, Board[][] g) {
		String opponent = player%2==0 ? "black" : "white";

        Positions end = new Positions(x, y);
        Positions start = new Positions(positions.getX()-1, positions.getY()-2);
        if( helperMove(start, end, opponent, g) )
            return true;

        start.setCoords(positions.getX()+1, positions.getY()-2);
        if( helperMove(start, end, opponent, g) )
            return true;

        start.setCoords(positions.getX()+2, positions.getY()-1);
        if( helperMove(start, end, opponent, g) )
            return true;

        start.setCoords(positions.getX()+2, positions.getY()+1);
        if( helperMove(start, end, opponent, g) )
            return true;

        start.setCoords(positions.getX()+1, positions.getY()+2);
        if( helperMove(start, end, opponent, g) )
            return true;

        start.setCoords(positions.getX()-1, positions.getY()+2);
        if( helperMove(start, end, opponent, g) )
            return true;

        start.setCoords(positions.getX()-2, positions.getY()-1);
        if( helperMove(start, end, opponent, g) )
            return true;

        start.setCoords(positions.getX()-2, positions.getY()+1);
        if( helperMove(start, end, opponent, g) )
            return true;
        else
            return false;


	}

    private boolean helperMove(Positions s, Positions e, String opponent, Board [][] g)
    {
        if( s.getX() == e.getX() && s.getY() == e.getY() && !g[e.getX()][e.getY()].clicked )
            return true;
        else if( s.getX() == e.getX() && s.getY() == e.getY() && g[e.getX()][e.getY()].clicked && g[e.getX()][e.getY()].color.equals(opponent) )
            return true;
        else
            return false;
	}

	@Override
	public void skiplMove(String c) {
		// TODO Auto-generated method stub
		
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
