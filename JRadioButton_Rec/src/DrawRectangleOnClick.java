import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class DrawRectangleOnClick extends JFrame {
    private static final long serialVersionUID = 1L;
	private JRadioButton drawButton;
    private DrawPanel drawPanel;
    
    public DrawRectangleOnClick() {
        setTitle("Draw Rectangle on Click");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        drawButton = new JRadioButton("Enable Drawing");
        JPanel controlPanel = new JPanel();
        controlPanel.add(drawButton);
        
        drawPanel = new DrawPanel();
        drawPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (drawButton.isSelected()) {
                    drawPanel.startDrawing(e.getX(), e.getY());
                }
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                if (drawButton.isSelected()) {
                    drawPanel.endDrawing(e.getX(), e.getY());
                }
            }
        });
        
        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (drawButton.isSelected()) {
                    drawPanel.updateRectangle(e.getX(), e.getY());
                }
            }
        });
        
        add(controlPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
    }
    
    private static class DrawPanel extends JPanel {
        private final List<Rectangle> rectangles = new ArrayList<Rectangle>();
        private Rectangle currentRect;
        
        public void startDrawing(int x, int y) {
            currentRect = new Rectangle(x, y, 0, 0);
            repaint();
        }
        
        public void updateRectangle(int x, int y) {
            if (currentRect != null) {
                currentRect.width = Math.abs(x - currentRect.x);
                currentRect.height = Math.abs(y - currentRect.y);
                currentRect.x = Math.min(x, currentRect.x);
                currentRect.y = Math.min(y, currentRect.y);
                repaint();
            }
        }
        
        public void endDrawing(int x, int y) {
            if (currentRect != null) {
                currentRect.width = Math.abs(x - currentRect.x);
                currentRect.height = Math.abs(y - currentRect.y);
                currentRect.x = Math.min(x, currentRect.x);
                currentRect.y = Math.min(y, currentRect.y);
                rectangles.add(currentRect);
                currentRect = null;
                repaint();
            }
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            for (Rectangle rect : rectangles) {
                g.drawRect(rect.x, rect.y, rect.width, rect.height);
            }
            if (currentRect != null) {
                g.drawRect(currentRect.x, currentRect.y, currentRect.width, currentRect.height);
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DrawRectangleOnClick frame = new DrawRectangleOnClick();
                frame.setVisible(true);
            }
        });
    }
}
