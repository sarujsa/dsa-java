package saruj.leet.problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Move zeroes.
 */
public class P283 {

    public static void main(String[] args){
        int[] a1 = new int[]{0,1,0,3,12};
        int[] a2 = new int[]{0};
        int[] a3 = new int []{0,0,0,0,0,5,6,0};
        P283 p = new P283();
        int[] nums = a2;
        p.moveZeroes(nums);
        for(int z : nums) {
            System.out.print(z + ",");
        }
    }
    public void moveZeroes(int[] nums) {
        Queue<Integer> zeroes = new ArrayDeque<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes.add(i);
            } else {
                if(!zeroes.isEmpty()) {
                    int index = zeroes.poll();
                    nums[index] = nums[i];
                    nums[i] = 0;
                    zeroes.add(i);
                }
            }
        }
    }
}
