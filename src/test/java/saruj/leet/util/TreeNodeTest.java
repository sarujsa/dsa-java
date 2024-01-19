package saruj.leet.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TreeNodeTest {

    @Test
    public void testFromArray() {
        Integer[] ar = new Integer[]{3,9,20,null,1,15,7};
        TreeNode root = TreeNode.fromArray(ar);
        System.out.println(root);

        Integer[] ar1 = new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,11,null,null,8,10};
        TreeNode root1 = TreeNode.fromArray(ar1);
        System.out.println(root1);
    }

    @Test
    public void testToArray1() {
        Integer[] ar = new Integer[]{3,9,20,null,1,15,7};
        TreeNode root = TreeNode.fromArray(ar);
        Integer[] fromTreeNode = TreeNode.toArray(root);
        System.out.println(Arrays.stream(fromTreeNode)
                        .map(i -> i +"")
                        .collect(Collectors.joining(",","[","]")));
    }

    @Test
    public void testToArray2() {
        Integer[] ar = new Integer[]{3,9,null,20,null,null,null,30,null,null,null,null,null,null,null};
        TreeNode root = TreeNode.fromArray(ar);
        Integer[] fromTreeNode = TreeNode.toArray(root);
        System.out.println(Arrays.stream(fromTreeNode)
                .map(i -> i +"")
                .collect(Collectors.joining(",","[","]")));
    }

}
