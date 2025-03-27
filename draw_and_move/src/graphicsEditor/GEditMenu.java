package graphicsEditor;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

// 편집 메뉴 클래스 (Edit 메뉴)
public class GEditMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	// Edit 메뉴 항목 정의
	private JMenuItem propertyItem; // 속성 설정 메뉴
	private JMenuItem undoItem; // 실행 취소 메뉴
	private JMenuItem redoItem; // 다시 실행 메뉴

	public GEditMenu() {
		super("Edit"); // 메뉴 이름 설정

		this.propertyItem = new JMenuItem("property"); // 'property' 항목 생성
		this.add(this.propertyItem); // 메뉴에 추가

		this.undoItem = new JMenuItem("undo"); // 'undo' 항목 생성
		this.add(this.undoItem); // 메뉴에 추가

		this.redoItem = new JMenuItem("redo"); // 'redo' 항목 생성
		this.add(this.redoItem); // 메뉴에 추가
	}
}
