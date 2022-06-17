package ms.observer.v3;

public class Main1 {

    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
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
    Dad  d = new Dad();
    Mum m = new Mum();
    Dog dog = new Dog();
    public boolean isCry() {
        return cry ;
    }
    public void wakeUp(){
        System.out.println("wake up! crying wuwuwuwu、、、、、");
        cry = true ;
        d.feed();
        m.hug();
        dog.wang();
    }
}

class Dad{
    public void feed(){
        System.out.println("dad feeding......");
    }
}

class Mum{
    public void hug(){
        System.out.println("mum hugging....");
    }
}
class Dog{
    public void wang(){
        System.out.println("dog wang.....");
    }

}
