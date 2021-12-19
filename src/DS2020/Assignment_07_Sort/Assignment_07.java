package DS2020.Assignment_07_Sort;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Assignment_07 {
    public static void main(String[] args) {
        int[] a = {67, 81, 88, 16, 62, 51, 46, 51, 32, 48, 46, 27, 38, 51, 5, 60, 81, 18, 20,51};
        int[] arr = {935345,84564,734,6567,5686,4662,446,9489,55674,323,2645,7345,355678,355,4345,3646,1767,3878,5672,16856};
        int[] b={25,61,82,93,76,24,19,0,64,73,29,61,31,46,88,99,100,11,5,47,17,56,41,97,79,48};
        int[] c={84, 8, 26, 69, 100, 69, 3, 92, 5, 66, 26, 65, 56, 45, 50, 70, 100, 51, 94, 81, 31, 68, 40, 74, 4, 61, 51, 50, 9, 17, 88, 55, 48, 90, 59, 93, 24, 52, 70, 24, 14, 91, 1, 95, 52, 76, 99, 87, 24, 0, 98, 27, 62, 45, 5, 69, 59, 34, 68, 39, 51, 79, 81, 33, 65, 77, 8, 34, 11, 84, 20, 74, 13, 48, 41, 43, 26, 90, 84, 19, 5, 5, 43, 29, 91, 82, 55, 8, 40, 7, 90, 94, 94, 56, 68, 1, 0, 74, 45, 76, 14, 39, 43, 48, 8, 89, 89, 63, 22, 60, 25, 20, 62, 51, 74, 46, 72, 44, 40, 85, 60, 66, 42, 94, 45, 87, 8, 76, 64, 14, 46, 29, 77, 19, 71, 85, 67, 70, 54, 36, 64, 63, 23, 85, 61, 39, 42, 21, 49, 60, 69, 51, 25, 39, 93, 8, 19, 7, 26, 54, 77, 40, 48, 55, 77, 25, 54, 27, 47, 44, 10, 4, 57, 64, 87, 36, 1, 78, 61, 16, 5, 10, 87, 10, 85, 4, 54, 35, 49, 43, 55, 6, 67, 5, 14, 3, 4, 72, 62, 12, 50, 71, 24, 13, 21, 35, 90, 19, 21, 98, 90, 65, 59, 48, 90, 18, 82, 8, 32, 63, 28, 43, 2, 89, 88, 5, 29, 85, 53, 16, 2, 99, 89, 44, 4, 89, 41, 88, 49, 37, 25, 97, 43, 50, 63, 49, 60, 21, 49, 12, 85, 55, 77, 26, 46, 84, 63, 27, 20, 61, 46, 15, 74, 11, 91, 61, 82, 35, 44, 43, 32, 95, 45, 99, 23, 18, 45, 73, 29, 14, 18, 68, 14, 64, 31, 59, 50, 67, 50, 36, 1, 64, 80, 7, 35, 10, 26, 3, 7, 62, 4, 12, 83, 83, 17, 57, 76, 99, 64, 64, 62, 23, 59, 12, 79, 66, 60, 54, 3, 94, 42, 71, 46, 40, 99, 22, 9, 89, 56, 46, 82, 30, 73, 17, 80, 77, 93, 58, 75, 70, 97, 69, 67, 14, 40, 96, 33, 27, 6, 100, 93, 17, 83, 81, 83, 16, 89, 10, 0, 96, 2, 97, 4, 29, 25, 24, 14, 67, 67, 73, 30, 31, 48, 82, 32, 28, 17, 22, 93, 85, 53, 8, 91, 27, 6, 73, 10, 94, 5, 0, 48, 77, 58, 52, 54, 74, 46, 9, 96, 7, 36, 18, 20, 13, 83, 12, 93, 36, 46, 28, 23, 63, 10, 92, 76, 12, 13, 96, 52, 66, 13, 83, 99, 52, 1, 87, 87, 32, 28, 48, 80, 97, 76, 50, 52, 10, 85, 82, 4, 30, 21, 78, 52, 8, 36, 63, 73, 55, 62, 42, 16, 62, 63, 14, 1, 9, 57, 59, 62, 69, 4, 24, 28, 79, 55, 78, 40, 30, 44, 43, 67, 24, 35, 85, 11, 51, 74, 65, 20, 43, 85, 76, 1, 14, 87, 54, 36, 24, 61, 52, 100, 26, 95, 73, 82, 69, 57, 10, 15, 77, 67, 23, 54, 92, 71, 62, 100, 92, 18, 16, 65, 10, 34, 90, 7, 54, 20, 16, 61, 8, 68, 27, 51, 18, 93, 41, 69, 11, 45, 17, 61, 60, 5, 96, 73, 24, 7, 94, 72, 16, 9, 89, 74, 1, 52, 81, 88, 24, 50, 57, 83, 77, 70, 14, 2, 60, 60, 79, 35, 51, 38, 25, 69, 20, 22, 74, 56, 12, 68, 33, 54, 28, 42, 12, 86, 64, 61, 57, 17, 28, 85, 76, 58, 52, 54, 21, 1, 9, 64, 48, 99, 38, 19, 30, 20, 88, 73, 28, 66, 61, 69, 26, 80, 12, 12, 94, 67, 59, 88, 64, 89, 92, 53, 53, 16, 75, 73, 68, 12, 50, 20, 67, 28, 57, 68, 42, 97, 62, 13, 37, 37, 14, 22, 56, 59, 24, 82, 75, 13, 3, 2, 41, 29, 64, 24, 2, 10, 59, 42, 46, 87, 86, 82, 67, 48, 75, 11, 48, 10, 15, 38, 50, 31, 20, 34, 19, 62, 97, 67, 2};
        int[] d={91, 91, 61, 17, 74, 68, 66, 6, 19, 76, 60, 99, 46, 13, 10, 65, 14, 30, 17, 60, 93, 56, 100, 66, 43, 83, 56, 27, 87, 35, 23, 80, 5, 60, 5, 91, 25, 82, 76, 37, 23, 24, 50, 31, 13, 97, 55, 24, 35, 98, 36, 9, 18, 98, 22, 93, 67, 42, 0, 35, 47, 94, 92, 19, 52, 57, 3, 37, 61, 80, 57, 29, 9, 92, 81, 94, 25, 49, 86, 74, 8, 96, 58, 95, 57, 73, 11, 32, 86, 63, 76, 48, 23, 92, 21, 76, 84, 25, 37, 53, 3, 16, 32, 13, 27, 3, 59, 91, 12, 40, 69, 100, 64, 46, 1, 20, 47, 1, 11, 94, 30, 75, 2, 74, 15, 49, 86, 75, 21, 50, 35, 88, 45, 11, 77, 73, 67, 9, 79};
        int[] e={81, 68, 5, 48, 2, 34, 70, 46, 14, 68, 61, 48};
        int[] f = {4, 48, 14, 81, 81, 81, 81};

        preprocess(a);
        System.out.println(howManyGradesInRange(51,51));
        preprocess(b);
        System.out.println(howManyGradesInRange(34,71));
        preprocess(c);
        System.out.println(howManyGradesInRange(39,63));
        preprocess(d);
        System.out.println(howManyGradesInRange(18,49));
        preprocess(e);
        System.out.println(howManyGradesInRange(81,81));
        preprocess(f);
        System.out.println(howManyGradesInRange(4,81));


        System.out.println(findSum_AnotherWay(new int[]{-7, 8, 3, 2, 4},7));
        System.out.println(findSum_AnotherWay(new int[]{29, 42, 9, 40, 3, 64, 7, 72, 7, 50, 45},71));
        System.out.println(findSum_AnotherWay(new int[]{58, 69, -79, 2, 10, -2, -43, 66, -91, 46, 4, -12, 1, 3, -39, 10, -54, 5, -6, -89, -85, -96, -1, -65, -51, 5, 0, 0, 1, -8, 0, 5, -4, 4, 7, -2, 32},-65));
        System.out.println(findSum_AnotherWay(new int[]{-8, -7, 9, 7, 42, 11, -86, -8, -6, -67, 2, -5, 76, -4, -3},-81));
        System.out.println(findSum_AnotherWay(new int[]{-94, -58, -43, -33, -32, -28, -6, -5, -3, -2, -1, -1, 0, 0, 1, 2, 3, 3, 3, 4, 5, 5, 5, 6, 7, 7, 7, 9, 9, 19, 19, 22, 27, 29, 39, 51, 64, 78, 78, 78, 81, 92},33));


    }



    // Q 1
    public static boolean AreSetsEquivalent(int[] arr, int[] brr) {
        if(arr.length==0&&brr.length==0)return true;
        if(arr.length!=0&&brr.length==0)return false;
        if(brr.length!=0&&arr.length==0)return false;
        Arrays.sort(arr);
        Arrays.sort(brr);
        int sumA=arr[0],sumB=brr[0];
        for(int i=1;i<arr.length;i++)
            if(arr[i]!=arr[i-1])
                sumA+=arr[i];
        for(int i=1;i<brr.length;i++)
            if(brr[i]!=brr[i-1])
                sumB+=brr[i];
        return sumA==sumB;
    }
    // End of Q 1


    // Q 2
    public static void linearSort(int[] arr) {
        if(arr.length<=1)return;
        int max=arr[0],width=0;
        for(int e:arr){
            if(e>max)max=e;
        }
        while(max!=0){
            width++;
            max/=10;
        }
        Radix_Sort(arr,10,width);
    }
    public static void Radix_Sort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++)
            RadixSingleSort(input, i, radix);
    }
    public static void RadixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;
        int[] countingArray = new int[radix];

        for (int value : input)
            countingArray[getDigit(position, value, radix)]++;

        for (int j = 1; j < radix; j++)
            countingArray[j] += countingArray[j - 1];

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--)
            temp[--countingArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];

        System.arraycopy(temp,0,input,0,temp.length);
    }
    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }
    // End of Q 2


    // Q 3
    public static long countingInversion(int [] ary){
        if(ary.length<=1)return 0;
        long inversions=0;
        for (int FirstunSortedInedx = 1; FirstunSortedInedx < ary.length; FirstunSortedInedx++) {

            int NewElement = ary[FirstunSortedInedx];
            int i;
            for (i = FirstunSortedInedx; i > 0 && ary[i - 1] > NewElement; i--) {
                ary[i] = ary[i - 1];
                inversions++;
            }

            ary[i] = NewElement;
        }
        return inversions;
    }
    // End of Q 3


    // Q 4
    static int[] map;
    static int[] queryMap;
    public static void preprocess(int [] grades){

        map=new int[101]; queryMap=new int[101];

        for(int e:grades) { map[e]++; }

        queryMap[0]=map[0];

        for(int i=1;i<101;i++) { queryMap[i]=map[i]+queryMap[i-1]; }
    }
    public static int howManyGradesInRange(int l, int r){ // This method must work in constant time
        if(r>100)r=100;
        if(l<0)l=0;
        if(l>r){
            int temp=l;
            l=r;
            r=temp;
        }
        if(l==r)return map[r];
        return queryMap[r]-queryMap[l]+map[l];
    }
    // End of Q 4


    // Q 5
    public static boolean findSum(int arr[], int sum){
        java.util.HashSet <Integer> s = new java.util.HashSet <Integer>();
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
            int temp = sum - arr[i];

            // checking for condition
            if (s.contains(temp)) {
                return true;
            }
            s.add(arr[i]);
        }
        return false;
    }
    public static boolean findSum_AnotherWay(int arr[], int sum){
        int start=0,end=arr.length-1;
        Arrays.sort(arr);
        while(start<end){
            if(arr[start]+arr[end]>sum)
                end--;
            else if(arr[start]+arr[end]<sum)
                start++;
            else
                return true;
        }
        return false;
    }
    // End of Q 5
}
