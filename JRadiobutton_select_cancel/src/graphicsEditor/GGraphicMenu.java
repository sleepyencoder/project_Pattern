package graphicsEditor;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

// 그래픽 설정 메뉴 클래스
public class GGraphicMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	// 메뉴 항목들 선언
	private JMenuItem linethicknessItem; // 선 굵기 설정
	private JMenuItem lineStyleItem; // 선 스타일 설정
	private JMenuItem fontstyleItem; // 글꼴 스타일 설정
	private JMenuItem fontsizeItem; // 글자 크기 설정

	public GGraphicMenu() {
		super("Edit"); // 메뉴 이름이 Edit으로 되어 있으나, 실제 기능은 그래픽 설정

		this.linethicknessItem = new JMenuItem("Line thickness");
		this.add(this.linethicknessItem);

		this.lineStyleItem = new JMenuItem("Line Style");
		this.add(this.lineStyleItem);

		this.fontstyleItem = new JMenuItem("Font style");
		this.add(this.fontstyleItem);

		this.fontsizeItem = new JMenuItem("Font size");
		this.add(this.fontsizeItem);
	}
}
