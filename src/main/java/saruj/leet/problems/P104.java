package saruj.leet.problems;

import saruj.leet.util.TreeNode;

import java.util.Stack;

/**
 * Maximum depth of binary tree.
 */
public class P104 {
    public static void main(String[] args) {
        P104 p = new P104();
        TreeNode tn1 = TreeNode.fromArray(new Integer[]{3,9,20,null,null,15,17});
        System.out.println(p.maxDepth(tn1));
        tn1 = TreeNode.fromArray(new Integer[]{1,null,2});
        System.out.println(p.maxDepth(tn1));
        tn1 = TreeNode.fromArray(new Integer[]{1});
        System.out.println(p.maxDepth(tn1));
        System.out.println(p.maxDepth(null));
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Stack<Integer> depthStack = new Stack<>();
        depthStack.push(1);
        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);
        int maxDepth = 0;
        while(!treeStack.isEmpty()) {
            TreeNode node = treeStack.pop();
            int depth = depthStack.pop();
            if(node.left == null && node.right == null) {
                maxDepth = Math.max(depth, maxDepth);
                continue;
            }
            if(node.right != null) {
                treeStack.push(node.right);
                depthStack.push(depth+1);
            }
            if(node.left != null) {
                treeStack.push(node.left);
                depthStack.push(depth+1);
            }
        }
        return maxDepth;
    }
}
