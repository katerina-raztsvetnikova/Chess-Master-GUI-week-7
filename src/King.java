
import java.util.Vector;


public class King extends Piece{

	@Override
	public void move(int x, int y) {
		positions.setCoords(x, y);	
	}

	@Override
	public boolean canMove(int x, int y, int player, Board[][] g) {
		String opponent = player%2==0 ? "black" : "white";


        if(positions.getX()-1 ==x && positions.getY() == y && (!g[x][y].clicked || g[x][y].color.equals(opponent)) )
            return true;
        else if(positions.getX()+1 ==x && positions.getY() == y && (!g[x][y].clicked || g[x][y].color.equals(opponent)) )
            return true;
        else if(positions.getX() ==x && positions.getY()+1 == y && (!g[x][y].clicked || g[x][y].color.equals(opponent)) )
            return true;
        else if(positions.getX() ==x && positions.getY()-1 == y && (!g[x][y].clicked || g[x][y].color.equals(opponent)) )
            return true;
        else if(positions.getX()+1 ==x && positions.getY()+1 == y && (!g[x][y].clicked || g[x][y].color.equals(opponent)) )
            return true;
        else if(positions.getX()-1 ==x && positions.getY()+1 == y && (!g[x][y].clicked || g[x][y].color.equals(opponent)) )
            return true;
        else if(positions.getX()+1 ==x && positions.getY()-1 == y && (!g[x][y].clicked || g[x][y].color.equals(opponent)) )
            return true;
        else if(positions.getX()-1 ==x && positions.getY()-1 == y && (!g[x][y].clicked || g[x][y].color.equals(opponent)) )
            return true;
        else
            return false;
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
