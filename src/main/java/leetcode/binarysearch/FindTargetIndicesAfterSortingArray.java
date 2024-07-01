package leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-target-indices-after-sorting-array/
 * <p>
 * You are given a 0-indexed integer array nums and a target element target.
 * A target index is an index i such that nums[i] == target.
 * Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
 */
public class FindTargetIndicesAfterSortingArray {

    public static void main(String[] args) {
        System.out.println(new FindTargetIndicesAfterSortingArray().targetIndices(new int[]{1}, 2)); // []
//        System.out.println(new FindTargetIndicesAfterSortingArray().targetIndices(new int[]{1, 2, 5, 2, 3}, 2)); // 1,2
//        System.out.println(new FindTargetIndicesAfterSortingArray().targetIndices(new int[]{1, 2, 5, 2, 3}, 3)); // 3
//        System.out.println(new FindTargetIndicesAfterSortingArray().targetIndices(new int[]{1, 2, 5, 2, 3}, 4)); // 3
//        System.out.println(new FindTargetIndicesAfterSortingArray().targetIndices(new int[]{1, 2, 5, 2, 3}, 5)); // 3
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) res.add(i);
        }
        return res;
    }
}
