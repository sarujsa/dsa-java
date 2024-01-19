package saruj.algies.dp;

public class Fibonacci {

    private long counter = 0;

    public static void main(String ...args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fib(50));
        System.out.println(f.counter);
    }

    public long fib(int n) {
        long[] array = new long[n+1];
        long retval = fib(n, array);
        for(long i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        return retval;
    }

    public long fib(int n, long[] array) {
        counter++;
        if(n <= 1) {
            array[n] = n;
            return array[n];
        } else if (array[n] == 0) {
            array[n] = fib(n-1, array) + fib(n-2, array);
            return array[n];
        } else {
            return array[n];
        }
    }
}
