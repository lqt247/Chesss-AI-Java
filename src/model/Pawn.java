package model;

import java.awt.image.BufferedImage;

import main.GameFrame;
import ui.GamePanel;
import utils.ImageLoader;

public class Pawn extends Pieces {

	public Pawn(int color, int col, int row) {
		super( color,col, row);

		if (color == GamePanel.WHITE) {
			image = ImageLoader.load("/accet_pieces/w-pawn-pieces.png");

		} else {
			image = ImageLoader.load("/accet_pieces/b-pawn-pieces.png");

		}
	}

}
