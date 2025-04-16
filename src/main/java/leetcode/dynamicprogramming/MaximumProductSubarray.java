package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/maximum-product-subarray/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class MaximumProductSubarray {

    public static void main(String[] args) { // TODO
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{2, 3, -2, 4})); // 6
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{-2, 0, -1}));  // 0
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{3, -1, 4}));  // 4
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{2, -5, -2, -4, 3}));  // 24
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int temp = Math.max(current, Math.max(max * current, min * current));
            min = Math.min(current, Math.min(max * current, min * current));
            max = temp;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
