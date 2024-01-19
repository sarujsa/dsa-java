package saruj.leet.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Number of Steps to Make Two Strings Anagram
 */
public class P1347 {
    class Solution {
        public int minSteps(String s, String t) {
            Map<Character,Pair> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++) {
                Pair p = map.putIfAbsent(s.charAt(i), new Pair(1,0));
                if(p != null) {
                    p.s++;
                }
                p = map.putIfAbsent(t.charAt(i), new Pair(0,1));
                if(p != null) {
                    p.t++;
                }
            }
            int result = 0;
            for(var kv : map.entrySet()) {
                Pair p = kv.getValue();
                char c = kv.getKey();
                if(p.s > p.t) {
                    result += p.s - p.t;
                }
            }
            return result;
        }

        static class Pair {
            int s;
            int t;

            public Pair(int s, int t) {
                this.s = s;
                this.t = t;
            }
        }
    }
}
