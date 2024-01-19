package saruj.leet.problems;

import java.util.PriorityQueue;

/**
 * Kth largest element in an array.
 */
public class P215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for(int n : nums) {
            pQueue.add(-n);
        }
        for(int i = 1; i < k; i++) {
            pQueue.poll();
        }
        return pQueue.poll() * -1;
    }

}
