package saruj.leet.problems;

import saruj.leet.util.TreeNode;


/**
 * Delete node in a BST.
 */
public class P450 {

    public static void main(String[] args) {
        P450 p = new P450();
        TreeNode t, res;
        t = initT1();
        System.out.println(t);

//        res = p.deleteNode(t, 50);
//        System.out.println(res);
//
//        t = initT1();
//        res = p.deleteNode(t, 100);
//        System.out.println(res);
//
//        t = initT1();
//        res = p.deleteNode(t, 25);
//        System.out.println(res);

        t = initT1();
        res = p.deleteNode(t, 12);
        System.out.println(res);

        t = initT1();
        res = p.deleteNode(t, 37);
        System.out.println(res);

        t = initT1();
        res = p.deleteNode(t, 6);
        System.out.println(res);

        t = initT1();
        res = p.deleteNode(t, 18);
        System.out.println(res);
    }

    private static TreeNode initT1() {
        return TreeNode.fromArray(new Integer[]
                {100,50,null,25 ,75,null,null,12,37,62,87,null,null,null,null,6,18,28,40,60,70,80,99});
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        S3 s = getNodeToBeReplaced(root, key, null, false);
        if(s == null) {
            return root;
        }
        if(s.toBeReplaced.left != null && s.toBeReplaced.right != null) {
            // set the value of toBeReplaced to the rightmost child on the left
            S3 r = findReplacement(s.toBeReplaced.left);
            s.toBeReplaced.val = r.toBeReplaced.val;
            // now fix the rightMost child
            if(r.parent == r.toBeReplaced) {
                s.toBeReplaced.left = r.toBeReplaced.left;
            } else {
                r.parent.right = r.toBeReplaced.left;
            }
        } else if(s.toBeReplaced.left == null) {
            if(s.parent == null) { // we're removing root
                return s.toBeReplaced.right;
            }
            if(s.left) {
                s.parent.left = s.toBeReplaced.right;
            } else {
                s.parent.right = s.toBeReplaced.right;
            }
        } else {
            if(s.parent == null) { // we're removing root
                return s.toBeReplaced.left;
            }
            if(s.left) {
                s.parent.left = s.toBeReplaced.left;
            } else {
                s.parent.right = s.toBeReplaced.left;
            }
        }
        return root;
    }

    private S3 findReplacement(TreeNode root) {
        TreeNode parent = root;
        while(root.right != null) {
            parent = root;
            root = root.right;
        }
        return new S3(root, parent, false);
    }

    private S3 getNodeToBeReplaced(TreeNode root, int key, TreeNode rootsParent, boolean left) {
        if(root == null) return null;
        if(root.val == key) {
            return new S3(root, rootsParent, left);
        } else {
            if(key < root.val) {
                return getNodeToBeReplaced(root.left, key, root, true);
            } else {
                return getNodeToBeReplaced(root.right, key, root, false);
            }
        }
    }

    static class S3 {
        TreeNode toBeReplaced;
        TreeNode parent;
        boolean left;

        public S3(TreeNode toBeReplaced, TreeNode parent, boolean left) {
            this.toBeReplaced = toBeReplaced;
            this.parent = parent;
            this.left = left;
        }
    }
}
