package main;

import javax.swing.JFrame;

import ui.GamePanel;

//JFrame chính, chứa toàn bộ UI

public class GameFrame extends JFrame{
	 public GameFrame() {
	JFrame window = new JFrame("Chess-AI");
	window.setResizable(false);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	// THÊM GP vào WINDOW
	GamePanel gp = new GamePanel();
	window.add(gp);	
	window.pack();
	
	
	
	
	window.setLocationRelativeTo(null);
	window.setVisible(true);
	
	
	
	
	// LAUNCH GAME
	gp.launchGame();
	
	
	
	
	
	
	
	 }
}
