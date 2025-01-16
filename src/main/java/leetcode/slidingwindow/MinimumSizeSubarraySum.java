package leetcode.slidingwindow;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3})); // 2
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(4, new int[]{1, 4, 4})); // 1
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1})); // 0
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(15, new int[]{1, 2, 3, 4, 5})); // 5
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8})); // 2
    }


    public int minSubArrayLen(int target, int[] nums) { // 99.94%
        int ans = 100000, l = 0, prefixSum = 0;

        for (int r = 0; r < nums.length; r++) {
            prefixSum += nums[r];

            if (prefixSum >= target) {
                ans = Math.min(ans, r - l + 1);

                while (prefixSum >= target && l <= r) {
                    prefixSum -= nums[l];
                    l++;
                    if (prefixSum >= target) {
                        ans = Math.min(ans, r - l + 1);
                    }
                }
            }
        }
        return ans == 100000 ? 0 : ans;
    }
}
