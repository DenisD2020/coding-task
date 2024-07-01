package leetcode.prefixsum;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-xor-for-each-query/
 * <p>
 * You are given a sorted array nums of n non-negative integers and an integer maximumBit. You want to perform the following query n times:
 * <p>
 * Find a non-negative integer k < 2maximumBit such that nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k is maximized. k is the answer to the ith query.
 * Remove the last element from the current array nums.
 * Return an array answer, where answer[i] is the answer to the ith query.
 */
public class MaximumXOREachQuery {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaximumXOREachQuery().getMaximumXor(new int[]{0, 1, 1, 3}, 2))); //[0,3,2,3]
        System.out.println(Arrays.toString(new MaximumXOREachQuery().getMaximumXor(new int[]{2, 3, 4, 7}, 3))); //[5,2,6,5]]
        System.out.println(Arrays.toString(new MaximumXOREachQuery().getMaximumXor(new int[]{0, 1, 2, 2, 5, 7}, 3))); //[4,3,6,4,6,7]
    }

    public int[] getMaximumXor(int[] nums, int maximumBit) {

        int res = 0 ^ 1 ^ 1 ^ 3;

        return null;
    }
}

