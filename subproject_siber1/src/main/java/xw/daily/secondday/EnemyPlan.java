package xw.daily.secondday;

import javax.swing.*;
import java.awt.*;

public class EnemyPlan extends Thread {

    public GameFrame gameFrame ;
    public int x ,y ;
    public int width = 50 , hegiht =50 ;
    public int speed =  2 ;
    Image img = new ImageIcon("G:\\xm\\zy\\zycloud1\\subproject_siber1\\img\\enemy.jpg").getImage();

    public EnemyPlan(GameFrame gameFrame, int x, int y, int width, int hegiht,Image img) {
        this.gameFrame = gameFrame;
        this.x = x;
        this.y = y;
        this.width = width;
        this.hegiht = hegiht;
        this.img = img;
    }

    public EnemyPlan(GameFrame gameFrame, int x, int y) {
        this.gameFrame = gameFrame;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run (){
        while (true){
            if(this.hit()){
                System.out.println("碰撞啦");
                this.speed = 0 ;
                this.img = new ImageIcon("G:\\xm\\zy\\zycloud1\\subproject_siber1\\img\\die.jpg").getImage();
                try {
                    this.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gameFrame.enemys.remove(this);
                break ;
            }
            if(this.y>=760){
                break;
            }
            try {
                this.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public boolean hit(){
        Rectangle rectangle = new Rectangle(this.x,this.y,this.width,this.hegiht);
        Rectangle rect = null ;
        for (int i = 0; i < gameFrame.bullets.size(); i++) {
            Bullet bullet = gameFrame.bullets.get(i);
            rect = new Rectangle(bullet.x,bullet.y-1,bullet.width,bullet.height);
            if(rectangle.intersects(rect)){
                return true ;
            }
        }
        return  false ;
    }

}
