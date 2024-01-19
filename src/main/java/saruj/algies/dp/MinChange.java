
package saruj.algies.dp;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * For input n = amount, ns = list of coins,
 * find which list of coins can be added up to 'amount' so that
 * the fewest number of coins are used.
 *
 * E.g. n = 5, ns = [1,2,3], minChange = [2,3].
 */
public class MinChange {

    private static final int[] coins = new int[]{1,2,3};
    private static final int amount = 100;

    public static void main(String ... args) {
        Pair<Boolean, List<Integer>> tuple = minChange(amount, coins);
        if(tuple.getLeft()) {
            tuple.getRight().forEach(e -> System.out.print(e + " "));
        } else {
            System.out.println("Cannot separate "+ amount + " into coins ");
        }
    }

    private static Pair<Boolean, List<Integer>> minChange(int amount, int[] coins) {
        Map<Integer,Pair<Boolean,List<Integer>>> memo = new HashMap<>();
        Pair<Boolean, List<Integer>> minChange = minChange(amount, coins, memo);
        for(var entry : memo.entrySet()) {
            System.out.print(entry.getKey() + " : [");
            entry.getValue().getRight()
                    .forEach(i -> System.out.print(i + " "));
            System.out.println("]");
        }
        return minChange;
    }

    private static Pair<Boolean, List<Integer>> minChangeNoMemo(int amount, int[] coins) {
        if (amount == 0) {
            return Pair.of(Boolean.TRUE, new ArrayList<>());
        } else if (amount < 0) {
            return Pair.of(Boolean.FALSE, null);
        }
        Map<Integer,List<Integer>> possibleMinimums = new  HashMap<>();
        for(int coin : coins) {
            var tuple = minChangeNoMemo(amount - coin, coins);
            if(tuple.getLeft()) {
                possibleMinimums.put(coin, tuple.getRight());
                tuple.getRight().add(coin);
            }
        }
        if(possibleMinimums.isEmpty()) {
            return Pair.of(Boolean.FALSE, null);
        } else {
            return Pair.of(Boolean.TRUE, getMinimum(possibleMinimums));
        }
    }

    private static List<Integer> getMinimum(Map<Integer, List<Integer>> possibleMinimums) {
        int minSize = Integer.MAX_VALUE;
        List<Integer> returnList = new ArrayList<>();
        for(var entry : possibleMinimums.entrySet()) {
            if(entry.getValue().size() < minSize) {
                minSize = entry.getValue().size();
                returnList = entry.getValue();
            }
        }
        return returnList;
    }

    private static Pair<Boolean, List<Integer>> minChange(int amount, int[] coins,
                                                          Map<Integer,Pair<Boolean,List<Integer>>> memo) {
        if (amount == 0) {
            return Pair.of(Boolean.TRUE, new ArrayList<>());
        } else if (amount < 0) {
            return Pair.of(Boolean.FALSE, null);
        } else if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        Map<Integer,List<Integer>> possibleMinimums = new  HashMap<>();
        for(int coin : coins) {
            var tuple = minChange(amount - coin, coins, memo);
            if(tuple.getLeft()) {
                List<Integer> copyList = new ArrayList<>(tuple.getRight());
                possibleMinimums.put(coin, copyList);
                copyList.add(coin);
            }
        }
        if(possibleMinimums.isEmpty()) {
            memo.put(amount, Pair.of(Boolean.FALSE, null));
            return Pair.of(Boolean.FALSE, null);
        } else {
            List<Integer> returnList = getMinimum(possibleMinimums);
            memo.put(amount, Pair.of(Boolean.TRUE, returnList));
            return Pair.of(Boolean.TRUE, returnList);
        }
    }


}
