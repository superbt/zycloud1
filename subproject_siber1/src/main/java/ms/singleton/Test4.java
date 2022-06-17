package ms.singleton;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test4 {

    private static Test4 test2 ;

    private Test4(){

    }


    public static   Test4 getTest2(){
        if(test2==null){
            synchronized (Test4.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test2 = new Test4();
            }
        }
        return test2 ;
    }

    public void m(){
        System.out.println("m");
    }

   public static Map<Object,Object> checkMap = new ConcurrentHashMap<Object,Object>();
    public static void main(String[] args) {
        long startTime = new Date().getTime();
        for (int i = 0; i <100 ; i++) {
            new Thread(  ()->{
               // System.out.println(Test2.getTest2().hashCode());
                Test4 t2 = Test4.getTest2();
              if(checkMap.get(t2.hashCode())==null){
                 // System.out.println(t2.hashCode()+"====");
                  checkMap.put(t2.hashCode(),t2);
              }else{
                 // System.out.println("冲突");
              }
            }).start();
        }

        System.out.println(checkMap.size()+"====");
        checkMap.forEach((k,v)->{
            System.out.println("获取到实例："+k);
        });
        long endTime = new Date().getTime();
        System.out.println("耗时："+(endTime-startTime));

    }
}
