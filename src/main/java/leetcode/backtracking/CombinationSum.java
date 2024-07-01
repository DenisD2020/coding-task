package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7)); // [[2,2,3],[7]]
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8)); // [[2,2,2,2],[2,3,3],[3,5]]
        System.out.println(new CombinationSum().combinationSum(new int[]{2}, 1)); // []
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void backTrack(int[] candidates, int target, ArrayList<List<Integer>> res, ArrayList<Integer> current, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int difference = target - candidates[i];
            if (difference < 0) return;
            current.add(candidates[i]);
            backTrack(candidates, difference, res, current, i);
            current.remove(current.size() - 1);
        }
    }
}
