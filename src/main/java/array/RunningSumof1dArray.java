package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class RunningSumof1dArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RunningSumof1dArray().runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new RunningSumof1dArray().runningSum(new int[]{1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(new RunningSumof1dArray().runningSum(new int[]{3, 1, 2, 10, 1})));
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}
