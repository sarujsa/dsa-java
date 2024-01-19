package saruj.leet.problems;

/**
 * Max Increase to Keep City Skyline
 */
public class P807 {

    static int[][] grid = new int[][] {
            {8, 4, 8, 7},
            {7, 4, 7, 7},
            {9, 4, 8, 7},
            {3, 3, 3, 3}
    };

    public static void main(String[]args) {
        var s = new P807().new Solution();
        s.maxIncreaseKeepingSkyline(grid);
    }
    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            if(grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int[] rowMaxes = new int[grid.length];
            int[] colMaxes = new int[grid[0].length];
            setRowAndColMaxes(grid, rowMaxes, colMaxes);
            return findMaxIncreases(grid, rowMaxes, colMaxes);
        }

        int min(int i, int j) {
            return i < j ? i : j;
        }

        private int findMaxIncreases(int[][] grid, int[] rowMaxes, int[] colMaxes) {
            int sumDiff = 0;
            int referent;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[i].length; j++) {
                    referent = min(rowMaxes[i],colMaxes[j]);
                    if(grid[i][j] < referent) {
                        sumDiff+= referent - grid[i][j];
                    }
                }
            }
            return sumDiff;
        }

        private void setRowAndColMaxes(int[][] grid, int[] rowMaxes, int[] colMaxes) {
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[i].length; j++) {
                    if(grid[i][j] > rowMaxes[i]) {
                        rowMaxes[i] = grid[i][j];
                    }
                    if(grid[i][j] > colMaxes[j]) {
                        colMaxes[j] = grid[i][j];
                    }
                }
            }
        }
    }
}
