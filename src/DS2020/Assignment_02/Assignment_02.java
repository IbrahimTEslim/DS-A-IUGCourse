package DS2020.Assignment_02;

public class Assignment_02 {
    public static void main(String[] args) {
        int[] b = {1,4,3,5,6,1,2};

            //   50 ,11, 82 ,57 ,65 ,19 ,56, 60 ,69 ,15, 31 ,24, 53, 41, 70 ,25 ,14 ,78 ,61 ,28 ,22 ,63, 4 ,58 ,42 ,64 ,51, 59, 9, 79, 45, 44 ,19, 7, 13, 76, 77 ,2, 67, 47, 37, 20, 26, 10 ,18 ,73 ,30 ,12 ,19, 27, 84, 55,16 ,8 ,83 ,19 ,38 ,46 ,49 ,40 ,19, 36, 35, 34 ,29, 21, 68 ,54 ,5 ,81, 43 ,48 ,62, 32 ,71 ,80 ,1 ,23 ,74, 17, 72, 19, 52, 66 ,39, 85 };





            System.out.println(findWeezyNumber(b));

    }

    public static int[][] sumArrays(int[] arr) {
        int b[][] = new int[arr.length][arr.length]; int temp=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i > j) { b[i][j] = 0; continue; }
                temp+=arr[j];
                b[i][j] = temp; }
            temp=0; }
        return b;
    }

    public static long helpJudge(int hours) {
        if (hours == 0) return 0;
        return (long) Math.pow(2, Math.pow(2, hours - 1));
    }

    public static int findWeezyNumber(int[] a) {
        int slower=a[0];
        int faster=a[slower];

        while(slower!=faster)
        {
            slower=a[slower];
            faster=a[a[faster]];
        }
        slower=0;
        while(slower!=faster)
        {
            slower=a[slower];
            faster=a[faster];

        }
        return slower;
    }


}
