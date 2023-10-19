package hashtable;

import java.util.HashSet;

/**
 * You are given an array nums consisting of positive integers.
 * You have to take each integer in the array, reverse its digits, and add it to the end of the array. You should apply this operation to the original integers in nums.
 * Return the number of distinct integers in the final array.
 * <p>
 * https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/description/
 */
public class CountNumberofDistinctIntegersAfterReverseOperations {

    public static void main(String[] args) {
        System.out.println(new CountNumberofDistinctIntegersAfterReverseOperations().countDistinctIntegers(new int[]{1, 13, 10, 12, 31})); // 6
        System.out.println(new CountNumberofDistinctIntegersAfterReverseOperations().countDistinctIntegers(new int[]{2, 2, 2})); // 1
    }

    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
            set.add(getReverseInt(i));
        }
        return set.size();
    }

    private int getReverseInt(int value) {
        int resultNumber = 0;
        for (int i = value; i != 0; i /= 10) {
            resultNumber = resultNumber * 10 + i % 10;
        }
        return resultNumber;
    }
}
