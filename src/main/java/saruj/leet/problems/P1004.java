package saruj.leet.problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Maximum consecutive ones III.
 */
public class P1004 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int[] nums2 = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int[] nums3 = new int[]{0};
        int[] nums4 = new int[]{1};
        int[] nums5 = new int[]{0,0,0,1};
        int[] nums6 = new int[]{0,1,1};
        int[] nums7 = new int[]{1,1,1,0,0,0,1,1,1,1};
        P1004 p = new P1004();
        System.out.println(p.longestOnes(nums3, 1));
    }

    public int longestOnes(int[] nums, int k) {
        Queue<Integer> zeroQueue = new ArrayDeque<>();
        if(k == 0) {
            return f0(nums);
        }
        if(nums.length == 1) {
            return 1;
        }
        int start = 0;
        int end = 0;
        int zeroCount;
        if (nums[0] == 0) {
            zeroCount = 1;
            zeroQueue.add(0);
        } else {
            zeroCount = 0;
        }
        int max = 0;
        while(end < nums.length) {
            do{
                end++;
            } while(end < nums.length && nums[end] == 1);
            if(nums[end-1] == 1) {
                max = Math.max(max, end - start);
            }
            if(end == nums.length) {
                break;
            }
            zeroQueue.add(end);
            zeroCount++;
            if(zeroCount > k) {
                if(start < end && nums[start] == 0) {
                    start++;
                    zeroQueue.poll();
                } else {
                    start = zeroQueue.poll();
                    start++;
                }
                zeroCount--;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    private int f0(int[] nums) {
        int max = 0;
        int start = 0;
        int end = 0;
        while(end < nums.length) {
            while(start < nums.length && nums[start] != 1) {
                start++;
            }
            end = start;
            while(end < nums.length && nums[end] == 1) {
                end++;
            }
            max = Math.max(max, end-start);
            start = end;
        }
        return max;
    }

}
