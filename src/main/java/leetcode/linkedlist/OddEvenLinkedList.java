package leetcode.linkedlist;

import leetcode.twopointers.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/description/
 * <p>
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        System.out.println(new OddEvenLinkedList().oddEvenList(Helper.fromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}))); // 1,3,5,7,2,4,6,8
        System.out.println(new OddEvenLinkedList().oddEvenList(Helper.fromArray(new int[]{1, 2, 3, 4, 5}))); // 1,3,5,2,4
        System.out.println(new OddEvenLinkedList().oddEvenList(Helper.fromArray(new int[]{2, 1, 3, 5, 6, 4, 7}))); // 2,3,6,7,1,5,4
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode rootOdd = oddHead;
        ListNode rootEven = evenHead;

        while (evenHead != null && evenHead.next != null) {
            oddHead.next = oddHead.next.next;
            evenHead.next = evenHead.next.next;

            oddHead = oddHead.next;
            evenHead = evenHead.next;
        }
        oddHead.next = rootEven;
        return rootOdd;
    }

/*    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) return head;
        ListNode end = head;
        int count = 0;
        while (end.next != null) {
            count++;
            end = end.next;
        }

        ListNode left = head;
        ListNode leftN = null;

        int middle = count % 2 == 0 ? count / 2 : count / 2 + 1;

        for (int i = 0; i < middle; i++) {

            leftN = left.next.next;
            left.next.next = null;
            end.next = left.next;
            left.next = leftN;

            end = end.next;
            left = left.next;
        }
        return head;
    }*/
}
