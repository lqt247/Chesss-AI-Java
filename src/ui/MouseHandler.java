package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
	public int mouseX, mouseY;
	public boolean clicked;

	@Override
	public void mousePressed(MouseEvent e) {
		mouseX= e.getX();
		mouseY= e.getY();
		clicked = true;
	}

	public void mouseReleased(MouseEvent e) {
		clicked = false;
	}


}
