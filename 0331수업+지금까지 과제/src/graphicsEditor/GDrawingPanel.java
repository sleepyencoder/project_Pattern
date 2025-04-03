// Class_0331/src/graphicsEditor/GDrawingPanel.java
package graphicsEditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javax.swing.JPanel;

class Rect {
	int x, y, w, h;
	public Rect(int x, int y, int w, int h) {
		this.x = x; this.y = y; this.w = w; this.h = h;
	}
}

public class GDrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Vector<Rect> rectList = new Vector<>();
	private Point startPoint, endPoint, prevPoint;
	private Rect selectedRect = null;
	private GToolBar toolBar;
	private int x1, y1, x2, y2;

	public GDrawingPanel(GToolBar toolBar) {
		this.toolBar = toolBar;
		this.setBackground(Color.WHITE);
		MouseHandler mouseHandler = new MouseHandler();
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
	}

	public void initialize() {}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for (Rect r : rectList) g.drawRect(r.x, r.y, r.w, r.h);
	}

	public void draw(int x, int y, int w, int h) {
		Graphics2D graphics = (Graphics2D) this.getGraphics();
		graphics.setXORMode(getBackground());
		graphics.drawRect(x, y, w, h);
	}

	private Rect getRectAt(Point p) {
		for (int i = rectList.size() - 1; i >= 0; i--) {
			Rect r = rectList.get(i);
			if (p.x >= r.x && p.x <= r.x + r.w && p.y >= r.y && p.y <= r.y + r.h)
				return r;
		}
		return null;
	}

	private class MouseHandler implements MouseListener, MouseMotionListener {
		@Override
		public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();
			if (toolBar.isRectangleSelected()) {
				x1 = e.getX();
				y1 = e.getY();
				x2 = x1;
				y2 = y1;
			} else {
				selectedRect = getRectAt(p);
				if (selectedRect != null) prevPoint = p;
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (toolBar.isRectangleSelected()) {
				draw(x1, y1, x2 - x1, y2 - y1);
				x2 = e.getX();
				y2 = e.getY();
				draw(x1, y1, x2 - x1, y2 - y1);
			} else if (selectedRect != null && prevPoint != null) {
				Point curr = e.getPoint();
				int dx = curr.x - prevPoint.x;
				int dy = curr.y - prevPoint.y;
				selectedRect.x += dx;
				selectedRect.y += dy;
				prevPoint = curr;
				repaint();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (toolBar.isRectangleSelected()) {
				draw(x1, y1, x2 - x1, y2 - y1);
				int x = Math.min(x1, x2);
				int y = Math.min(y1, y2);
				int w = Math.abs(x2 - x1);
				int h = Math.abs(y2 - y1);
				rectList.add(new Rect(x, y, w, h));
				repaint();
			}
			startPoint = endPoint = prevPoint = null;
			selectedRect = null;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	}
} 
