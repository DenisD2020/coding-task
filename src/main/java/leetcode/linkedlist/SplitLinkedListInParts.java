package leetcode.linkedlist;

import leetcode.twopointers.ListNode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 */
public class SplitLinkedListInParts {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SplitLinkedListInParts().splitListToParts(Helper.fromArray(new int[]{0, 1, 2, 3, 4}), 3))); // [[0,1],[2,3],[4]]
//        System.out.println(Arrays.toString(new SplitLinkedListInParts().splitListToParts(new ListNode(0), 1))); // []
//        System.out.println(Arrays.toString(new SplitLinkedListInParts().splitListToParts(null, 3))); // []
        System.out.println(Arrays.toString(new SplitLinkedListInParts().splitListToParts(Helper.fromArray(new int[]{1, 2, 3}), 5))); // [[1],[2],[3],[],[]]
        System.out.println(Arrays.toString(new SplitLinkedListInParts().splitListToParts(Helper.fromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 3))); // [[1,2,3,4],[5,6,7],[8,9,10]]
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) return new ListNode[k];
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        ListNode[] ans = new ListNode[k];
        ListNode prev = head;
        ListNode current = head;
        int basketSize = length / k;
        int extra = length % k;
        for (int b = 0; b < k; b++) {
            for (int i = 0; i < basketSize  + (extra > 0 ? 1 : 0) && current != null; i++) {
                if (i == 0) ans[b] = current;
                prev = current;
                current = current.next;
            }
            prev.next = null;
            extra--;
        }
        return ans;
    }
}
