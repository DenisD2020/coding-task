package linkedlist;

import twopointers.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/remove-nodes-from-linked-list/description/
 */
public class RemoveNodesFromLinkedList {

    public static void main(String[] args) {
        System.out.println(new RemoveNodesFromLinkedList().removeNodes(Helper.fromArray(new int[]{5, 2, 13, 3, 8}))); // 13,8
        System.out.println(new RemoveNodesFromLinkedList().removeNodes(Helper.fromArray(new int[]{1, 1, 1, 1, 1}))); // 1,1,1,1
    }

    public ListNode removeNodes(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            while (!stack.isEmpty() && stack.peek() < head.val) {
                stack.pop();
            }
            stack.push(head.val);
            head = head.next;
        }
        ListNode root = null;
        ListNode next = null;
        while (!stack.isEmpty()) {
            ListNode node = new ListNode(stack.pollLast());
            if (root == null) {
                root = node;
            } else {
                next.next = node;
            }
            next = node;
        }
        return root;
    }
}
