package ms.ds.singleton;

public class EnumSingletonTest {

    public static void main(String[] args) {

        EnumSingleton instacne = EnumSingleton.INSTANCE;
        instacne.print();
    }
}
enum EnumSingleton{
    INSTANCE ;
    public void print(){
        System.out.println("XXXX");
    }
}
