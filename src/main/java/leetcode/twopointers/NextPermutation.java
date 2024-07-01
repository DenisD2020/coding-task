package leetcode.twopointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 * <p>
 * <p>
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * <p>
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 * <p>
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 * <p>
 * The replacement must be in place and use only constant extra memory.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 * <p>
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 * <p>
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class NextPermutation {

    public static void main(String[] args) {
        new NextPermutation().printAllPermutation(new int[]{1, 2, 3});
        //new NextPermutation().nextPermutation(new int[]{3, 2, 1});
        //new NextPermutation().nextPermutation(new int[]{1, 1, 5});
    }

    public void printAllPermutation(int[] array) {
        int k = array.length - 1;
        int n = k;
        System.out.println(Arrays.toString(array));
        for (; k > 0; ) {
            leftShift(array, k);
            if (array[k] != k) {
                System.out.println(Arrays.toString(array));
                k = n;
            } else {
                k = k - 1;
            }

        }
    }

    public void leftShift(int[] array, int k) {
        int temp = array[0];
        for (int i = 0; i < k; i++) {
            array[i] = array[i + 1];
        }
        array[k] = temp;
    }
}
