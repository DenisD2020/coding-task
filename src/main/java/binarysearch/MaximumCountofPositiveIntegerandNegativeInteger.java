package binarysearch;

/**
 * https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/
 */
public class MaximumCountofPositiveIntegerandNegativeInteger {

    public static void main(String[] args) {
//        System.out.println(new MaximumCountofPositiveIntegerandNegativeInteger().maximumCount(new int[]{-2, -1, -1, 1, 2, 3})); // 3
        System.out.println(new MaximumCountofPositiveIntegerandNegativeInteger().maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2})); // 3
    }

    public int maximumCount(int[] nums) {
        int length = nums.length;

        int l = 0;
        int h = nums.length;

        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] < 0) {
                l = m + 1;
            } else if (nums[m] >= 0) {
                h = m;
            }
        }
        return 0;
    }
}
