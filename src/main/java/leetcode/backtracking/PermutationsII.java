package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/permutations-ii/description/
 */
public class PermutationsII {

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{1, 1, 2}));
        System.out.println(new PermutationsII().permuteUnique(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
            for (Integer i : nums) {
                map.putIfAbsent(i, 0);
                map.put(i, map.get(i) + 1);
            }
        backTracking(res, map, new ArrayList<>(), nums.length);
        return res;
    }

    private void backTracking(List<List<Integer>> res, HashMap<Integer, Integer> map, ArrayList<Integer> temp, int length) {
        if (temp.size() == length) {
            res.add(new ArrayList<>(temp));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0) continue;
            temp.add(num);
            map.put(num, count - 1);
            backTracking(res, map, temp, length);
            temp.remove(temp.size() - 1);
            map.put(num, count);
        }
    }
}
