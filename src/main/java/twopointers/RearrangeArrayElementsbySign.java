package twopointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 * <p>
 * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
 * <p>
 * You should rearrange the elements of nums such that the modified array follows the given conditions:
 * <p>
 * Every consecutive pair of integers have opposite signs.
 * For all integers with the same sign, the order in which they were present in nums is preserved.
 * The rearranged array begins with a positive integer.
 * Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,1,-2,-5,2,-4]
 * Output: [3,-2,1,-5,2,-4]
 * Explanation:
 * The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
 * The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
 * Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.
 * Example 2:
 * <p>
 * Input: nums = [-1,1]
 * Output: [1,-1]
 * Explanation:
 * 1 is the only positive integer and -1 the only negative integer in nums.
 * So nums is rearranged to [1,-1].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 2 * 105
 * nums.length is even
 * 1 <= |nums[i]| <= 105
 * nums consists of equal number of positive and negative integers.
 */
public class RearrangeArrayElementsbySign {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RearrangeArrayElementsbySign().rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
        System.out.println(Arrays.toString(new RearrangeArrayElementsbySign().rearrangeArray(new int[]{-1, 1})));
    }

    public int[] rearrangeArray(int[] nums) {

        int l = nums.length;
        int res[] = new int[l];

        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int elem : nums) {
            if (elem > 0) {
                res[positiveIndex] = elem;
                positiveIndex += 2;
            } else {
                res[negativeIndex] = elem;
                negativeIndex += 2;
            }
        }
        return res;
    }
}
