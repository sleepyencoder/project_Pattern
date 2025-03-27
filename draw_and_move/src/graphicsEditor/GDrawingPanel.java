package graphicsEditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JPanel;

// 사각형 정보를 저장하기 위한 클래스
class Rect {
	int x, y, w, h; // 좌상단 좌표(x, y)와 너비(w), 높이(h)

	public Rect(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
}

// 도형을 그리는 패널 클래스
public class GDrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private GToolBar toolBar; // 어떤 도형이 선택되었는지를 알기 위한 툴바 참조
	private Vector<Rect> rectList; // 그려진 사각형들을 저장하는 리스트
	private Point startPoint; // 마우스를 누른 시작 위치
	private Point endPoint; // 마우스를 뗀 끝 위치

	private Rect selectedRect = null;
	private Point prevPoint; // 드래그 중 이전 마우스 위치

	public GDrawingPanel(final GToolBar toolBar) {
		this.toolBar = toolBar;
		this.rectList = new Vector<>();
		this.setBackground(Color.WHITE);

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point p = e.getPoint();
				if (toolBar.isRectangleSelected()) {
					startPoint = p;
				} else {
					selectedRect = getRectAtPoint(p);
					if (selectedRect != null) {
						prevPoint = p;
					}
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (toolBar.isRectangleSelected() && startPoint != null) {
					endPoint = e.getPoint();
					int x = Math.min(startPoint.x, endPoint.x);
					int y = Math.min(startPoint.y, endPoint.y);
					int w = Math.abs(startPoint.x - endPoint.x);
					int h = Math.abs(startPoint.y - endPoint.y);
					rectList.add(new Rect(x, y, w, h));
					repaint();
				}
				selectedRect = null;
				startPoint = null;
				prevPoint = null;
			}
		});

		this.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (!toolBar.isRectangleSelected() && selectedRect != null && prevPoint != null) {
					Point curr = e.getPoint();
					int dx = curr.x - prevPoint.x;
					int dy = curr.y - prevPoint.y;
					selectedRect.x += dx;
					selectedRect.y += dy;
					prevPoint = curr;
					repaint();
				}
			}
		});
	}

	private Rect getRectAtPoint(Point p) {
		for (int i = rectList.size() - 1; i >= 0; i--) {
			Rect r = rectList.get(i);
			if (p.x >= r.x && p.x <= r.x + r.w && p.y >= r.y && p.y <= r.y + r.h) {
				return r;
			}
		}
		return null;
	}

	// 실제 화면에 사각형을 그리는 메서드
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK); // 도형 색상을 검은색으로 설정
		for (Rect r : rectList) {
			g.drawRect(r.x, r.y, r.w, r.h); // 저장된 사각형 그리기
		}
	}

	public void draw() {} // 추후 도형 그리기 확장을 위한 빈 메서드

	public void initialize() {
		this.draw(); // 초기화 시 draw 메서드 호출
	}
}
