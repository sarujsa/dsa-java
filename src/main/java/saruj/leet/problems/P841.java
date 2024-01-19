package saruj.leet.problems;

import java.util.*;

/**
 * Keys and rooms.
 */
public class P841 {

    public static void main(String[] args) {
        P841 p = new P841();
        List<List<Integer>> rooms = List.of(List.of(1), List.of(2), List.of(3), Collections.emptyList());
//        System.out.println(p.canVisitAllRooms(rooms));

        rooms = List.of(List.of(1,3), List.of(3,0,1), List.of(2), List.of(0));
        System.out.println(p.canVisitAllRooms(rooms));
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        Integer[] arraySet = new Integer[1001];
        q.add(0);
        arraySet[0] = 1;
        int visitedCount = 0;
        while(!q.isEmpty()) {
            Integer next = q.poll();
            visitedCount++;
            var neighbors = rooms.get(next);
            for(int i : neighbors) {
                if(arraySet[i] == null) {
                    arraySet[i] = 1;
                    q.add(i);
                }
            }
        }
        return visitedCount == rooms.size();
    }
}
