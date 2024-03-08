package twopointers;

import linkedlist.Helper;

/**
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 * <p>
 * You are given the head of a linked list, and an integer k.
 * <p>
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 */
public class SwappingNodesLinkedList {

    public static void main(String[] args) {
//        System.out.println(new SwappingNodesLinkedList().swapNodes(Helper.fromArray(new int[]{1, 2}), 1));
        System.out.println(new SwappingNodesLinkedList().swapNodes(Helper.fromArray(new int[]{1, 2, 3, 4}), 2));
//        System.out.println(new SwappingNodesLinkedList().swapNodes(Helper.fromArray(new int[]{1, 2, 3, 4, 5}), 2));
//        System.out.println(new SwappingNodesLinkedList().swapNodes(Helper.fromArray(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5}), 5));
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode current = head;
        int length = 0;

        while (current != null) {
            current = current.next;
            length++;
        }

        if (length == 1) return head;

        current = head;

        ListNode left = null;
        ListNode right = null;

        for (int i = 1; i <= length; i++) {

            if (i == k) {
                left = current;
            }

            if (i == length + 1 - k) {
                right = current;
            }
            current = current.next;
        }

        var tmp = left.val;
        left.val = right.val;
        right.val = tmp;

        return head;
    }
}
