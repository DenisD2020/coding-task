package leetcode.twopointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/description/?envType=problem-list-v2&envId=two-pointers
 */
public class LongestUncommonSubsequenceII {

    public static void main(String[] args) {
        System.out.println(new LongestUncommonSubsequenceII().findLUSlength(new String[]{"aba", "cdc", "eae"})); // 3
        System.out.println(new LongestUncommonSubsequenceII().findLUSlength(new String[]{"aaa", "aaa", "aa"})); // 0
    }

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());

        if (strs[0].length() > strs[1].length()) return strs[0].length();

        for (int i = 0; i < strs.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (isSubSeq(strs[i], strs[j])) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) return strs[i].length();
        }
        return 0;
    }

    private boolean isSubSeq(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == str1.length();
    }
}
