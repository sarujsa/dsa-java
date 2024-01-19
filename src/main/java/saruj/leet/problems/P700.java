package saruj.leet.problems;

import saruj.leet.util.TreeNode;

/**
 * Search in a Binary Search Tree.
 */
public class P700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(val == root.val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
