package leetcode.backtracking;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/target-sum/description/
 */
public class TargetSum { // TODO

    public static void main(String[] args) {
//        System.out.println(new TargetSum().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3)); // 5
//        System.out.println(new TargetSum().findTargetSumWays(new int[]{1}, 1)); // 1

//        System.out.println(new TargetSum().findTargetSumWays2(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(new TargetSum().findTargetSumWays2(new int[]{35, 25, 24, 23, 2, 47, 39, 22, 3, 7, 11, 26, 6, 30, 5, 34, 10, 43, 41, 28}, 49)); // 6266
    }

    public int findTargetSumWays(int[] nums, int target) { // TODO too slow O(2^n)
        return calculate(nums, target, 0, 0);
    }

    private int calculate(int[] nums, int target, int res, int idx) {
        if (nums.length == idx) {
            return target == res ? 1 : 0;
        }
        return calculate(nums, target, res - nums[idx], idx + 1) + calculate(nums, target, res + nums[idx], idx + 1);
    }


    // with memo
    int memo[][];
    int total = 0;
    public int findTargetSumWays2(int[] nums, int target) { //
        total = Arrays.stream(nums).sum();
        memo = new int[nums.length][2 * total + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculate2(nums, target, 0, 0);
    }

    private int calculate2(int[] nums, int target, int res, int idx) {
        if (nums.length == idx) {
            return target == res ? 1 : 0;
        }
        int val = memo[idx][total + res + nums[idx]];
        if (val != Integer.MIN_VALUE) {
            return val;
        }

        int add = calculate2(nums, target, res + nums[idx], idx + 1);
        int subtract = calculate2(nums, target, res - nums[idx], idx + 1);
        memo[idx][total + res + nums[idx]] = add + subtract;
        return add + subtract;
    }
}
