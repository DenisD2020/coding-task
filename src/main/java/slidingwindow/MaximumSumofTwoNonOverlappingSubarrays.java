package slidingwindow;

/**
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 * <p>
 * <p>
 * Given an integer array nums and two integers firstLen and secondLen, return the maximum sum of elements in two non-overlapping subarrays with lengths firstLen and secondLen.
 * <p>
 * The array with length firstLen could occur before or after the array with length secondLen, but they have to be non-overlapping.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
 * Output: 20
 * Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
 * Example 2:
 * <p>
 * Input: nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
 * Output: 29
 * Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
 * Example 3:
 * <p>
 * Input: nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
 * Output: 31
 * Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [0,3,8] with length 3.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= firstLen, secondLen <= 1000
 * 2 <= firstLen + secondLen <= 1000
 * firstLen + secondLen <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 */
public class MaximumSumofTwoNonOverlappingSubarrays {

    public static void main(String[] args) {
        new MaximumSumofTwoNonOverlappingSubarrays().maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2);// 20
        new MaximumSumofTwoNonOverlappingSubarrays().maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2);//
        new MaximumSumofTwoNonOverlappingSubarrays().maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3);//
    }


    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int res = 0;

        for (int i = 0 ; i < nums.length; i++) {
            
        }

        return 0;

    }
}
