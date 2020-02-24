
import java.util.Vector;

public class Pawn extends Piece {
private boolean firstMove;
	
	public Pawn(){
		firstMove = true;
	}

	@Override
	public void move(int x, int y) {
		positions.setCoords(x, y);
		firstMove = false;
		
	}

	@Override
	public boolean canMove(int x, int y, int player, Board[][] g) {
		if(player%2 == 0)
		{
			if(firstMove )
			{
				if(positions.getX() == x && positions.getY()-2 ==y && !g[x][y].clicked)
					return true;
				else if(positions.getX() == x && positions.getY()-1 ==y && !g[x][y].clicked)
					return true;
				else if(positions.getX()-1 ==x && positions.getY()-1 == y && g[x][y].clicked && g[x][y].color.equals("black"))
					return true;
				else if(positions.getX()+1 ==x && positions.getY()-1 == y && g[x][y].clicked && g[x][y].color.equals("black"))
					return true;
				else 
					return false;
			}
			else
			{
				if(positions.getX() == x && positions.getY()-1 ==y && !g[x][y].clicked)
					return true;
				else if(positions.getX()-1 ==x && positions.getY()-1 == y && g[x][y].clicked && g[x][y].color.equals("black"))
					return true;
				else if(positions.getX()+1 ==x && positions.getY()-1 == y && g[x][y].clicked && g[x][y].color.equals("black"))
					return true;
				else 
					return false;
			}
		}
		else if(player%2 != 0){
			if(firstMove){
				if(positions.getX() == x && positions.getY()+2 ==y && !g[x][y].clicked) {
					return true;
				}else if(positions.getX() == x && positions.getY()+1 ==y && !g[x][y].clicked) {
					return true;
				}else if(positions.getX()-1 ==x && positions.getY()+1 == y && g[x][y].clicked && g[x][y].color.equals("white")) {
					return true;
				}else if(positions.getX()+1 ==x && positions.getY()+1 == y && g[x][y].clicked && g[x][y].color.equals("white")) {
					return true;
				}else{
					return false;
				}
				}else{
				if(positions.getX() == x && positions.getY()+1 ==y && !g[x][y].clicked) {
					return true;
				}else if(positions.getX()-1 ==x && positions.getY()+1 == y && g[x][y].clicked && g[x][y].color.equals("white")) {
					return true;
				}else if(positions.getX()+1 ==x && positions.getY()+1 == y && g[x][y].clicked && g[x][y].color.equals("white")) {
					return true;
		}else {
			return false;
			}
		}
	}
		return false;
}

	@Override
	public void skiplMove(String c) {
		if(c.equals("white")){
            if(positions.getY() == 6) {
                firstMove = true;
            }
        }else{
            if(positions.getY() == 1) {
                firstMove = true;
            }
        }

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
