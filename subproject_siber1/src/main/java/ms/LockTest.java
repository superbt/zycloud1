package ms;

import java.util.concurrent.CountDownLatch;

public class LockTest {

    public static int n ;
    public static void main(String[] args) throws  Exception{

        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        for (int i = 0; i <threads.length ; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j <10000 ; j++) {
                  synchronized (LockTest.class){
                      n++;
                  }
                }
            });

            threads[i].start();

            latch.countDown();

        }

        latch.await();
        System.out.println("hello---"+n);
    }

    public static void test1(){
        Object o = new Object();

    }
}
