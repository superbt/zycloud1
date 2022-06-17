package ms.iterator.v2;

public class Main {


    public static void main(String[] args) {
        LinkedList_ link = new LinkedList_();
        for (int i = 0; i <15 ; i++) {
            link.add(new String("s"+i));
        }
        System.out.println(link.size());

        while(link.tail!=null){

        }


    }

}

class LinkedList_{
    Node head = null ;
    Node tail = null ;
    private int size =  0 ;

    public void add(Object o){
        Node n = new Node(o);
        n.next = null ;

        if(head == null){
            head = n ;
            tail = n ;
        }
        tail.next = n ;
        tail = n ;
        size++ ;
    }

    private class Node{
        private Object o ;
        Node next ;

        public Node(Object o) {
            this.o = o;
        }

        public Object getO() {
            return o;
        }

        public void setO(Object o) {
            this.o = o;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public int size(){
        return  size ;
    }
}

