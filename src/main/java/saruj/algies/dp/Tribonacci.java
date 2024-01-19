package saruj.algies.dp;

public class Tribonacci {

    public static void main(String ...args) {
        System.out.println(trib(50));
    }

    public static long trib(int n) {
        long[] memo = new long[n+1];
        long retval = trib(n, memo);
        for(long l : memo) {
            System.out.print(l + " ");
        }
        System.out.println();
        return retval;
    }

    public static long trib(int n, long[] memo) {
        if(n == 0 || n == 1) {
            memo[n] = 0;
            return 0;
        } else if (n == 2) {
            memo[n] = 1;
            return 1;
        }
        if(memo[n] == 0) {
            memo[n] = trib(n-1, memo) + trib(n-2, memo) + trib(n-3, memo);
        }
        return memo[n];
    }
}
