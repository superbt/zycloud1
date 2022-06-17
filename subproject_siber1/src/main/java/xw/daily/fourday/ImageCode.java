package xw.daily.fourday;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ImageCode {

    public static void main(String[] args) {
        //1/画板
        //2 准备画笔
        //3/准备一些数据 随机从数组中去4个
        //4 通过画笔把获取的数据画到画板上
        //5.生成一张真正额图片
        Random random = new Random();
        int index = random.nextInt(strs.length);
        int w =150 ;
        int h = 50 ;
        int imageType = BufferedImage.TYPE_INT_RGB ;
        BufferedImage image = new BufferedImage(w,h,imageType);
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0,0,w,h);

        g.setColor(Color.YELLOW);
        g.setFont(new Font("楷体",Font.BOLD,30));
        int char_x = 30 ;
        for (int i = 0; i < strs.length; i++) {
            String str  = strs[i];
            g.drawString(str,char_x,30+i);
            char_x=char_x+30;

        }


        Color[] colors = {Color.RED,Color.YELLOW,Color.BLUE,Color.BLACK};

        for (int i = 0; i <10 ; i++) {
            int c = random.nextInt(colors.length);
            g.setColor(colors[c]);

         int x1 = random.nextInt(30);
            int y1 = random.nextInt(50);
            int x2 = random.nextInt(30)+120;
            int y2 = random.nextInt(50);
           g.drawLine(x1,y1,x2,y2);
        }


        try {

           // ImageIO.write(image,".jpg", new File("G:\\demo\\1"+random.nextInt(1000)+".jpg"));
            File filePath = new File("G:\\demo");
            if(!filePath.exists()){
                filePath.mkdir();
            }
            File file = new File("G:\\demo\\1"+index+".jpg");
            ImageIO.write(image,"jpg", file );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String [] strs = {
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","p","q","r","s","t","u","v","w","x","y","z",
            "1","2","3","4","5","6","7","8","9"
    } ;
}
