package saruj.leet.util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        ListNode iter = this;
        StringBuilder sb = new StringBuilder("[");
        while(iter != null) {
            sb.append(iter.val).append(",");
            iter = iter.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static ListNode initListNode(int[] ints) {
        ListNode iter = new ListNode(ints[ints.length-1]);
        for(int i = ints.length-2; i >=0; i--) {
            iter = new ListNode(ints[i], iter);
        }
        return iter;
    }
}
