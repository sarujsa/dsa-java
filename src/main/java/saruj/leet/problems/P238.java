package saruj.leet.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Product of class except self.g
 */
public class P238 {

    public static void main(String[]args) {
        P238 p = new P238();
        int[] nums1 = new int[]{1,2,3,4};
        int[] nums2 = new int[]{-1,1,0,-3,3};
        int[] r = p.productExceptSelf(nums2);
        System.out.println(Arrays.stream(r)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" ")));
    }
    public int[] productExceptSelf(int[] nums) {
        int[] leftProds = new int[nums.length];
        int[] rightProds = new int[nums.length];
        int leftProd = 1;
        int rightProd = 1;
        final int limit = nums.length-1;
        for(int i = 0; i < limit; i++) {
            leftProd *= nums[i];
            rightProd *= nums[limit-i];
            leftProds[i+1] = leftProd;
            rightProds[limit-i-1] = rightProd;
        }
        int[] res = new int[nums.length];
        res[0] = rightProds[0];
        res[nums.length-1] = leftProds[limit];
        for(int i = 1; i < limit; i++) {
            res[i] = leftProds[i]*rightProds[i];
        }
        return res;
    }
}
