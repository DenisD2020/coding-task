package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/description/?envType=problem-list-v2&envId=backtracking
 */
public class CombinationSumII {

    public static void main(String[] args) {
//        System.out.println(new CombinationSumII().combinationSum2(new int[]{1, 2, 2}, 3)); //
        System.out.println(new CombinationSumII().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)); // [[1,1,6],[1,2,5],[1,7],[2,6]]
        System.out.println(new CombinationSumII().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5)); // [[1,2,2],[5]]
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, new int[candidates.length], ans, new ArrayList<>(), 0);
        return ans;
    }

    private void backTrack(int[] candidates, int target, int[] track, List<List<Integer>> ans, ArrayList<Integer> tmp, int idx) {
        int sum = tmp.stream().reduce(0, Integer::sum);
        if (sum == target) {
            ans.add(new ArrayList<>(tmp));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (track[i] == 1) continue;
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            track[i] = 1 ;
            tmp.add(candidates[i]);
            backTrack(candidates, target, track, ans, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
            track[i] = 0 ; 
        }
    }
}
