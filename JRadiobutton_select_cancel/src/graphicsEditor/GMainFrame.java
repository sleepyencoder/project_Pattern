package graphicsEditor;

import java.awt.BorderLayout;
import javax.swing.JFrame;

// 전체 프로그램의 메인 프레임 (창)
public class GMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private GMenuBar menuBar; // 메뉴 바
	private GToolBar toolBar; // 도형 선택 툴바
	private GDrawingPanel drawingPanel; // 도형 그리기 패널

	public GMainFrame() {
		this.setLocation(100, 200); // 창의 시작 위치 설정
		this.setSize(800, 600); // 창 크기 설정
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫기 버튼 누르면 종료
		this.setLayout(new BorderLayout()); // 레이아웃 설정

		this.menuBar = new GMenuBar(); // 메뉴 바 생성
		this.setJMenuBar(menuBar); // 프레임에 메뉴 바 설정

		this.toolBar = new GToolBar(); // 툴바 생성
		this.add(toolBar, BorderLayout.NORTH); // 툴바를 위쪽에 배치

		this.drawingPanel = new GDrawingPanel(this.toolBar); // 그리기 패널 생성
		this.add(drawingPanel, BorderLayout.CENTER); // 중앙에 배치
	}

	public void initialize() {
		this.menuBar.initialize(); // 메뉴 초기화
		this.toolBar.initialize(); // 툴바 초기화
		this.drawingPanel.initialize(); // 패널 초기화
	}
}
