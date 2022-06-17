package ms.observer.v6;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        Child child = new Child();
        new Thread(()->{
            try {
                Thread.sleep(5000);
                child.wakeUp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        while (!child.isCry()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("oberving、、、、");
        }
    }
}

class Child{
    private boolean cry = false ;
    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean isCry() {
        return cry ;
    }
    public void wakeUp(){
        System.out.println("wake up! crying wuwuwuwu、、、、、");
        cry = true ;
        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(),"bed");
        for (Observer o:observers
             ) {
             o.actionOnWakeUp(event);
        }
    }
}

interface Observer {
    void actionOnWakeUp(WakeUpEvent event);
}

class Dad implements Observer{
    public void feed(){
        System.out.println("dad feeding......");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        feed();
    }
}

class Mum implements Observer{
    public void hug(){
        System.out.println("mum hugging....");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        hug();
    }
}

class Dog implements  Observer{
    public void wang(){
        System.out.println("dog wang.....");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        wang();
    }
}

class WakeUpEvent{
    long timestamp ;
    String loc ;
    String srouce ;
    public WakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }

    public WakeUpEvent(long timestamp, String loc, String srouce) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.srouce = srouce;
    }
}

