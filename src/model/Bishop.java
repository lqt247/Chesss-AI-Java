package model;

import java.awt.image.BufferedImage;

import ui.GamePanel;
import utils.ImageLoader;

public class Bishop extends Pieces {
	public Bishop(int color, int col, int row) {
		super(color, col, row);		
		if(color == GamePanel.WHITE) 
		
		{
			image = ImageLoader.load("/accet_pieces/w-bishop-pieces.png");
		}
		else {
			image = ImageLoader.load("/accet_pieces/b-bishop-pieces.png");
			}
		} 
		

}
