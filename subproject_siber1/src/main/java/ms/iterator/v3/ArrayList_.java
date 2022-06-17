package ms.iterator.v3;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_ implements  Collection_ {
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

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }
    private class ArrayListIterator implements  Iterator_{
        private int currentIndex = 0 ;

        @Override
        public boolean hasNext() {
            return (currentIndex>=index)?false:true;
        }

        @Override
        public Object next() {
            Object o = objects[currentIndex] ;
            currentIndex++;
            return o;
        }
    }

}
