package graphicsEditor;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

public class GToolBar extends JToolBar {
    private static final long serialVersionUID = 1L;

    private JRadioButton rectangleButton;
    private JRadioButton triangleButton;
    private JRadioButton ovalButton;
    private JRadioButton polygonButton;
    private JRadioButton textBoxButton;

    private ButtonGroup shapeGroup;

    public GToolBar() {
        // 기존처럼 float 불가능하게, 왼쪽 정렬
        this.setFloatable(false);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        // 버튼 생성
        this.rectangleButton = new JRadioButton("Rectangle");
        this.triangleButton = new JRadioButton("Triangle");
        this.ovalButton = new JRadioButton("Oval");
        this.polygonButton = new JRadioButton("Polygon");
        this.textBoxButton = new JRadioButton("TextBox");

        // 기본 선택
        this.rectangleButton.setSelected(true);

        // ButtonGroup(단일 선택)
        this.shapeGroup = new ButtonGroup();
        this.shapeGroup.add(rectangleButton);
        this.shapeGroup.add(triangleButton);
        this.shapeGroup.add(ovalButton);
        this.shapeGroup.add(polygonButton);
        this.shapeGroup.add(textBoxButton);

        // 툴바에 추가
        this.add(this.rectangleButton);
        this.add(this.triangleButton);
        this.add(this.ovalButton);
        this.add(this.polygonButton);
        this.add(this.textBoxButton);
    }

    public void initialize() {
        // 필요 시 추가 초기화
    }

    // 현재 선택된 도형 타입을 리턴
    public String getSelectedShape() {
        if (rectangleButton.isSelected()) return "Rectangle";
        if (triangleButton.isSelected()) return "Triangle";
        if (ovalButton.isSelected()) return "Oval";
        if (polygonButton.isSelected()) return "Polygon";
        if (textBoxButton.isSelected()) return "TextBox";
        return "Rectangle"; // 디폴트
    }
}
