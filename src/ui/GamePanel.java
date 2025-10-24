package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Bishop;
import model.Board;
import model.King;
import model.Knight;
import model.Pawn;
import model.Pieces;
import model.Queen;
import model.Rook;

//Bàn cờ + các nút bên phải


public class GamePanel extends JPanel implements Runnable {
	// Cho giá trị cho chiều r, chiều d
	final int MAX_WIDTH = 1400;
	final int MAX_HEIGHT = 1000;
	// Cho giá trị khung hình = 60
	final int FPS = 60;
	
	
	Thread gameThread;
	Board board = new Board();
	MouseHandler mouse = new MouseHandler();
	
	
	
	// PIECES
	public static ArrayList<Pieces> pieces = new ArrayList<>();
	public static ArrayList<Pieces> simPieces = new ArrayList<>();
	Pieces activePieces;
	
	// COLOR
	public static final int WHITE = 1;
	public static final int BLACK = 0;
	int currentColor = WHITE;
	
	
	
	
	
	public GamePanel() {
		setPreferredSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));
		setBackground(new Color(0x2E, 0x66, 0x33));
		
		
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		
		
		setPieces();
		copyPices(pieces, simPieces);
		
		
		
		
	}

	public void launchGame() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	// ĐĂT QUÂN CỜ VÀO BÀN
	public void setPieces() {
		
		// WHITE_TEAM
			// PAWN
		pieces.add(new Pawn(WHITE, 0, 6));
		pieces.add(new Pawn(WHITE, 1, 6));
		pieces.add(new Pawn(WHITE, 2, 6));
		pieces.add(new Pawn(WHITE, 3, 6));
		pieces.add(new Pawn(WHITE, 4, 6));
		pieces.add(new Pawn(WHITE, 5, 6));
		pieces.add(new Pawn(WHITE, 6, 6));
		pieces.add(new Pawn(WHITE, 7, 6));
			// KING
		pieces.add(new King(WHITE, 4, 7));
			// QUEEN
		pieces.add(new Queen(WHITE, 3, 7));	
			// BISHOP
		pieces.add(new Bishop(WHITE, 2, 7));
		pieces.add(new Bishop(WHITE, 5, 7));
			// ROOK
		pieces.add(new Rook(WHITE, 0, 7));
		pieces.add(new Rook(WHITE, 7, 7));
			// KNIGHT
		pieces.add(new Knight(WHITE, 1, 7));
		pieces.add(new Knight(WHITE, 6, 7));
		
			// BLACK_TEAM
			// PAWN
		pieces.add(new Pawn(BLACK, 0, 1));
		pieces.add(new Pawn(BLACK, 1, 1));
		pieces.add(new Pawn(BLACK, 2, 1));
		pieces.add(new Pawn(BLACK, 3, 1));
		pieces.add(new Pawn(BLACK, 4, 1));
		pieces.add(new Pawn(BLACK, 5, 1));
		pieces.add(new Pawn(BLACK, 6, 1));
		pieces.add(new Pawn(BLACK, 7, 1));
			// KING
		pieces.add(new King(BLACK, 4, 0));
			// QUEEN
		pieces.add(new Queen(BLACK, 3, 0));	
			// BISHOP
		pieces.add(new Bishop(BLACK, 2, 0));
		pieces.add(new Bishop(BLACK, 5, 0));
			// ROOK
		pieces.add(new Rook(BLACK, 0, 0));
		pieces.add(new Rook(BLACK, 7, 0));
			// KNIGHT
		pieces.add(new Knight(BLACK, 1, 0));
		pieces.add(new Knight(BLACK, 6, 0));
	}
	public void copyPices(ArrayList<Pieces> src, ArrayList<Pieces> target) {
		target.clear();
		for(int i=0; i<src.size();i++) {
			target.add(src.get(i));
		}
	}
	
	
	
	@Override
	public void run() {
		// GAME LOOP
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while (gameThread != null) {
			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;

			if (delta >= 1) {
				update();
				repaint();
				delta--;
			}

		}

	}

	public void update() {
	    if (mouse.clicked) {
	        int clickedCol = (mouse.mouseX - Board.offsetX) / Board.SQUARE_SIZE;
	        int clickedRow = (mouse.mouseY - Board.offsetY) / Board.SQUARE_SIZE;

	        // Kiểm tra có quân nào tại vị trí click
	        Pieces clickedPiece = getPieceAt(clickedCol, clickedRow);

	        if (activePieces == null) {
	            // Lần đầu: chọn quân
	            if (clickedPiece != null && clickedPiece.color == currentColor) {
	                activePieces = clickedPiece;
	            }
	        } else {
	            // Lần hai: nếu click vào ô mới
	            if (clickedPiece == null || clickedPiece.color != activePieces.color) {
	                // Di chuyển quân
	                activePieces.col = clickedCol;
	                activePieces.row = clickedRow;
	                activePieces.x = activePieces.getX(clickedCol);
	                activePieces.y = activePieces.getY(clickedRow);

	                // Đổi lượt
	                currentColor = (currentColor == WHITE) ? BLACK : WHITE;
	            }

	            // Bỏ chọn sau khi di chuyển
	            activePieces = null;
	        }

	        // Chỉ xử lý 1 lần mỗi click
	        mouse.clicked = false;
	    }
	}




	private Pieces getPieceAt(int col, int row) {
	    for (Pieces p : simPieces) {
	        if (p.col == col && p.row == row) {
	            return p;
	        }
	    }
	    return null;
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		board.draw(g2);
		//
		if (activePieces != null) {
		    g2.setColor(new Color(0, 255, 0, 100)); 
		    int highlightX = Board.offsetX + activePieces.col * Board.SQUARE_SIZE;
		    int highlightY = Board.offsetY + activePieces.row * Board.SQUARE_SIZE;
		    g2.fillRect(highlightX, highlightY, Board.SQUARE_SIZE, Board.SQUARE_SIZE);
		}

		// PIECES
		for(Pieces p:simPieces) {
				p.draw(g2);
	        
				
				
	
	    }
		g2.dispose();	
	}
	
	

}
