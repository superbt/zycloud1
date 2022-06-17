package ms.strategy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat [] cat =  {new Cat(12,23),new Cat(2,33),new Cat(24,3)} ;
        Dog [] dogs = {new Dog(3),new Dog(1),new Dog(5)};
     /*   Sorter s = new Sorter();*/
  /*      Sorter2 s = new Sorter2();
        s.sort(cat,new CatHeightCompartor());*/
        Sorter2 s = new Sorter2();
        s.sort(cat,(c1,c2)->{
            Cat cc1 = (Cat) c1;
            Cat cc2 = (Cat) c2;
            if(cc1.weight<cc2.weight) return  -1 ;
            else if (cc1.weight>cc2.weight) return  1 ;
            else return  0 ;
        });
        System.out.println(Arrays.toString(cat));
    }
}
