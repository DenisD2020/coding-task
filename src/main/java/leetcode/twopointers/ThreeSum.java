package leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/description/
 * <p>
 * Given an integer array nums, return all the triplets
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 */
public class ThreeSum {

    public static void main(String[] args) {
//        System.out.println(new ThreeSum().threeSum(new int[]{0, 0, 0, 0})); // [[0,0,0]]
//        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1,-1,2],[-1,0,1]]
//        System.out.println(new ThreeSum().threeSum(new int[]{0, 1, 1})); // []
//        System.out.println(new ThreeSum().threeSum(new int[]{0, 0, 0})); // [[0,0,0]]
//        System.out.println(new ThreeSum().threeSum(new int[]{2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10})); // [[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]
        // [-10, -5, -5, -4, -4, -3, -2, -2, 0, 0, 1, 2, 2, 2, 2, 5, 5]
        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4})); // [[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
        // [-4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4]
    }

    public List<List<Integer>> threeSum(int[] nums) { // 26.36%

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int length = nums.length;

        for (int i = 0; i < length - 2; i++) {

            int left = i + 1;
            int right = length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            while (left < right) {

                int currSum = nums[i] + nums[left] + nums[right];

                if (currSum == 0) {
                    ans.add(List.of(nums[i], nums[left], nums[right]));
                }

                if (currSum < 0) {
                    do {
                        left++;
                    } while (left < right && left - 1 != i && nums[left - 1] == nums[left]);
                } else {
                    do {
                        right--;
                    } while (right > left && right != length - 1 && nums[right + 1] == nums[right]);
                }
            }
        }
        return ans;
    }
}
