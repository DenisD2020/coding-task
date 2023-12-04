package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3})); // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        System.out.println(new Subsets().subsets(new int[]{0})); // [[],[0]]
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        backTracking(nums, ans, new ArrayList(), 0);
        return ans;
    }

    private void backTracking(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index) {
        ans.add(new ArrayList<>(temp));
        if (temp.size() == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backTracking(nums, ans, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
