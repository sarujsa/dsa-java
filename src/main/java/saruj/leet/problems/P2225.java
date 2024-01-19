package saruj.leet.problems;

import java.util.*;

/**
 * Find Players With Zero or One Losses
 */
public class P2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        long[] losses = new long[100_001];
        Set<Integer> playersSet = new HashSet<>();
        int[] players = new int[100_001];
        for(int[] match : matches) {
            losses[match[1]]++;
            if(players[match[0]] == 0) {
                playersSet.add(match[0]);
                players[match[0]]++;
            }
            if(players[match[1]] == 0) {
                playersSet.add(match[1]);
                players[match[1]]++;
            }
        }
        List<List<Integer>> retList = new ArrayList<>(2);
        retList.add(new ArrayList<>());
        retList.add(new ArrayList<>());
        List<Integer> sortedPlayers = playersSet.stream().sorted().toList();
        for(int i : sortedPlayers) {
            if(losses[i] == 0) {
                retList.get(0).add(i);
            } else if (losses[i] == 1) {
                retList.get(1).add(i);
            }
        }
        return retList;
    }
}
