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

    public String longestPalindrome(String s) { // 88.62%

        if (s.length() == 1) return s;

        for (int i = 1; i < s.length(); i++) {
            if (i == 1) ans = s.substring(1, 2);
            isPalindrome(s, i - 1, i + 1);
            isPalindrome(s, i - 1, i);
        }
        return ans;
    }

    private void isPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if ((r - l) > ans.length()) {
            ans = s.substring(l + 1, r);
        }
    }
}
