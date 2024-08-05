package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/count-substrings-that-differ-by-one-character/description/
 */
public class CountSubstringsThatDifferByOneCharacter {

    public static void main(String[] args) {
        System.out.println(new CountSubstringsThatDifferByOneCharacter().countSubstrings("aba", "baba")); // 6
        System.out.println(new CountSubstringsThatDifferByOneCharacter().countSubstrings("ab", "bb")); // 3
        System.out.println(new CountSubstringsThatDifferByOneCharacter().countSubstrings("abe", "bbc")); // 10
    }

    public int countSubstrings(String s, String t) { // TODO
        int sL = s.length(), nL = t.length();

        int[][][] dp = new int[sL][nL][2];

        int res = 0;
        // first col s[0:i] match t[0:0]
        for (int i = 0; i < sL; i++) {
            dp[i][0][0] = (s.charAt(i) == t.charAt(0)) ? 1 : 0;
            dp[i][0][1] = (s.charAt(i) == t.charAt(0)) ? 0 : 1;
            res += dp[i][0][1];
        }


        // first row s[0:0] match t[0:j]
        for (int j = 1; j < nL; j++) {
            dp[0][j][0] = (s.charAt(0) == t.charAt(j)) ? 1 : 0;
            dp[0][j][1] = (s.charAt(0) == t.charAt(j)) ? 0 : 1;
            res += dp[0][j][1];
        }

        for (int i = 1; i < sL; i++) {
            for (int j = 1; j < nL; j++) {
                dp[i][j][0] = (s.charAt(i) == t.charAt(j)) ? dp[i - 1][j - 1][0] + 1 : 0;
                dp[i][j][1] = (s.charAt(i) == t.charAt(j)) ? dp[i - 1][j - 1][1] : dp[i - 1][j - 1][0] + 1;
                res += dp[i][j][1];
            }
        }
        return res;
    }
}

/*    Map<String, Integer> dp = new HashMap<>();

    public int countSubstrings(String s, String t) { // 16.9 %
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (dp.get(substring) != null) {
                    ans += dp.get(substring);
                    continue;
                }
                int count = count(substring, t);
                ans += count;
                dp.put(substring, count);
            }
        }
        return ans;
    }

    private int count(String s, String t) {
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            int differCount = 0;
            for (int j = 0; j < s.length(); j++) {
                if (i + s.length() > t.length()) break;
                if (s.charAt(j) != t.charAt(i + j)) {
                    differCount++;
                }
                if (differCount > 1) break;
            }
            if (differCount == 1) count++;
        }
        return count;
    }*/

