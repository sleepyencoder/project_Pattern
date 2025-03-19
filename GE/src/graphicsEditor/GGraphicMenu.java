// GGraphicMenu.java
package graphicsEditor;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GGraphicMenu extends JMenu {
    private static final long serialVersionUID = 1L;

    private JMenuItem lineThicknessItem;
    private JMenuItem lineStyleItem;
    private JMenuItem fontStyleItem;
    private JMenuItem fontSizeItem;

    public GGraphicMenu() {
        super("Graphic");

        this.lineThicknessItem = new JMenuItem("Line Thickness");
        this.lineStyleItem = new JMenuItem("Line Style");
        this.fontStyleItem = new JMenuItem("Font Style");
        this.fontSizeItem = new JMenuItem("Font Size");

        this.add(this.lineThicknessItem);
        this.add(this.lineStyleItem);
        this.addSeparator();
        this.add(this.fontStyleItem);
        this.add(this.fontSizeItem);

        // 간단한 이벤트 예시
        this.lineThicknessItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Line Thickness 설정(예시)",
                        "Line Thickness",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

    public void initialize() {
        // 필요 시 초기화
    }
}
