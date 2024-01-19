package saruj.leet.problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Maximum Average Subarray I
 */
public class P643 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,12,-5,-6,50,3};
        int[] nums2 = new int[]{5};
        int[] nums3 = new int[]{0,4,0,3,2};
        P643 p = new P643();
        System.out.println(p.findMaxAverage(nums3, 1));
    }
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0;
        Queue<Double> queue = new ArrayDeque<>();
        for(int i = 0; i < k ; i++) {
            double d = ((double) nums[i]) / k;
            avg += d;
            queue.add(d);
        }
        double max = avg;
        for(int i = k; i < nums.length; i++) {
            double d = ((double) nums[i]) / k;
            avg = avg - queue.poll() + d;
            max = Math.max(avg, max);
            queue.add(d);
        }
        return max;
    }
}
