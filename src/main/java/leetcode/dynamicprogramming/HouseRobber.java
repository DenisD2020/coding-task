package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/house-robber/description/?envType=problem-list-v2&envId=dynamic-programming&difficulty=MEDIUM
 */
public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{0}));
        System.out.println(new HouseRobber().rob(new int[]{1, 2, 3, 1})); // 4
        System.out.println(new HouseRobber().rob(new int[]{2, 7, 9, 3, 1})); // 12

        System.out.println(new HouseRobber().rob(new int[]{2, 1, 1, 2})); // 4
    }

    public int rob(int[] nums) { // 100.00%
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }
}
