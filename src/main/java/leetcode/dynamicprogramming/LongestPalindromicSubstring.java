package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/?envType=problem-list-v2&envId=dynamic-programming&difficulty=MEDIUM
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ab"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("bb"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad")); // bab or aba
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd")); // bb
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("bacaad")); // bab or aba
    }

    String ans = "";

    public String longestPalindrome(String s) { // 36.65%

        if (s.length() == 1) return s;

        for (int i = 1; i < s.length(); i++) {
            if (i == 1) ans = s.substring(1, 2);
            isPalindrome(s, i - 1, i + 1);
            isPalindrome(s, i - 1, i);
        }
        return ans;
    }

    private boolean isPalindrome(String s, int l, int r) {
        if (l < 0 || r >= s.length()) return false;
        if (s.charAt(l) != s.charAt(r)) return false;
        String substring = s.substring(l, r + 1);
        if (ans.length() < substring.length()) ans = substring;
        return isPalindrome(s, l - 1, r + 1);
    }
}
