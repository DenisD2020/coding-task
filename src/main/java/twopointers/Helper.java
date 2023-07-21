package twopointers;

public class Helper {

    public static ListNode fromArray(int[] data) {
        ListNode head = new ListNode(data[0]);
        ListNode node = head;
        for (int i = 1; i< data.length; i++) {
            node.next = new ListNode(data[i]);
            node = node.next;
        }
        return head;
    }
}
