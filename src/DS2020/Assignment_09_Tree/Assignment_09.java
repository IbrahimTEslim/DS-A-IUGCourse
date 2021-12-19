package DS2020.Assignment_09_Tree;


import java.util.*;

public class Assignment_09 {

    public static void main(String[] args) {
        NodeQ6<Integer> root1 = new NodeQ6<Integer>(1);
        NodeQ5<Integer> root2 = new NodeQ5<Integer>(3);
        NodeQ6<Integer> a = new NodeQ6<>(2);
        NodeQ6<Integer> b = new NodeQ6<>(3);

        NodeQ6<Integer> c = new NodeQ6<>(4);
        NodeQ6<Integer> d = new NodeQ6<>(5);

        NodeQ6<Integer> e = new NodeQ6<>(6);
        NodeQ6<Integer> f = new NodeQ6<>(7);

        root1.setLeft(a);
        root1.setRight(b);
        a.setParent(root1);
        b.setParent(root1);


        a.setLeft(c);
        a.setRight(d);
        c.setParent(a);
        d.setParent(a);

        d.setLeft(e);
        d.setRight(f);
        e.setParent(d);
        f.setParent(d);

        NodeQ6<Integer> mRoot=mirror(root1);

//        TreeNode<Integer> root=new TreeNode<>(4);
//        TreeNode<Integer> a=new TreeNode<>(1);
//        TreeNode<Integer> b=new TreeNode<>(-110);
//        TreeNode<Integer> c=new TreeNode<>(-100);
//        TreeNode<Integer> d=new TreeNode<>(5);
//        TreeNode<Integer> e=new TreeNode<>(11);
//        TreeNode<Integer> f=new TreeNode<>(-300);
//        TreeNode<Integer> g=new TreeNode<>(-40);
//
//        root.addChildren(a);
//        root.addChildren(b);
//        root.addChildren(c);
//        a.setParent(root);
//        b.setParent(root);
//        c.setParent(root);
//
//        a.addChildren(d);
//        a.addChildren(e);
//        b.addChildren(f);
//        c.addChildren(g);
//
//        d.setParent(a);
//        e.setParent(a);
//        f.setParent(b);
//        g.setParent(c);
//
//        System.out.println(secondMax(root));


        String[] cmds={"+ 0 -43","+ 4 1","+ 1 10","+ 2 10","? 5"};//,"+ 4 5","+ 5 6","+ 6 7","+ 7 8","? 7"};
        System.out.println(solveFenwick(5, cmds));

        int[][] list= new int[][]{{25, 24,26,18,19,31,26},
                {4, 3, 1, 2},
                {13, 9, 4, 11},
                {10, 20, 8, 7},
                {32, 10, 21},
                {23, 13, 19, 32, 22},
                {19, 12 ,5 ,14, 17 ,30},
                {14, 6, 15, 16},
                {30, 18, 31, 29},
                {24 ,23, 26},
                {26, 27, 28}};
        System.out.println(helpCat(list,23));
    }


    // Q 1
    static class NodeQ1<E> {
        E data;
        NodeQ1<E> parent;
        NodeQ1<E> left;
        NodeQ1<E> right;

        NodeQ1(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public NodeQ1<E> getParent() {
            return parent;
        }

        public void setParent(NodeQ1<E> parent) {
            this.parent = parent;
        }

        public NodeQ1<E> getLeft() {
            return left;
        }

        public void setLeft(NodeQ1<E> left) {
            if (this.left == null) {
                this.left = left;
            } else {
                this.left.setData(left.data);
            }
        }

        public NodeQ1<E> getRight() {
            return right;
        }

        public void setRight(NodeQ1<E> right) {
            if (this.right == null) {
                this.right = right;
            } else {
                this.right.setData(right.data);
            }
        }
    }
    public static int numberOfNode(NodeQ1<Integer> root) {
        //write code here
        if (root == null) {
            return 0;
        }
        return 1 + numberOfNode(root.left) + numberOfNode(root.right);
    }
    public static int numberOfLeaves(NodeQ1<Integer> root) {
        //write code here
        if (root == null) {
            return 0;
        } else if (root.getRight() == null && root.getLeft() == null) {
            return 1;
        } else {
            return numberOfLeaves(root.getLeft()) + numberOfLeaves(root.getRight());
        }
    }
    public static int numberOfFullNode(NodeQ1<Integer> root) {
        //write code here
        if (root == null) {
            return 0;
        }
        int noFullNodes = 0;
        if (root.getLeft() != null && root.getRight() != null) {
            noFullNodes++;
        }

        noFullNodes += (numberOfFullNode(root.getLeft()) + numberOfFullNode(root.getRight()));
        return noFullNodes;
    }
    public static int numberOfRightLeaves(NodeQ1 root) {
        if (root == null)
            return 0;
        int sum = 0;
        if (root.right != null)
            if (root.right.left == null &&
                    root.right.right == null)
                sum++;

        sum += numberOfRightLeaves(root.left);
        sum += numberOfRightLeaves(root.right);
        return sum;
    }
    // End of Q 1


    // Q 2
    public static String helpCat(int[][] list, int catPlace){
        if(list.length==0) { return ""; }

       boolean[] visited=new boolean[list.length];
       String ans="";
       for(int i=0;i<list.length;i++){
           if(visited[i]==true) { continue; }
           for (int j = 1; j < list[i].length; j++) {
                if(list[i][j]==catPlace){
                    visited[i]=true;
                    ans+=list[i][j]+" -> ";
                    catPlace=list[i][0];
                    i=-1;
                    break;
                }
           }
       }
       return ans+catPlace;
    }
    // End of Q 2



    // Q 3
    public static class TreeNode<E> {

    TreeNode<E> parent;
    List<TreeNode<E>> children;
    E data;

    public TreeNode(E data){
        this.data= data;
        children= new ArrayList<>();
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public List<TreeNode<E>> getChildren() {
        return children;
    }

    public void addChildren(TreeNode<E> child) {
        this.children.add(child);
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
    public static int secondMax(TreeNode<Integer> root) {
        if(root==null) { return 0; }
        int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE;
        Queue<TreeNode<Integer>> q=new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int nodeInThisLevel=q.size();
            while(nodeInThisLevel-- > 0){
                TreeNode<Integer> temp=q.poll();
                if(temp.getData()>first){
                    second=first;
                    first=temp.getData();
                }
                else if(temp.getData()>second){
                    second=temp.getData();
                }
                if(temp.getChildren()!=null){
                    for(TreeNode<Integer> n: temp.children)
                        q.add(n);
                }
            }
        }
        return first;
    }
    public static int Min(TreeNode<Integer> root) {
        if(root==null) { return 0; }
        int first=Integer.MAX_VALUE,second=Integer.MIN_VALUE;
        Queue<TreeNode<Integer>> q=new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int nodeInThisLevel=q.size();
            while(nodeInThisLevel-- > 0){
                TreeNode<Integer> temp=q.poll();
                if(temp.getData()<first){
                    second=first;
                    first=temp.getData();
                }
                else if(temp.getData()>second){
                    second=temp.getData();
                }
                if(temp.getChildren()!=null){
                    for(TreeNode<Integer> n: temp.children)
                        q.add(n);
                }
            }
        }
        return first;
    }
    // End of Q 3



    // Q 4
    static class NodeQ4<E>{
    E data;
    NodeQ4<E> parent;
    NodeQ4<E> left;
    NodeQ4<E> right;

    NodeQ4(E data){
        this.data= data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodeQ4<E> getParent() {
        return parent;
    }

    public void setParent(NodeQ4<E> parent) {
        this.parent = parent;
    }
    public NodeQ4<E> getLeft() {
        return left;
    }

    public void setLeft(NodeQ4<E> left) {
        if(this.left == null) {
            this.left = left;
        }
        else{
            this.left.setData(left.data);
        }
    }

    public NodeQ4<E> getRight() {
        return right;
    }

    public void setRight(NodeQ4<E> right) {
        if(this.right == null){
            this.right= right;
        }
        else{
            this.right.setData(right.data);
        }
    }
}
    static int maxSum(NodeQ4<Integer> root) {
        if (root == null) { return 0; }

        int maxSum = root.getData();
        Queue<NodeQ4> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            int nodeInThisLevel = q.size();
            int levelSum = 0;
            while (nodeInThisLevel-- > 0) {
                NodeQ4<Integer> temp = q.poll();
                levelSum = levelSum + temp.data;
                if (temp.getLeft() != null)
                    q.add(temp.getLeft());
                if (temp.getRight() != null)
                    q.add(temp.getRight());
            }
            maxSum = Math.max(levelSum, maxSum);
        }
        return maxSum;
    }
    // End of Q 4


    // Q 5
    static class NodeQ5<E>{
    E data;
    NodeQ5<E> parent;
    NodeQ5<E> left;
    NodeQ5<E> right;
    NodeQ5(E data){
    this.data= data;
}

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodeQ5<E> getParent() {
        return parent;
    }

    public void setParent(NodeQ5<E> parent) {
        this.parent = parent;
    }
    public NodeQ5<E> getLeft() {
        return left;
    }

    public void setLeft(NodeQ5<E> left) {
        if(this.left == null) {
            this.left = left;
        }
        else{
            this.left.setData(left.data);
        }
}

    public NodeQ5<E> getRight() {
        return right;
    }

    public void setRight(NodeQ5<E> right) {
        if(this.right == null){
            this.right= right;
        }
        else{
            this.right.setData(right.data);
        }
    }
    }
    public static boolean identicalStructural(NodeQ5<Integer> root1, NodeQ5<Integer> root2){
        if(root1==null && root2== null){ return true; }
        else if(root1!=null && root2==null || root1==null && root2!=null) { return false; }
        else{
            if(identicalStructural(root1.getLeft(),root2.getLeft())==true && identicalStructural(root1.getRight(),root2.getRight())) {  return true; }
            else { return false; }
        }
    }
    // End of Q 5


    // Q 6
    static class NodeQ6<E>{
    E data;
    NodeQ6<E> parent;
    NodeQ6<E> left;
    NodeQ6<E> right;

    NodeQ6(E data){
        this.data= data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodeQ6<E> getParent() {
        return parent;
    }

    public void setParent(NodeQ6<E> parent) {
        this.parent = parent;
    }
    public NodeQ6<E> getLeft() {
        return left;
    }

    public void setLeft(NodeQ6<E> left) {
        if(this.left == null) {
            this.left = left;
        }
        else{
            this.left.setData(left.data);
        }
    }

    public NodeQ6<E> getRight() {
        return right;
    }

    public void setRight(NodeQ6<E> right) {
        if(this.right == null){
            this.right= right;
        }
        else{
            this.right.setData(right.data);
        }
    }
}
    public static NodeQ6<Integer> mirror(NodeQ6<Integer> root) {
        if(root==null)return null;

        NodeQ6<Integer> mirrorRoot=new NodeQ6<Integer>(root.data);
        mirrorRoot.setLeft(mirror(root.getRight()));
        mirrorRoot.setRight(mirror(root.getLeft()));

        return mirrorRoot;
    }
    // End of Q 6


    // Q 7
    public static String solveFenwick(int n,String[] cmds){
        int[] ary=new int[n+1];
        String res="";
        for(int i=0;i<ary.length;i++) { ary[i]=0; }
        for(int i=0;i<cmds.length;i++){
            String[] cmd=cmds[i].split(" ");
            if(cmd[0].charAt(0)=='+'){
                int index=Integer.parseInt(cmd[1])+1;
                int value=Integer.parseInt(cmd[2]);
                for (;index <= n;) {
                    ary[index]+=value;
                    index += -index & index;
                }
            }
            else{
                int sum = 0;
                int queryIndex=Integer.parseInt(cmd[1]);
                if(queryIndex>=0) { // if queryIndex == 1 it means the query for arr[0] so interpreted as an empty sum (sum = 0)
                    for (; queryIndex > 0; ) {
                        sum += ary[queryIndex];
                        queryIndex -= -queryIndex & queryIndex;
                    }
                } else { sum = 0; }

                res += sum + "\n";
                //or we can print it
                //System.out.println(sum);
            }
        }
        return res;
    }
    // End of Q 7



}
