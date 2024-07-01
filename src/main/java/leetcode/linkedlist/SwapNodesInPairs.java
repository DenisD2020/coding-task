package leetcode.linkedlist;

import leetcode.twopointers.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        System.out.println(new SwapNodesInPairs().swapPairs(Helper.fromArray(new int[]{1, 2, 3, 4}))); // [2, 1, 4, 3]
        System.out.println(new SwapNodesInPairs().swapPairs(new ListNode(1))); // [1]
        System.out.println(new SwapNodesInPairs().swapPairs(null)); // []
    }

    public ListNode swapPairs(ListNode head) { // TODO analyse another solutions
        if (head == null || head.next == null ) return head;
        ListNode fakeNode = new ListNode(0);
        fakeNode.next = head;
        ListNode scr = fakeNode;
        while (scr != null && scr.next != null && scr.next.next != null) {
            ListNode next = scr.next;
            ListNode nextN1 = scr.next.next;
            ListNode nextN2 = scr.next.next.next;
            scr.next = nextN1;
            nextN1.next = next;
            next.next = nextN2;
            scr = scr.next.next;
        }
        return fakeNode.next;
    }

    /*
      public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fakeNode = new ListNode(0);
        fakeNode.next = head;
        solve(fakeNode);
        return fakeNode.next;
    }

    private void solve(ListNode scr) {
        if (scr == null || scr.next == null || scr.next.next == null) return;

        ListNode next = scr.next;
        ListNode nextN1 = scr.next.next;
        ListNode nextN2 = scr.next.next.next;
        scr.next = nextN1;
        nextN1.next = next;
        next.next = nextN2;
        solve(scr.next.next);
    }

     */
}
