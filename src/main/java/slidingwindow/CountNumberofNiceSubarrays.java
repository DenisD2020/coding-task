package slidingwindow;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/count-number   -of-nice-subarrays/
 * <p>
 * Return the number of nice sub-arrays.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * Example 2:
 * <p>
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There is no odd numbers in the array.
 * Example 3:
 * <p>
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */
public class CountNumberofNiceSubarrays {

    public static void main(String[] args) {
        System.out.println(new CountNumberofNiceSubarrays().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3)); // 2
        System.out.println(new CountNumberofNiceSubarrays().numberOfSubarrays(new int[]{2, 4, 6}, 1)); // 0
        System.out.println(new CountNumberofNiceSubarrays().numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2)); // 16
    }

    public int numberOfSubarrays(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2 == 0 ? 0 : 1;
        }

        var res = 0;
        var sum = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.get(sum - k) != null) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}