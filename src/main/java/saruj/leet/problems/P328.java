package saruj.leet.problems;

import saruj.leet.util.ListNode;

/**
 * Odd Even Linked List
 */
public class P328 {
    public static void main(String[] args) {
        P328 p = new P328();
        System.out.println(p.oddEvenList(ListNode.initListNode(
                new int[]{1,2,3,4,5}
        )));
        System.out.println(p.oddEvenList(ListNode.initListNode(
                new int[]{1}
        )));
        System.out.println(p.oddEvenList(ListNode.initListNode(
                new int[]{1,2}
        )));
        System.out.println(p.oddEvenList(ListNode.initListNode(
                new int[]{1,2,3}
        )));
        System.out.println(p.oddEvenList(ListNode.initListNode(
                new int[]{1,2,3,4}
        )));
        System.out.println(p.oddEvenList(ListNode.initListNode(
                new int[]{1,2,3,4,5,6,7,8,9}
        )));
        System.out.println(p.oddEvenList(ListNode.initListNode(
                new int[]{1,2,3,4,5,6,7,8,9,10}
        )));
    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else if (head.next.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode odd = head;
        try {
            while (even != null) {
                odd.next = even.next;
                odd = odd.next == null ? odd : odd.next;
                even.next = odd.next;
                even = even.next;
            }
        } catch (NullPointerException expected) {}
        odd.next = evenHead;
        return head;
    }
}
