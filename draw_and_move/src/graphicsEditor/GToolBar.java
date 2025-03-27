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

//	private ButtonGroup shapeGroup; // 버튼 중복 선택 방지를 위한 그룹
	private JRadioButton[] shapeButtons;


	public GToolBar() {
		this.setFloatable(false); // 툴바 위치 고정 - 드래그로 안 끌리게
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
		
		this.shapeButtons = new JRadioButton[] {
				rectangleButton, triangleButton, ovalButton, polygonButton, textBoxButton
			};

		addToggleBehavior(rectangleButton);
		addToggleBehavior(triangleButton);
		addToggleBehavior(ovalButton);
		addToggleBehavior(polygonButton);
		addToggleBehavior(textBoxButton);
	}
	
	private void addToggleBehavior(final JRadioButton targetButton) {
		targetButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if (targetButton.isSelected()) {
					for (int i = 0; i < shapeButtons.length; i++) {
						if (shapeButtons[i] != targetButton) {
							shapeButtons[i].setSelected(false);
						}
					}
				} else {
					targetButton.setSelected(false); // 명시적 해제
				}
			}
		});
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
