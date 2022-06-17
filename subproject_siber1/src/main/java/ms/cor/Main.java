package ms.cor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

/*        Msg msg = new Msg();
        msg.setMsg("大家好<script> 欢迎 sbt.大家都是996,:)");*/
        //处理msg
//        List<Filter> filterList = new ArrayList<>();
//        filterList.add(new HTMLFilter());
//        filterList.add(new SensitFilter());
//        for (int i = 0; i <filterList.size() ; i++) {
//            filterList.get(i).doFilter(msg);
//        }
//        FilterChain fc = new FilterChain();
//        fc.add(new HTMLFilter());
//        fc.add(new SensitFilter());
//        fc.doFilter(msg);
/*        FilterChain fc = new FilterChain();
        fc.add2(new HTMLFilter()).add2(new SensitFilter());


        FilterChain fc2 = new FilterChain();
        fc2.add2(new FaceFilter()).add2(new URLFilter());
        fc.add2(fc2) ;

        fc.doFilter(msg);
       System.out.println(msg);*/
    }
}
/*
class Msg{
    String name ;
    String msg ;

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

interface  Filter{
    boolean doFilter(Msg m);
}

class HTMLFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace('<','[');
        r = r.replace('>',']');
        msg.setMsg(r);
        return true ;
    }
}

class SensitFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace("996","995");
        msg.setMsg(r);
        return false ;
    }
}

class FaceFilter implements Filter{

    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace(":)","^V^");
        m.setMsg(r);
        return true ;
    }
}

class URLFilter implements Filter{

    @Override
    public boolean doFilter(Msg m) {

        return true ;
    }
}

class FilterChain implements Filter{
    List<Filter> list = new ArrayList<>();
    public void add(Filter f){
        list.add(f);
    }

    public FilterChain add2(Filter f){
        list.add(f);
        return this ;
    }


    public boolean doFilter(Msg msg){
        for (Filter filter:list
             ) {
            if (!filter.doFilter(msg)) {
                return false ;
            } ;
        }
        return true ;
    }
}
*/
