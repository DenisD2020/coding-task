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
        System.out.println(new ThreeSum().threeSum(new int[]{0, 0, 0, 0})); // [[0,0,0]]
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(new ThreeSum().threeSum(new int[]{0, 1, 1})); // []
        System.out.println(new ThreeSum().threeSum(new int[]{0, 0, 0})); // [[0,0,0]]
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            while (left < right) {

                int currSum = nums[i] + nums[left] + nums[right];

                if (currSum == 0) {
                    ans.add(List.of(nums[i], nums[left], nums[right]));

                    while (nums[left] == nums[right-1] && left < right) {
                        left++;
                    }
                }

                if (currSum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return ans;
    }
}
