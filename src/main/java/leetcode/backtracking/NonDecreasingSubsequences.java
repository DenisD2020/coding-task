package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/non-decreasing-subsequences/
 */
public class NonDecreasingSubsequences {

    public static void main(String[] args) {
        System.out.println(new NonDecreasingSubsequences().findSubsequences(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1}));
        System.out.println(new NonDecreasingSubsequences().findSubsequences(new int[]{4, 6, 6, 7, 7})); // [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
        System.out.println(new NonDecreasingSubsequences().findSubsequences(new int[]{4, 4, 3, 2, 1}));
    }

    public List<List<Integer>> findSubsequences(int[] nums) { // 50%
        Set<List<Integer>> ans = new HashSet<>();
        backtrack(nums, ans, new ArrayList<>(), 0);
        return new ArrayList<>(ans);
    }

    private void backtrack(int[] nums, Set<List<Integer>> ans, List<Integer> curr, int idx) {
        if (curr.size() >= 2) {
            ans.add(new ArrayList<>(curr));
        }

        if (idx >= nums.length) return;

        for (int i = idx; i < nums.length; i++) {

            if (i - idx >= 1 && nums[i] == nums[i - 1]) continue;

            int num = nums[i];
            if (curr.isEmpty() || curr.getLast() <= num) {
                curr.add(num);
                backtrack(nums, ans, curr, i + 1);
                curr.removeLast();
            }
        }
    }
}
