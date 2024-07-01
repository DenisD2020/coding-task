package leetcode.slidingwindow;

/**
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 * <p>
 * Given a binary array nums, you should delete one element from it.
 * <p>
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 * Example 2:
 * <p>
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 * Example 3:
 * <p>
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */
public class LongestSubarray1sAfterDeletingOneElement {

    public static void main(String[] args) {
        System.out.println(new LongestSubarray1sAfterDeletingOneElement().longestSubarray(new int[]{1, 1, 0, 1})); // 3
        System.out.println(new LongestSubarray1sAfterDeletingOneElement().longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1})); // 5
        System.out.println(new LongestSubarray1sAfterDeletingOneElement().longestSubarray(new int[]{1, 1, 1})); // 2
    }

    public int longestSubarray(int[] nums) {
        int res = 0;
        int temp[] = new int[nums.length - 1];
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp[t] += nums[i];
            } else {
                t++;
            }
        }
        if (temp[0] == nums.length) return nums.length -1;

        for (int i = 0; i < temp.length - 1; i++) {
            int sum = temp[i] + temp[i + 1];
            if (res < sum) {
                res = sum;
            }
        }
        return res;
    }
}
