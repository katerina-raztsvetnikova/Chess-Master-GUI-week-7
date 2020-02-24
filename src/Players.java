public class Players {
	public Pawn pawn []= new Pawn[4];
	public Rook rook [] = new Rook[2];
	public Knight knight [] = new Knight[2];
	public Bishop bishop [] = new Bishop[2];
	public King king;
	public Queen queen;
	public String color;
		
	public Players(String type, Board [][] board){
		color = type;
		if(type.equals("white")){
			setupWhitePieces(board);
		}else{
			setupBlackPieces(board);
		}
	}

	private void setupWhitePieces(Board [][] g) {	
	
		for(int i = 0; i < pawn.length; i++){
			pawn[i]= new Pawn();
			pawn[i].positions.setCoords(i+2, 6);
			g[i+2][6].color="white";
			g[i+2][6].clicked = true;
		}
	
		for(int i = 0; i < 2; i++){
			rook[i] = new Rook();
			if(i == 0){
				rook[i].positions.setCoords(0, 7);
				g[0][7].color="white";
				g[0][7].clicked = true;
			}else{
				rook[i].positions.setCoords(7, 7);
				g[7][7].color="white";
				g[7][7].clicked = true;
			}
		}
		
		
		for(int i = 0; i < 2; i++){
			knight[i] = new Knight();
			if(i == 0){
				knight[i].positions.setCoords(1, 7);
				g[1][7].color="white";
				g[1][7].clicked = true;
			}else{
				knight[i].positions.setCoords(6, 7);
				g[6][7].color="white";
				g[6][7].clicked = true;
			}
		}
		
		for(int i = 0; i < 2; i++){
			bishop[i] = new Bishop();
			if(i == 0){
				bishop[i].positions.setCoords(2, 7);
				g[2][7].color="white";
				g[2][7].clicked = true;
			}else{
				bishop[i].positions.setCoords(5, 7);
				g[5][7].color="white";
				g[5][7].clicked = true;
			}
		}
		
		king = new King();
		king.positions.setCoords(4, 7);
		g[4][7].color="white";
		g[4][7].clicked = true;
				
		queen = new Queen();
		queen.positions.setCoords(3, 7);
		g[3][7].color="white";
		g[3][7].clicked = true;	
	}
	
	private void setupBlackPieces(Board[][] g){

		for(int i = 0; i < pawn.length; i++){
			pawn[i]= new Pawn();
			pawn[i].positions.setCoords(i+2, 1);
			g[i+2][1].color="black";
			g[i+2][1].clicked = true;
		}
			
		for(int i = 0; i < 2; i++){
			rook[i] = new Rook();
			if(i == 0){
				rook[i].positions.setCoords(0, 0);
				g[0][0].color="black";
				g[0][0].clicked = true;
			}else{
				rook[i].positions.setCoords(7, 0);
				g[7][0].color="black";
				g[7][0].clicked = true;
			}
		}
			
		for(int i = 0; i < 2; i++){
			knight[i] = new Knight();
			if(i == 0){
				knight[i].positions.setCoords(1, 0);
				g[1][0].color="black";
				g[1][0].clicked = true;
			}else{
				knight[i].positions.setCoords(6, 0);
				g[6][0].color="black";
				g[6][0].clicked = true;
			}
		}
			
		for(int i = 0; i < 2; i++){
			bishop[i] = new Bishop();
			if(i == 0){
				bishop[i].positions.setCoords(2, 0);
				g[2][0].color="black";
				g[2][0].clicked = true;
			}else{
				bishop[i].positions.setCoords(5, 0);
				g[5][0].color="black";
				g[5][0].clicked = true;
			}
		}
			
		king = new King();
		king.positions.setCoords(4, 0);
		g[4][0].color="black";
		g[4][0].clicked = true;
				
		queen = new Queen();
		queen.positions.setCoords(3, 0);
		g[3][0].color="black";
		g[3][0].clicked = true;
				
	}

	public Piece validPieceSelected(int mouseX, int mouseY){
		
		for(int i = 0; i < pawn.length; i++){	
			if( (mouseX == pawn[i].positions.getX()) && (mouseY == pawn[i].positions.getY()) ){
				pawn[i].selected = true;
				return pawn[i];
			}
		}
		
		for(int i = 0; i < pawn.length; i++){	
			if( (mouseX == pawn[i].positions.getX()) && (mouseY == pawn[i].positions.getY()) ){
				pawn[i].selected = true;
				return pawn[i];
			}
		}
		
		for(int i = 0; i < rook.length; i++){	
			if( (mouseX == rook[i].positions.getX()) && (mouseY == rook[i].positions.getY()) ){
				rook[i].selected = true;
				return rook[i];
			}
		}
		
		for(int i = 0; i < knight.length; i++){	
			if( (mouseX == knight[i].positions.getX()) && (mouseY == knight[i].positions.getY()) ){
				knight[i].selected = true;
				return knight[i];
			}
		}
		
		for(int i = 0; i < bishop.length; i++){	
			if( (mouseX == bishop[i].positions.getX()) && (mouseY == bishop[i].positions.getY()) ){
				bishop[i].selected = true;
				return bishop[i];
			}
		}
		for(int i = 0; i < pawn.length; i++){	
			if( (mouseX == pawn[i].positions.getX()) && (mouseY == pawn[i].positions.getY()) ){
				pawn[i].selected = true;
				return pawn[i];
			}
		}
		
		if( (mouseX == queen.positions.getX()) && (mouseY == queen.positions.getY()) ){
			queen.selected = true;
			return queen;
		}
		if( (mouseX == king.positions.getX()) && (mouseY == king.positions.getY()) ){
			king.selected = true;
			return king;
		}
		return null;
	}


	public boolean movePiece(Piece p, int newX, int newY, int player, Board[][] g){
		
		if(p.canMove(newX, newY, player, g)){
			p.move(newX, newY);
			return true;
		}
			return false;
	}
	
	public Piece checkClicked(int newX, int newY){
		for(int i = 0; i < pawn.length; i++){	
			if((newX == pawn[i].positions.getX()) && (newY == pawn[i].positions.getY())){
				pawn[i].isMoved = true;
				return pawn[i];
			}
		}
		
		for(int i = 0; i < pawn.length; i++){
			if((newX == pawn[i].positions.getX()) && (newY == pawn[i].positions.getY())){
				pawn[i].isMoved = true;
				return pawn[i];
			}
		}		

	
		for(int i = 0; i < pawn.length; i++){
			if((newX == pawn[i].positions.getX()) && (newY == pawn[i].positions.getY())){
				pawn[i].isMoved = true;
				return pawn[i];
			}
		}		
		
		for(int i = 0; i < rook.length; i++){
			if((newX == rook[i].positions.getX()) && (newY == rook[i].positions.getY())){
				rook[i].isMoved = true;
				return rook[i];
			}
		}
		
		for(int i = 0; i < knight.length; i++){
			if((newX == knight[i].positions.getX()) && (newY == knight[i].positions.getY())){
				knight[i].isMoved = true;
				return knight[i];
			}
		}
		
		for(int i = 0; i < bishop.length; i++){
			if((newX == bishop[i].positions.getX()) && (newY == bishop[i].positions.getY())){
				bishop[i].isMoved = true;
				return bishop[i];
			}

		}
			
		if((newX == king.positions.getX()) && (newY == king.positions.getY())){
			king.isMoved = true;
			return king;
		}

		if((newX == queen.positions.getX()) && (newY == queen.positions.getY())){
			queen.isMoved = true;
			return queen;
		}

        return null;
	}
}
