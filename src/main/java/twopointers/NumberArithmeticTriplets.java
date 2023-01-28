package twopointers;

import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/number-of-arithmetic-triplets/
 * <p>
 * You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:
 * <p>
 * i < j < k,
 * nums[j] - nums[i] == diff, and
 * nums[k] - nums[j] == diff.
 * Return the number of unique arithmetic triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,4,6,7,10], diff = 3
 * Output: 2
 * Explanation:
 * (1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
 * (2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3.
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,8,9], diff = 2
 * Output: 2
 * Explanation:
 * (0, 2, 4) is an arithmetic triplet because both 8 - 6 == 2 and 6 - 4 == 2.
 * (1, 3, 5) is an arithmetic triplet because both 9 - 7 == 2 and 7 - 5 == 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 200
 * 0 <= nums[i] <= 200
 * 1 <= diff <= 50
 * nums is strictly increasing.
 */
public class NumberArithmeticTriplets {
    public static void main(String[] args) {
        System.out.println(new NumberArithmeticTriplets().arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
        System.out.println(new NumberArithmeticTriplets().arithmeticTriplets(new int[]{4, 5, 6, 7, 8, 9}, 2));
    }


    // O(n) - time
    // O(n) - memory
    public int arithmeticTriplets(int[] nums, int diff) {
        int result = 0;
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (set.contains(num - diff) && set.contains(num - diff * 2)) {
                result++;
            }
            set.add(num);
        }
        return result;
    }

    // O(n^2)
    public int arithmeticTriplets_2(int[] nums, int diff) {
        int result = 0;
        int pointer1 = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (pointer1 == -1 && nums[i] - nums[j] == diff) {
                    pointer1 = nums[j];
                } else if (pointer1 != -1 && pointer1 - nums[j] == diff) {
                    System.out.println(nums[i] + "" + pointer1 + "" + nums[j]);
                    result++;
                    break;
                }
            }
            pointer1 = -1;
        }
        return result;
    }
}
