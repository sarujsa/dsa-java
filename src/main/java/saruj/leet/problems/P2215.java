package saruj.leet.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the Difference of Two Arrays.
 */
public class P2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] set1 = new boolean[2001];
        boolean[] set2 = new boolean[2001];
        for(int n : nums1) {
            set1[n+1000] = true;
        }
        for(int n : nums2) {
            set2[n+1000] = true;
        }
        List<Integer> l1not2 = new ArrayList<>();
        List<Integer> l2not1 = new ArrayList<>();
        for(int i = 0; i < 2001; i++) {
            if(set1[i]) {
                if(!set2[i]) {
                    l1not2.add(i-1000);
                }
            } else if (set2[i]) {
                l2not1.add(i-1000);
            }
        }
        return Arrays.asList(l1not2, l2not1);
    }
}
