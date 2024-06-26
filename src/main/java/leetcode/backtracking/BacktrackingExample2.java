package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingExample2 {

    public static void main(String[] args) {
        System.out.println(new BacktrackingExample2().subsetsWithTargetSum(new int[]{1, 2, 3, 4, 5, 6}, 6));
    }

    public List<List<Integer>> subsetsWithTargetSum(int[] nums, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, targetSum, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int targetSum, int index, List<Integer> subset, List<List<Integer>> result) {
        if (targetSum == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            if (targetSum - num >= 0) {
                subset.add(num);
                backtrack(nums, targetSum - num, i + 1, subset, result);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
