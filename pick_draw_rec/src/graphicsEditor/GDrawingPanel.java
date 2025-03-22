package graphicsEditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JPanel;

class Rect {
	int x, y, w, h;
	public Rect(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
}

public class GDrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private GToolBar toolBar;
	private Vector<Rect> rectList;
	private Point startPoint;
	private Point endPoint;

	public GDrawingPanel(GToolBar toolBar) {
		this.toolBar = toolBar;
		this.rectList = new Vector<>();
		this.setBackground(Color.WHITE);

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (GDrawingPanel.this.toolBar.isRectangleSelected()) { 
					startPoint = e.getPoint();
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (GDrawingPanel.this.toolBar.isRectangleSelected() && startPoint != null) { 
					endPoint = e.getPoint();
					int x = Math.min(startPoint.x, endPoint.x);
					int y = Math.min(startPoint.y, endPoint.y);
					int w = Math.abs(startPoint.x - endPoint.x);
					int h = Math.abs(startPoint.y - endPoint.y);
					rectList.add(new Rect(x, y, w, h));
					repaint();
				}
			}
		});

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for (Rect r : rectList) {
			g.drawRect(r.x, r.y, r.w, r.h);
		}
	}

	public void draw() {}
	public void initialize() {
		this.draw();
	}
}
