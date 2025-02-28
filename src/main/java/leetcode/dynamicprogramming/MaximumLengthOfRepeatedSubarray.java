package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/?envType=problem-list-v2&envId=dynamic-programming&favoriteSlug=&difficulty=MEDIUM
 */
public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        System.out.println(new MaximumLengthOfRepeatedSubarray().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7})); // 3
        System.out.println(new MaximumLengthOfRepeatedSubarray().findLength(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0})); // 5
    }

    int[][] dp;
    int ans = 0;

    public int findLength(int[] nums1, int[] nums2) {
        dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = Math.max(1, dp[i - 1][j - 1] + 1);
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans;
    }
}
