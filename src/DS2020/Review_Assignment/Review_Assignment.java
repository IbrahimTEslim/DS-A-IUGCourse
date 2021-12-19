package DS2020.Review_Assignment;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;

public class Review_Assignment {
    public static void main(String[] args) {

        System.out.println(is_permutation_of_a_palindrome("Osama's SMS"));
        System.out.println(is_permutation_of_a_palindrome("aa"));
//        Node<Integer> root=new Node<Integer>(3);
//        Node<Integer> xl=new Node<Integer>(2);
//        Node<Integer> xr=new Node<Integer>(1);
//        Node<Integer> zl=new Node<Integer>(0);
//        Node<Integer> zr=new Node<Integer>(1);
//        root.setLeft(xl);
//        root.setRight(xr);
//        xl.setParent(root);
//        xr.setParent(root);
//
//        zr.setParent(xl);
//        xl.setRight(zr);
//
//        zl.setParent(xr);
//        xr.setLeft(zl);
//        delete(root);
//        System.out.println("Done!");

    }




    // Q 1
    public static void changeDeque(Deque<Integer> S, Deque<Integer> D){
        S.add(D.poll());
        S.add(D.poll());
        D.add(D.poll());
        S.add(D.poll());
        D.add(D.poll());
        D.add(D.poll());
        S.add(D.poll());
        S.add(D.poll());
        S.add(D.poll());

        D.add(S.poll());
        D.add(S.poll());
        D.add(S.poll());
        D.add(S.poll());
        D.add(S.poll());
        D.add(S.poll());
    }
    // End of Q 1

    // Q 2
    static class Node<E>{
    E data;
    Node<E> parent;
    Node<E> left;
    Node<E> right;

    Node(E data){
        this.data= data;
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
        if(this.left == null) {
            this.left = left;
        }
        else{
            this.left.setData(left.data);
        }
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        if(this.right == null){
            this.right= right;
        }
        else{
            this.right.setData(right.data);
        }
    }
}

    public static Node<Integer> deleteAllLeavs(Node<Integer> root){
        if(root==null) return null;
        Queue<Node<Integer>> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node<Integer> temp=q.poll();
            if(temp.left==null && temp.right==null){
                temp=temp.getParent();
                if(temp.right!=null) {
                    if (temp.right.left == null && temp.right.right == null) {
                        temp.right=null;
                    }
                }
                if(temp.left!=null) {
                    if (temp.left.left == null && temp.left.right == null) {
                        temp.left=null;
                    }
                }
                continue;
            }
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        return root;
    }
    public static Node<Integer> delete(Node<Integer> root){
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }

        // Else recursively delete in left and right
        // subtrees.
        root.left = delete(root.left);
        root.right = delete(root.right);

        return root;
    }



    // Q 3
    int findMessing(int [] array){
        long max=array[0],sum=array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i]>max) max=array[i];
            sum+=array[i];
        }
        long totalSum=max*(max+1)/2;
        return (int)(totalSum-sum);
    }
    // Q 3


    // Q 4
    public static boolean is_permutation_of_a_palindrome(String s) {
        int[] letters=new int[26];
        for (int i = 0; i < s.length(); i++) {
            if(!Character.isLetter(s.charAt(i))) continue;
            char ch=Character.toLowerCase(s.charAt(i));
            if(letters[ch-97]>0) letters[ch-97]--;
            else letters[ch-97]++;
        }
        int sum=0;
        for (int i = 0; i < 26; i++) {
            sum+=letters[i];
        }
        return sum<=1;
    }
    // End of Q 4

}
