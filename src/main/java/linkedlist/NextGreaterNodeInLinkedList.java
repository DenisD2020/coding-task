package linkedlist;

import twopointers.ListNode;

import java.util.*;

/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/description/
 */
public class NextGreaterNodeInLinkedList {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterNodeInLinkedList().nextLargerNodes(Helper.fromArray(new int[]{2, 7, 4, 3, 5})))); // 7,0,5,5,0
        System.out.println(Arrays.toString(new NextGreaterNodeInLinkedList().nextLargerNodes(Helper.fromArray(new int[]{2, 1, 5})))); // 5,5,0
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int[] ans = new int[values.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < values.size(); i++) {
            while (!stack.isEmpty() && values.get(stack.peek()) < values.get(i)) {
                ans[stack.peek()] = values.get(i);
            }
            stack.add(i);
        }
        return ans;
    }
}
