package ms.observer.v1;

public class Main1 {

    public static void main(String[] args) {
        Child child = new Child();
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
    public boolean isCry() {
        return cry ;
    }
    public void wakeUp(){
        System.out.println("wake up! crying wuwuwuwu、、、、、");

    }
}
