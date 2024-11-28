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

    public int findLength(int[] nums1, int[] nums2) {
        dp = new int[nums1.length][nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = 1;
                }
            }
        }

        return 0;
    }
}
