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
        this.setFloatable(false); // 움직이지 않게 고정 
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
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
		
		// 버튼 중복 선택 방
        this.shapeGroup = new ButtonGroup();
        this.shapeGroup.add(rectangleButton);
        this.shapeGroup.add(triangleButton);
        this.shapeGroup.add(ovalButton);
        this.shapeGroup.add(polygonButton);
        this.shapeGroup.add(textBoxButton);
	}

	public void initialize() {
		// TODO Auto-generated method stub
	}

	public boolean isRectangleSelected() { //선택됐는지 아닌지 참거짓으로만 판
		return rectangleButton.isSelected();
	}

}
