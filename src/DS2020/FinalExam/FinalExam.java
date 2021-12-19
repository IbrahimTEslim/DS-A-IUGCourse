package DS2020.FinalExam;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FinalExam {
    public static void main(String[] args) {

    }


    // Q 1
    class Node<E> {
        E data;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            if (this.left == null) {
                this.left = left;
            } else {
                this.left.setData(left.data);
            }
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            if (this.right == null) {
                this.right = right;
            } else {
                this.right.setData(right.data);
            }
        }

    }

    public int calculateWidth(Node<Integer> root) {
        if (root == null) return 0;
        Integer min = root.data, max = root.data;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node<Integer> temp = q.poll();
            if (temp.getData() < min) min = temp.getData();
            if (temp.getData() > max) max = temp.getData();
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
        return max - min;
    }


    // Q 2
    class Line{
        // return 0 for while and 0 for black
        int whitePoint;
        int money=0;
        Line(int whitePoint){ this.whitePoint=whitePoint; }
        int getColorOfPoint(int p){
            if(p>=this.whitePoint) return 0;
            else return 1;
        }
    }
    static int findChangPoint(Line line) {
        // call line.getColorOfPoint( p ) to get the color of point p
        int point = 1000;
        if (line.getColorOfPoint(point) == 1) {
            return helper(line, 0, point);
        }
        while (line.getColorOfPoint(point) == 0) {
            point *= point;
        }
        return helper(line, (int) (Math.sqrt(point)), point);
    }

    static int helper(Line line, int s, int e) {
        while (e > s) {
            int mid = s + (e - s) / 2;
            if (line.getColorOfPoint(mid) == 0)
                s = mid + 1;
            if (line.getColorOfPoint(mid) == 1) {
                e = mid - 1;
            }
        }
        if (line.getColorOfPoint(e) == 1 && line.getColorOfPoint(e - 1) == 0)
            return e;

        else
            return e + 1;
    }


    // Q 4
    static long salah_ways(int n, int jumps, int[] broken_steps) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer e : broken_steps)
            set.add(e);
        long[] arr = new long[n + 1];
        java.util.Arrays.fill(arr, -1);
        return salah_ways(arr, n, jumps, set);
    }
    static long salah_ways(long[] arr, int n, int jumps, HashSet<Integer> set) {
        if (n < 0) return 0;
        if (n < 2) return 1;
        if (arr[n] != -1) return arr[n];
        long sum = 0;
        int r = 1;
        while (r <= jumps) {
            if (set.contains(n)) return 0;
            sum += salah_ways(arr, n - r, jumps, set);
            r++;
        }
        return arr[n] = sum;
    }
    // End of Q 4

}
