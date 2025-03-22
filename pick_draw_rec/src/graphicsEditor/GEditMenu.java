package graphicsEditor;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GEditMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	//Property, Undo, Redo
	private JMenuItem propertyItem;
	private JMenuItem undoItem;
	private JMenuItem redoItem;
	
	public GEditMenu() {
		super("Edit");
		
		this.propertyItem = new JMenuItem("property");
		this.add(this.propertyItem);
		
		this.undoItem = new JMenuItem("undo");
		this.add(this.undoItem);
		
		this.redoItem = new JMenuItem("redo");
		this.add(this.redoItem);
		
		
	}

}
