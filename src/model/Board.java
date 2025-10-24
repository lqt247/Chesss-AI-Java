package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Board {
	final int MAX_COL = 8;
	final int MAX_ROW = 8;
	public static final int SQUARE_SIZE = 100;
	public static final int HALF_SQUARE_SIZE = SQUARE_SIZE/2;
	 public static int offsetX = 100;
     public static int offsetY = 100;
	
	
public void draw(Graphics2D g2) {
   
        for (int row = 0; row < MAX_ROW; row++) {
            for (int col = 0; col < MAX_COL; col++) {
                if ((row + col) % 2 == 0)
                	 g2.setColor(new Color(0xE0, 0x9C, 0x31)); 
                else
                	  g2.setColor(new Color(0xA2, 0x3D, 0x48)); 
                
          
                g2.fillRect( offsetX+ col * SQUARE_SIZE, offsetY+ row * SQUARE_SIZE , SQUARE_SIZE,SQUARE_SIZE);
            }
        }

}
	
	
}
