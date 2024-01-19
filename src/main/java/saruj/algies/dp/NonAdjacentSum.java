package saruj.algies.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonAdjacentSum {

    public static void main(String ... aargs) {
        System.out.println(nonAdjacentSum(list));
    }
    public static List<Integer> list = Arrays.asList(7,5,5,12,1,2,10,9,4,4,5,9,1,1,1);

    public static int nonAdjacentSum(List<Integer> list) {
        int i = 0;
        return nonAdjacentSum(list, i, new HashMap<>());
    }

    public static int nonAdjacentSum(List<Integer> list, int index, Map<Integer,Integer> memo) {
        if(list.isEmpty()) {
            return 0;
        } else if(list.size() == 1) {
            return list.get(0);
        } else if (memo.containsKey(index)) {
            return memo.get(index);
        } else {
            int first = list.get(0);
            if(list.size() > 2) {
                first += nonAdjacentSum(list.subList(2, list.size()), index+2, memo);
            }
            int second = list.get(1);
            if(list.size() > 3) {
                second += nonAdjacentSum(list.subList(3, list.size()), index + 3, memo);
            }
            memo.put(index, Math.max(first, second));
            return Math.max(first,second);
        }
    }

}
