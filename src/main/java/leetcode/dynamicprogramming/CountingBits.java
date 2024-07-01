package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/counting-bits/
 * <p>
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 105
 */
public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits().countBits(2)));
        System.out.println(Arrays.toString(new CountingBits().countBits(5)));
    }

    public int[] countBits(int n) {
        int res[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = summBinary(Integer.toBinaryString(i));
        }
        return res;
    }

    private int summBinary(String binaryString) {
        int res = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            res += Integer.valueOf(binaryString.substring(i, i + 1));
        }
        return res;
    }
}
