package graphicsEditor;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GFileMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	private JMenuItem newItem;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem saveasItem;
	private JMenuItem quitItem;
	
	public GFileMenu() {
		super("File");
		
		this.newItem = new JMenuItem("new");
		this.add(this.newItem);
		
		this.openItem = new JMenuItem("open");
		this.add(this.openItem);
		
		this.saveItem = new JMenuItem("save");
		this.add(this.saveItem);
		
		this.saveasItem = new JMenuItem("saveas");
		this.add(this.saveasItem);
		
		this.quitItem = new JMenuItem("quit");
		this.add(this.quitItem);
		
		
	}

}
