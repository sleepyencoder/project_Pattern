package graphicsEditor;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GDrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public GDrawingPanel() {
		
		
	}
	
	public void draw() {
		//읏?! 그림이 안 그려지네? 에러는 안 나는데 그림이 안 그려지네?
		//숙제로 해와. 숙제가 많아졌네.
		Graphics graphics = this.getGraphics();
		graphics.drawRect(10, 10, 50, 50);
		
	}

	public void initialize() {
		// TODO Auto-generated method stub
		this.draw();
	}
	
}
