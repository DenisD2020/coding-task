package leetcode.linkedlist;

import leetcode.twopointers.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/linked-list-random-node/description/
 */
public class LinkedListRandomNode { // TODO
    public static void main(String[] args) {
        Solution solution = new Solution(Helper.fromArray(new int[]{1, 2, 3}));
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }


    static class Solution {

        List<Integer> node = new ArrayList<>();

        public Solution(ListNode head) {
            while (head != null) {
                node.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            return node.get((int) (Math.floor(Math.random() * (node.size()))));
        }
    }
}
