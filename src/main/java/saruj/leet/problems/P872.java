package saruj.leet.problems;

import saruj.leet.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Leaf-Similar Trees.
 */
public class P872 {

    public static void main(String[] args) {
        P872 p = new P872();

        TreeNode t7 = TreeNode.fromArray(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,11,null,null,8,10});
        // ovo se krivo ucita pa ajmo dodati:
        TreeNode node = t7.right.right.right;
        node.left = new TreeNode(8);
        node.right = new TreeNode(10);
        TreeNode t8 = TreeNode.fromArray(new Integer[]{3,5,1,6,2,9,8,null,null,7,4});
        System.out.println(p.leafSimilar(t7, t8));

        TreeNode t5 = TreeNode.fromArray(new Integer[]{1,2,null,3});
        TreeNode t6 = TreeNode.fromArray(new Integer[]{1,3});
        System.out.println(p.leafSimilar(t5, t6));

        TreeNode t1 = TreeNode.fromArray(new Integer[]{3,5,1,6,2,9,8,null,null,7,4});
        TreeNode t2 = TreeNode.fromArray(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8});
        System.out.println(p.leafSimilar(t1, t2));

        TreeNode t3 = TreeNode.fromArray(new Integer[]{1,2,3});
        TreeNode t4 = TreeNode.fromArray(new Integer[]{1,3,2});
        System.out.println(p.leafSimilar(t3, t4));
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root1);
        Queue<Integer> queue1 = new LinkedList<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack2.push(root2);
        Queue<Integer> queue2 = new LinkedList<>();
        boolean same = true;
        outer: while(!stack1.isEmpty() || !stack2.isEmpty()) {
            pushToStackOrQueue(stack1, queue1);
            pushToStackOrQueue(stack2, queue2);
            while(!queue2.isEmpty() && !queue1.isEmpty()) {
                if(!queue2.poll().equals(queue1.poll())) {
                    same = false;
                    break outer;
                }
            }
        }
        if(queue2.isEmpty() && !queue1.isEmpty()
            || queue1.isEmpty() && !queue2.isEmpty()) {
            same = false;
        }
        return same;
    }

    private void pushToStackOrQueue(Stack<TreeNode> stack, Queue<Integer> queue) {
        if(stack.isEmpty()) return;
        TreeNode node = stack.pop();
        if(node != null) {
            if (node.left == null && node.right == null) {
                queue.add(node.val);
            } else {
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
        }
    }
}
