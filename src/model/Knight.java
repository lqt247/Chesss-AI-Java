package model;

import java.awt.image.BufferedImage;

import ui.GamePanel;
import utils.ImageLoader;

public class Knight extends Pieces {
	public Knight(int color, int col, int row) {
		super(color, col, row);
	
		if(color == GamePanel.WHITE) 
		{
			image = ImageLoader.load("/accet_pieces/w-knight-pieces.png");
		}
		else {
			image = ImageLoader.load("/accet_pieces/b-knight-pieces.png");
		}
	}
	}

