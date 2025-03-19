// GOval.java (GShape 구현 예시)
package graphicsEditor;

import java.awt.Graphics;

public class GOval implements GShape {
    private int x, y, width, height;

    public GOval(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(x, y, width, height);
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void resize(int dw, int dh) {
        this.width += dw;
        this.height += dh;
    }

    @Override
    public void rotate(double angle) {
        System.out.println("Oval rotate: " + angle);
    }

    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setSize(int w, int h) {
        this.width = w;
        this.height = h;
    }
}
