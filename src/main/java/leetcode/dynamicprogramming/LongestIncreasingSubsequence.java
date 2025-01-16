package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4  -> 2,3,7,101
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})); // 4  -> 0,1,2,3
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7})); // 1
    }

    public int lengthOfLIS(int[] nums) {
        int maxLen = 1;

        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}
