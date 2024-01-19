package saruj.algies.dp;

import org.apache.commons.collections4.map.MultiKeyMap;

public class MaxPath {
    public static void main(String[]args) {
        int[][] M = new int[][]{{1,3,12},{5,6,2}};
        int ret = new MaxPath().mp(M, 0, 0);
        System.out.println(ret);
    }

    public int mp(int[][] M, int x, int y) {
        MultiKeyMap<Integer,Integer> map = new MultiKeyMap<>();
        return mp(M, x, y, map);
    }

    public int mp(int[][] M, int x, int y, MultiKeyMap<Integer,Integer> memo) {
        if(x == M.length-1 && y == M[x].length-1) {
            return M[x][y];
        } else if (memo.containsKey(x,y)) {
            return memo.get(x,y);
        }
        int max = 0;
        if(x < M.length-1) {
            max = Math.max(max, M[x][y] + mp(M, x+1,y, memo));
        }
        if(y < M[x].length-1) {
            max = Math.max(max, M[x][y] + mp(M, x,y+1, memo));
        }
        memo.put(x,y,max);
        return max;
    }
}
