package saruj.leet.problems;

import saruj.leet.util.ListNode;

import static saruj.leet.util.ListNode.initListNode;

/**
 * 2095. Delete the Middle Node of a Linked List
 */
public class P2095 {

    public static void main(String[] args) {
        P2095 p = new P2095();
        ListNode n1 = initListNode(new int[]{1,3,4,7,1,2,6});
        System.out.println(p.deleteMiddle(n1));

        ListNode n2 = initListNode(new int[]{1,2,3,4});
        System.out.println(p.deleteMiddle(n2));

        ListNode n3 = initListNode(new int[]{2,1});
        System.out.println(p.deleteMiddle(n3));

        ListNode n4 = initListNode(new int[]{2});
        System.out.println(p.deleteMiddle(n4));
    }

    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) {
            return null;
        }
        ListNode iter = head;
        int count = 1;
        while(iter.next != null) {
            iter = iter.next;
            count++;
        }
        final int removeIndex = Math.floorDiv(count, 2);
        iter = head;
        ListNode reversed = new ListNode(head.val);
        for(int i = 0; i < removeIndex; i++) {
            iter = iter.next;
            reversed = new ListNode(iter.val, reversed);
        }
        // iter is the element we must delete
        // reversed is also that element, but backwards
        reversed = reversed.next;
        ListNode returnList = new ListNode(reversed.val, iter.next);
        while(reversed.next != null) {
            reversed = reversed.next;
            returnList = new ListNode(reversed.val, returnList);
        }
        return returnList;
    }

}
