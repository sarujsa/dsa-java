package saruj.algies.math;

/**
 * Algorithm for finding the greatest common divisor of two natural numbers.
 * This is actually an enhancement of the original algorithm.  The original
 * used subtraction, this one uses 'modulo' operation.
 */
public class EuclideanAlgorithmGCD {

    public static void main(String ... args) {
        System.out.println(gcd(10,7));
    }

    public static int gcd(int x, int y) {
        System.out.println("(" + x + ", " + y + ")");
        if(y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
