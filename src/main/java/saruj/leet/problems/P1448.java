package saruj.leet.problems;

import saruj.leet.util.TreeNode;

import java.util.Stack;

/**
 * Count Good Nodes in Binary Tree
 */
public class P1448 {
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        Stack<S2> stack = new Stack<>();
        stack.push(new S2(root, root.val));
        while(!stack.isEmpty()) {
            S2 tuple = stack.pop();
            if(tuple.node.val >= tuple.max) {
                count++;
            }
            if(tuple.node.right != null) {
                stack.push(new S2(tuple.node.right, Math.max(tuple.max, tuple.node.val)));
            }
            if(tuple.node.left != null) {
                stack.push(new S2(tuple.node.left, Math.max(tuple.max, tuple.node.val)));
            }
        }
        return count;
    }

    static class S2 {
        TreeNode node;
        Integer max;

        public S2(TreeNode node, Integer max) {
            this.node = node;
            this.max = max;
        }
    }
}
