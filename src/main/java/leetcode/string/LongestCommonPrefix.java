package leetcode.string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // "fr"
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog", "racecar", "car"})); // ""
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"ab", "a"})); // "a"
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        Arrays.sort(strs);
        String lastWord = strs[strs.length - 1];
        String firstWord = strs[0];
        int idx = 0;
        for (; idx < firstWord.length(); idx++) {
            if (lastWord.charAt(idx) != firstWord.charAt(idx)) {
                break;
            }
        }
        return firstWord.substring(0, idx);
    }
}
