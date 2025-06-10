package leetcode.linkedlist;

import leetcode.twopointers.ListNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println(new AddTwoNumbers().addTwoNumbers(
                Helper.fromArray(new int[]{2, 4, 3}),
                Helper.fromArray(new int[]{5, 6, 4})) // 708
        );

        System.out.println(new AddTwoNumbers().addTwoNumbers(
                Helper.fromArray(new int[]{9, 9, 9, 9, 9, 9, 9}),
                Helper.fromArray(new int[]{9, 9, 9, 9})) // 8,9,9,9,0,0,0,1
        );
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { // 100%

        var root = new ListNode();
        ListNode prev = root;
        int add = 0;

        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + add;
            if (sum > 9) {
                add = 1;
                sum = sum - 10;
            } else {
                add = 0;
            }
            ListNode next = new ListNode(sum);
            prev.next = next;
            prev = next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (add == 1) {
            prev.next = new ListNode(1);
        }
        return root.next;
    }
}
