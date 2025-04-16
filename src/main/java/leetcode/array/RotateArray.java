package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(nums, 10);
        System.out.println(Arrays.toString(nums)); // [5,6,7,1,2,3,4]
        int[] nums1 = {-1, -100, 3, 99};
        new RotateArray().rotate(nums1, 2);
        System.out.println(Arrays.toString(nums1)); // [3,99,-1,-100]
        int[] nums2 = {-1};
        new RotateArray().rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2)); // [-1]
        int[] nums3 = {1, 2, 3};
        new RotateArray().rotate(nums3, 4);
        System.out.println(Arrays.toString(nums3)); // 3,1,2
    }

    public void rotate(int[] nums, int k) { // 49.17%

        int length = nums.length;
        int[] tmp = new int[length];
        int start = length - k;
        if (k > length) {
            start = length - k % length;
        }
        for (int i = 0; i < length; i++) {
            int next = start + i;
            if (next >= length) {
                next = next - length;
            }
            tmp[i] = nums[next];
        }
        for (int i = 0; i < length; i++) {
            nums[i] = tmp[i];
        }
    }
}
