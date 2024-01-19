package saruj.leet.problems;

/**
 *  Find the Highest Altitude.
 */
public class P1732 {
    public static void main(String[] args) {

    }

    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for(int n : gain) {
            sum+=n;
            if(n > 0) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
