package saruj.leet.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Reorder Routes to Make All Paths Lead to the City Zero.
 */
public class P1466 {

    public static void main(String[] args) {
        P1466 p = new P1466();
        int[][] conns;
        int res;

        conns = new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}};
        res = p.minReorder(6, conns);

        System.out.println(res);
    }

    public int minReorder(int n, int[][] connections) {
        ArrayList<List<Integer>> arMap = initList(n);
        ArrayList<List<Integer>> reversedMap = initList(n);
        fillArrays(connections, arMap, reversedMap);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        List<Integer> sinks;
        List<Integer> sources;
        int count = 0;
        boolean[] visited = new boolean[n];
        while(!stack.isEmpty()) {
            Integer root = stack.pop();
            visited[root] = true;
            sinks = arMap.get(root);
            if(sinks != null) {
                for(Integer i : sinks) {
                    if(!visited[i]) {
                        stack.push(i);
                        count++;
                    }
                }
            }
            sources = reversedMap.get(root);
            if(sources != null) {
                for(Integer i : sources) {
                    if(!visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
        return count;
    }

    private ArrayList<List<Integer>> initList(int n) {
        ArrayList<List<Integer>> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(null);
        }
        return list;
    }

    private void fillArrays(int[][] connections, List<List<Integer>> arMap, List<List<Integer>> reversedMap) {
        List<Integer> neighbors1;
        List<Integer> neighbors2;
        for(int[] pair : connections) {
            neighbors1 = arMap.get(pair[0]);
            if(neighbors1 == null) {
                neighbors1 = new ArrayList<>();
                arMap.set(pair[0], neighbors1);
            }
            neighbors1.add(pair[1]);

            neighbors2 = reversedMap.get(pair[1]);
            if(neighbors2 == null) {
                neighbors2 = new ArrayList<>();
                reversedMap.set(pair[1], neighbors2);
            }
            neighbors2.add(pair[0]);
        }
    }

}
