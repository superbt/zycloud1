package xw.daily.secondday;

import javax.swing.*;
import java.awt.*;

public class HeroPlan  extends Thread{
    int x =230 ,y = 600 ;
    int width = 50 ,height = 50 ;
    Image img = new ImageIcon("G:\\xm\\zy\\zycloud1\\subproject_siber1\\img\\zdj.jpg").getImage();
    boolean up ,down,left,right ;
    int speed = 10 ;

    public HeroPlan() {
    }

    public HeroPlan(int x, int y, int width, int height, Image img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
    }

    @Override
    public void run (){
        while (true){
            if(up){
                y = y-speed ;
            }
            if(down){
                y = y+speed ;
            }
            if(left){
                x = x-speed ;
            }
            if(right){
                x = x+speed ;
            }
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
