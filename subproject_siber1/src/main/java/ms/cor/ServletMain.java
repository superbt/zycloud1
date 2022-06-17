package ms.cor;

import java.util.ArrayList;
import java.util.List;

public class ServletMain {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "request";
        Response response = new Response();
        response.str = "response";
        FilterChain fc = new FilterChain();
        fc.add2(new HTMLFilter()).add2(new SensitFilter());
        fc.doFilter(request,response);
        System.out.println(request.str);
        System.out.println(response.str);

    }
}



interface  Filter{
    boolean doFilter(Request req,Response res ,FilterChain chain) ;
}

class HTMLFilter implements Filter{
    @Override
    public boolean doFilter(Request req,Response res,FilterChain chain)   {
      String reqStr = req.str ;
      reqStr = reqStr.replace("<","[").replace(">","]");
      req.str = reqStr ;
        chain.doFilter(req, res);
        res.str=res.str+"---HTMLFilter";
        return true ;
    }
}

class SensitFilter implements Filter{
    @Override
    public boolean doFilter(Request req,Response res ,FilterChain chain) {
        String reqStr = req.str ;
        reqStr = reqStr.replace("996","995");
        req.str = reqStr ;
        chain.doFilter(req, res);
        res.str=res.str+"---SensitFilter";
        return true ;
    }
}


class FilterChain {
    List<Filter> list = new ArrayList<>();
    int index = 0 ;
    public void add(Filter f){
        list.add(f);
    }

    public FilterChain add2(Filter f){
        list.add(f);
        return this ;
    }


    public boolean doFilter(Request req,Response res) {
        if(index == list.size()) return  false ;
        Filter f = list.get(index);
        index++ ;
        return f.doFilter(req,res,this);
    }
}

class Request {
    String str ;
}
class Response {
    String str ;
}
