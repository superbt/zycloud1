package ms.proxy.v08;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new LogHander(tank));
               m.move();
    }
}


interface Movable{
    void move();
}

class  LogHander implements  InvocationHandler{

    Tank tank ;

    public LogHander(Tank tank) {
        this.tank = tank;
    }

    public void before(){
        System.out.println(" start...");
    }

    public void after(){
        System.out.println(" end!");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        this.before();
        Object o = method.invoke(tank,args);
        this.after();
        return o;
    }
}




