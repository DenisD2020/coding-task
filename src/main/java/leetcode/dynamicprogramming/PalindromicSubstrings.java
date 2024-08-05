package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
//        System.out.println(new PalindromicSubstrings().countSubstrings("ab")); // 2
//        System.out.println(new PalindromicSubstrings().countSubstrings("abc")); // 3
//        System.out.println(new PalindromicSubstrings().countSubstrings("aaa")); // 6
//        System.out.println(new PalindromicSubstrings().countSubstrings("aaaaa")); // 15
        System.out.println(new PalindromicSubstrings().countSubstrings("fdsklf")); // 6
//        System.out.println(new PalindromicSubstrings().countSubstrings("xkjkqlajprjwefilxgpdpebieswu")); // 30
//        System.out.println(new PalindromicSubstrings().countSubstrings("dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg")); // 77
    }

    private int[][] dp;

    public int countSubstrings(String s) {
        int ans = 0;
        dp = new int[s.length()][s.length()];
        for (int i = s.length(); i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                    ans++;
                }
            }
        }
        return ans;
    }
}
