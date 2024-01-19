package saruj.leet.problems;

/**
 * Number of provinces.
 */
public class P547 {
    public static void main(String[] args) {
        P547 p = new P547();
        int[][] m = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(p.findCircleNum(m));
    }
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinceCount = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            provinceCount++;
            dfs(i, isConnected, visited);
        }
        return provinceCount;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true;
        for(int j = 0; j < isConnected[i].length; j++) {
            if(j == i) {
                continue;
            }
            if(isConnected[i][j] == 0 || visited[j]) {
                continue;
            }
            dfs(j, isConnected, visited);
        }
    }

}
