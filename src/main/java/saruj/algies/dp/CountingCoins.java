package saruj.algies.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input: integer n, array of coins.
 * Output: Number of combinations of coins which can be added up to n.
 * Coins can be repeated.
 */
public class CountingCoins {

    public static void main(String ... args) {
        System.out.println(cc(6, List.of(1,2,3)));
    }

    public static int cc(int n, List<Integer> coins) {
        Map<String, Integer> memo = new HashMap<>();
        return cc(n, coins, memo);
    }

    public static int cc(int n, List<Integer> coins, Map<String, Integer> memo) {
        if(n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else if (coins.isEmpty()) {
            return 0;
        }
        String key = n + coins.toString();
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int coin = coins.get(0);
        List<Integer> sublist = coins.size() == 1 ? new ArrayList<>() : coins.subList(1, coins.size());
        int count = 0;
        int mul = 0;
        int retCount = 0;
        while(mul <= n) {
            retCount += cc(n-mul, sublist, memo);
            count++;
            mul = coin*count;
        }
        memo.put(key, retCount);
        return retCount;
    }
}
