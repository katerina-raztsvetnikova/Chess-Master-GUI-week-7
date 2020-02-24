import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameController {
    static Game game; 
    public static ChessBoard board;

    GameController() {
        board = new ChessBoard();
    }

    public static void main(String[] args){
        GameController c = new GameController();
        game = new Game(c);

    }

    public static MouseListener getMouse() {
        MouseListener mouselistener = new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                if(!game.pause) {
                	int newx = (int) ((board.getWidth() * e.getX()) / game.getWidth() ) ;
                    int newy = (int) ((board.getHeight() * (e.getY()-40)) / game.getHeight() );

                    boolean movePiece = e.isShiftDown();
                    if(movePiece) {
                        board.moveSelectedPiece(newx, newy);
                        movePiece = false;
                    }else{
                    	game.mouseX=newx;
                    	game.mouseY=newy;
                        board.mouseX=newx;
                        board.mouseY=newy;
                        Vector<Positions> moves = board.getValidMoves();
                        game.addMoves(moves);
                        game.repaint();
                    }
                }

            }
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        };
        return mouselistener;
    }
    
   public Piece getPieces(int player, char name, int index )
    {
        if(player ==1) {
            return board.getPieces(board.player1, name, index);
        }else {
            return board.getPieces(board.player2, name, index);
        }
    }

    public int getWidth() {
    	return board.getWidth(); 
    }

    public int getHeight(){
    	return board.getHeight(); 
    	}

    public int gameOver() {
        if(board.player1.king.isMoved){
            return 1;

        }else if(board.player2.king.isMoved)
        {
           return 2;
        }else
            return -1;
    }
}
