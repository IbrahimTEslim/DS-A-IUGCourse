package DS2020.Assignment_04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Assignment_04 {
    public static void main(String[] args) {
        int[] a = new int[]{20, 47, 71, 23 ,48 ,1 ,94, 7 ,99 ,75};
        int[] b = new int[]{4,7,8,-10};
        System.out.println(Arrays.toString(calculateDamage(a)));
    }


    // Q 1
    public static int findSpecialIndex(int[] arr) {
        return Helper1(arr, 0, arr.length);
    }
    public static int Helper1(int[] insert, int start, int end) {
        if (end - start < 2) {
            if (insert[end - start] == end - start) return end - start;
            if (insert[end - start - 1] == end - start - 1) return end - start - 1;
            else return -1;
        }
        int mid = (end + start) / 2;
        if (insert[mid] == mid) return mid;
        else if (insert[mid] < mid) {
            return Helper1(insert, mid, end);
        } else {
            return Helper1(insert, start, mid);
        }

    }
    // End of Q 1


    // Q 2
    static int[] findElement(int[][] arr, int element) {
        return Helper2(arr, element, 0, arr.length - 1);
    }
    static int[] Helper2(int[][] arr, int e, int log, int y) {
        if (log < arr.length && y >= 0) {
            if (arr[log][y] == e) return new int[]{log, y};
            if (arr[log][y] < e) return Helper2(arr, e, log + 1, y);
            if (arr[log][y] > e) return Helper2(arr, e, log, y - 1);
        }
        return new int[]{-1, -1};
    }
    // End of Q 2

    // Q 3
    static void rearrange(int[] arr) {
        if (arr.length <= 1) return;
        int negative=0,positve=arr.length-1;

        for(int i=0;i<arr.length;i++)
            if(arr[i]<0){
                swap(arr,i,negative);
                negative++;
            }
        for(int i=arr.length-1;i>=0;i--)
            if(arr[i]>0) {
                swap(arr,i,positve);
                positve--;
            }
    }
    static void swap(int[] ary, int f, int s) {
        int temp = ary[f];
        ary[f] = ary[s];
        ary[s] = temp;
    }
    // End of Q 3



    // Q 4
//    static SecretItem[] firstAndSecondMax(SecretItem arr[], SecretItemComparator myComparator) {
//        int[] log; // for indexs
//        int Log_counter = 0; // index for log
//        int firstLarge = 0; // firstLarge is only an index
//        if (arr.length % 2 == 0) {log = new int[arr.length / 2 + 2];}
//         else {
//            log = new int[arr.length / 2 + 3];
//            log[0] = arr.length - 1;
//            Log_counter = 1;}
//        for (int i = 0; i < arr.length - 1; i += 2) {
//            if (myComparator.compare(arr[i], arr[i + 1]) == 1) {
//                log[Log_counter] = i;
//                Log_counter++;
//                if (i == 0) { firstLarge = i; }
//                if (myComparator.compare(arr[i], arr[firstLarge]) == 1) {firstLarge = i; }
//            } else {
//                log[Log_counter] = i + 1;
//                Log_counter++;
//                if (i == 0) { firstLarge = log[i + 1];}
//                if (myComparator.compare(arr[i + 1], arr[firstLarge]) == 1) { firstLarge = i + 1;}
//            }}
//        if (arr.length % 2 != 0) {
//            if (myComparator.compare(arr[arr.length - 1] , arr[firstLarge])==1  ) { firstLarge = arr.length - 1; }
//        }
//        if (firstLarge == arr.length - 1) {  log[log.length - 2] = firstLarge - 1;}
//        else if (firstLarge == 0) {log[log.length - 1] = firstLarge + 1;}
//         else { log[log.length - 2] = firstLarge - 1;log[log.length - 1] = firstLarge + 1;}
//        return new SecretItem[]{arr[firstLarge], Get_Second(log, arr, firstLarge, myComparator)};
//    }
//    public static SecretItem Get_Second(int[] indexs, SecretItem[] arr, int firstLarge, SecretItemComparator myComparator) {
//        Arrays.sort(indexs);
//        int length = removeDuplicateElements(indexs, indexs.length);
//        SecretItem Second_Max;
//        if (firstLarge != 0) { Second_Max = arr[indexs[0]];}
//         else {Second_Max = arr[indexs[1]];}
//        for (int i = 0; i < length; i++) {
//            if (indexs[i] != firstLarge) {
//                if (myComparator.compare(arr[indexs[i]] , Second_Max)==1   ) {Second_Max = arr[indexs[i]];}
//            }}
//        return Second_Max;}
//    //Remove Method from the Internet
//    public static int removeDuplicateElements(int arr[], int n) {
//        if (n == 0 || n == 1) {
//            return n;
//        }
//        int[] temp = new int[n];
//        int j = 0;
//        for (int i = 0; i < n - 1; i++) {
//            if (arr[i] != arr[i + 1]) {
//                temp[j++] = arr[i];
//            }
//        }
//        temp[j++] = arr[n - 1];
//        // Changing original array
//        for (int i = 0; i < j; i++) {
//            arr[i] = temp[i];
//        }
//        return j;
//    }
    // End of Q 4


/*
    Database a, and Database b here are special objcts that you can query for the kth smallest item.
    if you call a.query(1), Database a will return the smallest item in it (and charge you $10)
    if you call a.query(5), Database a will return the 5th smallest item in it (and charge you another $10) and so on.
*/

    // Q 5
//    static int findMedian(Database a,Database b)
//    {
//        int start=0,end=a.size(),n= a.size(),A_index,B_index;
//        if(a.size()==1)
//        {
//            int ax=a.query(1),bx=b.query(1);
//            if(ax>bx)return bx;
//            else return ax;
//        }
//        if(a.size()==2)
//        {
//            int ax1=a.query(1),bx1=b.query(1),ax2=a.query(2);
//            return Math.min(ax2,Math.max(ax1,bx1));
//        }
//        if(a.size()==3)
//        {
//            int ax2=a.query(2),bx2=b.query(2),ax1=a.query(1),bx1=b.query(1),ax3=a.query(3),bx3=b.query(3);
//            if(ax2>bx2)
//            {
//                if(bx2<ax1)
//                {
//                    if(bx3<ax1) return bx3;
//                    return ax1;
//                }
//                else return bx2;
//            }
//            else
//            {
//                if(bx1<ax3)
//                {
//                    if(bx1>ax2)return bx1;
//                    return ax2;
//                }
//                else return ax3;
//            }
//        }
//
//        while(start<=end)
//        {
//            A_index = (start + end) / 2;
//            B_index = n - A_index;
//
//
//            if(A_index > 1 && B_index < n && b.query(B_index+1) < a.query(A_index))
//                end=A_index-1;
//            else if(A_index < n && B_index > 1 && b.query(B_index) >a.query(A_index+1)) start=A_index+1;
//            else
//            {
//                int B_dxz=b.query(B_index),A_dxz=a.query(A_index);
//                if(A_index==1)  return B_dxz;
//                if(B_index==1) return A_dxz;
//                else
//                if(A_dxz>B_dxz) return A_dxz;
//                else return B_dxz;
//            }
//        }
//        return 0;
//    }
    //End of Q 5


    // Q 6
    static long maxSubArraySum(int a[]){
    long temp_max=a[0],Top_max=a[0];
    for(int i=1;i<a.length;i++){
        if(temp_max+a[i]>=a[i])  temp_max=temp_max+a[i];
        else  temp_max=a[i];
        if(Top_max<temp_max)Top_max=temp_max;
        }
    return Top_max;
    }
    // End of Q 6


    // Q 7
    static class House {

        int resistance;
        int indx;

        public House(int resistance, int indx) {
            this.resistance = resistance;
            this.indx = indx;
        }

        public int getIndx() {
            return indx;
        }

        public int getResistance() {
            return resistance;
        }

        @Override
        public String toString() {
            return "" + resistance;
        }

    }
    public static int[] calculateDamage(int[] arr) {
        House[] houses = new House[arr.length];

        for (int i = 0; i < houses.length; i++) {
            houses[i] = new House(arr[i], i);
        }

        int[] dmg = new int[houses.length];
        Arrays.fill(dmg, 1);

        mergeAndAddDamageRec(houses, 0, houses.length - 1, dmg);

        return dmg;
    }
    private static void mergeAndAddDamageRec(House[] in, int start, int end, int[] dmg) { // merge in[start..start+inc-1] and in[start+inc..start+2*inc-1]

        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeAndAddDamageRec(in, start, mid, dmg);
        mergeAndAddDamageRec(in, mid + 1, end, dmg);


        int i = 0, j = 0;

        House[] leftside = new House[mid - start + 1];
        System.arraycopy(in, start, leftside, 0, leftside.length);
        House[] rightside = new House[end - mid];
        System.arraycopy(in, mid + 1, rightside, 0, rightside.length);

        while (start <= end) {
            if ((j >= rightside.length) || (i < leftside.length && leftside[i].getResistance() <= rightside[j].getResistance())) {
                dmg[leftside[i].getIndx()] += j;   // this is where the magic happens;
                in[start++] = leftside[i++];
            } else {
                in[start++] = rightside[j++];
            }
        }

    }
    // End of Q 7
}
