
package draw_qua;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

class Rect {
	int x, y, w, h;
	public Rect(int x, int y, int w, int h) {
		this.x = x; 
		this.y = y; 
		this.w = w; 
		this.h = h;
	}
}


public class draw extends JFrame {
	int x, y;
	int w = 0, h = 0;
	int x1, y1, x2, y2;
	Vector<Rect> list = new Vector<>();
	MyPanel panel; 
	
	class MyPanel extends JPanel{ 
		public MyPanel() {
			setFocusable(true); 
            //requestFocusInWindow(); 
            
			
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					x1 = e.getX();
					y1 = e.getY();
				}
				
				public void mouseReleased(MouseEvent e) {
					x2 = e.getX();
					y2 = e.getY();
					x = Math.min(x1,  x2);
					y = Math.min(y1,  y2);
					w = Math.abs(x1-x2);
					h = Math.abs(y1-y2);
					
					list.add(new Rect(x, y, w, h));
					repaint();
				}
			});
			addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        list.clear(); 
                        repaint();
                    }
                }
            });
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.orange);
			g.fillRect(x,  y, w, h);
			for(Rect r:list)
				g.drawRect(r.x,  r.y,  r.w,  r.h);
		}
	}
	
	public draw() {
		panel = new MyPanel();
		 
		add(new MyPanel());
		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        panel.requestFocusInWindow();

	}
	
	public static void main(String[] args) {
		new draw();
	}
}
