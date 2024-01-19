package saruj.leet.problems;

/**
 * Find Pivot Index.
 */
public class P724 {

    public static void main(String[] args) {
        P724 p = new P724();
        int[] nums1 = new int[]{1,7,3,6,5,6};
        int[] nums2 = new int[]{1,2,3};
        int[] nums3 = new int[]{2,1,-1};
        int[] nums4 = new int[]{-1,-1,0,0,-1,-1};
        System.out.println(p.pivotIndex(nums4));
    }

    public int pivotIndex(int[] nums) {
        int[] leftSum = new int[nums.length];
        leftSum[0] = 0;
        for(int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }
        int rightSum = 0;
        for(int i = nums.length-1; i>=0 ; i--) {
            if(leftSum[i] == rightSum) {
                return i;
            }
            rightSum += nums[i];
        }
        return -1;
    }

}
