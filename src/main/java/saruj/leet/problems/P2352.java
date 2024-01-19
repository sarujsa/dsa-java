package saruj.leet.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Equal row and column pairs.
 */
public class P2352 {
    public static void main(String[] args) {
        P2352 p = new P2352();
        int[][] grid1 = new int[][]{{3,2,1},{1,7,6},{2,7,7}};
        int[][] grid2 = new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(p.equalPairs(grid2));
    }
    public int equalPairs(int[][] grid) {
        Map<String,Integer> rowMap = new HashMap<>();
        for(int[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for(int s : row) {
                sb.append(s).append(',');
            }
            rowMap.merge(sb.toString(), 1, Integer::sum);
        }
        int pairs = 0;
        for(int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < grid.length; j++) {
                sb.append(grid[j][i]).append(',');
            }
            Integer count = rowMap.get(sb.toString());
            if(count != null) {
                pairs += count;
            }
        }
        return pairs;
    }
}
