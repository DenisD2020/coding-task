package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/submissions/1119140149/
 */
public class Combinations {
    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2)); // [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        System.out.println(new Combinations().combine(1, 1)); // [[1]]
    }

    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        traverse(n, k, ans, new ArrayList<>(), new int[n + 1], 1);
        return ans;
    }

    private void traverse(int n, int k, List<List<Integer>> ans, ArrayList<Integer> temp, int[] track, int index) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
            if (track[i] == 1) continue;
            temp.add(i);
            track[i] = 1;
            traverse(n, k, ans, temp, track, i + 1);
            temp.remove(temp.size() - 1);
            track[i] = 0;
        }
    }
}
