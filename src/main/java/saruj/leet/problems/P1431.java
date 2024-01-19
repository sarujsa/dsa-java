package saruj.leet.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Kids With the Greatest Number of Candies
 */
public class P1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int n : candies) {
            max = Math.max(n, max);
        }
        List<Boolean> retList = new ArrayList<>(candies.length);
        for (int n : candies) {
            retList.add(n + extraCandies >= max);
        }
        return retList;
    }
}
