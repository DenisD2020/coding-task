package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber-ii/description/
 */
public class HouseRobberII {

    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[]{2, 3, 2})); // 3
        System.out.println(new HouseRobberII().rob(new int[]{1, 2, 3, 1})); // 4
        System.out.println(new HouseRobberII().rob(new int[]{1, 2, 3})); // 3
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int ans1 = robHelp(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int ans2 = robHelp(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(ans1, ans2);
    }

    private int robHelp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }
}
