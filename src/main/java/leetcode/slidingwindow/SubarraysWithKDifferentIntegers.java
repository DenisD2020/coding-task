package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarrays-with-k-different-integers/description/
 */

public class SubarraysWithKDifferentIntegers { // TODO

    public static void main(String[] args) {
        System.out.println(new SubarraysWithKDifferentIntegers().subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2)); // 7
        System.out.println(new SubarraysWithKDifferentIntegers().subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3)); // 3
    }

    public int subarraysWithKDistinct(int[] nums, int kk) {

        if (nums.length == 0) return 0;

        int ans = 0, l = 0, r = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (l < nums.length) {



        }

        return ans;
    }

/*    public int subarraysWithKDistinct(int[] nums, int kk) { // TimeLimitExceed
        if (nums.length == 0) return 0;

        int ans = 0;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                set.add(nums[j]);
                if (set.size() == kk) {
                    ans++;
                } else if (set.size() > kk) {
                    break;
                }
            }
            set.clear();
        }
        return ans;
    }*/

/*    public int subarraysWithKDistinct(int[] nums, int kk) { // TimeLimitExceed
        if (nums.length == 0) return 0;

        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> copy = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            copy = new HashMap<>();
            for (int j = i; j < nums.length; j++) {
                copy.put(nums[j], copy.getOrDefault(nums[j], 0) + 1);
                if (copy.size() == kk) {
                    ans++;
                } else if (copy.size() > kk) {
                    break;
                }
            }
        }
        return ans;
    }*/
}
