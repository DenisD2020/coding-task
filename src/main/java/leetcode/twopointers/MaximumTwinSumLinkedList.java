package leetcode.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 * <p>
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 * <p>
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 * <p>
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [5,4,2,1]
 * Output: 6
 * Explanation:
 * Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
 * There are no other nodes with twins in the linked list.
 * Thus, the maximum twin sum of the linked list is 6.
 * Example 2:
 * <p>
 * <p>
 * Input: head = [4,2,2,3]
 * Output: 7
 * Explanation:
 * The nodes with twins present in this linked list are:
 * - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
 * - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
 * Thus, the maximum twin sum of the linked list is max(7, 4) = 7.
 * Example 3:
 * <p>
 * <p>
 * Input: head = [1,100000]
 * Output: 100001
 * Explanation:
 * There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is an even integer in the range [2, 105].
 * 1 <= Node.val <= 105
 */
public class MaximumTwinSumLinkedList {

    public static void main(String[] args) {
        System.out.println(new MaximumTwinSumLinkedList().pairSum(new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1)))))); // 5 4 2 1
    }

    public int pairSum(ListNode head) {
        List<Integer> list = toList(head, new ArrayList<>());
        int max = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            int indexTwin = list.size() - 1 - i;
            max = Math.max(max, list.get(i) + list.get(indexTwin));
        }
        return max;
    }

    private List<Integer> toList(ListNode head, List<Integer> result) {
        var _head = head;
        while (_head != null) {
            result.add(_head.val);
            _head = _head.next;
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
