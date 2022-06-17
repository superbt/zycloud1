package ms.iterator.v3;


public  class LinkedList_ implements Collection_{
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

    public Node getHead(){
        return  head ;
    }



    public int size(){
        return  size ;
    }

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements  Iterator_{

        @Override
        public boolean hasNext() {
            Node next = head.getNext() ;
            System.out.println("next:"+next.getO());
            return (next==null)?false:true;
        }

        @Override
        public Object next() {
            Object o = head.next ;
            return o;
        }
    }
}

class Node{
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
