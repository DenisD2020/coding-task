package leetcode.prefixsum;

/**
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 * <p>
 * Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.
 * A subarray is a contiguous subsequence of the array.
 */
public class SumAllOddLengthSubarrays {

    public static void main(String[] args) {
        System.out.println(new SumAllOddLengthSubarrays().sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3})); //58
        System.out.println(new SumAllOddLengthSubarrays().sumOddLengthSubarrays(new int[]{1, 2})); //3
        System.out.println(new SumAllOddLengthSubarrays().sumOddLengthSubarrays(new int[]{10, 11, 12})); //66
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;

        for (int start = 0; start < arr.length; start++) {
            int prefix = 0;
            for (int j = start; j < arr.length; j++) {
                prefix += arr[j];
                if ((j - start + 1) % 2 != 0) {
                    res += prefix;
                }
            }
        }
        return res;
    }
}
