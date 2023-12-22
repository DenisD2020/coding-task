package backtracking;

import org.checkerframework.checker.units.qual.A;

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
        backTrack(nums, ans, new ArrayList<Integer>(), 0);
        return ans;

    }

    private void backTrack(int[] nums, ArrayList<List<Integer>> ans, ArrayList<Integer> list, int index) {
        ans.add(new ArrayList<>(list));
        for(int i = index ; i < nums.length; i ++) {
            list.add(nums[i]);
            backTrack(nums, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
