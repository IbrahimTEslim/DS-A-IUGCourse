package DS2020.Assignment_06_Dynamic_Programming;

public class Lecture_Code {

    public static void main(String[] args) {
        System.out.println(LongestCommonSequence("GTTCCTAATA","CGATAATTGAGA"));
        System.out.println(LongestCommonSequence("ABCDEFG","XZACKDFWGH"));
    }


    public static long Fibonacci_number(int n) { // T(n) = O(n)
        long[] f = new long[n];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < n; i++)
            f[i] = f[i - 1] + f[i - 2];
        return f[n - 1];
    }

    public static int[][] LongestCommonSequence_arr(String a, String b) {
        int[][] res = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() ; i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j))
                    res[i+1][j+1] = res[i][j ] + 1;
                else
                    res[i+1][j+1] = Math.max(res[i][j+1], res[i+1][j]);
            }
        }
        return res;
    }
    public static String LongestCommonSequence(String a,String b){
        int[][] res=LongestCommonSequence_arr(a,b);
        StringBuilder sb=new StringBuilder();
        int i=a.length(),j=b.length();
        while(res[i][j]>0){
            if(a.charAt(i-1)==b.charAt(j-1)) {
                sb.append(a.charAt(i-1));
                i--;
                j--;
            }
            else if(res[i-1][j]>=res[i][j-1])
                i--;
            else j--;
        }
        return sb.reverse().toString();
    }
}
