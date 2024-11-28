package leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/extra-characters-in-a-string/description/
 */
public class ExtraCharactersInAString {
    public static void main(String[] args) {
        System.out.println(new ExtraCharactersInAString().minExtraChar("ccab", new String[]{"cc", "cab"})); // 1
        System.out.println(new ExtraCharactersInAString().minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"})); // 1
        System.out.println(new ExtraCharactersInAString().minExtraChar("sayhelloworld", new String[]{"hello", "world"})); //  3
        System.out.println(new ExtraCharactersInAString().minExtraChar("dwmodizxvvbosxxw", new String[]{"ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu"})); //  7
    }

    Integer[] memo;
    HashSet<String> dictionarySet;

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        memo = new Integer[n];
        dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        return dp(0, n, s);
    }

    private int dp(int start, int n, String s) {
        if (start == n) {
            return 0;
        }

        if (memo[start] != null) return memo[start];

        int ans = dp(start + 1, n, s) + 1;
        for (int end = start; end < n; end++) {
            var cur = s.substring(start, end + 1);
            if (dictionarySet.contains(cur)) {
                ans = Math.min(ans, dp(end + 1, n, s));
            }

        }
        return memo[start] = ans;
    }

/*    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        memo = new Integer[n];
        dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        return dp(0, n, s);
    }

    private int dp(int start, int n, String s) {
        if (start == n) {
            return 0;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        // To count this character as a left over character
        // move to index 'start + 1'
        int ans = dp(start + 1, n, s) + 1;
        for (int end = start; end < n; end++) {
            var curr = s.substring(start, end + 1);
            if (dictionarySet.contains(curr)) {
                ans = Math.min(ans, dp(end + 1, n, s));
            }
        }

        return memo[start] = ans;
    }*/
}
