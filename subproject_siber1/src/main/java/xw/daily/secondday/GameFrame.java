package xw.daily.secondday;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class GameFrame extends JFrame {

      HeroPlan heroPlan;
      Vector<Bullet> bullets = new Vector<>();
      Vector<EnemyPlan> enemys = new Vector<>();
      GameFrame gameFrame ;

    public GameFrame(){
        gameFrame = this ;
        heroPlan = new HeroPlan();
        heroPlan.start();

        this.setSize(500,760);
        this.setTitle("bt 小游戏");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.setMaximizedBounds();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            Random random = new Random();
            @Override
            public void run() {
             while (true){
                 EnemyPlan enemyPlan = new EnemyPlan(gameFrame ,random.nextInt(500),0) ;
                 enemyPlan.start();
                enemys.add(enemyPlan);
                 try {
                     Thread.sleep(500);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
            }
        }).start();

    }

    public void paint(Graphics g){
        //System.out.println("绘制画板");
        BufferedImage image = (BufferedImage)this.createImage(this.getSize().width,this.getSize().height);
        Graphics bi = image.getGraphics();
        String filename = "G:\\xm\\zy\\zycloud1\\subproject_siber1\\img\\bj_level1.jpg"; //img/bj_level1.jpg"
        bi.drawImage(new ImageIcon(filename).getImage(),0,0,null);
        bi.drawImage(heroPlan.img,heroPlan.x,heroPlan.y,heroPlan.width,heroPlan.height,null);
/*        for(Bullet bullet:bullets){
            if(bullet.y-bullet.speed>0){
                bi.drawImage(bullet.img,bullet.x,bullet.y=bullet.y-bullet.speed,bullet.width,bullet.height,null);
            }else{
                bullets.remove(bullet);
            }
        }*/
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i) ;
            if(bullet.y>0){
                bi.drawImage(bullet.img,bullet.x,bullet.y=bullet.y-bullet.speed,bullet.width,bullet.height,null);
            }else{
                bullets.remove(bullet);
            }
        }

        for (int i = 0; i < enemys.size(); i++) {
            EnemyPlan enemy = enemys.get(i) ;
            if(enemy.y<760){
                bi.drawImage(enemy.img,enemy.x,enemy.y=enemy.y+enemy.speed,enemy.width,enemy.hegiht,null);
            }else{
                enemys.remove(enemy);
            }
        }
       // System.out.println("===敌机数量："+enemys==null?0:enemys.size());

        g.drawImage(image,0,0,null);
    }

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        Player player = new Player(frame);
        frame.addKeyListener(player);
    }
}

