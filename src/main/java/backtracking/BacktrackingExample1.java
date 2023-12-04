package backtracking;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingExample1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums, 0);
        System.out.println(result);
    }

    private static void backtrack(List result, List tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
