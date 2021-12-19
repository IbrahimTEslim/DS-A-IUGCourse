package DS2020.Assignment_01;

public class CircularlyLinkedList {

    static class Node {

        private Integer element;
        private Node next;

        public Node(Integer e, Node n) {
            this.element = e;
            this.next = n;
        }

        public Integer getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node tail = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Node first() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext();
    }

    public Node last() {
        if (isEmpty()) {
            return null;
        }
        return tail;
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    public void addFirst(Integer e) {

        if (isEmpty()) {
            tail = new Node(e, null);
            tail.setNext(tail);
        } else {
            Node newest = new Node(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(Integer e) {
        addFirst(e);
        tail = tail.getNext();
        size++;
    }

    public Integer removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node head = tail.getNext();
        //if size =1
        if (tail == head) {
            tail = null;
        }
        tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        Node walk = tail.getNext();
        while (walk != tail) {
            s.append("(").append(walk.getElement()).append(") -> ");
            walk = walk.getNext();
        }
        s.append("(").append(tail.getElement()).append(")  -> loop back to head");
        return s.toString();
    }


    public static void main(String[] args)
    {
        System.out.println("Hello, World!");
        CircularlyLinkedList l=new CircularlyLinkedList();
//      l.addFirst(1);
//        l.addLast(2);
//        l.addLast(3);
//        l.addLast(4);
//        l.addLast(5);
//        l.addLast(9);
//        l.addLast(11);
    }

    public static void reverse(CircularlyLinkedList cs) {
        if(cs.size==0)return;
        int pre_size=(cs.size+1)/2;
        Node h=cs.first();
        for(int i=0;i<pre_size;i++) {cs.addFirst(h.element);  h=h.next;}
        for(int j=0;j<pre_size;j++)cs.rotate();
        for(int k=0;k<pre_size;k++) cs.removeFirst();
    }
}
