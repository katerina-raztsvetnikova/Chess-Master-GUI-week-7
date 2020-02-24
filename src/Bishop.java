

import java.util.Vector;

public class Bishop extends Piece {

	@Override
	public void move(int x, int y) {
		positions.setCoords(x, y);
		
	}

	@Override
	public boolean canMove(int x, int y, int player, Board[][] g) {
		if(positions.getX() == x || positions.getY() == y) {
			return false;
		}

		int direction = getDirection(x, y);
		Positions end = new Positions(x, y);
		Positions start = new Positions(positions.getX(), positions.getY());
		
			if(player%2 == 0){ 
			return test(start, end,"black", direction, g, 0);
		}
		else if(player%2 != 0){
			return test(start, end, "white", direction, g, 0);
		}
		
	
		return true;
	}
	
	private int getDirection(int x, int y){
		if(x > positions.getX()){
			if(y >positions.getY()){
				return 2;
			}
			else{
				return 1;
			}	
		}
		else{
			if(y >positions.getY()){
				return 3;
			}
			else{
				return 4;
			}	
		}
	
	}

	private boolean test(Positions s, Positions e, String player, int direction, Board [][] g, int count){
		
		if(s.equal(e) && !g[e.getX()][e.getY()].clicked)
			return true;
		else if(s.equal(e) && g[e.getX()][e.getY()].clicked && g[e.getX()][e.getY()].color.equals(player))
			return true;
		else if(g[s.getX()][s.getY()].clicked && count > 0)
			return false;
		else
		{
			if(direction == 1)
			{
				s.setCoords(s.getX()+1, s.getY()-1);
				if(s.getX() > e.getX() || s.getY() < e.getY())
					return false;
				return test(s, e, player, direction, g, 1);
			}
			else if(direction == 2)
			{
				s.setCoords(s.getX()+1, s.getY()+1);
				if(s.getX() > e.getX() || s.getY() > e.getY())
					return false;
				return test(s, e, player, direction, g, 1);
			}
			else if(direction == 3)
			{
				s.setCoords(s.getX()-1, s.getY()+1);
				if(s.getX() < e.getX() || s.getY() > e.getY())
					return false;
				return test(s, e, player, direction, g,1);
			}
			else
			{
				s.setCoords(s.getX()-1, s.getY()-1);
				if(s.getX() < e.getX() || s.getY() < e.getY())
					return false;
				return test(s, e, player, direction, g,1);
			}
		}
	}

	@Override
	public void skiplMove(String c) {
	
	}
		

	@Override
	public Vector<Positions> addMoves(int player, Board[][] g) {
		 Vector<Positions> values = new Vector<Positions>();

	        for(int i = 0; i < 8;i++ ){
	            for(int j = 0; j < 8;j++){
	                if( canMove(i, j, player, g) ) {
	                    values.add(new Positions(i, j) );
	                }
	            }
	        }

	      return values;	
	}

}
