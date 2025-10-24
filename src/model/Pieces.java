package model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Pieces {
    public BufferedImage image;
    public int col, row, preCol, preRow;
    public int color;
    public int x, y;

    public Pieces(int color, int col, int row) {
        this.color = color;
        this.col = col;
        this.row = row;
        x = getX(col);
        y = getY(row);
    }

    public int getX(int col) {
        return Board.offsetX + col * Board.SQUARE_SIZE;
    }

    public int getY(int row) {
        return Board.offsetY + row * Board.SQUARE_SIZE;
    }
    public int getCol(int x) {
    	return (x + Board.HALF_SQUARE_SIZE/Board.SQUARE_SIZE);
    }
    public int getRow(int y) {
    	return( y + Board.HALF_SQUARE_SIZE/Board.SQUARE_SIZE);
    }
    public void draw(Graphics2D g2) {
        if (image != null)
            g2.drawImage(image, x, y, Board.SQUARE_SIZE,
            		Board.SQUARE_SIZE, null);
    }
}
