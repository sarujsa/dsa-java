package saruj.leet.problems;

import saruj.leet.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Pascal's Triangle II
 */
public class P119 {
    public static void main(String[] args) {
        TreeNode t = TreeNode.fromArray(new Integer[]{1,2,3,null,5,null,4});
        P119 p = new P119();
        System.out.println(p.WRONGrightSideView(t));

        t = TreeNode.fromArray(new Integer[]{1,2,3,null,5,null,4,null,null,3,5});
        System.out.println(p.WRONGrightSideView(t));

        t = new TreeNode(1, new TreeNode(2), null);
        System.out.println(p.WRONGrightSideView(t));

        t = new TreeNode(1, null, new TreeNode(2, null,
                new TreeNode(5,
                        new TreeNode(4, new TreeNode(3), null),
                        new TreeNode(6))));
        System.out.println(p.WRONGrightSideView(t));

        t = TreeNode.fromArray(new Integer[]{5,3,6,1,4,null,null,null,2});
        System.out.println(p.WRONGrightSideView(t));
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        final TreeNode ROW_END = new TreeNode(0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(ROW_END);
        Integer previous = null;
        while(!queue.isEmpty()) {
            TreeNode next = queue.poll();
            if(ROW_END == next) {
                values.add(previous);
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(ROW_END);
                    continue;
                }
            }
            previous = next.val;
            if(next.left != null) queue.add(next.left);
            if(next.right != null) queue.add(next.right);
        }
        return values;
    }

    public List<Integer> WRONGrightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        values.add(root.val);
        int levelsOnRight = root.right == null? 0 : dfsRight(root, values);
        TreeNode next = levelsOnRight == 0 ? root : skipXLevelsLeft(root, levelsOnRight);
        if(next != null) {
            dfsRight(next, values);
        }
        return values;
    }

    private TreeNode skipXLevelsLeft(TreeNode root, int levelsToSkip) {
        TreeNode next = root;
        while(next.left == null) {
            if(next.right != null) {
                next = next.right;
                levelsToSkip--;
            } else {
                return null;
            }
        }
        next = next.left;
        levelsToSkip--;
        while(levelsToSkip > 0) {
            if(next.right != null) {
                next = next.right;
            } else if (next.left != null) {
                next = next.left;
            } else {
                next = null;
                break;
            }
            levelsToSkip--;
        }
        return next;
    }

    private int dfsRight(TreeNode node, List<Integer> values) {
        int depth = 0;
        do {
            if(node.right != null) {
                node = node.right;
                values.add(node.val);
                depth++;
            } else if (node.left != null) {
                node = node.left;
                values.add(node.val);
                depth++;
            } else {
                return depth;
            }
        } while (true);
    }

}
