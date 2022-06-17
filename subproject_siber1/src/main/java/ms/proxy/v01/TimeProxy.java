package ms.proxy.v01;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TimeProxy {

    @Before("")
    private void  before(){
        System.out.println("method start"+System.currentTimeMillis());
    }


    @After("")
    private void  After(){
        System.out.println("method stop"+System.currentTimeMillis());
    }
}
