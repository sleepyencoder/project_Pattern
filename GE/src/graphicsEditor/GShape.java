// GShape.java (interface)
package graphicsEditor;

import java.awt.Graphics;

public interface GShape {
    void draw(Graphics g);
    void move(int dx, int dy);
    void resize(int dw, int dh);
    void rotate(double angle);

    // 예시로 위치/크기 세팅도
    void setLocation(int x, int y);
    void setSize(int w, int h);
}
