package graphicsEditor;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

// 파일 메뉴 클래스 (File 메뉴)
public class GFileMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	// File 메뉴 항목들 선언
	private JMenuItem newItem;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem saveasItem;
	private JMenuItem quitItem;

	public GFileMenu() {
		super("File"); // 메뉴 이름 설정

		this.newItem = new JMenuItem("new"); // 새로 만들기 항목
		this.add(this.newItem);

		this.openItem = new JMenuItem("open"); // 열기 항목
		this.add(this.openItem);

		this.saveItem = new JMenuItem("save"); // 저장 항목
		this.add(this.saveItem);

		this.saveasItem = new JMenuItem("saveas"); // 다른 이름으로 저장 항목
		this.add(this.saveasItem);

		this.quitItem = new JMenuItem("quit"); // 종료 항목
		this.add(this.quitItem);
	}
}
