package ms.memento;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException {

        Demo demo = new Demo("s1", "s2");
        File file = new File("d://bt/bt.data");

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(demo);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Demo osDemo = (Demo) ois.readObject();
            System.out.println(osDemo.dealD1andD2());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Demo implements Serializable {
    String d1 ;
    String d2 ;

    public Demo(String d1, String d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    public String dealD1andD2(){
        return d1+d2 ;
    }
}
