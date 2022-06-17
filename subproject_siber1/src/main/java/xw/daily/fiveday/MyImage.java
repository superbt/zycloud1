package xw.daily.fiveday;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MyImage extends  JPanel {

    BufferedImage [] images = new BufferedImage[4];
    BufferedImage image ;

    public static void main(String[] args) {
        //创建窗口
        JFrame frame = new JFrame();
        frame.setSize(1000,900);
        frame.setTitle("Hello BT Photo");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);

        MyImage myImage = new MyImage();
        myImage.initImages();
        frame.add(myImage);
        myImage.repaint();
        myImage.begin();
        myImage.chanage();
        frame.setVisible(true);
    }


    float ff = 20f;
    int num = 0 ;

    //ctrl+o
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D)g ;
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(ff/100f));
        if(image!=null){
            g.drawImage(image,0,0,image.getWidth(),image.getHeight(),null);
        }
    }

    public void chanage(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                    image = images[num];
                    num++;
                    if(num==4){
                        num = 0 ;
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void begin(){
        new Thread(new Runnable() {
            @Override
            public void run() {
               while (true){
                   if(ff<100f){
                       ff= ff+1f ;
                       repaint();
                   }else{
                       ff=0f;
                       //break;
                   }
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }).start();
    }

    public void initImages(){

        for (int i = 1; i <=4 ; i++) {
            try {
                BufferedImage image = ImageIO.read(MyImage.class.getResource("/img/b" + i + ".jpg"));
                images[i-1] = image ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        image = images[0];
    }
}
