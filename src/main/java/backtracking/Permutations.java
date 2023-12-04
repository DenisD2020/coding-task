package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
        System.out.println(new Permutations().permute(new int[]{0, 1}));
    }

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        backTracking(ans, new ArrayList<>(), nums, new int[nums.length]);
        return ans;
    }

    private List<List<Integer>> backTracking(ArrayList<List<Integer>> ans, ArrayList<Integer> temp, int[] nums, int[] track) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (track[i] == 0) {
                track[i] = 1;
                temp.add(nums[i]);
                backTracking(ans, temp, nums, track);
                track[i] = 0;
                temp.remove(temp.size() - 1);
            }
        }
        return ans;
    }
}
