package leetcode.linkedlist;

import leetcode.twopointers.ListNode;

/**
 * https://leetcode.com/problems/merge-nodes-in-between-zeros/description/
 */
public class MergeNodesInBetweenZeros {
    public static void main(String[] args) {
        System.out.println(new MergeNodesInBetweenZeros().mergeNodes(Helper.fromArray(new int[]{0, 24, 14, 0}))); //[38]
        System.out.println(new MergeNodesInBetweenZeros().mergeNodes(Helper.fromArray(new int[]{0, 3, 1, 0, 4, 5, 2, 0}))); //[4,11]
        System.out.println(new MergeNodesInBetweenZeros().mergeNodes(Helper.fromArray(new int[]{0, 1, 0, 3, 0, 2, 2, 0}))); //[1,3,4]
    }

    public ListNode mergeNodes(ListNode root) {
        ListNode prev = root;
        ListNode next = root.next;
        while (next != null) {
            if (next.val == 0 && next.next == null) {
                prev.next = null;
                break;
            }
            if (next.val == 0) {
                prev.next = new ListNode(0);
                prev = prev.next;
            } else {
                prev.val += next.val;
            }
            next = next.next;
        }
        return root;
    }


/*    public ListNode mergeNodes(ListNode head) { // recursive solution, still slow
        solve(head.next, head);
        return head;
    }

    private void solve(ListNode head, ListNode prev) {
        if (head.val == 0 && head.next == null) {
            prev.next = null;
            return;
        }
        if (head.val == 0) {
            prev.next = new ListNode(0);
            prev = prev.next;
        } else {
            prev.val += head.val;
        }
        solve(head.next, prev);
    }*/


/*    public ListNode mergeNodes(ListNode head) { // 6 ms to slow, time O(n) memory  O(n)
        ListNode newNode = new ListNode(0);
        ListNode root = newNode;
        head = head.next;
        while (head != null) {
            if (head.val == 0 && head.next == null) break;
            if (head.val == 0) {
                newNode.next = new ListNode();
                newNode = newNode.next;
            } else {
                newNode.val += head.val;
            }
            head = head.next;
        }
        return root;
    }*/
}
