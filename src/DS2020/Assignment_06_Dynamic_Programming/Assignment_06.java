package DS2020.Assignment_06_Dynamic_Programming;

import java.util.*;

public class Assignment_06 {

    public static void main(String[] args) {
        int[] a = {-2, 11, -4, 13, -5, 2};
        int[]v={1, -3, 4 ,-2, -1, 6};
        int[] b = {-102, -60, -78, -38, 44, 24, -44, 99, -78, -30, 6, -70, 36, -30, -82, 64};
        int[] c = {-23, -19, -58, -3, -73, -35, -24, -80, -34, -74, -79, -78, -92, -72, -27, -19, -30, -49, -91, -37, -97};
        int[] d = {-2, -11, -4, -13, -5, -2};
        int[][] x = {{1, 0, 0, 0, 0}, {6, 8, 0, 0, 0}, {4, 2, 3, 0, 0}, {9, 7, 5, 1, 0}, {14, 12, 9, 8, 10}};
        int[][] xx = {{9, 0, 0}, {3, 74, 0}, {47, 54, 57}};
        int[][] xxx = {{8,0}, {4,22}};
        int [][] vv = {{830,0,0},{434,858,0},{760,876,412}};
        System.out.println(Arrays.toString(minSumPath(vv)));
        //  انا اسف... غلط ياباشا 🤣🤣🤣💔
        System.out.println(salah_ways(4,2));


    }

    // Q 1
    public static List<Integer> maxSubarraySum(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int temp_max = arr[0];
        int end_index = 0;
        int Top_Max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            temp_max = Math.max(arr[i], arr[i] + temp_max);
            if (temp_max > Top_Max){
                Top_Max = temp_max;
                end_index = i;
            }
        }
        int j=end_index;
        for (; j >= 0 && Top_Max != 0; j--) {
            Top_Max -= arr[j];
        }
        for (int i=j+1; i < end_index+1; i++) { res.add(arr[i]); }
        return res;
    }
    // End of Q 1


    // Q 2
    static long salah_ways(int n, int jump) {
        if(n<=1) return 1;
        if(n==2) return 2;
        if(n==3) return 4;
        long res[] = new long[n+1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;
        res[3] = 4;
        for (int i = 4; i < n+1; i++) {
            res[i] = 0;
            for (int j = 1; j <= jump && j <= i; j++)
                res[i] += res[i - j];
        }
        return res[n];
    }
    // End of Q 2






    // Q 3
    static int[] minSumPath(int A[][]) {
        if(A.length==0)return new int[]{};
        if(A.length==1)return new int[]{A[0][0]};
        int n = A.length - 1;
        int limit=A.length;
        int sum=0;
        int[] memo = new int[A.length];
        int[] ans=new int[A.length];
        int[][] ab=new int[A.length][A.length];

        for (int i = 0;i < A[n].length; i++) {
            memo[i] = A[n][i];
            ab[n][i]=A[n][i];
        }

        for (int i = A.length - 2; i >= 0; i--){
            for (int j = 0; j < limit-1; j++) {
                memo[j] = A[i][j] + (int) Math.min(memo[j], memo[j + 1]);
            }
            limit-=1;
            for(int k=limit;k< A.length;k++) memo[k]=0;
            for(int k=0;k<memo.length;k++){
                ab[i][k]=memo[k];
            }
        }

        for(int i=0;i<ab.length-1;i++){
            ans[i]=get_min(ab[i])-get_min(ab[i+1]);
            sum+=ans[i];
        }
        ans[ans.length-1]=memo[0]-sum;

        return ans;
    }
    static int get_min(int[] a){
        int min=a[0];
        for(int i=1;i< a.length;i++){
            if(a[i]==0)break;
            if(a[i]<min){
                min=a[i];
            }
        }
        return min;
    }
    // End of Q 3


}
