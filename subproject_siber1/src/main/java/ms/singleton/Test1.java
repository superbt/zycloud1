package ms.singleton;

public class Test1 {

    private static Test1 test1 ;

    private Test1(){

    }

    public static Test1 getTest1() {
        if (test1 ==null){
            test1 = new Test1();
        }
        return  test1 ;
    }

    public static void main(String[] args) {
        Test1 t1 = Test1.getTest1();
        Test1 t2 = Test1.getTest1();
        System.out.println(t1==t2?"相等":"不相等");

    }
}
