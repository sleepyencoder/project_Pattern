package graphicsEditor;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private GMenuBar menuBar;
	private GToolBar toolBar;
	private GDrawingPanel drawingPanel;

	public GMainFrame() {
		this.setLocation(100, 200);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout()); // BorderLayout 사용

		this.menuBar = new GMenuBar();
		this.setJMenuBar(menuBar);

		this.toolBar = new GToolBar();
		this.add(toolBar, BorderLayout.NORTH); // 툴바를 메뉴바 밑, 그림판 상단에 배치

		this.drawingPanel = new GDrawingPanel(this.toolBar);
		this.add(drawingPanel, BorderLayout.CENTER); // 그림판 중앙에 배치
	}

	public void initialize() {
		this.menuBar.initialize();
		this.toolBar.initialize();
		this.drawingPanel.initialize();
	}
}
