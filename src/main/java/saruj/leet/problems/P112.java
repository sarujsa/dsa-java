package saruj.leet.problems;

import saruj.leet.util.TreeNode;

/**
 * Path Sum.
 */
public class P112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            return root.val == targetSum;
        } else {
            boolean retVal = false;
            if(root.left != null) {
                retVal = hasPathSum(root.left, targetSum - root.val);
            }
            if(root.right != null) {
                retVal = retVal || hasPathSum(root.right, targetSum - root.val);
            }
            return retVal;
        }
    }
}
