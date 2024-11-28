package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/maximum-subarray/description/?envType=problem-list-v2&envId=dynamic-programming&difficulty=MEDIUM
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{1})); // 1
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{5, 4, -1, 7, 8})); // 23
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-1})); // -1
    }

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int curr = 0;
        for (int num : nums) {
            curr += num;
            ans = Math.max(ans, curr);
            if (curr < 0) {
                curr = 0;
            }
        }
        return ans;
    }
}
