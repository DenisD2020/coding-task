package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {

    public static void main(String[] args) {
        System.out.println(new LongestUnequalAdjacentGroupsSubsequenceI().getLongestSubsequence(
                new String[]{"e", "a", "b"}, new int[]{0, 0, 1})); // ["e","b"]
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int prev = groups[0];
        ans.add(words[0]);
        for (int i = 1; i < groups.length; i++) {
            if (groups[i] != prev) {
                prev = groups[i];
                ans.add(words[i]);
            }
        }
        return ans;
    }
}
