package saruj.leet.problems;

import saruj.leet.util.TreeNode;

/**
 * Longest ZigZag Path in a Binary Tree
 */
public class P1372 {
    public static void main(String[] args) {
        P1372 p = new P1372();
        TreeNode n1 =
                new TreeNode(1,
                null,
                    new TreeNode(1,
                        new TreeNode(1),
                        new TreeNode(1,
                                new TreeNode(1,
                                        null,
                                        new TreeNode(1,
                                                null,
                                                new TreeNode(1)
                                        )
                                ),
                                new TreeNode(1)
                        )
                )
        );
        System.out.println(p.longestZigZag(n1));
    }
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;
        return Math.max(longestZigZag(root.left, true, 0), longestZigZag(root.right, false, 0));
    }

    private int longestZigZag(TreeNode root, boolean left, int count) {
        if(root == null) return count;
        count++;
        int leftCount = 0;
        int rightCount = 0;
        if(left) {
            leftCount = longestZigZag(root.right, false, count);
            rightCount = longestZigZag(root.left, true, 0);
        } else {
            leftCount = longestZigZag(root.right, false, 0);
            rightCount = longestZigZag(root.left, true, count);
        }
        return Math.max(leftCount, rightCount);
    }

}
