package linkedlist;


import twopointers.Helper;
import twopointers.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        System.out.println(new ReverseLinkedList().reverseList(Helper.fromArray(new int[]{1, 2, 3, 4, 5}))); // 5,4,3,2,1
    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode res = null;

        while (head != null) {
            if (prev == null) {
                prev = new ListNode(head.val);
                res = prev;
            } else {
                res = new ListNode(head.val);
                res.next = prev;
                prev = res;
            }
            head = head.next;
        }
        return res;
    }
}
