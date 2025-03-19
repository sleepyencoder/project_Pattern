package graphicsEditor;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private GMenuBar menuBar;
	private GToolBar toolBar;
	private GDrawingPanel drawingPanel;
	
	public GMainFrame() {
		//attributes
		this.setLocation(100, 200);
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//components(자식)
		//FlowLayout은 들어오는대로 차곡차곡 쌓아줌
		this.setLayout(new FlowLayout());
		
		
		//실체를 연결해 바인딩하기
		this.menuBar = new GMenuBar();
		this.setJMenuBar(menuBar);
		//자식으로 붙일 때 set 그래서 메뉴바만 set 나머지 add
		
		this.toolBar = new GToolBar();
		this.add(toolBar);
		
		this.drawingPanel = new GDrawingPanel();
		this.add(drawingPanel);
		
		
		
	}
	
	public void initialize() {
		this.menuBar.initialize();
		this.toolBar.initialize();
		this.drawingPanel.initialize();
	}

}
