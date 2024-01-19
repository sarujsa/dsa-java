package saruj.leet.problems;

import saruj.leet.util.ListNode;

/**
 * Reverse Linked List
 */
public class P206 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode reversed = new ListNode(head.val);
        while(head.next != null) {
            head = head.next;
            reversed = new ListNode(head.val, reversed);
        }
        return reversed;
    }
}
