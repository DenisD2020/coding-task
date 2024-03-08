package linkedlist;

import twopointers.ListNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 */
public class AddTwoNumbersII {

    public static void main(String[] args) {
        System.out.println(new AddTwoNumbersII().addTwoNumbers(Helper.fromArray(new int[]{0}), Helper.fromArray(new int[]{7,3}))); //
        System.out.println(new AddTwoNumbersII().addTwoNumbers(Helper.fromArray(new int[]{5}), Helper.fromArray(new int[]{5}))); // 10
        System.out.println(new AddTwoNumbersII().addTwoNumbers(Helper.fromArray(new int[]{7, 2, 4, 3}), Helper.fromArray(new int[]{5, 6, 4}))); // 7,8,0,7
        System.out.println(new AddTwoNumbersII().addTwoNumbers(Helper.fromArray(new int[]{3, 9, 9, 9, 9, 9, 9, 9, 9, 9}), Helper.fromArray(new int[]{7}))); //
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.add(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.add(l2.val);
                l2 = l2.next;
            }
        }

        ListNode prev = null;
        ListNode res = null;
        int additional = 0;

        while (!s1.isEmpty() || !s2.isEmpty()) {
            Integer el1 = 0;
            Integer el2 = 0;
            if (!s1.isEmpty()) {
                el1 = s1.pop();
            }
            if (!s2.isEmpty()) {
                el2 = s2.pop();
            }
            int sum = el1 + el2 + additional;
            if (additional > 0) additional--;
            if (sum >= 10) {
                additional++;
                sum -= 10;
            }
            res = new ListNode(sum);
            res.next = prev;
            prev = res;
        }
        if (additional > 0) {
            res = new ListNode(1);
            res.next = prev;
        }
        return res;
    }
}
