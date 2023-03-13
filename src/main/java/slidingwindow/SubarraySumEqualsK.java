package slidingwindow;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {
//        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1, 1, 1, 2}, 2)); // 3
//        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1, 1, 1}, 2)); // 2
//        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1, 2, 3}, 3)); // 2
//        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1}, 0)); // 0
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1, -1, 0}, 0)); // 0
    }

    public int subarraySum(int[] nums, int k) {

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
