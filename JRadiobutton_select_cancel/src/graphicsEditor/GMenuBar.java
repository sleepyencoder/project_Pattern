package graphicsEditor;

import javax.swing.JMenuBar;

// 상단 메뉴 바 클래스
public class GMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	private GFileMenu fileMenu; // File 메뉴
	private GEditMenu editMenu; // Edit 메뉴
	private GGraphicMenu graphicMenu; // Graphic 메뉴

	public GMenuBar() {
		this.fileMenu = new GFileMenu(); // File 메뉴 생성
		this.add(this.fileMenu); // 메뉴 바에 추가

		this.editMenu = new GEditMenu(); // Edit 메뉴 생성
		this.add((this.editMenu));

		this.graphicMenu = new GGraphicMenu(); // Graphic 메뉴 생성
		this.add((this.graphicMenu));
	}

	public void initialize() {
		// 메뉴 초기화 시 동작할 부분이 있으면 작성
	}
}
