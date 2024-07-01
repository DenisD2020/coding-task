package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 3}, 6)));
//        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 5, 5, 11}, 10)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int two = target - nums[i];
            if (map.containsKey(two)) {
                return new int[]{map.get(two), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
