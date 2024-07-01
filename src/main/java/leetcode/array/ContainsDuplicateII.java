package leetcode.array;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 * <p>
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such
 * that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3)); // true
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1)); // true
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2)); // false
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index == null) {
                map.put(nums[i], i);
            } else if (Math.abs(index - i) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    /*
    // sliding windows
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int start = 0; start < nums.length; start++) {
            for (int right = start + 1; right <= start + k && right < nums.length; right++) {
                if (nums[start] == nums[right] && Math.abs(start - right) <= k) {
                    return true;
                }
            }
        }
        return false;
    }*/
}
