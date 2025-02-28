package leetcode.twopointers;

import java.util.Objects;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/description/?envType=problem-list-v2&envId=two-pointers
 */
public class LongestUncommonSubsequenceI {

    public static void main(String[] args) {
        System.out.println(new LongestUncommonSubsequenceI().findLUSlength("aba", "cdc")); // 3
        System.out.println(new LongestUncommonSubsequenceI().findLUSlength("aba", "cdc")); // 3
        System.out.println(new LongestUncommonSubsequenceI().findLUSlength("aaa", "bbb")); // 3
        System.out.println(new LongestUncommonSubsequenceI().findLUSlength("aaa", "aaa")); // 3
    }

    public int findLUSlength(String a, String b) {
        if (Objects.equals(a, b)) return -1;
        return Math.max(a.length(), b.length());
    }
}
