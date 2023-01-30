package twopointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/
 */
public class MinimizeMaximumPairSuminArray {

    public static void main(String[] args) {
        System.out.println(new MinimizeMaximumPairSuminArray().minPairSum(new int[]{3, 5, 2, 3}));
        System.out.println(new MinimizeMaximumPairSuminArray().minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
    }

    public int minPairSum(int[] nums) {

        Arrays.sort(nums);
        int res = 0;

        for (int i = 0; i < nums.length / 2; i++) {
            res = Math.max(res, nums[i] + nums[nums.length - 1 - i]);
        }
        return res;
    }
}
