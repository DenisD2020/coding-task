package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class SubsetsII {

    public static void main(String[] args) { // TODO repeat
        System.out.println(new SubsetsII().subsetsWithDup(new int[]{1, 2, 2})); // [[],[1],[1,2],[1,2,2],[2],[2,2]]
        System.out.println(new SubsetsII().subsetsWithDup(new int[]{0})); // [[],[0]]
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void backTrack(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
        ans.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            backTrack(nums, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
