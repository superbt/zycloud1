package ms.proxy.v10;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TimeProxy {

 @Before("execution( void ms.proxy.v10.Tank.move())")
 public void before(){
     System.out.println("before");
 }

 @After(("execution( void ms.proxy.v10.Tank.move())"))
 public void after(){
     System.out.println("after");
 }
}

