package linkedlist;

import twopointers.Helper;
import twopointers.ListNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 */
public class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        new DeleteNodeInALinkedList().deleteNode(Helper.fromArray(new int[]{4, 5, 1, 9}));
        new DeleteNodeInALinkedList().deleteNode(Helper.fromArray(new int[]{4, 5, 1, 9}));
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
