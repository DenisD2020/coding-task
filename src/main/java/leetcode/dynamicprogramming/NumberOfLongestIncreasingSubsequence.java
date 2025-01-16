package leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 */
public class NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
//        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1, 3, 5, 4, 7})); // 2 [1, 3, 4, 7] and [1, 3, 5, 7]
//        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[]{2, 2, 2, 2, 2})); // 5
        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1, 2, 3, 1, 2, 3})); // 4
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int findNumberOfLIS(int[] nums) { // TODO

        int length = nums.length;
        int[] dp = new int[length];
        int[] ansD = new int[length];
        Arrays.fill(dp, 1);
        Arrays.fill(ansD, 1);
        int ans = 0;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int max = Math.max(dp[j] + 1, dp[i]);
                    if (max == dp[i]) {
                        ansD[max] = ansD[max] + 1;
                    }
                    dp[i] = max;
                }
            }
        }
        return ans + 1;
    }
}
