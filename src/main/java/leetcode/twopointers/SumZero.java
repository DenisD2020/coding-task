package leetcode.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewquery.com/interview-guides/revolut-software-engineer
 * <p>
 * You are given a list of integers called numbers. Write a function to return any subset
 * of numbers where the elements sum to zero and that does not contain the number 0.
 * If there are no combinations of elements that sum to zero, return an empty list.
 */
public class SumZero {

    public static void main(String[] args) {
        System.out.println(new SumZero().summ(new int[]{1, -2, 6, 7, 1})); // 1,-2,1
        System.out.println(new SumZero().summ(new int[]{0, 0, 1, 3, 6, -4, -1})); // 1,3,-4 or 1,-1
    }

    // backtrack
    public List<Integer> summ(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        backtrack(nums, 0, new int[nums.length], new ArrayList<>(), 0, ans);
        return ans;
    }

    private void backtrack(int[] nums, int idx, int[] track, List<Integer> ans, int summ, List<Integer> list) {
        if (summ == 0 && ans.size() > 1) {
            list.addAll(ans);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (track[i] == 1) continue;
            track[i] = 1;
            summ = summ + nums[i];
            ans.add(nums[i]);
            backtrack(nums, i, track, ans, summ, list);
            summ = summ - nums[i];
            ans.removeLast();
            track[i] = 0;
        }
    }
}
