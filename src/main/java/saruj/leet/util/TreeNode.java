package saruj.leet.util;

import java.util.*;
import java.util.stream.Stream;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(this);
        final TreeNode endMarkerNode = new TreeNode();
        final TreeNode childMarkerNode = new TreeNode();
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if(current == endMarkerNode) {
                sb.append(")");
                continue;
            } else if (current == childMarkerNode) {
                sb.append("()");
                continue;
            }
            sb.append("(").append(current.val);
            if(current.right == null && current.left == null) {
                sb.append(")");
            } else {
                stack.push(endMarkerNode);
                stack.push(Objects.requireNonNullElse(current.right, childMarkerNode));
                stack.push(Objects.requireNonNullElse(current.left, childMarkerNode));
            }
        }
        return sb.toString();
    }

    /**
     * Warning -- can easily cause OutOfMemoryError.
     */
    public static Integer[] toArray(TreeNode root) {
        if(root == null) return new Integer[0];
        Integer[] array = new Integer[1];
        Deque<S3> deque = new LinkedList<>();
        deque.push(new S3(root, 0, 0));
        while(!deque.isEmpty()) {
            S3 tuple = deque.pop();
            Integer level = tuple.level;
            Integer numberAtLevel = tuple.numberAtLevel;
            int index = (int) Math.pow(2, level) + numberAtLevel -1;
            if(index >= array.length) {
                array = resizeAndCopyArray(array, index);
            }
            TreeNode node = tuple.node;
            array[index] = node.val;
            if(node.left != null) {
                deque.push(new S3(node.left, level+1, numberAtLevel*2));
            }
            if(node.right != null) {
                deque.push(new S3(node.right, level+1, numberAtLevel*2+1));
            }
        }
        return array;
    }

    /**
     * A halper class for Stack, has 3 components.
     */
    static class S3 {
        TreeNode node;
        Integer level;
        Integer numberAtLevel;
        public S3(TreeNode node, Integer level, Integer numberAtLevel) {
            this.node = node;
            this.level = level;
            this.numberAtLevel = numberAtLevel;
        }
    }

    private static final List<Integer> powersOfTwo;
    static {
        powersOfTwo = Stream.iterate(1, i -> i * 2)
                .limit(10)
                .toList();
    }
    private static Integer[] resizeAndCopyArray(Integer[] array, int mustFit) {
        int max = powersOfTwo.get(powersOfTwo.size()-1);
        if(mustFit >= max) {
            throw new IllegalArgumentException("This size of array is not supported. Max is " + max);
        }
        if(mustFit < 0) {
            throw new IllegalStateException("Argument mustFit must be > 0. Is " + mustFit);
        }
        int newSize = 0;
        for(Integer powerOfTwo : powersOfTwo) {
            if(powerOfTwo-1 > mustFit) {
                newSize = powerOfTwo-1;
                break;
            }
        }
        Integer[] newArray = new Integer[newSize];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    public static TreeNode fromArray(Integer[] array) {
        if(array == null || array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        S4 start = new S4(root, 0, 0, null);
        Stack<S4> stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()) {
            S4 tuple = stack.pop();
            int nextLevel = tuple.level+1;
            int nextNumberAtLevel = tuple.numberAtLevel*2+1;
            int nextIndex = (int) Math.pow(2, nextLevel) + nextNumberAtLevel -1;
            if(nextIndex >= array.length) {
                continue;
            }
            if(array[nextIndex] != null) {
                S4 right = new S4(new TreeNode(array[nextIndex]), nextLevel, nextNumberAtLevel, tuple.node);
                stack.push(right);
                tuple.node.right = right.node;
            }
            nextNumberAtLevel = nextNumberAtLevel-1;
            nextIndex = nextIndex - 1;
            if(array[nextIndex] != null) {
                S4 left = new S4(new TreeNode(array[nextIndex]), nextLevel, nextNumberAtLevel, tuple.node);
                stack.push(left);
                tuple.node.left = left.node;
            }
        }
        return root;
    }

    public static class S4 {
        TreeNode node;
        Integer level;
        Integer numberAtLevel;
        TreeNode parent;

        public S4(TreeNode node, Integer level, Integer numberAtLevel, TreeNode parent) {
            this.node = node;
            this.level = level;
            this.numberAtLevel = numberAtLevel;
            this.parent = parent;
        }
    }

}
