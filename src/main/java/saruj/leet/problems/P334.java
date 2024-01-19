package saruj.leet.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Increasing Triplet Subsequence.
 */
public class P334 {

    public static void main(String[]args) {
        int[] nums1 = new int[]{1,2,3,4,5};
        int[] nums2 = new int[]{5,4,3,2,1};
        int[] nums3 = new int[]{2,1,5,0,4,6};
        P334 p = new P334();
        System.out.println(p.increasingTriplet(nums1));
        System.out.println(p.increasingTriplet(nums2));
        System.out.println(p.increasingTriplet(nums3));
    }

    public boolean increasingTriplet(int[] nums) {
        int[] smaller = new int[nums.length];
        int[] greater = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            smaller[i] = min;
        }
        int max = Integer.MIN_VALUE;
        for(int i = nums.length-1; i >= 0; i--) {
            max = Math.max(max, nums[i]);
            greater[i] = max;
            if(smaller[i] < nums[i] && greater[i] > nums[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean slowerIncreasingTriplet(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> firsts = new ArrayDeque<>();
        firsts.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int min = firsts.getLast();
            if(n < min) {
                if(!map.containsKey(n) && !map.containsKey(min)) {
                    firsts.pollLast();
                    firsts.add(n);
                } else {
                    firsts.add(n);
                }
            } else {
                for (Integer first : firsts) { // firsts could also be a priority queue
                    Integer second = map.get(first);
                    if (n > first && (second == null || second > n)) {
                        map.put(first,n);
                    } else if (second != null && n > second) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
