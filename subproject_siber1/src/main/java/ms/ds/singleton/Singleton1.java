package ms.ds.singleton;

public class Singleton1 {
    public static void main(String[] args) {

    }
}

class LazySingleton{
    public static LazySingleton lazySingleton ;

    private LazySingleton() {
    }

    public static  LazySingleton getLazySingleton(){

            if (lazySingleton==null){
                synchronized (Singleton1.class){
                    if(lazySingleton ==null){
                        lazySingleton = new LazySingleton();
                    }
            }
        }

        return lazySingleton ;
    }
}
