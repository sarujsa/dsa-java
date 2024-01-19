package saruj.leet.problems;

import saruj.leet.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Maximum Level Sum of a Binary Tree.
 */
public class P1161 {
    public static void main(String[] args) {
        P1161 p = new P1161();
        TreeNode n = null;

        //n = TreeNode.fromArray(new Integer[]{1,7,0,7,-8,null,null});
        n = TreeNode.fromArray(new Integer[]{-100,-200,-300,-20,-5,-10,null});
        System.out.println(p.maxLevelSum(n));
    }
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        final TreeNode DELIMITER = new TreeNode();
        queue.add(DELIMITER);
        int max = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currentLevel = 1;
        int sum = 0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == DELIMITER) {
                boolean stopHere = queue.isEmpty();
                queue.add(DELIMITER);
                if(sum > max) {
                    maxLevel = currentLevel;
                    max = sum;
                }
                currentLevel++;
                sum = 0;
                if(stopHere) {
                    break;
                }
            } else {
                sum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return maxLevel;
    }
}
