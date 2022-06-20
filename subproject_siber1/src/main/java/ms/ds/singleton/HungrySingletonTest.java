package ms.ds.singleton;

public class HungrySingletonTest {
    public static void main(String[] args) {
      Class<HungrySingleton> hungrySingletonClass = HungrySingleton.class;
        System.out.println(HungrySingleton.name);
    }
}

class HungrySingleton{

    public  static String name ="xyj";

    {
        System.out.println("HungrySingleton");
    }

    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }
    public static HungrySingleton getInstance(){
        return  hungrySingleton ;
    }
}
