package DS2020.Assignment_10_Heap;

import java.util.*;

public class Assignment_10 {
    public static void main(String[] args) {
        int[] a={2, 3, 4, 2, 3, 6, 8, 4, 5};
        int[] b={2, 2, 3, 3, 4, 6, 8, 4, 5};
        System.out.println(activityNotifications(4,a));
    }

    // Q 1
    public static int activityNotifications(int d, int[] expenditure){
        int notifications=0,index=0;
        for (int i = d; i <expenditure.length ; i++) {
            int[] temp=Arrays.copyOfRange(expenditure,index,index+d);
            Arrays.sort(temp);
            double median=getMedian(temp);
            if(median*2<=expenditure[i])
                notifications++;

            index++;
        }

        return notifications;
    }
    static double getMedian(int[] ary){
        if(ary.length%2==0) {
            return (double)((ary[ary.length/2]+ary[(ary.length/2)-1])/2.0);
        }
        else
            return ary[ary.length/2];
    }
    // End of Q 1



/*
    // Q 2
    public class QueueByPQ<E> implements Queue<E> {

        class KeyValue<E> implements Comparable<KeyValue>{
            int key;
            E value;
            public KeyValue(int k,E v){
                this.key=k;
                this.value=v;
            }

            @Override
            public int compareTo(KeyValue o) {
                return key-o.key;
            }
            @Override
            public String toString(){
                return value+"";
            }
        }

        PriorityQueue<KeyValue<E>> pq = new PriorityQueue<>();
        int t = 0;

        @Override
        public int size() {
            return pq.size();
        }

        @Override
        public boolean isEmpty() {
            return pq.isEmpty();
        }

        @Override
        public void enqueue(E e) {
            pq.add(new KeyValue<>(t++,e));
        }

        @Override
        public E dequeue() {
            //write code here
            if(pq.isEmpty())
                return null;
            return pq.poll().value;
        }

        @Override
        public E first() {
            //write code here
            if(pq.isEmpty())
                return null;
            return pq.peek().value;
        }

        @Override
        public String toString() {
            //write code here
            return pq.toString();
        }
    }
    // End of Q 2

    // Q 3
    public class StackByPQ<E> implements Stack<E>{

        class KeyValue<E> implements Comparable<KeyValue>{
            int key;
            E value;
            public KeyValue(int k,E v){
                this.key=k;
                this.value=v;
            }

            @Override
            public int compareTo(KeyValue o) {
                return key-o.key;
            }
            @Override
            public String toString(){
                return value+"";
            }
        }
        PriorityQueue<KeyValue<E>> pq= new PriorityQueue<>();
        int t= 0;
        @Override
        public int size() {
            //write code here
            return pq.size();
        }

        @Override
        public boolean isEmpty() {
            //write code here
            return pq.isEmpty();
        }

        @Override
        public void push(E e) {
            //write code here
            pq.add(new KeyValue<>(t--,e));
        }

        @Override
        public E pop() {
            //write code here
            if(pq.isEmpty())
                return null;
            return pq.poll().value;
        }

        @Override
        public E top() {
            //write code here
            if(isEmpty())
                return null;
            return pq.peek().value;
        }

        @Override
        public String toString() {
            //write code here
            return pq.toString();
        }
    }
    // End of Q 3
*/


    // Q 5
    class Heap<E extends Comparable<E>> {
        protected List<E> heap = new ArrayList<>();


        public E getElement(int j) {
            return heap.get(j);
        }


        public int size() {
            return heap.size();
        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }

        public int parent(int j) {
            return (j - 1) / 2;
        }

        public int left(int j) {
            return 2 * j + 1;
        }

        public int right(int j) {
            return 2 * j + 2;
        }

        public boolean hasLeft(int j) {
            return left(j) < heap.size();
        } // you can make is external in a previous chapter in a same way :)

        public boolean hasRight(int j) {
            return right(j) < heap.size();
        }


        public E min() {
            if (heap.isEmpty()) return null;
            return heap.get(0);
        }

//    public E removeMin() {
//        if (isEmpty()) return null;
//        E answer = heap.get(0);
//        swap(0, size() - 1);
//        heap.remove(size() - 1);
//        downheap(0);
//        return answer;
//    }
    }
    //index of root = 0;

    // Breadth Traversal
    public static void printSmaller(Heap<Integer> heap, int x) {
        Queue<Integer> q = new ArrayDeque<>();
        if (heap.min() > x) return;
        q.add(0);
        System.out.print(heap.min() + " ");
        while (!q.isEmpty()) {
            int node = q.poll();
            if (heap.hasLeft(node) && heap.getElement(heap.left(node)) <= x) {
                q.add(heap.left(node));
                System.out.print(heap.getElement(heap.left(node)) + " ");
            }
            if (heap.hasRight(node) && heap.getElement(heap.right(node)) <= x) {
                q.add(heap.right(node));
                System.out.print(heap.getElement(heap.right(node)) + " ");
            }
        }
    }

    // Depth Traversal - PreOrder Traversal
    public static void printSmaller(Heap<Integer> heap, int x,int index) {
        if(index==0){
            System.out.print(heap.min()+" ");
        }
        if (heap.hasLeft(index) && heap.getElement(heap.left(index))<=x){
            System.out.print(heap.getElement(heap.left(index))+" ");
            printSmaller(heap,x,heap.left(index));
        }
        if(heap.hasRight(index)&&heap.getElement(heap.right(index))<=x){
            System.out.print(heap.getElement(heap.right(index))+" ");
            printSmaller(heap,x,heap.right(index));
        }
    }
    // End of Q 5
}
