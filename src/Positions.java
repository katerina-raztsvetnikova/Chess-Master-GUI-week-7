

public class Positions {
	private int xPos, yPos;
	
	public Positions(int x, int y) {
		xPos=x;
		yPos = y;
	}
	
	public void setCoords(int x, int y){
		xPos = x;
		yPos = y;
	}
	
	public boolean equal(Positions p){
		if(xPos == p.getX() && yPos == p.getY()) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getX(){	
		return xPos;	
		}
	
	public int  getY(){
		return yPos;}
	

}
