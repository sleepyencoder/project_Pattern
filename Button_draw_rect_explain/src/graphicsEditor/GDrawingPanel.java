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

	public GDrawingPanel(GToolBar toolBar) {
		this.toolBar = toolBar;
		this.rectList = new Vector<>();
		this.setBackground(Color.WHITE); // 배경색은 흰색으로 설정

		// 마우스 이벤트 리스너 등록
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// 사각형 버튼이 선택된 경우 시작 좌표를 저장
				if (GDrawingPanel.this.toolBar.isRectangleSelected()) {
					startPoint = e.getPoint();
				}
			}

			public void mouseReleased(MouseEvent e) {
				// 사각형 버튼이 선택되어 있고, 시작점이 null이 아닌 경우에만 처리
				if (GDrawingPanel.this.toolBar.isRectangleSelected() && startPoint != null) {
					endPoint = e.getPoint();
					int x = Math.min(startPoint.x, endPoint.x); // 좌측 상단 x
					int y = Math.min(startPoint.y, endPoint.y); // 좌측 상단 y
					int w = Math.abs(startPoint.x - endPoint.x); // 너비
					int h = Math.abs(startPoint.y - endPoint.y); // 높이
					rectList.add(new Rect(x, y, w, h)); // 리스트에 새 사각형 추가
					repaint(); // 화면 다시 그리기
				}
			}
		});
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
