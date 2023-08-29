package binarysearch;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/
 * <p>
 * You are given an integer array nums of length n, and an integer array queries of length m.
 * Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 */
public class LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LongestSubsequenceWithLimitedSum().answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21}))); // [2,3,4]
//        System.out.println(Arrays.toString(new LongestSubsequenceWithLimitedSum().answerQueries(new int[]{4, 5, 2, 1}, new int[]{1}))); // [0]
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int length = queries.length;
        int[] ans = new int[length];

        for (int i = 0; i < length; i++) {
            int count = 0;
            int q = queries[i];
            for (int n : nums) {
                if (q >= n) {
                    q -= n;
                    count++;
                } else {
                    break;
                }
                ans[i] = count;
            }
        }
        return ans;
    }
}
