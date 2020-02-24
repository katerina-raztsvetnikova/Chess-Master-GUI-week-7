import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {

	public BufferedImage whitePawn;
	public BufferedImage whiteRook;
	public BufferedImage whiteKnight;
	public BufferedImage whiteBishop;
	public BufferedImage whiteQueen;
	public BufferedImage whiteKing;
	public BufferedImage blackPawn;
	public BufferedImage blackRook;
	public BufferedImage blackKnight;
	public BufferedImage blackBishop;
	public BufferedImage blackQueen;
	public BufferedImage blackKing;
	
	public Images() {
		
		try {
			whitePawn = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\Chess_plt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		try {
			whiteRook = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\75px-Chess_rlt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			whiteKnight = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\75px-Chess_nlt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		try {
			whiteBishop = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\Chess_blt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			whiteQueen = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\75px-Chess_qlt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			whiteKing = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\Chess_klt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		try {
			whitePawn = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\Chess_plt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			whitePawn = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\Chess_plt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		

		try {
			blackPawn = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\75px-Chess_pdt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			blackRook = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\75px-Chess_rdt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		try {
			blackKnight = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\75px-Chess_ndt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		try {
			blackBishop = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\75px-Chess_bdt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		try {
			blackQueen = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\75px-Chess_qdt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		try {
			blackKing = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\75px-Chess_kdt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		try {
			blackPawn = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\75px-Chess_pdt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		try {
			blackPawn = ImageIO.read(new File("D:\\Programming\\Java-Eclipse\\Chess Master GUI\\Chess Pieces\\75px-Chess_pdt45.svg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
