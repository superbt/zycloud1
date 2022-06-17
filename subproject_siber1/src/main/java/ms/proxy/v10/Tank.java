package ms.proxy.v10;

import java.util.Random;

public class Tank {

    public void move() {
        long start  = System.currentTimeMillis();
        System.out.println("Tank moving claclacla....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("运行："+(endTime-start)/1000);
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.move();
    }
}

