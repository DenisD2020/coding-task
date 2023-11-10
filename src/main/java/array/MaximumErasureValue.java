package array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-erasure-value/description/
 */
public class MaximumErasureValue {

    public static void main(String[] args) {
        System.out.println(new MaximumErasureValue().maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6})); // 17
        System.out.println(new MaximumErasureValue().maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5})); //8
    }

    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0, l = 0, r = 0;
        int summ = 0;
        Set<Integer> set = new HashSet<>();
        while (r < nums.length) {
            if (set.add(nums[r])) {
                summ += nums[r];
                ans = Math.max(ans, summ);
                r++;
            } else {
                while (nums[l] != nums[r]) { // move l to right
                    summ -= nums[l];
                    set.remove(nums[l]);
                    l++;
                }
                summ -= nums[l];
                set.remove(nums[l]);
                l++;
            }
        }
        return ans;
    }
}
