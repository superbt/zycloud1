package ms.templatemethod;

public class Test {
    public static void main(String[] args) {
        FTest f = new Test1();
        f.m();
    }
}

abstract class FTest{
    void m(){
        op1();
        op2();
    }
    abstract void op1() ;
    abstract void op2() ;

}

class Test1 extends  FTest{

    @Override
    void op1() {
        System.out.println("op1");

    }

    @Override
    void op2() {
        System.out.println("op2");

    }
}
