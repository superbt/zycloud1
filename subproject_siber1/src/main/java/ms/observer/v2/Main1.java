package ms.observer.v2;

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
    public boolean isCry() {
        return cry ;
    }
    public void wakeUp(){
        System.out.println("wake up! crying wuwuwuwu、、、、、");
        cry = true ;
        d.feed();
    }
}

class Dad{
    public void feed(){
        System.out.println("dad feeding......");
    }
}
