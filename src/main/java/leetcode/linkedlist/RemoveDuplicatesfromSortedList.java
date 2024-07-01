package leetcode.linkedlist;


import leetcode.twopointers.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class RemoveDuplicatesfromSortedList {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesfromSortedList().deleteDuplicates(
                        Helper.fromArray(new int[]{1, 1, 2}) // 1,2
                )
        );
    }

    public ListNode deleteDuplicates(ListNode head) {
        var res = head;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                head.next = head.next == null ? null : head.next.next;
            } else {
                head = head.next;
            }
        }
        return res;
    }
}
