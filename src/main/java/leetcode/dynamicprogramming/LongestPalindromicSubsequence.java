package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("abba")); // 4
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab")); // 4
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("cbbd")); // 2
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("aabaa")); // 5
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("abcdef")); // 1
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("abcabcabcabc")); // 7
    }

    int[][] dp;

    public int longestPalindromeSubseq(String s1) {
        return longestCommonSubsequence(s1, new StringBuilder(s1).reverse().toString());
    }

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
