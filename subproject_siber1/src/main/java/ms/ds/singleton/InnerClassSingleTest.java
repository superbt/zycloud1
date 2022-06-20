package ms.ds.singleton;

import java.lang.reflect.Constructor;

public class InnerClassSingleTest {

    public static void main(String[] args) throws  Exception {

        //System.out.println(InnerClassSingle.name);
        Constructor<HungrySingleton> declaredConstructor = HungrySingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        HungrySingleton hungrySingleton =  declaredConstructor.newInstance();
        HungrySingleton instance = HungrySingleton.getInstance();
        System.out.println(hungrySingleton == instance );

    }
}

class InnerClassSingle{

    public static  String name ="xbt";
    static{
        System.out.println("static block");
    }

    private static class singleHolder{

        private  static  InnerClassSingle instance = new InnerClassSingle();
    }

    private InnerClassSingle() {

    }

    public static InnerClassSingle getInstance(){
        return singleHolder.instance ;
    }


}
