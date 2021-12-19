package DS2020.Assignment_05_Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assignment_05 {


    public static void main(String[] args)
    {
//        double[][] a = new double[][]{{5.8, 3.06},{5.4, 7.95},{1.44, 9.29},{4.18, 8.15},{100,100},{5.66, 9.53},{1.74, 8.94}};
        double[][] a = new double[][]{{5.8, 3.06},{-7,-20.5},{1,1},{1,1},{4,5}};
//        int[][] arr = {{79,140},{14,102},{29,66},{10,40},{41,59},{14,40},{4,81},{98,184},{8,77}};
//        int[][] arr = {{7,7},{3,3},{5,5},{6,6},{9,9},{10,10},{8,8},{17,25},{11,17}};
        int[][] arr = {{49,134},{3,36},{96,139},{2,47},{62,126},{42,89},{2,78},{11,75},{73,149},{2,10},{71,141},{44,73},{13,44}};
        int[] b=new int[]{7};
        int[] c=new int[]{1};

        System.out.println(Arrays.toString(longestRoute(a)));
    }





    // Q 1
    public static int[] longestRoute(double [][] arr){
        if(arr.length==0)return new int[]{};
        if(arr.length==1) return new int[]{0};
        if(arr.length==2)return new int[]{0,1};
        double maxDistance=0;

        int[] ans=new int[arr.length]; int temp_index=-1;
        ans[0]=0;

        int[] indexs=new int[ans.length];
        for(int i=0;i<indexs.length;i++) indexs[i]=i;

        for(int i=0;i< arr.length-1;i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (distance(arr[i][0], arr[i][1], arr[j][0], arr[j][1]) >= maxDistance) {
                    maxDistance = distance(arr[i][0], arr[i][1], arr[j][0], arr[j][1]);
                    temp_index=j;
                }
            }
            swap(arr,i+1,temp_index);
            swap(indexs,i+1,temp_index);
            ans[i+1]=indexs[i+1];
            maxDistance=0;
        }
        ans[ans.length-1]=indexs[indexs.length-1];
        return ans;
    }
    static double distance(double x1,double y1,double x2,double y2){
        return Math.pow((Math.pow(x1-x2,2)+Math.pow(y1-y2,2)),0.5);
    }
    static void swap(double[][]arr,int i1,int i2){
        double tempx=arr[i1][0],tempy=arr[i1][1];
        arr[i1][0]=arr[i2][0]; arr[i1][1]=arr[i2][1];
        arr[i2][0]=tempx; arr[i2][1]=tempy;
    }
    static void swap(int[]a,int c,int d){
        int temp=a[c];
        a[c]=a[d];
        a[d]=temp;
    }
    // End of Q 1



    // Q 2
    public static int[] customerCare(int[] arr){
        if(arr.length==0)return new int[]{};
        if(arr.length==1)return new int[]{1};
        int[][]ValuesAndIndexes=new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            ValuesAndIndexes[i][1]=arr[i];
            ValuesAndIndexes[i][0]=i+1;
        }
        int[][] temp=mergeSort2D_2Q(ValuesAndIndexes,0,ValuesAndIndexes.length-1);
        for(int i=0;i<arr.length;i++){arr[i]=temp[i][0];}
        return arr;
    }
    public static int[][] mergeSort2D_2Q(int[][] arr , int start , int end){
        if(arr.length == 0)
            return new int[][]{};
        if(start == end)
            return new int[][] {arr[start]};
        int mid = (end + start) / 2;
        int[][] left = mergeSort2D_2Q(arr,start,mid);
        int[][] right = mergeSort2D_2Q(arr,mid+1,end);
        int[][] big = new int[left.length + right.length][2];
        int i = 0 , j = 0 , k = 0;
        while(i < left.length && j < right.length)
            big[k++] = left[i][1] > right[j][1] ? right[j++] : left[i++];

        while(i < left.length)
            big[k++] = left[i++];
        while(j < right.length)
            big[k++] = right[j++];
        return big;
    }
    // End of Q 2



    // Q 3
    public static List<Integer> collectFromTenant(int[][] arr) {

        if(arr.length == 0) return new ArrayList<>();

        List<Integer> ans = new ArrayList<Integer>();

        int [][] two_DArray = mergeSort2D(arr, 0, arr.length-1);

        int [] temp = two_DArray[0];

        for (int i = 1; i < two_DArray.length; i++) {
            if ( two_DArray[i][0] > temp[1]){
                ans.add(temp[1]);
                temp = two_DArray[i];
            }
        }
        ans.add(temp[1]);

        return ans;
    }
    public static int[][] mergeSort2D(int[][] arr , int start , int end){
        if(arr.length == 0)
            return new int[][]{};
        if(start == end)
            return new int[][] {arr[start]};
        int mid = (end + start) / 2;
        int[][] left = mergeSort2D(arr,start,mid);
        int[][] right = mergeSort2D(arr,mid+1,end);
        int[][] big = new int[left.length + right.length][2];
        int i = 0 , j = 0 , k = 0;
        while(i < left.length && j < right.length)
            big[k++] = left[i][1] > right[j][1] ? right[j++] : left[i++];

        while(i < left.length)
            big[k++] = left[i++];
        while(j < right.length)
            big[k++] = right[j++];
        return big;
    }
    // End of Q 3



    // Q 4
    public static long maxWin(int [] questions, int[] auctionIndexes){
        if(questions.length==0)return 0;
        if(questions.length==1)return questions[0];

        Arrays.sort(auctionIndexes);
        int question_index=questions.length-1;
        int auction_index= auctionIndexes.length-1;

        long points=0;

        int[] auction_elements=new int[auctionIndexes.length]; int counter=0;

        for(int i= questions.length-1;i>=0;i--)
        {
            if(auction_index>=0&&i+1==auctionIndexes[auction_index])
            {
                auction_elements[counter++]=questions[i];
                auction_index--;
            }
            else{
                points+=questions[i];
            }
        }
        Arrays.sort(auction_elements);

        for(int i=auction_elements.length-1;i>=0;i--)
        {
            if(auction_elements[i]>=points) points+=auction_elements[i];
            else{
                points*=2;
            }
        }
        return points;
    }
    // End of Q 4



    // Q 5
    public static String maxBudget(int[] numbers) {
        String res="";

        if(numbers.length==0)return res;

        int index=0,temp_index=0;


        String[] strs=new String[numbers.length];
        for(int i=0;i<numbers.length;i++) strs[i]= String.valueOf(numbers[i]);


        for(int j=0;j<strs.length;j++) {
            char temp = strs[0].charAt(0);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(0) > temp) {
                    temp = strs[i].charAt(0);
                    temp_index=i;
                    index = i;
                }
                else if (strs[i].charAt(0) == temp)
                {
                    String AB=strs[temp_index]+strs[i];
                    String BA=strs[i]+strs[temp_index];
                    if(BA.compareTo(AB)>0){
                        temp = strs[i].charAt(0);
                        temp_index=i;
                        index=i;
                    }
                }
            }
            res += strs[index];
            strs[index] = "0";
            index=0;
            temp_index=0;
        }
        return res;
    }
    //End of Q 5

}
