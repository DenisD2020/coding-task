package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().countSubstrings("ab")); // 2
        System.out.println(new PalindromicSubstrings().countSubstrings("abc")); // 3
        System.out.println(new PalindromicSubstrings().countSubstrings("aaa")); // 6
        System.out.println(new PalindromicSubstrings().countSubstrings("aaaaa")); // 15
        System.out.println(new PalindromicSubstrings().countSubstrings("fdsklf")); // 6
        System.out.println(new PalindromicSubstrings().countSubstrings("xkjkqlajprjwefilxgpdpebieswu")); // 30
        System.out.println(new PalindromicSubstrings().countSubstrings("dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg")); // 77
    }

    private int[][] dp;
    int ans = 0;

    public int countSubstrings(String s) {
        if (s.length() == 1) return 1;
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    ans++;
                } else if (dp[i][j] == - 1) continue;
                else if (dp[i][j] == 1) {
                    ans++;
                } else if (dp[i][j] == 0) {
                    if (isPalindrome(s, i, j)) ans++;
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s, int start, int end) {
        if (dp[start][end] != 0) return dp[start][end] == 1;
        if (start == end) return true;

        if (s.charAt(start) != s.charAt(end)) {
            dp[start][end] = -1;
        } else if (s.charAt(start) == s.charAt(end) && (end - start) == 1) {
            dp[start][end] = 1;
        } else if (dp[start][end] == 1 && dp[start + 1][end - 1] == 1) {
            dp[start][end] = 1;
        } else if (end > 0 && start < s.length() - 1 && dp[start + 1][end - 1] == 0) {
            dp[start][end] = isPalindrome(s, start + 1, end - 1) ? 1 : -1;
        }
        return dp[start][end] == 1;
    }
}
