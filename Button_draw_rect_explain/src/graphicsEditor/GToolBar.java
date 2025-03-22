package graphicsEditor;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

// 도형 선택 툴바 클래스
public class GToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;

	// 도형 선택 라디오 버튼들
	private JRadioButton rectangleButton;
	private JRadioButton triangleButton;
	private JRadioButton ovalButton;
	private JRadioButton polygonButton;
	private JRadioButton textBoxButton;

	private ButtonGroup shapeGroup; // 버튼 중복 선택 방지를 위한 그룹

	public GToolBar() {
		this.setFloatable(false); // 툴바 위치를 고정
		this.setLayout(new FlowLayout(FlowLayout.LEFT)); // 좌측 정렬

		this.rectangleButton = new JRadioButton("rectangle");
		this.add(this.rectangleButton);

		this.triangleButton = new JRadioButton("triangle");
		this.add(this.triangleButton);

		this.ovalButton = new JRadioButton("oval");
		this.add(this.ovalButton);

		this.polygonButton = new JRadioButton("polygon");
		this.add(this.polygonButton);

		this.textBoxButton = new JRadioButton("textBox");
		this.add(this.textBoxButton);

		this.shapeGroup = new ButtonGroup(); // 그룹 생성 및 버튼 추가
		this.shapeGroup.add(rectangleButton);
		this.shapeGroup.add(triangleButton);
		this.shapeGroup.add(ovalButton);
		this.shapeGroup.add(polygonButton);
		this.shapeGroup.add(textBoxButton);
	}

	public void initialize() {
		// 필요 시 툴바 초기화 동작 정의
	}

	// 각 도형 버튼이 선택되었는지 여부 반환
	public boolean isRectangleSelected() {
		return rectangleButton.isSelected();
	}

	public boolean isTriangleSelected() {
		return triangleButton.isSelected();
	}

	public boolean isOvalSelected() {
		return ovalButton.isSelected();
	}

	public boolean isPolygonSelected() {
		return polygonButton.isSelected();
	}

	public boolean isTextBoxSelected() {
		return textBoxButton.isSelected();
	}
}
