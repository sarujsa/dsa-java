package saruj.leet.problems;

import saruj.leet.util.TreeNode;

/**
 * Lowest Common Ancestor of a Binary Tree
 */
public class P236 {
    public static void main(String[] args) {
        P236 prog = new P236();

        TreeNode t = TreeNode.fromArray(new Integer[]{1,2,3,null,4});
        TreeNode p1 = t;
        TreeNode q1 = t.left.right;
        System.out.println(prog.lowestCommonAncestor(t, p1, q1));

        TreeNode n = TreeNode.fromArray(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p = n.left;
        TreeNode q = n.right;
        System.out.println(prog.lowestCommonAncestor(n, p, q));

        q = n.left.right.right;
        System.out.println(prog.lowestCommonAncestor(n, p, q));

        q = p;
        p = q.left;
        System.out.println(prog.lowestCommonAncestor(n, p, q));

        q = n.left.right;
        System.out.println(prog.lowestCommonAncestor(n, p, q));

        p = q.left;
        q = q.right;
        System.out.println(prog.lowestCommonAncestor(n, p, q));

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        var s4 = fun(root, p, q);
        if(s4 != null) return s4.node;
        else return root;
    }

    private S4 fun(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        boolean isP = root == p;
        boolean isQ = root == q;
        if(root.left == null && root.right == null) {
            return new S4(false, isP, isQ, null);
        } else {
            var s4Left = fun(root.left, p, q);
            if(s4Left != null && s4Left.resolved) return s4Left;
            var s4Right = fun(root.right, p, q);
            if(s4Right != null && s4Right.resolved) return s4Right;

            boolean resolved;
            if(isP) {
                resolved = s4Left != null && s4Left.q;
                if(resolved) return new S4(true, true, true, root);
                resolved = s4Right != null && s4Right.q;
                if(resolved) return new S4(true, true, true, root);
                return new S4(false, isP, isQ, null);
            } else if (isQ) {
                resolved = s4Left != null && s4Left.p;
                if(resolved) return new S4(true, true, true, root);
                resolved = s4Right != null && s4Right.p;
                if(resolved) return new S4(true, true, true, root);
                return new S4(false, isP, isQ, null);
            } else if(s4Left != null && s4Right != null) {
                if(s4Left.p && s4Right.q || s4Left.q && s4Right.p) {
                    return new S4(true, true, true, root);
                } else if (s4Left.p || s4Left.q) {
                    return s4Left;
                } else {
                    return s4Right;
                }
            } else {
                if(s4Left != null) return s4Left;
                if(s4Right != null) return s4Right;
                else return new S4(false, false, false, null);
            }
        }
    }

    static class S4 {
        private boolean resolved;
        private boolean p;
        private boolean q;
        private TreeNode node;

        public S4(boolean resolved, boolean p, boolean q, TreeNode node) {
            this.resolved = resolved;
            this.p = p;
            this.q = q;
            this.node = node;
        }
    }
}
