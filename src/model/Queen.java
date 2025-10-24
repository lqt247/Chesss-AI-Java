package model;

import java.awt.image.BufferedImage;

import ui.GamePanel;
import utils.ImageLoader;

public class Queen extends Pieces {
	public Queen(int color, int col, int row) {
		super(color, col, row);
		if(color == GamePanel.WHITE) 
	
		{
			image = ImageLoader.load("/accet_pieces/w-queen-pieces.png");
		}
		else {
			image = ImageLoader.load("/accet_pieces/b-queen-pieces.png");
			}
		}
		
	}
	

