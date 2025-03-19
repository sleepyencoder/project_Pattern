package graphicsEditor;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GDrawingPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    // 실제로 그려질 도형을 저장할 리스트 (간단 예시)
    private ArrayList<GShape> shapes;

    // 드래그 시작점
    private int startX, startY;

    // GToolBar를 참조 (현재 선택된 도형 타입 얻어오기 위해)
    private GToolBar toolBar;

    public GDrawingPanel() {
        this.shapes = new ArrayList<>();
    }

    // Swing에서 권장되는 그리기 방식: paintComponent 오버라이딩
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GShape shape : shapes) {
            shape.draw(g);
        }
    }

    public void initialize() {
        // 마우스 드래그로 도형을 그리는 간단 예시
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (toolBar == null) return; // 툴바 참조 없으면 무시

                int endX = e.getX();
                int endY = e.getY();

                // 현재 툴바에서 어떤 도형이 선택되었는지 확인
                String selectedShape = toolBar.getSelectedShape();
                GShape shape = null;

                // 드래그 영역 계산
                int x = Math.min(startX, endX);
                int y = Math.min(startY, endY);
                int w = Math.abs(endX - startX);
                int h = Math.abs(endY - startY);

                // 선택된 도형 타입에 따라 생성 (간단 예시)
                switch (selectedShape) {
                    case "Rectangle":
                        shape = new GRectangle(x, y, w, h);
                        break;
                    case "Oval":
                        shape = new GOval(x, y, w, h);
                        break;
                    case "Triangle":
                        // 실제로는 drawPolygon 등으로 삼각형 구현 필요
                        shape = new GRectangle(x, y, w, h); // 예시 대용
                        break;
                    case "Polygon":
                        // 실제로는 drawPolygon 등으로 다각형 구현 필요
                        shape = new GRectangle(x, y, w, h); // 예시 대용
                        break;
                    case "TextBox":
                        // 실제로는 텍스트박스 전용 GShape 구현 필요
                        shape = new GRectangle(x, y, w, h); // 예시 대용
                        break;
                }

                // shape가 정상 생성되었다면 리스트에 추가 후 화면 갱신
                if (shape != null) {
                    shapes.add(shape);
                    repaint();
                }
            }
        });
    }

    // 외부(MainFrame)에서 툴바 참조를 주입받기 위한 메서드
    public void setToolBar(GToolBar toolBar) {
        this.toolBar = toolBar;
    }
}
