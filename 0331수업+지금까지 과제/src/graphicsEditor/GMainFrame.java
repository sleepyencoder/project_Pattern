package graphicsEditor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GMainFrame extends JFrame {
	//attributes
	private static final long serialVersionUID = 1L;
	//color, location 같은것도 여기에 들어가야하지만 JFrame에 들어가있고 그걸 상속받기 때문에 쓰지 않고 나머지 부분을 추가함
	
	//부품화, encapsulation
	//components
	private GMenuBar menuBar; //이름 만들기, 자식들을 밖으로 빼놓음
	private GToolBar toolBar;
	private GDrawingPanel drawingPanel;
	//associations
	//...
	
	//Constructor
	public GMainFrame() {//JFrame 상속 받음 extend : specialization,상속 후 특화함
		//attribute(속성)
		this.setLocation(100, 200);
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//components(자식)
		this.setLayout(new BorderLayout());
		
		this.menuBar = new GMenuBar(); //실체화, 이름과 binding
		this.setJMenuBar(menuBar);
		
		// GMainFrame.java 내부
		this.toolBar = new GToolBar();                   // 먼저 툴바 생성
		this.add(toolBar, BorderLayout.NORTH);

		this.drawingPanel = new GDrawingPanel(this.toolBar);  // 수정: 툴바를 넘김
		this.add(drawingPanel, BorderLayout.CENTER);
	}


	public void initialize() {
		//associated attributes
		//다른 자식들이 다 만들어지고 나서 할 수 있도록 아래에 배치
		this.setVisible(true);//draw mainFrame
				
		this.menuBar.initialize();
		this.toolBar.initialize();
		this.drawingPanel.initialize();
	}

}
