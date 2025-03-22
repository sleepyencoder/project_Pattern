package graphicsEditor;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GGraphicMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	//Line thickness , Line Style, Font style, Font size
	private JMenuItem linethicknessItem;
	private JMenuItem lineStyleItem;
	private JMenuItem fontstyleItem;
	private JMenuItem fontsizeItem;

	
	public GGraphicMenu() {
		super("Edit");
		
		this.linethicknessItem = new JMenuItem("Line thickness");
		this.add(this.linethicknessItem);
		
		this.lineStyleItem = new JMenuItem("Line Style");
		this.add(this.lineStyleItem);
		
		this.fontstyleItem = new JMenuItem("Font style");
		this.add(this.fontstyleItem);
		
		this.fontsizeItem = new JMenuItem("Font size");
		this.add(this.fontsizeItem);
		
	}

}
