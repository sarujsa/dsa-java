package saruj.leet.problems;

/**
 * Maximum Erasure Value
 */
public class P1695 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,2,4,5,6};
        int[] nums2 = new int[]{5,2,1,2,5,2,1,2,5};
        int[] nums3 = new int[]{1000};
        P1695 p = new P1695();
        System.out.println(p.maximumUniqueSubarray(nums2));
    }

    public int maximumUniqueSubarray(int[] nums) {
        int max = 0;
        int start = 0;
        int sum = 0;
        int[] indexMap = new int[10_001];
        int[] sumMap = new int[100_001];
        for(int i = 0; i < nums.length; i++) {
            final int n = nums[i];
            if(indexMap[n] == 0 && (i == 0 || nums[0] != nums[i]) || indexMap[n] < start) {
                sum += n;
                indexMap[n] = i;
            } else {
                if(start == 0) {
                    max = sum;
                } else {
                    max = Math.max(max, sum - sumMap[start-1]);
                }
                start = indexMap[n] + 1;
                sum += n;
                indexMap[n] = i;
            }
            sumMap[i] = sum;
        }
        if(start > 0) {
            max = Math.max(max, sum - sumMap[start - 1]);
        } else if (max == 0) {
            max = sum;
        }

        return max;
    }

}
