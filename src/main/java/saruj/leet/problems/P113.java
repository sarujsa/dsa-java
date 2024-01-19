package saruj.leet.problems;

import saruj.leet.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum II.
 */
public class P113 {
    public static void main(String[] args) {
        TreeNode n = TreeNode.fromArray(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,null,5,1});
        P113 p = new P113();
        System.out.println(p.pathSum(n, 22));
    }

    private final List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return lists;
        List<Integer> vals = new ArrayList<>();
        pathSum(root, targetSum, vals);
        return lists;
    }

    private void pathSum(TreeNode root, int targetSum, List<Integer> vals) {
        vals.add(root.val);
        if(root.left == null && root.right == null && targetSum == root.val) {
            lists.add(vals);
        } else {
            if(root.left != null) {
                ArrayList<Integer> left = new ArrayList<>(vals);
                pathSum(root.left, targetSum - root.val, left);
            }
            if(root.right != null) {
                ArrayList<Integer> right = new ArrayList<>(vals);
                pathSum(root.right, targetSum - root.val, right);
            }
        }
    }


}
