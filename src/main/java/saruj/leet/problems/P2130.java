package saruj.leet.problems;

import saruj.leet.util.ListNode;

/**
 * Maximum Twin Sum of a Linked List
 */
public class P2130 {
    public static void main(String[] args) {
        P2130 p = new P2130();
        ListNode l1 = ListNode.initListNode(new int[]{5,4,2,1});
        System.out.println(p.someoneElsesSolution(l1));
    }
    public int pairSum(ListNode head) {
        ListNode reversed = new ListNode(head.val);
        int count = 1;
        ListNode iter = head;
        while(iter.next != null) {
            iter = iter.next;
            reversed = new ListNode(iter.val, reversed);
            count++;
        }
        int halfway = count / 2;
        int sum = 0;
        for(int i = 0; i < halfway; i++) {
            sum = Math.max(sum, head.val + reversed.val);
            head = head.next;
            reversed = reversed.next;
        }
        return sum;
    }

    public int someoneElsesSolution(ListNode head) {
        ListNode start = head;
        int len =0;
        while(start!=null) {
            len++;
            start = start.next;
        }

        int n = len/2;

        ListNode prev = null;
        ListNode next = head;
        int i =0;
        int sum =0;
        while(head != null) {
            while(i< n) {
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
                i++;
            }

            if(sum < prev.val + head.val) {
                sum = prev.val +head.val;
            }
            head = head.next;
            prev = prev.next;
        }

        return sum;
    }
}
