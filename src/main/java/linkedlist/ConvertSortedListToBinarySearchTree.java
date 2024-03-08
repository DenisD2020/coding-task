package linkedlist;

import binarytree.TreeNode;
import twopointers.ListNode;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 */
public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        System.out.println(new ConvertSortedListToBinarySearchTree().sortedListToBST(Helper.fromArray(new int[]{-10, -3, 0, 5, 9})));
        System.out.println(new ConvertSortedListToBinarySearchTree().sortedListToBST(Helper.fromArray(new int[]{1, 3}))); // 3 1
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        return solve(head, null);

    }

    private TreeNode solve(ListNode head, ListNode tail) { // TODO
        ListNode slow = head;
        ListNode fast = head;

        if (head == tail) return null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = solve(slow, fast);
        root.right = solve(fast, fast);
        return root;
    }

}
