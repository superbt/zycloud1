package ms.iterator.v3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList_ list = new LinkedList_();
        for (int i = 0; i <15 ; i++) {
            list.add(new String("s"+i));
        }
        System.out.println(list.size());
        Iterator_ iterator_ = list.iterator();

        Node head = list.getHead();
        while (head.next!=null){
            head =head.next;
            System.out.println(head.getO());
        }
    }
}




