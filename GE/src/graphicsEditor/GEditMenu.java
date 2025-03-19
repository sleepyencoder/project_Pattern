// GEditMenu.java
package graphicsEditor;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GEditMenu extends JMenu {
    private static final long serialVersionUID = 1L;

    private JMenuItem propertyItem;
    private JMenuItem undoItem;
    private JMenuItem redoItem;

    public GEditMenu() {
        super("Edit");

        this.propertyItem = new JMenuItem("Property");
        this.undoItem = new JMenuItem("Undo");
        this.redoItem = new JMenuItem("Redo");

        this.add(this.propertyItem);
        this.addSeparator();
        this.add(this.undoItem);
        this.add(this.redoItem);

        // 간단한 이벤트 예시
        this.propertyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Property 창을 표시합니다(예시)",
                        "Property",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

    public void initialize() {
        // 필요 시 초기화
    }
}
