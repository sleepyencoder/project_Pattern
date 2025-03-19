package graphicsEditor;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GFileMenu extends JMenu {
    private static final long serialVersionUID = 1L;

    private JMenuItem newItem;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem saveAsItem;
    private JMenuItem quitItem;

    public GFileMenu() {
        super("File");

        this.newItem = new JMenuItem("New");
        this.openItem = new JMenuItem("Open");
        this.saveItem = new JMenuItem("Save");
        this.saveAsItem = new JMenuItem("Save As");
        this.quitItem = new JMenuItem("Quit");

        // 메뉴 아이템 추가
        this.add(this.newItem);
        this.add(this.openItem);
        this.add(this.saveItem);
        this.add(this.saveAsItem);
        this.addSeparator();
        this.add(this.quitItem);

        // 간단한 Quit 이벤트 (예시)
        this.quitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        null,
                        "정말 종료하시겠습니까?",
                        "Quit",
                        JOptionPane.YES_NO_OPTION
                );
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public void initialize() {
        // 필요 시 추가 초기화 로직
    }
}
