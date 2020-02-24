public class Movement {
	private Piece movedP;
    private Piece clickedP;
    private Positions prevPositions;
    private Positions newPositions;
    private String color;

    Movement(){
        prevPositions = new Positions(-1, -1);
        newPositions = new Positions(-1, -1);
    }

    public void update(Piece p, Piece e, String c, Positions old, Positions newP){
    	clickedP = e;
        movedP = p;
        prevPositions.setCoords(old.getX(), old.getY());
        newPositions.setCoords(newP.getX(), newP.getY());
        color = c;
    }

    public void movePrev(Board [][] g) {
        movedP.positions.setCoords(prevPositions.getX(), prevPositions.getY());
        movedP.skiplMove(color);

        g[newPositions.getX()][newPositions.getY()].clicked = false;
        g[prevPositions.getX()][prevPositions.getY()].clicked = true;
        g[prevPositions.getX()][prevPositions.getY()].color = color;

        if(clickedP != null) {
            String opponent = color.equals("white") ? "black" : "white";
            clickedP.isMoved = false;
            g[newPositions.getX()][newPositions.getY()].clicked = true;
            g[newPositions.getX()][newPositions.getY()].color = opponent;
        }

    }

}
