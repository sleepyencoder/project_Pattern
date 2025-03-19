package graphicsEditor;

import javax.swing.JMenuBar;

public class GMenuBar extends JMenuBar {
    private static final long serialVersionUID = 1L;

    private GFileMenu fileMenu;
    private GEditMenu editMenu;       // 새로 추가
    private GGraphicMenu graphicMenu; // 새로 추가

    public GMenuBar() {
        // File 메뉴
        this.fileMenu = new GFileMenu();
        this.add(this.fileMenu);

        // Edit 메뉴
        this.editMenu = new GEditMenu();
        this.add(this.editMenu);

        // Graphic 메뉴
        this.graphicMenu = new GGraphicMenu();
        this.add(this.graphicMenu);
    }

    public void initialize() {
        // 필요 시 각 메뉴들 초기화
        this.fileMenu.initialize();
        this.editMenu.initialize();
        this.graphicMenu.initialize();
    }
}
