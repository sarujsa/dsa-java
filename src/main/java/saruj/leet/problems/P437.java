package saruj.leet.problems;

import saruj.leet.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Path Sum III.
 */
public class P437 {

    public static void main(String[] args) {
        P437 p = new P437();

        TreeNode t = TreeNode.fromArray(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        System.out.println(p.pathSum(t, 8));

        p = new P437();
        t = new TreeNode(1);
        System.out.println(p.pathSum(t,0));
    }

    private Map<Long,Integer> prefixSumMap = new HashMap<>();
    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        pathSum(root, 0, targetSum);
        return count;
    }

    private void pathSum(TreeNode root, long prefixSum, int targetSum) {
        if(root == null) return;
        long sum = prefixSum + root.val;
        if(sum == targetSum) {
            count++;
        }
        if(prefixSumMap.containsKey(sum - targetSum)) {
            count += prefixSumMap.get(sum - targetSum);
        }
        prefixSumMap.merge(sum, 1, Integer::sum);
        pathSum(root.left, sum, targetSum);
        pathSum(root.right, sum, targetSum);
        prefixSumMap.compute(sum, (k, v) -> v-1);
    }


    private int slowCount = 0;

    private int slowerPathSum(TreeNode root, int targetSum) {
        slowerPathSum(root, targetSum, new ArrayList<>());
        return slowCount;
    }

    private void slowerPathSum(TreeNode root, long targetSum, List<Integer> vals) {
        vals.add(root.val);
        int end = vals.size()-1;
        long sum = 0;
        for(int i = end; i >= 0; i--) {
            sum += vals.get(i);
            if(sum == targetSum) {
                slowCount++;
            }
        }
        if(root.left != null) {
            ArrayList<Integer> left = new ArrayList<>(vals);
            slowerPathSum(root.left, targetSum, left);
        }
        if(root.right != null) {
            ArrayList<Integer> right = new ArrayList<>(vals);
            slowerPathSum(root.right, targetSum, right);
        }
    }
}
