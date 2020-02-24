import java.util.Vector;

public class ChessBoard implements GameBoard{

   
    public Players player1;
    public Players player2;

	private  final int width = 8;
	private final int height = 8;
	public Board [][] board = new Board[width][height];
    public int mouseX;
    public int mouseY;
    public int rotate;
    private Movement remove;


	public ChessBoard() {

		remove = new Movement();
		rotate=0;
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				board[i][j] = new Board();
			}
		}
	
		player1 = new Players("white", board);
		player2 = new Players("black", board);
	
	}
	
	
	public Piece getPieces(Players player, char name, int index){
		Piece p;
		switch (name) {
        case 'P':
        		if(player == player1)
        			{p= player1.pawn[index];}
        		else
        			{p= player2.pawn[index];}      		
                break;
        case 'R':
    			if(player == player1)
    				{p= player1.rook[index];}
        		else
        			{p= player2.rook[index];} 
    			break;
        case 'H':
        		if(player == player1)
        			{p= player1.knight[index];}
        		else
        			{p= player2.knight[index];}
        		break;
        case 'B':
	    		if(player == player1)
					{p= player1.bishop[index];}
				else
					{p= player2.bishop[index];}      		
		        break;
        case 'Q':
        		if(player == player1)
        			{p= player1.queen;}
        		else
        			{p= player2.queen;}      		
        		break;
        case 'K':
    			if(player == player1)
    				{p= player1.king;}
    			else
    				{p= player2.king;}      		
    			break;
        case 'W':
    			if(player == player1)
    				{p= player1.pawn[index];}
    			else
    				{p= player2.pawn[index];}      		
    			break;
        case 'A':
    			if(player == player1)
    				{p= player1.pawn[index];}
    			else
    				{p= player2.pawn[index];}      		
    			break;
        default : 
        		p = null;
        		System.out.println("Invalid selection");
        		break;
		}


		return p;
	}


    public void moveSelectedPiece(int newX, int newY){
      
        Piece pieceSelected = selection();
        boolean moved = false;

        if(pieceSelected != null){

       
            if(rotate % 2 == 0){
                moved = movePiece(pieceSelected, newX, newY, rotate);

                if(moved){
               
                    board[mouseX][mouseY].clicked= false;
                    board[newX][newY].clicked= true;
                    board[newX][newY].color = "white";

                    Piece clicked = player2.checkClicked(newX, newY);
                    remove.update(pieceSelected, clicked, "white",new Positions(mouseX, mouseY), new Positions(newX, newY) );
                    pieceSelected.selected = false;
                    rotate++;
                }

            }
           
            else{
                moved = player2.movePiece(pieceSelected, newX, newY, rotate, board);
                if(moved){
   
                	board[mouseX][mouseY].clicked= false;
                	board[newX][newY].clicked= true;
                	board[newX][newY].color = "black";

                    Piece clicked = player1.checkClicked(newX, newY);
                    remove.update(pieceSelected, clicked,"black" ,new Positions(mouseX, mouseY), new Positions(newX, newY) );
                    pieceSelected.selected = false;
                    rotate++;
                }
            }
            printBoard();
        }
    }
   
    private Piece selection(){
        if(rotate % 2==0) {
            return player1.validPieceSelected(mouseX, mouseY);
        }else {
            return player2.validPieceSelected(mouseX, mouseY);
        }
    }



    public boolean movePiece(Piece pSelected, int x, int y, int turn ){
        if(turn%2==0) {
            return player1.movePiece(pSelected, x, y, turn, board);
        } else {
            return player2.movePiece(pSelected, x, y, turn, board);
        }
    }

    public Vector<Positions> getValidMoves() {
       Vector<Positions> moves;
        int p;
        if(rotate%2==0) {
            p =0;
        }else {
            p = 1;
        }

       Piece selected = selection();

        if(selected != null) {
           moves = selected.addMoves(p, board);
           return moves;
        }

        return null;

    }

	public void printBoard() {
	}

	public int getWidth()
	{	return width;	}

	public int getHeight()
	{	return height;	}

}

