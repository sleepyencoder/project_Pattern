// Class_0331/src/graphicsEditor/GToolBar.java
package graphicsEditor;

import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

public class GToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;

	private JRadioButton rectangleButton;
	private JRadioButton triangleButton;
	private JRadioButton ovalButton;
	private JRadioButton polygonButton;
	private JRadioButton textBoxButton;
	private JRadioButton[] shapeButtons;

	public GToolBar() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));

		this.rectangleButton = new JRadioButton("Rectangle");
		this.triangleButton = new JRadioButton("Triangle");
		this.ovalButton = new JRadioButton("Oval");
		this.polygonButton = new JRadioButton("Polygon");
		this.textBoxButton = new JRadioButton("TextBox");

		this.shapeButtons = new JRadioButton[] {
				rectangleButton, triangleButton, ovalButton, polygonButton, textBoxButton
		};

		for (JRadioButton btn : shapeButtons) {
			this.add(btn);
			addToggleBehavior(btn);
		}
	}

	private void addToggleBehavior(final JRadioButton targetButton) {
		targetButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if (targetButton.isSelected()) {
					boolean wasAlreadySelected = targetButton.getModel().isPressed();
					for (JRadioButton btn : shapeButtons) {
						if (btn != targetButton) btn.setSelected(false);
					}
					if (wasAlreadySelected) targetButton.setSelected(false);
				} else {
					targetButton.setSelected(true);
					for (JRadioButton btn : shapeButtons) {
						if (btn != targetButton) btn.setSelected(false);
					}
				}
			}
		});
	}

	public void initialize() {}

	public boolean isRectangleSelected() {
		return rectangleButton.isSelected();
	}
}
