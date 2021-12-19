package DS2020.Assignment_03_Recursion;


import java.util.Arrays;

public class Assignment_03 {
    public static void main(String[] args) {
        int[] a = new int[]{5, 7, 6, 2, 6, 2, 2, 9};
        int[] b = new int[]{1, 5, 8, 8, 9, 4};
        int[] c = new int[]{5, 7, 6, 2, 6, 2, 2, 9};
        int[] d = new int[]{9, 9, 8, 6, 15, 9, 7, 8, 10, 7, 1, 0, 13, 9, 16, 11, 7, 14};
        int[] e = new int[]{12, 2, 6, 2, 2, 14, 7, 4, 4, 11, 3, 9, 4, 3};
        int i = 10;
        Lock l=new Lock();
        System.out.println(salah_ways(21));
        System.out.println(crack(l));
//        System.out.println("@rt#02m" == "@rt#02m");
//        System.out.println(NoursWinnings(a));
//        System.out.println(NoursWinnings_Test(c));
//        System.out.println(EmansWinnings_Test(a,0)[1]);
//        System.out.println(EmansWinnings_Test(c,0)[1]);
//        System.out.println(NoursWinnings_Original(c));

//        System.out.println(Arrays.toString(Arrays.copyOfRange(x, 1, x.length)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(x, 0, x.length-1)));
//        System.out.println(EmansWinnings(b));
//        System.out.println(EmansWinnings(c));

//        int tri[][] = {{1, 0, 0},
//                {4, 8, 0},
//                {1, 5, 3}};
//        System.out.println(maxPathSum(tri, 2, 2));

    }


    public static int ones_in_BinaryRepresentation(int num) {
        if (num == 0) return 0;
        else if (num % 2 != 0) return 1 + ones_in_BinaryRepresentation(num - 1);
        else return ones_in_BinaryRepresentation(num / 2);
    } //// Q 1


    // Q2
    static void big_X_pattern(int height) {
        if (height <= 0) return;
        if (height == 1) {
            System.out.print("O");
            return;
        }
        if (height == 2) {
            System.out.print("OO\nOO");
            return;
        }


        up_line(0, height);
        if (height % 2 == 0) {
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < height / 2 - 1; i++)
                    System.out.print(" ");
                System.out.println("OO");
            }
            down_line(height / 2 - 2, height, 2);
        } else {
            for (int i = 0; i < height / 2; i++)
                System.out.print(" ");
            System.out.println("O");
            down_line(height / 2 - 1, height, 1);
        }
    }

    static void up_line(int i, int heigth) //Following Q2
    {
        if (heigth == i + 2 || heigth == i + 1) return;
        for (int j = 0; j < i; j++) System.out.print(" ");
        System.out.print("O");
        for (int j = i; j < heigth - 2; j++) System.out.print(" ");
        System.out.print("O");
        System.out.println();
        up_line(i + 1, heigth - 1);
    }

    static void down_line(int i, int heigth, int th) //Following Q2
    {
        if (i == 0) {
            System.out.print("O");
            for (int q = 0; q < heigth - 2; q++)
                System.out.print(" ");
            System.out.print("O");
            return;
        }
        for (int j = i; j > 0; j--) System.out.print(" ");
        System.out.print("O");
        for (int j = 0; j < th; j++) System.out.print(" ");
        System.out.print("O");
        System.out.println();
        down_line(i - 1, heigth, th + 2);

    }
    // End of Q2


    //// Q 3

    /* Here is the Node class that is defined inside this question */
    public static class Node<E> {
        private E element;
        private Node<E> next;

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public static Node<Integer> removeAllOccurrences(Node<Integer> head, int item) {
        if (head == null) return null;

        if (head.getElement() == item) {
            helper(head, item);
        }
        if (head == null) return null;
        if (head.element == item && head.getNext() == null) return null;
        if (head.getNext() == null) return null;
        if (head.getNext().getElement() == item) {
            head.setNext(head.getNext().getNext());
            removeAllOccurrences(head, item);
        }
        removeAllOccurrences(head.getNext(), item);
        return head;
    }

    public static void helper(Node<Integer> head, int item) {
        if (head.getNext() == null) return;
        if (head.element == item) {
            head.element = head.getNext().element;
            head.setNext(head.getNext().getNext());
            helper(head, item);
        } else return;
    }  // helper 1

    //// End of Q 3


    static long salah_ways(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        return salah_ways(n - 3) + salah_ways(n - 2) + salah_ways(n - 1);
    }  //// Q 4


    //// Q 5
    static void twoEqualPartitions(int arr[]) {
        if (sumAry(arr) % 2 != 0) {
            System.out.print("No Solution");
            return;
        }
        int n = arr.length;
        int counter = 0;
        int nonZeroNo = 0;
        for (int i = 0; i < (1 << n); i++) {
            int[] tmp = new int[arr.length];


            //////////////////////////
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) > 0)
                    tmp[j] = arr[j];
            ///////////////////////
            if (sumAry(tmp) == sumAry(arr) / 2) {
                sort(tmp);

                for (int e : tmp)
                    if (e != 0) nonZeroNo++;
                int[] first = new int[nonZeroNo];
                nonZeroNo = 0;
                for (int d = 0; d < tmp.length; d++)
                    if (tmp[d] != 0) {
                        first[nonZeroNo] = tmp[d];
                        nonZeroNo++;
                    }

                for (int q = 0; q < arr.length; q++) {
                    for (int v = 0; v < tmp.length; v++) {
                        if (arr[q] == tmp[v]) {
                            if (arr[q] == 0) continue;
                            arr[q] = 0;
                            tmp[v] = 0;
                            counter++;
                        }
                    }
                }

                int[] third = new int[arr.length - counter];
                counter = 0;
                for (int e : arr)
                    if (e != 0) {
                        third[counter] = e;
                        counter++;
                    }

                sort(third);
                if (first.length > third.length) {
                    for (int e : first)
                        if (e != 0) System.out.print(e + " ");
                    System.out.println();
                    for (int e : third) {
                        System.out.print(e + " ");
                    }
                } else {
                    for (int e : third) {
                        System.out.print(e + " ");
                    }
                    System.out.println();
                    for (int e : first)
                        if (e != 0) System.out.print(e + " ");
                }
                return;
            }
        }
        System.out.print("No Solution");

    }

    static int sumAry(int[] arr) {
        int sum = 0;
        for (int e : arr) sum += e;
        return sum;
    } // helper 1

    static void sort(int[] ary) {
        for (int LastUnsortedIndex = ary.length - 1; LastUnsortedIndex > 0; LastUnsortedIndex--) {

            int LargeElement = ary[0];
            int pos = 0;


            for (int i = 1; i <= LastUnsortedIndex; i++) {
                if (ary[i] > LargeElement) {
                    LargeElement = ary[i];
                    pos = i;
                }
            }


            int temp = ary[LastUnsortedIndex];
            ary[LastUnsortedIndex] = LargeElement;
            ary[pos] = temp;
        }
    }  // helper 2

    //// End of Q 5


    public static int NoursWinnings(int[] arr) {
        int[] withoutLast = new int[arr.length - 1];
        if (arr.length % 2 == 0) {
            if (arr.length == 2)
                return Math.max(arr[0], arr[1]);


            for (int i = 0; i < withoutLast.length; i++) withoutLast[i] = arr[i];
            int fromRight = arr[arr.length - 1] + NoursWinnings(withoutLast);

            for (int i = 1; i < withoutLast.length + 1; i++) withoutLast[i - 1] = arr[i];
            int fromLeft = arr[0] + NoursWinnings(withoutLast);

            if (fromRight > fromLeft) {
                return fromRight;
            } else return fromLeft;
        } else {
            if (arr.length == 1)
                return arr[0];

//            withoutLast = new int[arr.length - 1];
            for (int i = 0; i < withoutLast.length; i++) withoutLast[i] = arr[i];
            int first = arr[arr.length - 1] + NoursWinnings(withoutLast);

            for (int i = 1; i < withoutLast.length + 1; i++) withoutLast[i - 1] = arr[i];
            int last = arr[arr.length - 1] + NoursWinnings(withoutLast);
            return Math.max(first, last);
//            if (fromRight > fromLeft) {
//                return fromRight;
//            } else return fromLeft;
        }

    }

//    public static int NourWinnings(int[] arr) {
//        if (arr.length == 2)
//            return Math.max(arr[0], arr[1]);
//        int[] withoutfirst = Arrays.copyOfRange(arr, 1, arr.length);
//        int first = arr[0];
//        EmanWinnings(withoutfirst);
//        int[] withoutLast = Arrays.copyOfRange(arr, 0, arr.length - 2);
//        int last = arr[arr.length - 1] + NourWinnings(withoutLast);
//        return (last < first) ? first : last;
//
//    }

//    public static int EmanWinnings(int[] arr) {
//        if (arr.length == 1)
//            return arr[0];
//        int[] withoutfirst = Arrays.copyOfRange(arr, 1, arr.length);
//        int first = arr[0];
//        NourWinnings(withoutfirst);
//        int[] withoutLast = Arrays.copyOfRange(arr, 0, arr.length - 2);
//        int last = arr[arr.length - 1] + NourWinnings(withoutLast);
//        return (last < first) ? first : last;
//
//    }
//    public static int NoursWinnings(int[] arr,int z) {
//        if(arr.length==0)
//            return 0;
//        int[] withoutLast=new int[arr.length-2];
//
//        for(int i=0;i<withoutLast.length;i++) withoutLast[i]=arr[i];
//        int fromRight= arr[arr.length-1]+NoursWinnings(withoutLast,z);
//
//        for(int i=2;i<withoutLast.length+2;i++) withoutLast[i-2]=arr[i];
//        int fromLeft = arr[0]+NoursWinnings(withoutLast,z);
//
//        if(fromRight>fromLeft) {
//            z=2;
//            return fromRight;
//        }
//        else {
//            z=1;
//            return fromLeft;
//        }
//    }

//    public static int NoursWinnings2(int[] arr) {
//        NoursWinnings(arr);
//    }

    ///// Q 6 (Not complete)
    public static int EmansWinnings(int[] arr) {
        if (arr.length == 1)
            return 0;

        int[] withoutLast = new int[arr.length - 2];
        for (int i = 0; i < withoutLast.length; i++) withoutLast[i] = arr[i];
        int fromRight = arr[arr.length - 1] + EmansWinnings(withoutLast);

        for (int i = 2; i < withoutLast.length + 2; i++) withoutLast[i - 2] = arr[i];
        int fromLeft = arr[0] + EmansWinnings(withoutLast);

        if (fromRight > fromLeft) {
            return fromRight;
        } else return fromLeft;
    }

    public static int NoursWinnings_Test(int[] arr) {
        if (arr.length % 2 != 0) {
            int[] eman = EmansWinnings_Test(arr, 0);
            if (eman[1] == 2) {
//             return   NoursWinnings_Test(Arrays.copyOfRange(arr, 0, arr.length-1));
                int[] withoutLast = new int[arr.length - 1];
                for (int g = 0; g < withoutLast.length - 1; g++) withoutLast[g] = arr[g];
                return NoursWinnings_Test(withoutLast);
            } else {
//                return NoursWinnings_Test(Arrays.copyOfRange(arr, 1, arr.length));
                int[] withoutLast = new int[arr.length - 1];
                for (int g = 1; g < withoutLast.length + 1; g++) withoutLast[g - 1] = arr[g];
                return NoursWinnings_Test(withoutLast);
            }
//           return 0;
        } else {
            if (arr.length == 0)
                return 0;
            int[] withoutLast = new int[arr.length - 1];

            for (int i = 0; i < withoutLast.length; i++) withoutLast[i] = arr[i];
            int fromRight = arr[arr.length - 1] + NoursWinnings_Test(withoutLast);

            for (int i = 1; i < withoutLast.length + 1; i++) withoutLast[i - 1] = arr[i];
            int fromLeft = arr[0] + NoursWinnings_Test(withoutLast);

            if (fromRight > fromLeft) {
                return fromRight;
            } else {
                return fromLeft;
            }
        }
        // for(int i=0;i<arr.length;i++)
        //  { i++;}

    }

    public static int[] EmansWinnings_Test(int[] arr, int k) {
        if (arr.length == 1)
            return new int[]{0, k};
        int[] withoutLast = new int[arr.length - 2];

        for (int i = 0; i < withoutLast.length; i++) withoutLast[i] = arr[i];
        int fromRight = arr[arr.length - 1] + EmansWinnings_Test(withoutLast, k)[0];

        for (int i = 2; i < withoutLast.length + 2; i++) withoutLast[i - 2] = arr[i];
        int fromLeft = arr[0] + EmansWinnings_Test(withoutLast, k)[0];

        if (fromRight > fromLeft) {
            k = 2;
            return new int[]{fromRight, k};
        } else {
            k = 1;
            return new int[]{fromLeft, k};
        }

        // for(int i=0;i<arr.length;i++)
        //  { i++;}

    }

    public static int NoursWinnings_Original(int[] arr) {
        if (arr.length == 0)
            return 0;
        int[] withoutLast = new int[arr.length - 2];

        for (int i = 0; i < withoutLast.length; i++) withoutLast[i] = arr[i];
        int fromRight = arr[arr.length - 1] + NoursWinnings(withoutLast);

        for (int i = 2; i < withoutLast.length + 2; i++) withoutLast[i - 2] = arr[i];
        int fromLeft = arr[0] + NoursWinnings(withoutLast);

        if (fromRight > fromLeft) return fromRight;
        else return fromLeft;

        // for(int i=0;i<arr.length;i++)
        //  { i++;}

    }
    ///// End of Q 6 (Not completed)


    ///// Q 7 (Not completed)
    static int maxPathSum(int tri[][], int n) {
        // loop for bottom-up calculation
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // for each element, check both
                // elements just below the number
                // and below right to the number
                // add the maximum of them to it
                if (tri[i + 1][j] > tri[i + 1][j + 1])
                    tri[i][j] += tri[i + 1][j];
                else
                    tri[i][j] += tri[i + 1][j + 1];
            }
        }

        // return the top element
        // which stores the maximum sum
        return tri[0][0];
    }
    ///// End of Q 7 (Not completed)


    ///// Q 8
    static String pass=new String();
    static String crack(Lock lock) {
        char[] Sets = new char[]{'a', 'l', 'g', 'o','r','i','t','h','m','0','2','@','#'};
        String temp = "";
        for (int i = 0; i < (1 << Sets.length); i++) {
            temp="";
            for (int j = 0; j < Sets.length; j++) {
                if ((i & (1 << j)) > 0)
                    temp += Sets[j];
            }
            if (temp.length() >= 3 && temp.length() <= 7)
               if(temp.contains("0")||temp.contains("2"))
                    if(temp.contains("@")||temp.contains("#"))
                        if(temp.contains("a")||temp.contains("l")||temp.contains("g")||temp.contains("o")||temp.contains("r")||temp.contains("i")||temp.contains("t")||temp.contains("h")||temp.contains("m"))
                           permute(temp,0,temp.length()-1,lock, "");

                            if(pass.length()>2){
                                return (pass);}
        }
        return pass;
    }

     static String[] permute(String str,int l, int r,Lock lock, String k) //Helper 1
    {
        if (l == r) {
            if (lock.open(str) == true) {
               pass = str; return new String[]{str, k};}
        }
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r,lock, k);
                str = swap(str,l,i);
            }
        }
        return new String [] {"",k};
    }

    static String swap(String a, int i, int j) //Helper for Helper 1
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    static class Lock{
        public  boolean open(String pass) {
            if (pass.equalsIgnoreCase("algo2#")) {
                return true;
            } else return false;
        }
    } //Class Lock to test if our crack works or not
    ///// Q 8
}

