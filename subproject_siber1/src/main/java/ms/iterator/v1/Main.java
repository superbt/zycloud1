package ms.iterator.v1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList_ list = new ArrayList_();
        for (int i = 0; i <15 ; i++) {
         list.add("s"+i);
        }
        System.out.println(list.size());

        int oldCapacity = 10 ;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println(newCapacity+"---"+(oldCapacity >> 1));
    }
}

class ArrayList_{
    Object[] objects = new Object[10];
    List list = new ArrayList();
    private int index = 0 ;
    public void add(Object o){
        if(index == objects.length){
            Object[] newObject = new Object[objects.length*2] ;
            System.arraycopy(objects,0,newObject,0,objects.length);
            objects = newObject ;
        }
        objects[index] = o ;
        index ++ ;
    }

    public int size(){
        return  index ;
    }
}
