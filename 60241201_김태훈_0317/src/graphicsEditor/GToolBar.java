package graphicsEditor;

import java.awt.FlowLayout;

import javax.swing.JRadioButton;
import javax.swing.JToolBar;

public class GToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;
	
	// Rectangle, Triangle, Oval, Polygon, TextBox
	private JRadioButton rectangleButton;
	private JRadioButton triangleButton;
	private JRadioButton ovalButton;
	private JRadioButton polygonButton;
	private JRadioButton textBoxButton;
	
	public GToolBar() {
		//rectangle 버튼 왼쪽에 붙여 고정시키기 위함인데 안됨... 알아서 하3
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
		
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}

}
