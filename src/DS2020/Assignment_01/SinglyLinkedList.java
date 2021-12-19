package DS2020.Assignment_01;

public class SinglyLinkedList implements Cloneable {

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
    }//end
    /* Singly linked list code*/

    private Node head;
    private Node tail;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }

        return false;
    }

    public Node first() {
        return head;
    }

    public Node last() {
        return tail;
    }

    public void addFirst(Integer e) {
        head = new Node(e, head);
        if (isEmpty()) {
            tail = head;
        }

        size++;
    }

    public void addLast(Integer e) {
        Node newest = new Node(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public Integer removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node removed = head;
        head = head.getNext();
        size--;
        //قبل ممكن يكون الهيد بيأشر عالتيل فلما أحذف العنصر لسا التيل محتفظ بقيمته فلازم أحذفها :)
        if (size == 0) {
            tail = null;
        }

        return removed.getElement();
    }

    //code fragment 3.19
    public boolean equals(SinglyLinkedList other) {
        if (other == null) {
            return false;
        }
        if (other.size() != size()) {
            return false;
        }
        Node a = head;
        Node b = other.head;

        while (a.getNext() != null) {
            if (a.getElement() != b.getElement()) {
                return false;
            }
            a = a.getNext();
            b = b.getNext();
        }
        return true;

    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        Node walk = head;
        while (walk.getNext() != null) {
            s.append("(" + walk.getElement()).append(") -> ");
            walk = walk.getNext();
        }
        s.append("(" + walk.getElement() + ")");
        return s.toString();
    }


    public static void main(String[] args) {
        System.out.println("Hello, World!");
//        SinglyLinkedList l = new SinglyLinkedList();

//        l.addFirst(1);
//        l.addLast(5);
//        l.addLast(20);
//        l.addLast(-4);
//        l.addLast(24);
//        l.addLast(27);
//        l.addLast(30);
//        l.addLast(24);

        int [] x = new int [1000000];
        for (int i = 0; i<x.length; i++){
            if(i == 54218) x[i] = 0;
            else x[i] = i+1;
        }
        helpHarryHend(x);
        System.out.println(x[54218]);

    }

    public static int getElementAtIndex(SinglyLinkedList l, int index) {
        if (index < 0 || index >= l.size())
            return -1;
        Node h = l.head;
        int ind = 0;
        while (ind != index) {
            h = h.next;
            ind = ind + 1;
        }
        return h.element;
    }

    public static void deleteNode(SinglyLinkedList l, Node node) {
        if (node == null || l.size == 0) return;
        if (node == l.head) {
            l.removeFirst();
            l.size++;
        } else if (node == l.last()) {
            Node h = l.head;
            for (int i = 0; i < l.size - 2; i++) {
                h = h.next;
            }
            h.setNext(null);
        } else {
            node.element = node.next.element;
            node.next = node.next.next;
        }
        l.size--;
    }

    public static void addInPosition(SinglyLinkedList list, Integer x) {
        if (x == null) return;
        if (list.size == 0 || x <= list.first().element) list.addFirst(x);
        else if (x >= list.last().element) list.addLast(x);
        else {
            Node h = list.head;
            while (x >= h.getNext().element) {
                h = h.next;
            }
            Node n = new Node(x, h.next);
            h.next = n;
            list.size++;
        }
    }

    public static void reverse(SinglyLinkedList l) {
        if (l.size == 0) return;
        Node h = l.head.next, f = l.head;
        int pre_size = l.size;
        for (int i = 0; i < pre_size - 1; i++) {
            l.addFirst(h.element);
            h = h.next;
        }
        f.setNext(null);
        l.size = l.size - pre_size + 1;
    }

    public static int largestDiff(SinglyLinkedList l) {
        if (l.size <= 1) return -1;
        int Large = -1;
        Node h = l.head;
        while (h != l.tail) {
            int sub = Math.abs(h.element - h.next.element);
            if (sub >= Large) Large = sub;
            h = h.next;
        }
        return Large;
    }

    public static boolean hasCycle(SinglyLinkedList l) {
        if (l.size < 1) return false;
        Node h = l.head;
        for (int i = 0; i < l.size; i++) {
            if (h.next == null) {
                return false;
            }
            h = h.next;
        }
        return true;
    }

    public static void helpHarry(int[] array) {
        if (array.length == 1) {
            array[0] = 1;
        } else {
            int Zero_cell = -1;
            double sum = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    Zero_cell = i;
                }
                sum += array[i];
            }
            double FullSum = ((1.0 + array.length) * (array.length / 2.0)) - sum;
            array[Zero_cell] = (int) FullSum;
        }

    }

    public static void helpHarryHend(int[] array) {
        int Zero_cell = -1;
        long n = array.length;
        long sum = -(long)( n* (n + 1) / 2);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                Zero_cell = i;
            }
            sum += array[i];
        }
        array[Zero_cell] = (int) Math.abs(sum);
    }
}
