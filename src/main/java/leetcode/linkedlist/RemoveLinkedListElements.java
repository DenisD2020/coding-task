package leetcode.linkedlist;

import leetcode.twopointers.ListNode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        System.out.println(new RemoveLinkedListElements().removeElements(Helper.fromArray(new int[]{1, 2, 6, 3, 4, 5, 6}), 6)); // [1,2,3,4,5]
        System.out.println(new RemoveLinkedListElements().removeElements(Helper.fromArray(new int[]{7, 7, 7, 7}), 7)); // []
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode prev = root;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return root.next;
    }
}
