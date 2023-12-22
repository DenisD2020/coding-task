package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/description/
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        System.out.println(new CombinationSumIII().combinationSum3(3, 7)); // [[1,2,4]]
        System.out.println(new CombinationSumIII().combinationSum3(3, 9)); // [[1,2,6],[1,3,5],[2,3,4]]
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        traverse(k, n, ans, new ArrayList<>(), new int[10], 1);
        return ans;
    }

    private void traverse(int k, int n, List<List<Integer>> ans, ArrayList<Integer> temp, int[] track, int index) {
        if (temp.size() == k && n == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < 10; i++) {
            if (track[i] == 1) continue;
            track[i] = 1;
            temp.add(i);
            traverse(k, n - i, ans, temp, track, i + 1);
            temp.remove(temp.size() - 1);
            track[i] = 0;
        }
    }
}
