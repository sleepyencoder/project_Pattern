package graphicsEditor;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GMainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private GMenuBar menuBar;
    private GToolBar toolBar;
    private GDrawingPanel drawingPanel;

    public GMainFrame() {
        // 기본 속성
        this.setLocation(100, 200);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 레이아웃 변경 (기존 FlowLayout → BorderLayout)
        this.setLayout(new BorderLayout());

        // 컴포넌트 생성
        this.menuBar = new GMenuBar();
        this.setJMenuBar(menuBar);

        this.toolBar = new GToolBar();
        // 툴바를 상단에 배치
        this.add(toolBar, BorderLayout.NORTH);

        this.drawingPanel = new GDrawingPanel();
        // 드로잉 패널은 중앙에 배치
        this.add(drawingPanel, BorderLayout.CENTER);
    }

    public void initialize() {
        // 순서대로 초기화
        this.menuBar.initialize();
        this.toolBar.initialize();

        // 드로잉패널에 툴바 참조 주입
        this.drawingPanel.setToolBar(this.toolBar);
        this.drawingPanel.initialize();
    }
}
