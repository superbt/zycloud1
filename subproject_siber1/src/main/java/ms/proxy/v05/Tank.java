package ms.proxy.v05;

import java.util.Random;

public class Tank  implements  Movable{
    @Override
    public void move() {
        System.out.println("Tank moving claclacla....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        new TankTimeProxy(tank).move();
    }
}

interface Movable{
    void move();
}

class  TankTimeProxy implements  Movable {
    Tank tank ;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis() ;
        tank.move();
        long endTime = System.currentTimeMillis();
        System.out.println("用时间："+(endTime - startTime));
    }
}
