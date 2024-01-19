package saruj.algies.dp;

import java.util.HashMap;
import java.util.Map;

public class SumPossible {

    public static void main(String ... args) {
        int n = 15;
        int[] ns = new int[]{6,10,8};
        System.out.println(sp(n,ns));
    }

    public static boolean sp(int n, int[] ns) {
        Map<Integer,Boolean> memo = new HashMap<>();
        return sp(n, ns, memo);
    }

    public static boolean sp(int n, int[] ns, Map<Integer,Boolean> memo) {
        if(n == 0) {
            return true;
        }
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        for(int a : ns) {
            if (n - a < 0) {
                continue;
            }
            if (sp(n - a, ns, memo)) {
                memo.put(n, true);
                return true;
            }
        }
        memo.put(n, false);
        return false;
    }

}
