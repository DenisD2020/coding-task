package leetcode.dynamicprogramming;

import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break/description/
 */
public class WordBreak {
    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("leetcode", List.of("leet", "code"))); // true
        System.out.println(new WordBreak().wordBreak("applepenapple", List.of("apple", "pen"))); // true
        System.out.println(new WordBreak().wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false
    }

    Integer[] memo;
    HashSet<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        set = new HashSet<>(wordDict);
        memo = new Integer[n];
        int ans = dp(0, n, s);
        return ans == 0;
    }

    private int dp(int start, int n, String s) {
        if (start == n) return 0;

        if (memo[start] != null) return memo[start];

        int ans = dp(start + 1, n, s) + 1;
        for (int end = start; end < n; end++) {
            var cur = s.substring(start, end + 1);
            if (set.contains(cur)) {
                ans = Math.min(ans, dp(end + 1, n, s));
            }
        }
        return memo[start] = ans;
    }
}
