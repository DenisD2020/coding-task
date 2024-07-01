package leetcode.slidingwindow;

/**
 * https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
 * <p>
 * You are given an integer array nums and two integers minK and maxK.
 * <p>
 * A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
 * <p>
 * The minimum value in the subarray is equal to minK.
 * The maximum value in the subarray is equal to maxK.
 * Return the number of fixed-bound subarrays.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
 * Output: 2
 * Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1], minK = 1, maxK = 1
 * Output: 10
 * Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i], minK, maxK <= 106
 */
public class CountSubarraysWithFixedBounds {
    public static void main(String[] args) {
//        System.out.println(new CountSubarraysWithFixedBounds().countSubarrays(new int[]{1}, 1, 1));
//        System.out.println(new CountSubarraysWithFixedBounds().countSubarrays(new int[]{1, 1}, 1, 1));
//        System.out.println(new CountSubarraysWithFixedBounds().countSubarrays(new int[]{1, 1, 1}, 1, 1));
//        System.out.println(new CountSubarraysWithFixedBounds().countSubarrays(new int[]{1, 1, 1, 1}, 1, 1));
//        System.out.println(new CountSubarraysWithFixedBounds().countSubarrays(new int[]{1, 1, 1, 1, 1}, 1, 1));
//        System.out.println(new CountSubarraysWithFixedBounds().countSubarrays(new int[]{1, 1, 1, 1, 1, 1}, 1, 1));
//        System.out.println(new CountSubarraysWithFixedBounds().countSubarrays(new int[]{1, 1, 1, 1, 1, 1, 1}, 1, 1));
      System.out.println(new CountSubarraysWithFixedBounds().countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5)); // 2
      System.out.println(new CountSubarraysWithFixedBounds().countSubarrays(new int[]{1, 1}, 1, 1)); // 3
      System.out.println(new CountSubarraysWithFixedBounds().countSubarrays(new int[]{5, 1, 1}, 1, 5)); // 2
      System.out.println(new CountSubarraysWithFixedBounds().countSubarrays(new int[]{1, 1, 1, 1}, 1, 1)); // 10
      System.out.println(new CountSubarraysWithFixedBounds().countSubarrays(new int[]{5, 5, 1}, 1, 5)); // 1
    }


    public long countSubarrays(int[] nums, int minK, int maxK) {

        long res = 0;
        int minIndex = -1, maxIndex = -1, leftBound = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                minIndex = -1;
                maxIndex = -1;
                leftBound = i;
            }
            if (nums[i] == minK) {
                minIndex = i;
            }
            if (nums[i] == maxK) {
                maxIndex = i;
            }
            if (maxIndex >= 0 && minIndex >= 0) {
                res+=Math.min(minIndex, maxIndex) - leftBound;
            }
        }
        return res;
    }
}
