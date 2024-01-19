package saruj.leet.problems;

import java.util.Arrays;

/**
 * Max Number of K-Sum Pairs
 */
public class P1679 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4};
        int[] nums2 = new int[]{3,1,3,4,3};
        int[] nums3 = new int[]{1,2,3,4,5,6,7,8,9,10,9,8,7,6,5,4,3,2,1};
        P1679 p = new P1679();
        System.out.println(p.maxOperations(nums3, 6));
    }
    public int maxOperations(int[] nums, int k) {
        if(nums.length == 1) return 0;
        Arrays.sort(nums);
        int right = findK(nums, k);
        int left = 0;
        int result = 0;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == k) {
                left++;
                right--;
                result++;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    private int findK(int[] nums, int k) {
        int i = nums.length/2;
        int diff = i;
        while (diff > 0) {
            diff /= 2;
            if(nums[i] == k) {
                while(i > 0 && nums[i] == k) {
                    i--;
                }
                return i;
            } else if(i < k) {
                i += diff;
            } else {
                i -= diff;
            }
        }
        if(nums[i] < k) {
            while(i < nums.length && nums[i] < k) {
                i++;
            }
        }
        return --i;
    }
}
