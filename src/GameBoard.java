public interface GameBoard {
	
	public Piece getPieces(Players player, char name, int index);

    public void moveSelectedPiece(int newX, int newY);

    public void printBoard();

}
