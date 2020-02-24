import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class Game extends JPanel{

	 public int mouseX, mouseY;
	    public boolean pause;
	    private Images pieces;
	    private int xSize, ySize;
	    private GameController controller;
	    private static JFrame frame; 
	    private static JFrame info;
	    private static JFrame scoreBoard;
	    private String p1Name;
	    private String p2Name;
	    private int p1Score;
	    private int p2Score;
	    private Vector<Positions>moves;


	    public Game(GameController c)
	    {
	        initializeBoard();
	        controller = c;
	        p1Score = 0;
	        p2Score = 0;

	        windowFrame();
	        setupNames();
	    }

	    private void setupNames() {
	        info = new JFrame("");
	        info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        JLabel p1 = new JLabel("Player 1: ");
	        final JLabel p2 = new JLabel("Player 2: ");

	        final JTextField player1 = new JTextField("Name", 10);
	        final JTextField player2 = new JTextField("Name", 10);

	        Container content = info.getContentPane();
	        SpringLayout layout = new SpringLayout();
	        content.setLayout(layout);

	        Dimension s1 = player1.getPreferredSize();
	        Dimension s2 = player2.getPreferredSize();
	        player1.setBounds(100, 20 , s1.width, s1.height);
	        player2.setBounds(100, 50, s2.width, s2.height);
	        content.add(p1);
	        content.add(player1);
	        content.add(p2);
	        content.add(player2);

	        SpringLayout.Constraints  labelCons =
	                layout.getConstraints(p1);
	        labelCons.setX(Spring.constant(10));
	        labelCons.setY(Spring.constant(20));


	        SpringLayout.Constraints textFieldCons =
	                layout.getConstraints(player1);
	        textFieldCons.setX(Spring.sum(Spring.constant(10),
	                labelCons.getConstraint(SpringLayout.EAST)));
	        textFieldCons.setY(Spring.constant(10));

	        SpringLayout.Constraints  labelCon =
	                layout.getConstraints(p2);
	        labelCon.setX(Spring.constant(10));
	        labelCon.setY(Spring.constant(50));


	        SpringLayout.Constraints textFieldCon =
	                layout.getConstraints(player2);
	        textFieldCon.setX(Spring.sum(Spring.constant(10),
	                labelCons.getConstraint(SpringLayout.EAST)));
	        textFieldCon.setY(Spring.constant(50));


	        JButton submit = new JButton("Start game");
	        content.add(submit);

	        SpringLayout.Constraints buttonCon =
	                layout.getConstraints(submit);
	       buttonCon.setX(Spring.sum(Spring.constant(20),
	                labelCons.getConstraint(SpringLayout.EAST)));
	        buttonCon.setY(Spring.constant(100));

	        submit.addActionListener(new ActionListener()
	        {
	            public void actionPerformed (ActionEvent e)
	            {
	                p1Name = player1.getText();
	                p2Name = player2.getText();
	                info.dispose();
	                setupPlayers();
	            }
	        });
	        info.setSize(250, 250);
	        info.setLocation(560,0);
	        info.setVisible(true);
	    }

	    private void setupPlayers()   {
	        scoreBoard = new JFrame();
	        scoreBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        JLabel p1 = new JLabel("Player 1: "+ p1Name);
	        JLabel p2 = new JLabel("Player 2: "+ p2Name);
	        JLabel p1s = new JLabel(""+p1Score);
	        JLabel p2s = new JLabel(""+p2Score);

	        Container content = scoreBoard.getContentPane();
	        SpringLayout layout = new SpringLayout();
	        content.setLayout(layout);

	        content.add(p1);
	        content.add(p2);
	        content.add(p1s);
	        content.add(p2s);

	        SpringLayout.Constraints  labelCons =
	                layout.getConstraints(p1);
	        labelCons.setX(Spring.constant(5));
	        labelCons.setY(Spring.constant(25));

	        SpringLayout.Constraints  labelCon =
	                layout.getConstraints(p2);
	        labelCon.setX(Spring.constant(5));
	        labelCon.setY(Spring.constant(75));

	        SpringLayout.Constraints  scoreCons =
	                layout.getConstraints(p1s);
	        scoreCons.setX(Spring.constant(50));
	        scoreCons.setY(Spring.constant(50));

	        SpringLayout.Constraints  scoreCon =
	                layout.getConstraints(p2s);
	        scoreCon.setX(Spring.constant(50));
	        scoreCon.setY(Spring.constant(100));

	        scoreBoard.setSize(250, 250);
	        scoreBoard.setLocation(560, 0);
	        scoreBoard.setVisible(true);
	    }

	    public void updateScore(int turn)
	    {
	        if(turn%2== 0)
	            p2Score++;
	        else
	            p1Score++;
	        setupPlayers();
	    }
	    public void initializeBoard()
	    {

	        pieces = new Images();
	        pause = false;
	    }


	    private void windowFrame() {
	        frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.add(this);
	        frame.setSize(800,800);
	        frame.addMouseListener(controller.getMouse());
	        frame.setVisible(true);
	    }


	    public void paint(Graphics g)
	    {
	        boardBackground(g);
	        possibleMovements(g);
	        displayPieces(g);
	        repaint();
	    }  
	    private void boardBackground(Graphics g){

	        xSize=( getWidth() / controller.getWidth());
	        ySize=( getHeight()/ controller.getHeight());

	        int count = 0;

	        for(int i=0; i< controller.getWidth();i++)
	        {
	            for (int j=0; j<controller.getHeight(); j++)
	            {
	                if(count%2==0)
	                {
	                    g.setColor(Color.WHITE);
	                    g.fillRect(i * xSize, j * ySize, xSize, ySize);
	                }
	                else
	                {
	                    g.setColor(Color.BLACK);
	                    g.fillRect(i * xSize, j * ySize, xSize, ySize);
	                }
	                count++;
	            }
	            count++;
	        }
	        g.setColor(Color.red);
	        g.drawRect(mouseX * xSize, mouseY * ySize, xSize, ySize);
	    }
	   
  private void displayPieces(Graphics g) {

	        getPieces(g, 1, 'P', 4);
	        getPieces(g, 1, 'R', 2);
	        getPieces(g, 1, 'B', 2);
	        getPieces(g, 1, 'H', 2);
	        getPieces(g, 1, 'K', 1);
	        getPieces(g, 1, 'Q', 1);
	        getPieces(g, 1, 'W', 2);
	        getPieces(g, 1, 'A', 2);
	  
	        getPieces(g, 2, 'P', 4);
	        getPieces(g, 2, 'R', 2);
	        getPieces(g, 2, 'B', 2);
	        getPieces(g, 2, 'H', 2);
	        getPieces(g, 2, 'K', 1);
	        getPieces(g, 2, 'Q', 1);
	        getPieces(g, 2, 'W', 2);
	        getPieces(g, 2, 'A', 2);       
	    }

	    private void getPieces(Graphics g, int player, char name, int numElements){

	        Image img;
	        switch (name) {
	            case 'P':
	                if(player == 1)
	                {img = pieces.whitePawn;}
	                else
	                {img = pieces.blackPawn;}
	                break;
	            case 'R':
	                if(player ==1)
	                    img = pieces.whiteRook;
	                else
	                    img = pieces.blackRook;
	                break;
	            case 'H':
	                if(player == 1)
	                    img = pieces.whiteKnight;
	                else
	                    img = pieces.blackKnight;
	                break;
	            case 'B':
	                if(player == 1)
	                    img = pieces.whiteBishop;
	                else
	                    img = pieces.blackBishop;
	                break;
	            case 'Q':
	                if(player == 1)
	                    img = pieces.whiteQueen;
	                else
	                    img = pieces.blackQueen;
	                break;
	            case 'K':
	                if(player == 1)
	                    img = pieces.whiteKing;
	                else
	                    img = pieces.blackKing;
	                break;
	            case 'W':
	                if(player == 1)
	                    img = pieces.whitePawn;
	                else
	                    img = pieces.blackPawn;
	                break;
	            case 'A':
	                if(player == 1)
	                    img = pieces.whitePawn;
	                else
	                    img = pieces.blackPawn;
	                break;
	            default :
	                img = pieces.whitePawn;
	                break;
	        }
	     
	        for(int i = 0; i < numElements; i++) {

	            Piece p = controller.getPieces(player, name, i);
	        
	            if(p != null && !p.isMoved ) {
	                g.drawImage(img, xSize*p.positions.getX()+7, ySize*p.positions.getY(), null);
	            }
	        }
	    }

	    public void addMoves(Vector<Positions> moves){

	        this.moves = moves;
    }

	    public void possibleMovements(Graphics g) {
	        if(moves != null)    {
	            for(int i = 0; i < moves.size(); i++)  {
	                Positions p = moves.elementAt(i);
	               
	                g.setColor(Color.red);
	                g.fillRect(p.getX() * xSize, p.getY() * ySize, xSize, ySize);
	            }
	        }
	    }
}
