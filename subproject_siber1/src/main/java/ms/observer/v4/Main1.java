package ms.observer.v4;

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
        for (Observer o:observers
             ) {
             o.actionOnWakeUp();
        }
    }
}

interface Observer {
    void actionOnWakeUp();
}

class Dad implements Observer{
    public void feed(){
        System.out.println("dad feeding......");
    }

    @Override
    public void actionOnWakeUp() {
        feed();
    }
}

class Mum implements Observer{
    public void hug(){
        System.out.println("mum hugging....");
    }

    @Override
    public void actionOnWakeUp() {
        hug();
    }
}

class Dog implements  Observer{
    public void wang(){
        System.out.println("dog wang.....");
    }

    @Override
    public void actionOnWakeUp() {
        wang();
    }
}


