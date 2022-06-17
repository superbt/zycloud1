package xw.daily.secondday;

import javax.swing.*;
import java.awt.*;

public class Bullet {
    int x , y ;
    int width = 10, height = 10 ;
    int speed = 8 ;
    Image img = new ImageIcon("G:\\xm\\zy\\zycloud1\\subproject_siber1\\img\\bullet1.jpg").getImage();

    public Bullet() {
    }

    public Bullet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
