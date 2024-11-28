package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/longest-common-subsequence/description/
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
//        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace")); // 3
//        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abc", "abc")); // 3
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abc", "abbc")); // 3
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("bl", "yby")); // 1
//        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abc", "def")); // 0
    }

    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length();
        int col = text2.length();
        dp = new int[row + 1][col + 1]; // row * col

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[row][col];
    }
}
