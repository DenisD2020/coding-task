package linkedlist;

import twopointers.Helper;
import twopointers.ListNode;

/**
 * https://leetcode.com/problems/linked-list-random-node/description/
 */
public class LinkedListRandomNode {
    public static void main(String[] args) {
        Solution solution = new Solution(Helper.fromArray(new int[]{1, 2, 3}));
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }


    static class Solution {
        public Solution(ListNode head) {

        }

        public int getRandom() {

        }
    }
}
