package leetcode.linkedlist;

import leetcode.twopointers.ListNode;

/**
 * https://leetcode.com/problems/merge-in-between-linked-lists/description/
 */
public class MergeInBetweenLinkedLists {
    public static void main(String[] args) {

        System.out.println(new MergeInBetweenLinkedLists().mergeInBetween(
                Helper.fromArray(new int[]{0, 1, 2, 3, 4, 5}),
                3, 4,
                Helper.fromArray(new int[]{1000000, 1000001, 1000002}))); // [0,1,2,1000000,1000001,1000002,5]

        System.out.println(new MergeInBetweenLinkedLists().mergeInBetween(
                Helper.fromArray(new int[]{0, 1, 2, 3, 4, 5}),
                2, 5,
                Helper.fromArray(new int[]{1000000, 1000001, 1000002, 1000003, 1000004}))); // [0,1,1000000,1000001,1000002,1000003,1000004,6]
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode current = list1;
        ListNode tmp = null;

        for (int i = 0; i < a - 1; i++) {
            current = current.next;
        }
        tmp = current.next;
        current.next = list2;

        while (list2.next != null) {
            list2 = list2.next;
        }

        for (int i = a; i < b + 1; i++) {
            tmp = tmp.next;
        }
        list2.next = tmp;
        return list1;
    }
}
