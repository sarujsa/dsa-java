package saruj.leet.problems;

import java.util.*;

/**
 * Determine if two strings are close.
 */
public class P1657 {
    class Solution {
        public boolean closeStrings(String word1, String word2) {
            if(word1.length() != word2.length()) {
                return false;
            }
            int[] chars1 = new int[26];
            int[] chars2 = new int[26];
            for(int i = 0; i < word1.length(); i++) {
                chars1[word1.charAt(i) - 'a']++;
                chars2[word2.charAt(i) - 'a']++;
            }
            Map<Integer,Integer> map1 = new HashMap<>();
            Map<Integer,Integer> map2 = new HashMap<>();
            Set<Integer> set = new TreeSet<>();
            for(int i = 0; i < 26; i++) {
                if(chars1[i] > 0 && chars2[i] == 0
                    || chars1[i] == 0 && chars2[i] > 0) {
                    return false;
                }
                map1.merge(chars1[i], 1, Integer::sum);
                map2.merge(chars2[i], 1, Integer::sum);
                set.add(chars1[i]);
                set.add(chars2[i]);
            }
            for(Integer n : set) {
                Integer n1 = map1.get(n);
                Integer n2 = map2.get(n);
                if(!Objects.equals(n1, n2)) return false;
            }
            return true;
        }
    }
}
